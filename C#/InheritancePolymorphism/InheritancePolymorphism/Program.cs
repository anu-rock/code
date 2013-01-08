// Day 3 of Stream Training

/* Creates an object of StudentResult10th class and uses it's own methods plus methods 
 * inherited from StudentResultCommon.
 * 
 * This is our main program.
 * 
 * Anurag Bhandari
 * 29-09-2009
 */

using System;
using System.Collections.Generic;
using System.Text;

namespace InheritancePolymorphism
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create a student of 10th grade
            StudentResult10th student_1 = new StudentResult10th();

            student_1.GetStudentInfo();
            student_1.DisplayStudentInfo();
        }
    }
}
