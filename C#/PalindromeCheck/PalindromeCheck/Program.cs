// Day 1 of Stream Training

using System;
using System.Collections.Generic;
using System.Text;

namespace PalindromeCheck
{
    class Program
    {
        static void Main(string[] args)
        {
            String myString;
            int flag = 1;
            System.Console.WriteLine("Enter the string to be checked:");
            myString = System.Console.ReadLine();
            for (int i=0; i<myString.Length; i++)
            {
                if (myString[i] != myString[myString.Length -1 - i])
                    flag = 0;
            }

            System.Console.WriteLine();
            if (flag==1)
                System.Console.WriteLine(myString + " is a palindrome");
            else
                System.Console.WriteLine(myString + " is a not palindrome");

            System.Console.ReadLine();
        }
    }
}
