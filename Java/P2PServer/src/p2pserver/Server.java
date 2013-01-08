package p2pserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Server {

    public static void main(String st[]) {
        ServerSocket server = null;
        //ServerSocket serverSearch = null;
        try {
            server = new ServerSocket(4321);
            //serverSearch = new ServerSocket(5432);
        } catch (IOException e) {
            System.out.println("Could not listen on port 4321 and(or) post 5432");
            System.exit(-1);
        }
        while (true) {
            System.out.println("Waiting for activity...");
            Socket client = null;
            //Socket clientSearch = null;
            try {
                client = server.accept();
                //clientSearch = serverSearch.accept();
                /* Getting the "file-list.txt" file from connected client */
                System.out.println(client.getRemoteSocketAddress());
                File downFile = new File(client.getInetAddress().toString().split("/")[1]);
                BufferedOutputStream buffout = null;
                InputStream inin = null;
                inin = client.getInputStream();
                OutputStream outout = null;
                outout = client.getOutputStream();
                byte[] buffer = new byte[1024];
           
                try {
                     buffout = new BufferedOutputStream(new FileOutputStream(downFile));
                }
                catch (FileNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
              
                int num;
                System.out.println("Starting download");
                try {
                    while ((num = inin.read(buffer)) != -1) {
                        buffout.write(buffer, 0, num);
                    }
                    System.out.println("File downloaded");
                }
                catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    buffout.close();
                    //inin.close();
                    //outout.close();
                }
                catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            catch (IOException e) {
                System.out.println("Accept failed: 4321 and(or) 5432");
                System.exit(-1);
            }
            
            /* Reinitializing socket after closing it above for clientthread to work */
            try {
                client = server.accept();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            clientthread cs = new clientthread(client);
            cs.start();
            //SearchDBThread sd = new SearchDBThread(clientSearch);
            //sd.start();
        }
    }
}