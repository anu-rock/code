/* This is my first Java program. It displays inputted command-line arguments.
 * Author: Anurag Bhandari
 * 23-12-2008
 */

class DisplayCLArgs {
    public static void main(String arguments[]) {
        System.out.println("You typed: ");
        int c = 0;
        while(c<arguments.length) {
            System.out.println(arguments[c]);
            ++c;
        }
    }
}