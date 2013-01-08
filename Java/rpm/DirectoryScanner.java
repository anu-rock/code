/**  
 * Anurag Bhandari (anurag.bhd@gmail.com)
 * 12-02-2009
 * 
 * DESCRIPTION:
 * This program scans a directory and returns the list of files contained 
 * in it, including sub-directories.
 * 
 */

package rpm;

import java.io.File;

class DirectoryScanner {
    
    /* Instance variables */
    private String folder;
    
    /* Constructor */
    DirectoryScanner(String d) {
        folder = d;
    }
    
   
    /* Methods */
    
    // Returns the list of files contained in the directory to be scanned
    public File[] filePathList() {
        File directory = new File(folder);
        return(directory.listFiles());
    }
}