import java.util.Scanner;

class EchoInput {
    public static void main(String args[]) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Your First Name: ");
        String firstName = myScanner.nextLine();
        System.out.print("Your Last Name: ");
        String lastName = myScanner.nextLine();
        System.out.println("Hello, " + firstName + " " + lastName);
    }
}