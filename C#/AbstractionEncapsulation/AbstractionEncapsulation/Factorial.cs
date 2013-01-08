// Day 3 of Stream Training

/* Defines a class Factorial which contains the method to calculate factorial of a user input 
 * number.
 * 
 * Anurag Bhandari
 * 29-09-2009
 */

using System;
using System.Collections.Generic;
using System.Text;

namespace AbstractionEncapsulation
{
    class Factorial
    {
        // Member fields
        static int number;

        // Member methods
        // Method to calculate and return the factorial of a number
        public long CalculateFactorial(int value)
        {
            number = value;
            if (number <= 1)
                return 1;
            else
                return (number * CalculateFactorial(number-1));
        }
    }
}
