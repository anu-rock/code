/* A simple arithmetic calculator. Supports the 4 basic arithmetic
 * operations.
 * 
 * Comments: due to some weird reasons, program does not work with 
 * operator "*". So, I have used "x" instead.
 * 
 * @author Anurag Bhandari <anurag.bhd@gmail.com>
 * 24-12-2008
 */

class ArithCalc {
    /* define functions to perform four basic arithmetic operations */
    public static double addition(double op1, double op2) {
        return(op1+op2);
    }
    public static double subtraction(double op1, double op2) {
        return(op1-op2);
    }
    public static double multiplication(double op1, double op2) {
        return(op1*op2);
    }
    public static double division(double op1, double op2) {
        return(op1/op2);
    }
    
    /* define the main function */
    public static void main(String args[]) {
        if(args.length==3) {
            double op1=0, op2=0; //initializing to value 0
            /* check to ensure operands are of desired type */
            try {
                op1 = Double.parseDouble(args[0]);
            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage()+", please specify a valid number");
            }
            try {
                op2 = Double.parseDouble(args[2]);
            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage()+", please specify a valid number");
            }
            
            /* check to ensure operation is one of available types */
            char operation = '?'; //default operation is unknown
            if(args[1].equals("+"))
                operation = '+';
            else if(args[1].equals("-"))
                operation = '-';
            else if(args[1].equals("x"))
                operation = 'x';
            else if(args[1].equals("/"))
                operation = '/';
            //else, operation remains unknown '?'
            
            switch(operation) {
                case '+':
                    System.out.println("Answer is: " + addition(op1,op2));
                    break;
                case '-':
                    System.out.println("Answer is: " + subtraction(op1,op2));
                    break;
                case 'x':
                    System.out.println("Answer is: " + multiplication(op1,op2));
                    break;
                case '/':
                    System.out.println("Answer is: " + division(op1,op2));
                    break;
                //the case when operation = '?' is the default case
                default:
                    System.out.println("Error in processing");
            }            
        }
        else {
            /* show them the help options */
            System.out.println("Valid options are:");
            System.out.println("operand1 + operand2");
            System.out.println("operand1 - operand2");
            System.out.println("operand1 x operand2");
            System.out.println("operand1 / operand2");
        }
    }
}