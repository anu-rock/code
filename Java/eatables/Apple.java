/** A simple program that demonstrates the use of interfaces.
 *
 * @author: Anurag Bhandari <anurag.bhd@gmail.com>
 * @date: 07-01-2009
 */

package eatables;

/* An interface should be used when there is a need to define a class which
 * is not a noun, but an adjective. An interface is a kind of abstract class.
 * Classes are nouns whereas interfaces are adjectives.
 */

interface edible {
    void eat();
    void setTasteValue(int tv);
}

class Apple implements edible {
    public static int tasteValue;
    public static String name;
    public static String color;
    // Constructor
    Apple(String n) {
        name = n;
    }
    /* Interface editble's implemented methods */
    public void eat() {
        System.out.println("Ahh! Eaten it!");
    }
    public void setTasteValue(int tv) {
        tasteValue = tv;
    }
    
    /* This class's own methods */
    public void setColor(String c) {
        color = c;
    }
    public void displayInfo() {
        System.out.println("I am " + name);
        System.out.println("My color is " + color);
        System.out.println("I have a taste value of " + tasteValue + " out of 10");
    }
    public static void main(String args[]) {
        Apple apple1 = new Apple("Apple1"); // creating a new apple
        apple1.eat(); //eating our apple
        apple1.setColor("Red"); //setting the color of our apple
        apple1.setTasteValue(8); //setting the taste value of our apple
        apple1.displayInfo(); // displaying all properties of our appple
    }
}