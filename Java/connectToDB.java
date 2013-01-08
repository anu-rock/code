/** This is the simplest program to demonstrate the connectivity to a MySQL 
 * database, execution of queries, retrieving results, and displaying them.
 * 
 * @author: Anurag Bhandari
 * @since: 27-01-2009
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class connectToDB {
    public static void main(String args[]) {
        /* Initializing the "connection" to null */
        Connection connection = null;
        
        try {
            /* MySQL driver info */
            String driverName = "com.mysql.jdbc.Driver"; // MySQL JDBC driver
            Class.forName(driverName); 
        
            /* MySQL server & DB info */
            String serverName = "localhost:3306";
            String dbName = "surveydb";
            String url = "jdbc:mysql://" + serverName + "/" + dbName; // a JDBC url
            String username = "anurag";
            String password = "anurag05";
            
            /* The actual connection to DB */
            connection = DriverManager.getConnection(url, username, password);
            
            /* Displaying connection related info */
            System.out.println("Connection: " + connection);
            
            /* Fetching & displaying info from DB */
            System.out.println();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM users");
            while(result.next()) {
                int user_id = result.getInt("user_id");
                String first_name = result.getString("first_name");
                System.out.println(user_id + " " + first_name);
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