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
 *   java p2p/PostToFile "<full path to folder>"
 * 
 */

package p2p;

import java.io.*;
import java.util.*;

public class PostToFile {
    
    /* Instance Variables */
    private String fileName, filePath, fileMD5, fileType;
    private String sharedFolder;
    private long fileSize;
    private Date lastModified;
    private String artist, album, song_title;
    private String[] metaInfo;
    
    public PostToFile(String folder) {
        sharedFolder = folder;
    }
    
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
    
    
    // Our main method
    public void generateFile() throws Exception {
       
            /* Dump data into a file */
            
            // Scan the directory containing files to be shared
            DirectoryScanner d = new DirectoryScanner();
            File[] listOfFiles = d.filePathList(sharedFolder);
            
            BufferedWriter out = new BufferedWriter(new FileWriter("file-list.txt"));
            
            // Do this for each file in the list of files in scanned directory
            for(File file : listOfFiles) {
                // Extract the metainfo out of the current file
                ExtractMetaInfo f = new ExtractMetaInfo(file.getPath());
                fileName = f.name();
                filePath = f.path();
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
                        artist = metaInfo[0];
                        album = metaInfo[1];
                        song_title = metaInfo[2];
                        
                        // Writing data to file    
                        out.write(fileName+'*'+filePath+'*'+fileSize+'*'+fileType+'*'+lastModified+'*'+fileMD5+'*'+song_title+'*'+artist+'*'+album);
                        out.newLine();

                    }
                }
            }
            out.close();
    }
}