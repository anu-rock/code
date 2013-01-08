/* The program prints an inverted triangle made of stars
 * Author: Anurag Bhandari <anurag.bhd@gmail.com>
 * 23-12-2008
 */

class InvertedTriangle {
    public static void main(String args[]) {
        int r, c, b;
        int blank = 0;
        for(r=20; r>=1; r-=2) { //loop for row
            for(b=0; b<blank; b++) { //loop for blanks
                System.out.print(" ");    
            }
            for(c=1; c<=r; c++) { //loop for stars (columns)
                System.out.print("*");
            }
            System.out.print("\n"); //a new line after each row
            blank++; //increment blank by 1
        }
    }
}