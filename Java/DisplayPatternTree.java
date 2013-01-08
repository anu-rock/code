/* The program prints a tree-like structure made of stars
 * Author: Anurag Bhandari <anurag.bhd@gmail.com>
 * 23-12-2008
 */

class DisplayPatternTree {
    public static void main(String args[]) {
        int c, r;
        for(r=1; r<=10; r++) {
            for(c=1; c<=r; c++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}