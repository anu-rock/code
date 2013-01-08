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

class ExtractInfoOld {
    
    /* Instance Variables */
    private int i, counter;
    private File file;
    private Runtime run;
    private BufferedReader buf;
    private String line, name, version, release, group;
    private String sizeInstalled, packager, url, summary;
    private String description;
    
    /* Constructor */
    ExtractInfoOld(String f) throws IOException {
        file =  new File(f);
        run = Runtime.getRuntime();
        Process p = run.exec("rpm -qip " + file.getPath());
        buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
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
    
    // Returns the name of the package
    public String name() throws IOException {
        line = buf.readLine();
        counter = 0;
        for(i=14; i<line.length(); i++) {
            counter = counter + 1;
            if(line.charAt(i)==' ') {
                break;
            }
        }
        name = line.substring(14, (14+counter)-1);
        return(name);
    }
    
    // Returns the version of the package
    public String version() throws IOException {    
        line = buf.readLine();
        counter = 0;
        for(i=14; i<line.length(); i++) {
            counter = counter + 1;
            if(line.charAt(i)==' ') {
                break;
            }
        }
        version = line.substring(14, (14+counter)-1);
        return(version);
    }
    
    // Returns the version release of the package
    public String release() throws IOException {
        line = buf.readLine();
        counter = 0;
        for(i=14; i<line.length(); i++) {
            counter = counter + 1;
            if(line.charAt(i)==' ') {
                break;
            }
        }
        release = line.substring(14, (14+counter)-1);
        return(release);
    }
    
    // Returns the group of the package
    public String group() throws IOException {
        //skipping "Install Date" info
        line = buf.readLine();
        /* Group */
        line = buf.readLine();
        counter = 0;
        for(i=14; i<line.length(); i++) {
            counter = counter + 1;
            if(line.charAt(i)==' ') {
                break;
            }
        }
        group = line.substring(14, (14+counter)-1);
        return(group);
    }
    
   // Returns the size (in bytes) of the package after installation
    public String sizeInstalled() throws IOException {
        line = buf.readLine();
        counter = 0;
        for(i=14; i<line.length(); i++) {
            counter = counter + 1;
            if(line.charAt(i)==' ') {
                break;
            }
        }
        sizeInstalled = line.substring(14, (14+counter)-1);
        return(sizeInstalled);
    }
    
    // Returns the packager of the package
    public String packager() throws IOException {
        //skipping "Signature" info
        line = buf.readLine();
        
        /* Packager */
        line = buf.readLine();
        // Check if this line really defines the "Packager" property
        // In some RPMs, "Packager" might not be mentioned
        if((line.substring(0,8)).equalsIgnoreCase("Packager")) {
            counter = 0;
            for(i=14; i<line.length(); i++) {
                counter = counter + 1;
                if(line.charAt(i)=='\n') {
                    break;
                }
            }
            packager = line.substring(14, (14+counter));
            
            // Read the next line (probably "URL")
            line = buf.readLine();
        }
        else
            packager = "NA";
        return(packager);
    }
    
    // Returns the source url of the package
    public String url() throws IOException {
        // Check if this line really defines the "URL" property
        // In some RPMs, "URL" might not be mentioned
        if((line.substring(0,3)).equalsIgnoreCase("URL")) {
            counter = 0;
            for(i=14; i<line.length(); i++) {
                counter = counter + 1;
                if(line.charAt(i)=='\n') {
                    break;
                }
            }
            url = line.substring(14, (14+counter));
            
            // Read the next line (definitely "Summary")
            line = buf.readLine();
        }
        else
            url = "NA";
        return(url);
    }
    
    // Returns the summary of the package
    public String summary() throws IOException {
        counter = 0;
        for(i=14; i<line.length(); i++) {
            counter = counter + 1;
            if(line.charAt(i)=='\n') {
                break;
            }
        }
        summary = line.substring(14, (14+counter));
        return(summary);
    }
    
    // Returns the description of the package
    public String description() throws IOException {
        //skipping "Description" label
        line = buf.readLine();
        
        /* Description */
        description = "";
        while((line = buf.readLine()) != null) {
            description = description + line + "\n";
        }
        return(description);
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