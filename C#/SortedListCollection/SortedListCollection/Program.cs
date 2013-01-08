// Day 5 of Stream Training

/* Implementation of a simple SortedList.
 * 
 * Anurag Bhandari
 * 01-10-2009
 */

using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace SortedListCollection
{
    class Program
    {
        static void Main(string[] args)
        {
            SortedList mySL = new SortedList();
            mySL.Add("One", "1");
            mySL.Add("Two", "2");
            mySL.Add("Three", "3");

            // Result will be displayed in sorted order as all keys are auto stored in sorted order
            System.Console.WriteLine("KEY\tVALUE");
            System.Console.WriteLine("---\t-----");
            for (int i = 0; i < mySL.Count; i++)
            {
                System.Console.WriteLine("{0}\t{1}", mySL.GetKey(i), mySL.GetByIndex(i));
            }
            System.Console.WriteLine("\nCapacity of this SortedList: {0}", mySL.Capacity);
            System.Console.WriteLine("Does this SortedList contain \"One\" as key: {0}", mySL.Contains("One"));
            System.Console.WriteLine("Number of objects presently in this SortedList: {0}", mySL.Count);
            System.Console.ReadLine();
        }
    }
}
