using System;
using System.Collections.Generic;
using System.Text;

namespace StringNamespace
{
    class Program
    {
        static void Main(string[] args)
        {
            String myString1 = "Avoid saying Hello World; it looks old-fashioned, isn't it?";
            String myString2 = "Aha! That's more like it.";
            char[] myString3 = { 'W', 'o', 'r', 'l', 'd' };

            // Compare: Positive value means string 1 > string 2. Negative value means string 1 < string 2. Zero means string 1 = string 2
            System.Console.WriteLine(String.Compare(myString1, myString2));

            System.Console.WriteLine(String.CompareOrdinal(myString1, myString2));

            // CompareTo: Same as Compare, except for this is a method of a string object
            System.Console.WriteLine(myString1.CompareTo(myString2));

            // Equals: Returns true if both strings match, false otherwise
            System.Console.WriteLine(myString1.Equals(myString2));
            
            // EndsWith: Returns true if string ends with specified substring, false otherwise
            System.Console.WriteLine(myString1.EndsWith("ned!"));
            
            // StartsWith: Returns true if string starts with specified substring, false otherwise
            System.Console.WriteLine(myString1.StartsWith("Avo"));

            // IndexOf: Returns the index number of the first occurance of a substring in a string
            System.Console.WriteLine(myString1.IndexOf("Hello"));
            
            System.Console.WriteLine(myString1.IndexOfAny(myString3));

            // LastIndexOf: Returns the index number of the last occurance of a substring in a string
            System.Console.WriteLine(myString1.LastIndexOf("it"));
            
            System.Console.WriteLine(myString1.LastIndexOfAny(myString3));
            
            // Copy: Returns a ditto copy of a string
            System.Console.WriteLine(String.Copy(myString1));

            // CopyTo: Copies part of a string to a char array
            myString2.CopyTo(0, myString3, 0, 5);
            System.Console.WriteLine(myString3);

            // Substring: Returns substring from a string
            System.Console.WriteLine(myString1.Substring(26, 12));

            // Split: Returns a string array of all substrings split according to a separator
            System.Console.WriteLine(myString1.Split(';')[0]);
            
            System.Console.ReadLine();
        }
    }
}
