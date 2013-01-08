// Day 3 of Stream Training

/* Inherits from StudentResultCommon all the properties, methods, and overrides one method 
 * of that class.
 * 
 * Anurag Bhandari
 * 29-09-2009
 */

using System;
using System.Collections.Generic;
using System.Text;

namespace InheritancePolymorphism
{
    class StudentResult10th : StudentResultCommon
    {
        // Demonstrates method overriding
        // Calculate the actual result for any number of subjects
        public override float Result(params int[] values)
        {
            float sum = 0;
            for (int i = 0; i < values.Length; i++)
                sum = sum + values[i];
            return (sum / values.Length);
        }
    }
}
