// Day 3 of Stream Training

/* Uses the class Factorial to create an object and uses that object to calculate 
 * the factorial of a user entered number.
 * 
 * Anurag Bhandari
 * 29-09-2009
 */

using System;
using System.Collections.Generic;
using System.Text;

namespace AbstractionEncapsulation
{
    class Program
    {
        static void Main(string[] args)
        {
            int number;
            Factorial obj = new Factorial(); // object of class Factorial
            System.Console.WriteLine("FACTORIAL CALCULATION\n");
            try
            {
                System.Console.Write("Enter the number: ");
                number = Convert.ToInt32(System.Console.ReadLine());
                System.Console.WriteLine("Factorial of {0} is: {1}", number, obj.CalculateFactorial(number));
            }
            catch (FormatException e)
            {
                System.Console.WriteLine("You can enter numeric values only. Exiting...");
            }
            System.Console.ReadLine();
        }
    }
}
