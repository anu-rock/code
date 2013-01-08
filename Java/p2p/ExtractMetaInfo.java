/** CLIENT-SIDE 
 * Anurag Bhandari (anurag.bhd@gmail.com)
 * 29-01-2009
 * 
 * DESCRIPTION:
 * This program extracts and returns many metainfo properties for a file.
 * 
 * NOTES:
 * - Idea taken from:
 *   http://www.javareference.com/jrexamples/viewexample.jsp?id=4
 * - all the methods associated with type File:
 *   http://java.sun.com/j2se/1.5.0/docs/api/java/io/File.html#method_summary
 * 
 * Requires these libraries in the classpath:
 * - myid3.jar (http://www.fightingquaker.com/myid3/)
 * - jakarta-regexp-1.5.jar (http://jakarta.apache.org/regexp/)
 * - fast-md5.jar (http://www.twmacinta.com/myjava/fast_md5.php#tutorial)
 * 
 */

package p2p;

import java.io.*;
import java.util.Date;
import com.twmacinta.util.MD5; // for calculating md5sum
import org.cmc.music.myid3.*; // for extracting mp3 metadata
import org.cmc.music.metadata.*; // for extracting mp3 metadata

class ExtractMetaInfo {
    
    /* Instance variables */
    private File file;
    private String hash;
    private static String artist, album, song_title;
    
    /* Constructor */
    ExtractMetaInfo(String f) {
        file =  new File(f);
    }
    
   
    /* Methods */
    
    // Returns the file name
    public String name() {
        return(file.getName());
    }
    
    // Returns the complete file path
    public String path() {
        return(file.getPath());
    }
    
    // Returns the file size in bytes
    public long size() {
        return(file.length());
    }
    
    // Returns the type (extension) of the file
    public String type() {
        String fileName, fileExtension;
        fileName = file.getName();
        String[] splittedFileName = fileName.split("\\.");
        
        if(splittedFileName.length==1) {
            fileExtension = "unknown";
        }
        else {
            fileExtension = splittedFileName[splittedFileName.length-1];
        }
        return(fileExtension);
    }
    
    // Returns the last modified date of the file in a formal format
    public Date lastModifiedDate() {
       return(new Date(file.lastModified()));
    }
    
    // Returns the md5sum of the file
    public String md5sum() throws IOException {
        hash = MD5.asHex(MD5.getHash(new File(file.getPath())));
        return(hash);
    }
    
   // Metadata of mp3 file
    public String[] mp3Meta() throws Exception {
        MusicMetadataSet src_set = new MyID3().read(file); // read metadata
        if (src_set == null) {
            // Perhaps, no metadata
            artist = album = song_title = "NA";
        }
        //Debug.debug("src_set", src_set); // dump all info.
        //Debug.debug("src_set", src_set.getArtist()); 
        IMusicMetadata metadata = src_set.getSimplified();
        artist = metadata.getArtist();  
        album = metadata.getAlbum();  
        song_title = metadata.getSongTitle(); 
        //int track_number = metadata.getTrackNumber();
        String[] mp3MetaData = new String[3];
        if(artist==null)
            mp3MetaData[0] = "NA";
        else
            mp3MetaData[0] = artist;
        if(album==null)
            mp3MetaData[1] = "NA";
        else
            mp3MetaData[1] = album;
        if(song_title==null)
            mp3MetaData[2] = "NA";
        else
            mp3MetaData[2] = song_title;
        
        return(mp3MetaData);
    }
    
    // General function to return metadata of a file
    public String[] metaData(String fileType) throws Exception {
        String [] metaData = new String[3];
        if(fileType.equals("mp3")) {
            metaData = mp3Meta();
        }
        else {
            metaData[0] = "Feature not implemented";
            metaData[1] = "Feature not implemented";
            metaData[2] = "Feature not implemented";
        }
        return(metaData);
    }
}