/** SERVER-SIDE 
 * Anurag Bhandari (anurag.bhd@gmail.com)
 * 28-02-2009
 * 
 * DESCRIPTION:
 * This program searches the DB using the keyword(s) supplied by the user 
 * to return/display a list of relevant files found.
 * 
 */

package p2pserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchDBThread extends Thread {
    
    /* Instance Variables */
    private static String query_view_create, query_view_delete, query_search;
    private static String searchKey, fileName, fileMD5,songArtist, songAlbum;
    private static ArrayList<String> resultArrayList;
    private static ArrayList<String> searchResult;
    Socket SDT_client = null;
    InputStream SDT_in = null;
    OutputStream SDT_outstream = null;
    InputStream SDT_instream = null;
    ObjectInputStream SDT_obin = null;
    ObjectOutputStream SDT_obout = null;
    
    /* Methods */
    public static Object toObject(byte[] bytes) {
        Object object = null;
        try {
            object = new ObjectInputStream(new ByteArrayInputStream(bytes)).readObject();
        } catch (IOException ex) {
            Logger.getLogger(SearchDBThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchDBThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }
    
    public static byte[] toBytes(Object object) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
        } catch (IOException ex) {
            Logger.getLogger(clientthread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return baos.toByteArray();
    }
    
    SearchDBThread(Socket skt) {
        this.SDT_client = skt;
        try {
            this.SDT_instream = SDT_client.getInputStream();
            this.SDT_outstream = SDT_client.getOutputStream();
            this.SDT_obin = new ObjectInputStream(SDT_instream);
            this.SDT_obout = new ObjectOutputStream(SDT_outstream);
        } catch (IOException ex) {
            Logger.getLogger(SearchDBThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        

    public void run() {

        while (true) {
            try {
                // Receive the search keyword
                byte[] bytearray = null;
                int size = SDT_obin.readInt();
                bytearray = new byte[size];
                SDT_instream.read(bytearray);
                searchKey = (String) toObject(bytearray);
                
                // Perform search and send back result to SDT_client
                searchResult = performSearch(searchKey);
                bytearray = toBytes(searchResult);
                size = bytearray.length;
                SDT_obout.writeInt(size);
                SDT_obout.flush();
                SDT_outstream.write(bytearray);
                SDT_outstream.flush();

                System.out.println("Search result sent to client");
            }
            catch (IOException ex) {
                Logger.getLogger(SearchDBThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // The method that performs actual searching
    public ArrayList<String> performSearch(String key) {
        /* Initializing the "connection" to null */
        Connection connection = null;
        
        try {
            /* MySQL driver info */
            String driverName = "com.mysql.jdbc.Driver"; // MySQL JDBC driver
            Class.forName(driverName); 
        
            /* MySQL server & DB info */
            // Getting this info from text file
            File configFile = new File("p2p_config.txt");
            ReadTextFile theFile = new ReadTextFile();
            @SuppressWarnings("static-access")
            String[] configValues = theFile.getContents(configFile).split(":");
            
            String serverName = configValues[1];
            String dbName = configValues[3];
            String url = "jdbc:mysql://" + serverName + "/" + dbName; // a JDBC url
            String username = configValues[5];
            String password = configValues[7];
            
            /* The actual connection to DB */
            connection = DriverManager.getConnection(url, username, password);
            
            /* Displaying connection related info */
            System.out.println("Connection: " + connection);
            
            /* Creating objects to handle queries */
            Statement stmt = connection.createStatement();
            ResultSet rs;
            
            
            query_view_create = "CREATE VIEW complete_file_info AS SELECT metainfo.file_id, metainfo.song_title, metainfo.artist, metainfo.album, files.file_name, files.file_path, files.file_size, files.file_type, files.file_last_modified, files.file_md5 FROM metainfo INNER JOIN files where metainfo.file_id=files.file_id";
            stmt.executeUpdate(query_view_create);
            
            query_search = "SELECT * FROM complete_file_info WHERE file_name like '%" + searchKey + "%' OR song_title like '%" + searchKey + "%' OR artist like '%" + searchKey + "%' OR album like '%" + searchKey + "%'";
            rs = stmt.executeQuery(query_search);
            
            resultArrayList = new ArrayList<String>();
            while(rs.next()) {
                fileName = rs.getString("file_name");
                fileMD5 = rs.getString("file_md5");
                songArtist = rs.getString("artist");
                songAlbum = rs.getString("album");
                resultArrayList.add(fileName + ":" + fileMD5 + ":" + songArtist + ":" + songAlbum);
            }
            
            query_view_delete = "DROP VIEW complete_file_info";
            stmt.executeUpdate(query_view_delete);

            /* Closing the MySQL connection */
            connection.close();
            
            
        } catch (ClassNotFoundException e) {
            // Could not find the database driver 
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            // Could not connect to the database 
            System.out.println(e.getMessage());
        }        
        return(resultArrayList);
    }
}