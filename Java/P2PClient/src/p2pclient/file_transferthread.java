/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2pclient;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GAGAN
 */
public class file_transferthread extends Thread {

    public static Object toObject(byte[] bytes) {
        Object object = null;
        try {
            object = new ObjectInputStream(new ByteArrayInputStream(bytes)).readObject();
        } catch (IOException ex) {
            Logger.getLogger(clientframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clientframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    @Override
    public void run() {
        ServerSocket srvrs = null;
        Socket client = null;
        InputStream in = null;
        OutputStream outstream = null;
        InputStream instream = null;
        ObjectInputStream obin = null;
        byte[] buffer = new byte[1024];
        String fileToUpload = null;

        try {
            srvrs = new ServerSocket(5555);
        } catch (IOException ex) {
            Logger.getLogger(file_transferthread.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {
                client = srvrs.accept();
                outstream = client.getOutputStream();
                instream = client.getInputStream();
                obin = new ObjectInputStream(instream);

                byte[] bytearray = null;
                int size = obin.readInt();
                bytearray = new byte[size];
                instream.read(bytearray);
                fileToUpload = (String) toObject(bytearray);

                System.out.println("Connection to client established");
            } catch (IOException ex) {
                Logger.getLogger(file_transferthread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Read the string: " + fileToUpload);
            try {
                in = new BufferedInputStream(new FileInputStream(fileToUpload));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(file_transferthread.class.getName()).log(Level.SEVERE, null, ex);
            }

            int num;
            try {
                while ((num = in.read(buffer)) != -1) {
                    outstream.write(buffer, 0, num);
                }
                outstream.close();
            } catch (IOException ex) {
                Logger.getLogger(file_transferthread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}