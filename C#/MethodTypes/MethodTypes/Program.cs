// Day 2 of Stream Training

/* Program to implement arithmetic functions (methods) to demonstrate the different types of methods:
 * - Value Type parameters
 * - Reference Type parameters
 * - Output parameters
 * - Parameter arrays
 * 
 * Anurag Bhandari
 * 28-09-2009
 */

using System;
using System.Collections.Generic;
using System.Text;

namespace MethodTypes
{
    class Program
    {
        // Adds two numbers
        // Example of passing by value
        static int Add(int number_1, int number_2)
        {
            return (number_1 + number_2);
        }

        // Subtracts two numbers
        // Example of passing by reference
        static void Subtract(ref int result, int number_1, int number_2)
        {
            result = number_1 - number_2;
        }

        // Multiplies two numbers
        // Example of output parameters
        static void Multiply(out int result, int number_1, int number_2)
        {
            result = number_1 * number_2;
        }

        // Divides two numbers
        // Example of parameter arrays
        static int Divide(params int[] values)
        {
            if (values[1] != 0)
                return (values[0] / values[1]);
            else
                return 0;
        }

        // Divides two numbers and returns the remainder
        // Example of parameter arrays
        static int Modulo(params int[] values)
        {
            if (values[1] != 0)
                return (values[0] % values[1]);
            else
                return 0;
        }

        static void Main(string[] args)
        {
            int number_1, number_2;
            int resultSubtraction = 0; // we'll have to initialize this as it will be passed by reference
            int resultMultiplication; // we don't need to initialize this as it will be passed as output parameter

            // Input values from user
            System.Console.WriteLine("Enter the first number:");
            number_1 = Convert.ToInt32(System.Console.ReadLine());
            System.Console.WriteLine("Enter the second number:");
            number_2 = Convert.ToInt32(System.Console.ReadLine());
            System.Console.WriteLine();

            System.Console.WriteLine("Addition of {0} and {1} is : {2}", number_1, number_2, Add(number_1, number_2));
            Subtract(ref resultSubtraction, number_1, number_2);

            System.Console.WriteLine("Subtraction of {0} and {1} is : {2}", number_1, number_2, resultSubtraction);
            Multiply(out resultMultiplication, number_1, number_2);

            System.Console.WriteLine("Multiplication of {0} and {1} is : {2}", number_1, number_2, resultMultiplication);

            System.Console.WriteLine("Division of {0} and {1} is : {2}", number_1, number_2, Divide(number_1, number_2));

            System.Console.WriteLine("Modulus of {0} and {1} is : {2}", number_1, number_2, Modulo(number_1, number_2));

            System.Console.ReadLine();
        }
    }
}
