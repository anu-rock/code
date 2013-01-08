// Day 5 of Stream Training

/* The program where we create objects of Employee class and apply the overloaded operator 
 * on them.
 * 
 * Anurag Bhandari
 * 01-10-2009
 */

using System;
using System.Collections.Generic;
using System.Text;

namespace OperatorOverloading
{
    class Program
    {
        static void Main(string[] args)
        {
            Employee emp_1 = new Employee();
            Employee emp_2 = new Employee();
            Employee emp_3 = new Employee();
            System.Console.Write("Enter name of employee 1: ");
            emp_1.name = System.Console.ReadLine();
            System.Console.Write("Enter salary of employee 1: ");
            emp_1.salary = Convert.ToInt32(System.Console.ReadLine());
            System.Console.Write("\nEnter name of employee 2: ");
            emp_2.name = System.Console.ReadLine();
            System.Console.Write("Enter salary of employee 2: ");
            emp_2.salary = Convert.ToInt32(System.Console.ReadLine());
            emp_3 = emp_1 + emp_2;
            System.Console.WriteLine("\n\nWhen we apply + on the two objects of Employee class, result is -\n");
            System.Console.WriteLine("Name: {0}", emp_3.name);
            System.Console.WriteLine("Salary: {0}", emp_3.salary);
            System.Console.ReadLine();
        }
    }
}
 