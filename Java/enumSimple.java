/** This is a simple example of an enum (declared within a class).
 * 
 * @author anurag
 * @since 25-01-2009
 * 
 */

class enumSimple {
    enum direction { NORTH, SOUTH, EAST, WEST };
    public static void main(String args[]) {
        direction direction1 = direction.EAST;
        System.out.println(direction1);
    }
}