// Day 1 of Stream Training

using System;
using System.Collections.Generic;
using System.Text;

namespace GreatestOfThree
{
    class Program
    {
        static void Main(string[] args)
        {
            int number_1, number_2, number_3;
            System.Console.WriteLine("Enter the first number: ");
            number_1 = Convert.ToInt32(System.Console.ReadLine());
            System.Console.WriteLine("Enter the second number: ");
            number_2 = Convert.ToInt32(System.Console.ReadLine());
            System.Console.WriteLine("Enter the third number: ");
            number_3 = Convert.ToInt32(System.Console.ReadLine());

            if (number_1 > number_2 && number_1 > number_3)
            {
                System.Console.WriteLine(number_1 + " is the greatest of three");
            }
            else if (number_2 > number_1 && number_2 > number_3)
            {
                System.Console.WriteLine(number_2 + " is the greatest of three");
            }
            else
            {
                System.Console.WriteLine(number_3 + " is the greatest of three");
            }

            System.Console.ReadLine();
        }
    }
}
