// Day 3 of Stream Training

/* The base class; contains the essential things to calculate result for a student of any grade.
 * 
 * Anurag Bhandari
 * 29-09-2009
 */

using System;
using System.Collections.Generic;
using System.Text;

namespace InheritancePolymorphism
{
    public class StudentResultCommon
    {
        /* Member fields */
        static String name;
        static String rollno;
        static int subject_1, subject_2, subject_3;

        /* Properties */
        public String Name
        {
            get
            {
                return name;
            }
            set
            {
                name = value;
            }
        }
        public String Rollno
        {
            get
            {
                return rollno;
            }
            set
            {
                rollno = value;
            }
        }

        /* Methods */
        // To demonstrate method overriding
        // Returns a bogus result
        public virtual float Result(params int[] values)
        {
            float sum = 0;
            for (int i = 0; i < values.Length; i++)
                sum = sum + values[i];
            return (0); // any pre-define value
        }

        // Demonstrates method overloading
        // Returns result for just 3 subjects
        public float Result(float subject_1, float subject_2)
        {
            return (((subject_1 + subject_2) / 2) * 100);
        }

        // Input different values from the user about the student
        public void GetStudentInfo()
        {         
            System.Console.Write("Enter student name: ");
            Name = System.Console.ReadLine();
            System.Console.Write("Enter student roll number: ");
            Rollno = System.Console.ReadLine();
            System.Console.Write("Enter subject 1 marks: ");
            subject_1 =  Convert.ToInt32(System.Console.ReadLine());
            System.Console.Write("Enter subject 2 marks: ");
            subject_2 = Convert.ToInt32(System.Console.ReadLine());
            System.Console.Write("Enter subject 3 marks: ");
            subject_3 = Convert.ToInt32(System.Console.ReadLine());
        }

        // Display all the information about student and his/her result
        public void DisplayStudentInfo()
        {
            System.Console.WriteLine("\nSTUDENT REPORT CARD");
            System.Console.WriteLine("-------------------");
            System.Console.WriteLine("Name: " + Name);
            System.Console.WriteLine("Roll Number: " + Rollno);
            System.Console.WriteLine("Result: " + Result(subject_1, subject_2, subject_3) + "%");
            System.Console.ReadLine();
        }
    }
}
