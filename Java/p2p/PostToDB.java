/** CLIENT-SIDE 
 * Anurag Bhandari (anurag.bhd@gmail.com)
 * 29-01-2009
 * 
 * DESCRIPTION:
 * This program scans the shared directory for files in it, extracts metainfo 
 * for each file in the file list, and dumps the extracted metainfo about each 
 * file into the MySQL database.
 * 
 * CLASSES USED:
 * - DirectoryScanner
 * - ExtractMetaInfo
 * - ReadTextFile
 * 
 * USAGE:
 * - Command:
 *   java p2p/PostToDB --full path to folder--
 * 
 */

package p2p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.util.Date;

class PostToDB {
    
    /* Instance Variables */
    private static String fileName, filePath, fileMD5, fileType;
    private static long fileSize;
    private static Date lastModified;
    private static String artist, album, song_title;
    private static String[] metaInfo;
    
    
    /* Methods */
    
    // Checks if the type/extension of a file is one of the allowed types
    public static boolean filter(String extensionList, String fileExtension) {
        boolean flag = false;
        String[] allowedTypes = extensionList.split(",");
        for(String type : allowedTypes) {
            if(type.equals(fileExtension)) {
                flag = true;
            }
        }
        return(flag);
    }
    
    // Replace all instances of a String in a String
    // I am using this method to replace all apostrophies "'" with "\'"
    // for making the complete string usable for the SQL syntax
    public static String replace( String s, String f, String r ) {
        if (s == null)  return s;
        if (f == null)  return s;
        if (r == null)  r = "";

        int index01 = s.indexOf( f );
        while (index01 != -1) {
            s = s.substring(0,index01) + r + s.substring(index01+f.length());
            index01 += r.length();
            index01 = s.indexOf( f, index01 );
        }
        return s;
    }
    
    // The "main" method
    public static void main(String args[]) throws Exception {
        /* Initializing the "connection" to null */
        Connection connection = null;
        
        try {
            /* MySQL driver info */
            String driverName = "com.mysql.jdbc.Driver"; // MySQL JDBC driver
            Class.forName(driverName); 
        
            /* MySQL server & DB info */
            // Getting this info from text file
            File myFile = new File("p2p_config.txt");
            ReadTextFile theFile = new ReadTextFile();
            @SuppressWarnings("static-access")
            String[] configValues = theFile.getContents(myFile).split(":");
            
            String serverName = configValues[1];
            String dbName = configValues[3];
            String url = "jdbc:mysql://" + serverName + "/" + dbName; // a JDBC url
            String username = configValues[5];
            String password = configValues[7];
            
            /* The actual connection to DB */
            connection = DriverManager.getConnection(url, username, password);
            
            /* Displaying connection related info */
            System.out.println("Connection: " + connection);
            
          
            /* Dump data into DB */
            
            // Scan the directory containing files to be shared
            DirectoryScanner d = new DirectoryScanner();
            File[] listOfFiles = d.filePathList(args[0]);
            
            Statement stmt = connection.createStatement();
            
            // Do this for each file in the list of files in scanned directory
            for(File file : listOfFiles) {
                // Extract the metainfo out of the current file
                ExtractMetaInfo f = new ExtractMetaInfo(file.getPath());
                fileName = replace(f.name(), "\'", "\\\'");
                filePath = replace(f.path(), "\'", "\\\'");
                fileSize = f.size();
                fileType = f.type();
                lastModified = f.lastModifiedDate();
                
                // Proceed only if the file type is one of specified in the 
                // filter list. The allowed file types should be mentioned 
                // in the first argument space, separated by commas.
                if(filter("mp3,wma", fileType)) {
                    if(!file.isDirectory()) {
                        // Calculate the md5sum only if it's not a directory, 
                        // otherwise, exception will occur telling something like  
                        // md5 cannot be applied to directory
                        fileMD5 = f.md5sum();
                        
                        // Metadata of file
                        metaInfo = f.metaData(fileType);
                        artist = replace(metaInfo[0], "\'", "\\\'");
                        album = replace(metaInfo[1], "\'", "\\\'");
                        song_title = replace(metaInfo[2], "\'", "\\\'");
                  
                        // Actually dumping data into DB
                        // Dump the data only if it's not a directory
                        String query_files = "INSERT INTO files (file_name, file_path, " + 
                            "file_size, file_type, file_last_modified, file_md5) " +
                            "values ('" + fileName + "', '" + filePath + "', '" + 
                            fileSize + "', '" + fileType + "', '" + lastModified + 
                            "', '" + fileMD5 + "')";
                        stmt.executeUpdate(query_files);
                        String query_metainfo = "INSERT INTO metainfo (song_title, " + 
                            "artist, album) " + "values ('" + song_title + "', '" 
                            + artist + "', '" + album + "')";
                        stmt.executeUpdate(query_metainfo);
                    }
                }
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