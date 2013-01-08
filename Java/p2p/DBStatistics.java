/** CLIENT-SIDE 
 * Anurag Bhandari (anurag.bhd@gmail.com)
 * 28-02-2009
 * 
 * DESCRIPTION:
 * This program performs various queries on our central database to extract 
 * general statistical information about files from it.
 * 
 */

package p2p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class DBStatistics {
    
    /* Instance Variables */
    private static float totalSize;
    private static long totalFiles;
    private static String unit = "Bytes"; 
    private static String query;
    
    /* Methods */
    
    // The "main" method
    public static void main(String args[]) {
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
            
            
            /* Queries on DB */
            // TOTAL SIZE OF FILES
            query = "SELECT SUM(file_size) from files";
            rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                totalSize= rs.getFloat("SUM(file_SIZE)"); // in Bytes
                // convert to KB
                if(totalSize>=1024) {
                    totalSize = totalSize/1024;
                    unit = "KB";
                }
                // convert to MB
                if(totalSize>=1024) {
                    totalSize = totalSize/1024;
                    unit = "MB";
                }
                // convert to GB
                if(totalSize>=1024) {
                    totalSize = totalSize/1024;
                    unit = "GB";
                }
                System.out.println("Total size of files in DB: "+ totalSize + " " + unit);
            }
            
            // TOTAL NUMBER OF FILES
            query = "SELECT COUNT(file_name) from files";
            rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                totalFiles = rs.getLong("COUNT(file_name)");
                System.out.println("Total number of files in DB: "+ totalFiles);
            }

            /* Closing the MySQL connection */
            connection.close();
            
        } catch (ClassNotFoundException e) {
            // Could not find the database driver 
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            // Could not connect to the database 
            System.out.println(e.getMessage());
        }        
    }
}