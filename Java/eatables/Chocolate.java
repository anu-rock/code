/** Program which makes use of an interface from another file of the same package.
 *
 * @author: Anurag Bhandari <anurag.bhd@gmail.com>
 * @date: 07-01-2009
 */

package eatables;

class Chocolate implements edible {
    public static int tasteValue;
    public static String name;
    public static String color;
    Chocolate(String n) {
        name = n;
        color = "Brown";
    }
    public void eat() {
        System.out.println("Ahh! Eaten it!");
    }
    public void setTasteValue(int tv) {
        tasteValue = tv;
    }
    public void displayInfo() {
        System.out.println("I am " + name);
        System.out.println("My color is " + color);
        System.out.println("I have a taste value of " + tasteValue + " out of 10");
    }
    public static void main(String args[]) {
        /* Creating Five Star */
        Chocolate choco1 = new Chocolate("Five Star");
        choco1.setTasteValue(10);
        choco1.displayInfo();
        System.out.println();
        /* Creating Dairy Milk */
        Chocolate choco2 = new Chocolate("Dairy Milk");
        choco2.setTasteValue(9);
        choco2.displayInfo();
    }
}