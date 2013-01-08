// Day 5 of Stream Training

/* A simple class that defines an employee's basic attributes. It also contains the 
 * operator overloading method.
 * 
 * Anurag Bhandari
 * 01-10-2009
 */

using System;
using System.Collections.Generic;
using System.Text;

namespace OperatorOverloading
{
    public class Employee
    {
        public String name;
        public int salary;

        /* The overloading method must be defined within the same class whose 
         * objects are going to be used with the operator; else, compiler will complain:
         * One of the parameters of a binary operator must be the containing type. */

        /* It is possible to use any kind of operators inside an overloaded operator 
         * besides itself to perform manipulations on variables. */

        /* Overloading + implicitly overloads += also. */ 

        // Overloading the + operator
        public static Employee operator +(Employee emp_1, Employee emp_2)
        {
            Employee emp = new Employee();
            emp.name = emp_1.name + " " + emp_2.name;
            emp.salary = emp_1.salary + emp_2.salary;
            return emp;
        }
    }
}
