/** 
 * Anurag Bhandari (anurag.bhd@gmail.com)
 * 12-02-2009
 * 
 * DESCRIPTION:
 * This program extracts and returns many RPM properties for a RPM package.
 * 
 */

package rpm;

import java.io.*;
import java.util.Date;

class ExtractInfo {
    
    /* Instance Variables */
    private File file;
    private Runtime run;
    private BufferedReader buf;
    private String line;
    private String info;
    private Process p;
    
    /* Constructor */
    ExtractInfo(String f) throws IOException {
        file =  new File(f);
        run = Runtime.getRuntime();
    }
    

    /* Methods */
    // Replace all instances of a String in a String
    // I am using this method to replace all apostrophies "'" with "\'"
    // for making the complete string usable for the SQL syntax
    public String replace( String s, String f, String r ) {
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
    
    // Returns information about the package based on property passed as argument
    public String packageInfo(String property) throws IOException {
        p = run.exec("rpm -qp --queryformat %{" + property + "} " + file.getPath());
        buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
        info = "";
        while((line = buf.readLine()) != null) {
            info = info + line;
            if((line = buf.readLine()) != null) {
                //we are adding "line" here as we have read the next line in 
                //above if condition
                info = info + "\n" + line + "\n";
            }
        }
        p.destroy();
        return(info);
    }
    
    // Returns the last modified date of the file in a formal format
    public Date lastModifiedDate() {
       return(new Date(file.lastModified()));
    }
    
    // Returns the last modified date of the file in the normal format
    public long timeStamp() {
       return(file.lastModified());
    }
    
    // Returns the package file size in bytes
    public long sizePackage() {
        return(file.length());
    }
    
    // Returns the complete package file name
    public String fileName() {
        return(file.getName());
    }
}