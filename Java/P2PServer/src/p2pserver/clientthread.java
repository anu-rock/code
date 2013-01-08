package p2pserver;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

class clientthread extends Thread {

    static Map<Socket, List<String>> Table = new HashMap<Socket, List<String>>();
    Socket client;
    OutputStream outstream = null;
    InputStream instream = null;
    ObjectInputStream obin;
    ObjectOutputStream obout;
    private static String query_view_create, query_view_delete, query_search;
    private static String searchKey, fileName, fileMD5,songArtist, songAlbum;
    private static ArrayList<String> resultArrayList;
    private static ArrayList<String> searchResult;

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

    public static Object toObject(byte[] bytes) {
        Object object = null;
        try {
            object = new ObjectInputStream(new ByteArrayInputStream(bytes)).readObject();
        } catch (IOException ex) {
            Logger.getLogger(clientthread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clientthread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    clientthread(Socket skt) {
        this.client = skt;
        try {
            this.instream = client.getInputStream();
            this.outstream = client.getOutputStream();
            obin = new ObjectInputStream(instream);
            obout = new ObjectOutputStream(outstream);
            Table.put(skt, null);
        } catch (IOException ex) {
            Logger.getLogger(clientthread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run() {
        int i;
        try {
            //BufferedReader br = new BufferedReader(new InputStreamReader(instream));
            //this.setName(br.readLine());
            //System.out.println("new user entered:" + this + "\n");
            while ((i = (int) instream.read()) != -1) {
                if (i == 1) {
                    List<String> filesname = null;
                    //System.out.println("i reached in if");
                    //System.out.println(br.readLine());
                    byte[] bytearray = null;
                    int size = obin.readInt();
                    bytearray = new byte[size];
                    i = instream.read(bytearray);
                    filesname = (List<String>) toObject(bytearray);
                    Table.remove(this.client);
                    Table.put(this.client, filesname);
                    System.out.println("files " + this + " is sharing are:");
                    filesname = Table.get(this.client);
                    Iterator me = filesname.iterator();
                    while (me.hasNext()) {
                        System.out.println(me.next() + "\n");
                    }
                    System.out.println(this + ":added files information to server\n");
                } else if (i == 2) {
                    byte[] bytearray = null;
                    int size = obin.readInt();
                    bytearray = new byte[size];
                    instream.read(bytearray);
                    searchKey = (String) toObject(bytearray);
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
                    
                        /* Initializing the "connection" to null */
                        Connection connection = null;
                    
                        /* The actual connection to DB */
                        connection = DriverManager.getConnection(url, username, password);
            
                        /* Displaying connection related info */
                        System.out.println("Connection: " + connection);
            
                        /* Creating objects to handle queries */
                        Statement stmt = connection.createStatement();
                        ResultSet rs;
                        
                        query_search = "SELECT * FROM files WHERE file_md5='"+ searchKey + "'";
                        rs = stmt.executeQuery(query_search);
                        
                        Map<InetAddress,String> result = new HashMap<InetAddress,String>();
                        String filePath;
                        String peerIPAddress;
                        while(rs.next()) {
                            filePath = rs.getString("file_path");
                            peerIPAddress = rs.getString("peer_ip");
                            result.put(InetAddress.getByName(peerIPAddress), filePath);
                        }
                        System.out.println("Server is sending result to " + this.client + ":");
                        bytearray = toBytes(result);
                        size = bytearray.length;
                        obout.writeInt(size);
                        obout.flush();
                        outstream.write(bytearray);
                        outstream.flush();

                        connection.close();
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if (i == 3) {
                    try {
                        // Receive the search keyword
                        byte[] bytearray = null;
                        int size = obin.readInt();
                        bytearray = new byte[size];
                        instream.read(bytearray);
                        searchKey = (String) toObject(bytearray);
                
                        // Perform search and send back result to client
                        searchResult = performSearch(searchKey);
                        bytearray = toBytes(searchResult);
                        size = bytearray.length;
                        obout.writeInt(size);
                        obout.flush();
                        outstream.write(bytearray);
                        outstream.flush();

                        System.out.println("Search result sent to client");
                    }
                    catch (IOException ex) {
                        Logger.getLogger(SearchDBThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        catch (IOException ex) {
            Logger.getLogger(clientthread.class.getName()).log(Level.SEVERE, null, ex);
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
            
            
                }
                catch (Exception e) {
                    // Could not find the database driver 
                    System.out.println(e.getMessage());
                }
                return(resultArrayList);
            }
}