/** This program explores some advanced aspects of enums.
 * That is, enums are almost like classes themselves.
 * 
 * @author anurag
 * @since 25-01-2009
 * 
 */

enum Month {
    JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30), 
    JULY(31), AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), 
    DECEMBER(31);
    
    /* instance variables */
    private int days;
    
    /* constructor */
    Month(int d) {
        days = d;
    }
    
    /* methods */
    public int getDays() {
        return days;
    }
}

class enumAdvanced {
    Month myBirthMonth = Month.JULY;
    
    public static void main(String args[]) {
        enumAdvanced obj = new enumAdvanced();
        System.out.println();
        System.out.print("My birth month is " + obj.myBirthMonth + ".");
        System.out.print(" It has " + obj.myBirthMonth.getDays() + " days.");
    }
}