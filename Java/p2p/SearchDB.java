/** CLIENT-SIDE 
 * Anurag Bhandari (anurag.bhd@gmail.com)
 * 28-02-2009
 * 
 * DESCRIPTION:
 * This program searches the DB using the keyword(s) supplied by the user 
 * to return/display a list of relevant files found.
 * 
 * USAGE:
 * - Command:
 *   java p2p/SearchDB "--searchterm in quotes--"
 * 
 */

package p2p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SearchDB {
    
    /* Instance Variables */
    private static String query_view_create, query_view_delete, query_search;
    private static String searchKey, fileName, filePath;
    private static ArrayList resultArrayList;
    
    /* Constructor */
    SearchDB(String keyword) {
        searchKey = keyword;
    }
    
    
    /* Methods */
    // The method that performs actual searching
    public static ArrayList performSearch() {
        /* Initializing the "connection" to null */
        Connection connection = null;
        
        try {
            /* MySQL driver info */
            String driverName = "com.mysql.jdbc.Driver"; // MySQL JDBC driver
            Class.forName(driverName); 
        
            /* MySQL server & DB info */
            String serverName = "localhost:3306";
            String dbName = "p2pdb";
            String url = "jdbc:mysql://" + serverName + "/" + dbName; // a JDBC url
            String username = "root";
            String password = "";
            
            /* The actual connection to DB */
            connection = DriverManager.getConnection(url, username, password);
            
            /* Displaying connection related info */
            System.out.println("Connection: " + connection);
            
            /* Creating objects to handle queries */
            Statement stmt = connection.createStatement();
            ResultSet rs;
            
            
            /* Search the DB */
            //The command-line argument keyword searching method
            /*for(int i=0; i<args.length; i++) {
                if(i==args.length-1)
                    searchKey = args[i];
                else
                    searchKey = args[i] + " ";
            }*/
            
            query_view_create = "CREATE VIEW complete_file_info AS SELECT metainfo.file_id, metainfo.song_title, metainfo.artist, metainfo.album, files.file_name, files.file_path, files.file_size, files.file_type, files.file_last_modified, files.file_md5 FROM metainfo INNER JOIN files where metainfo.file_id=files.file_id";
            stmt.executeUpdate(query_view_create);
            
            query_search = "SELECT * FROM complete_file_info WHERE file_name like '%" + searchKey + "%' OR song_title like '%" + searchKey + "%' OR artist like '%" + searchKey + "%' OR album like '%" + searchKey + "%'";
            rs = stmt.executeQuery(query_search);
            
            // Old way of printing search result in command-line
            /*int counter = 0;
            while(rs.next()) {
                fileName = rs.getString("file_name");
                System.out.println(fileName);
                counter++;
            }
            System.out.println("Total results: " + counter);*/
            
            resultArrayList = new ArrayList();
            while(rs.next()) {
                fileName = rs.getString("file_name");
                filePath = rs.getString("file_path");
                resultArrayList.add(fileName + ":" + filePath);
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
    
    // The "main" method
    /*public static void main(String args[]) {
        SearchDB obj = new SearchDB("coldplay");
        @SuppressWarnings("static-access")
        ArrayList temp = obj.performSearch();
        for(int i=0; i<temp.size(); i++) {
            System.out.println(temp.get(i));
        }
    }*/

}