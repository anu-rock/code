/** CLIENT-SIDE 
 * Anurag Bhandari (anurag.bhd@gmail.com)
 * 28-02-2009
 * 
 * DESCRIPTION:
 * This program sends the search keyword to the server app which in turn returns the search 
 * results back to this program.
 * 
 */

package p2p;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.net.*;

public class SearchDB {
    
    /* Instance Variables */
    String searchKey, serverIP;
    ArrayList<String> resultArrayList;
    Socket client;
    InputStream instream;
    OutputStream outstream;
    ObjectOutputStream obout;
    ObjectInputStream obin;
    
    /* Constructor */
    public SearchDB(String keyword, String IP) {
        searchKey = keyword;
        serverIP = IP;
    }
    
    
    /* Methods */
    public static byte[] toBytes(Object object) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
        } catch (IOException ex) {
            Logger.getLogger(SearchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return baos.toByteArray();
    }

    public static Object toObject(byte[] bytes) {
        Object object = null;
        try {
            object = new ObjectInputStream(new ByteArrayInputStream(bytes)).readObject();
        } catch (IOException ex) {
            Logger.getLogger(SearchDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }
    
      
    // The method that performs actual searching
    public ArrayList<String> performSearch() throws IOException {  
        client = new Socket(InetAddress.getByName(serverIP), 5432);
        outstream = client.getOutputStream();
        //obout = new ObjectOutputStream(outstream);
        
        // Send search keyword to server
        byte[] bytearray = toBytes(searchKey);
        int size = bytearray.length;
        try {
            obout.writeInt(size);
            obout.flush();
            outstream.write(bytearray);
            outstream.flush();
        } catch (IOException ex) {
            Logger.getLogger(SearchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Receive the result from server
        bytearray = null;
        //instream = client.getInputStream();
        //obin = new ObjectInputStream(instream);
        try {
            size = obin.readInt();
        } catch (IOException ex) {
            Logger.getLogger(SearchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        bytearray = new byte[size];
        try {
            instream.read(bytearray);
        } catch (IOException ex) {
            Logger.getLogger(SearchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultArrayList = (ArrayList<String>) toObject(bytearray);
        return(resultArrayList);
    }
}