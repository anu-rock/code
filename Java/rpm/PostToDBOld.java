/**
 * Anurag Bhandari (anurag.bhd@gmail.com)
 * 12-02-2009
 * 
 * DESCRIPTION:
 * This program scans the repository directory for RPMs in it, extracts rpminfo 
 * for each RPM in the file list, and dumps the extracted rpminfo about each 
 * RPM into the MySQL database.
 * 
 * CLASSES USED:
 * - DirectoryScanner
 * - ExtractInfoOld
 * - ReadTextFile
 * 
 */

package rpm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.util.Date;

class PostToDBOld {
    
    private static String packageName, packageVersion, packageRelease;
    private static String packageGroup, packageSizeInstalled, packagePackager;
    private static String packageUrl, packageSummary, packageDescription;
    private static long packageSize, timeStamp;
    private static Date lastModified;
    private static String fileName;
    
    @SuppressWarnings("static-access")
    public static void main(String args[]) throws IOException {
        /* Initializing the "connection" to null */
        Connection connection = null;
        
        try {
            /* MySQL driver info */
            String driverName = "com.mysql.jdbc.Driver"; // MySQL JDBC driver
            Class.forName(driverName); 
        
            /* MySQL server & DB info */
            String serverName = "localhost";
            String dbName = "rpmdb";
            String url = "jdbc:mysql://" + serverName + "/" + dbName; // a JDBC url
            String username = "anurag";
            String password = "anurag05";
            
            /* The actual connection to DB */
            connection = DriverManager.getConnection(url, username, password);
            
            /* Displaying connection related info */
            System.out.println("Connection: " + connection);
            
          
            /* Dump data into DB */
            
            // Scan the directory containing files to be shared
            File myFile = new File("repository_location.txt");
            ReadTextFile theFile = new ReadTextFile();
            String repoSection = args[0];

            
            DirectoryScanner d = new DirectoryScanner(theFile.getContents(myFile) + "RPMS." + repoSection);
            File[] listOfFiles = d.filePathList();
            
            Statement stmt = connection.createStatement();
            
            // Do this for each file in the list of files in scanned directory
            for(File file : listOfFiles) {
                // Extract the metainfo out of the current file
                ExtractInfoOld f = new ExtractInfoOld(file.getPath());
                packageName = f.name();
                packageVersion = f.version();
                packageRelease = f.release();
                packageGroup = f.group();
                packageSizeInstalled = f.sizeInstalled();
                packagePackager = f.packager();
                packageUrl = f.url();
                packageSummary = f.replace(f.summary(), "\'", "\\\'");
                packageDescription = f.replace(f.description(), "\'", "\\\'");
                packageSize = f.sizePackage();
                lastModified = f.lastModifiedDate();
                timeStamp = f.timeStamp();
                fileName = f.fileName();
                // Actually dumping data into DB
                // Dump the data only if it's not a directory
                String query = "INSERT INTO packages (package_name, package_version," + 
                    " package_release, package_group, package_size_installed, package_packager," +
                    " package_url, package_summary, package_description, package_size," +
                    " package_last_modified, package_timestamp, package_repo_section, package_file_name)" +
                    " values ('" + packageName + "', '" +  packageVersion +  "', '" + 
                    packageRelease + "', '" + packageGroup + "', '" + packageSizeInstalled + "', '" + 
                    packagePackager + "', '" + packageUrl + "', '" + packageSummary + "', '" + 
                    packageDescription + "', '" +  packageSize + "', '" + lastModified + "', '" + 
                    timeStamp + "', '" + repoSection + "', '" + fileName + "')";
                stmt.executeUpdate(query);
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