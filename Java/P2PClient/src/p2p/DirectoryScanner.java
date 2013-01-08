/** CLIENT-SIDE 
 * Anurag Bhandari (anurag.bhd@gmail.com)
 * 29-01-2009
 * 
 * DESCRIPTION:
 * This program scans a directory recursively and returns the list of files 
 * contained in it, including sub-directories and their files.
 * 
 */

package p2p;

import java.io.File;

class DirectoryScanner {
    
    /* Instance variables */
    private File[] listOfFiles;
    
   
    /* Methods */
    
    // Concatenates two "arrays" of type File together.
    public File[] concatenateArrays(File[] A, File[] B) {
        File[] C= new File[A.length+B.length];
        System.arraycopy(A, 0, C, 0, A.length);
        System.arraycopy(B, 0, C, A.length, B.length);
        return C;
    }

    
    // Returns the list of files contained in the directory to be scanned.
    // Note that this method generates file list recursively.
    public File[] filePathList(String folder) {
        File directory = new File(folder);
        listOfFiles = directory.listFiles();
        for(File file : directory.listFiles()) {
            if(file.isDirectory()) {
                // Recursivity logic
                listOfFiles = concatenateArrays(listOfFiles, filePathList(file.getPath()));
            }
        }
        return(listOfFiles);
    }
}