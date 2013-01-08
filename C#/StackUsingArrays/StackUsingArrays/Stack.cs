// Day 2 of Stream Training

/* Implementation of a simple stack (and it's related methods) using arrays. 
 * 
 * Anurag Bhandari
 * 28-09-2009
 */

using System;
using System.Collections.Generic;
using System.Text;

namespace StackUsingArrays
{
    class Stack
    {
        static int[] stack = new int[10];
        static int stackTop;

        // The constructor
        Stack()
        {
            stackTop = 0;
           
        }

        // Put an element to the top of stack, if not empty
        static void Push(int element)
        {
            if (stackTop >= 0 && stackTop < 9)
            {
                stack[stackTop] = element;
                stackTop = stackTop + 1;
                System.Console.WriteLine("1 element added at top!");
            }
            else
            { 
                System.Console.WriteLine("Stack is full. Cannot add more elements.");
            }
        }

        // Remove an element from the top of stack
        static void Pop()
        {
            if (stackTop > 0)
            {
                stackTop = stackTop - 1;
                stack[stackTop] = 0;
                System.Console.WriteLine("1 element removed from top!");
            }
            else
                System.Console.WriteLine("The stack is already empty. Nothing to remove!");
        }

        // Display all the contents of the stack
        static void DisplayStack()
        {
            try
            {
                for (int index = 0; index < 10; index++)
                {
                    System.Console.Write(stack[index] + " ");
                }
            }
            catch (NullReferenceException e)
            {
                System.Console.WriteLine("The stack is empty!");
            }
        }

        // Displays a menu with all features available for stack
        static void DisplayMenu()
        {
            int choice, element;
            Console.Clear();
            try
            {
                System.Console.WriteLine("S T A C K  U S I N G  A R R A Y S");
                System.Console.WriteLine("=================================\n");
                System.Console.WriteLine("1. Add an element (PUSH)");
                System.Console.WriteLine("2. Remove an element (POP)");
                System.Console.WriteLine("3. Display the contents of stack");
                System.Console.WriteLine("4. Exit");
                System.Console.WriteLine("---------------------------------");
                System.Console.WriteLine("Enter your choice (1, 2, 3, 4):");
                choice = Convert.ToInt32(System.Console.ReadLine());
                switch (choice)
                {
                    // Push an element
                    case 1:
                        Console.Clear();
                        try
                        {
                            System.Console.Write("Enter number: ");
                            element = Convert.ToInt32(System.Console.ReadLine());
                            Stack.Push(element);
                            System.Console.ReadLine();
                            Stack.DisplayMenu();
                        }
                        catch (FormatException e)
                        {
                            System.Console.WriteLine("Please enter a numeric value only. Exiting now...");
                            System.Console.ReadLine();
                        }
                        break;
                    // Pop an element
                    case 2:
                        Console.Clear();
                        Stack.Pop();
                        System.Console.ReadLine();
                        Stack.DisplayMenu();
                        break;
                    // Display the stack
                    case 3:
                        Console.Clear();
                        Stack.DisplayStack();
                        System.Console.ReadLine();
                        Stack.DisplayMenu();
                        break;
                    // Close the program
                    case 4:
                        System.Environment.Exit(0);
                        break;
                    // Any other choice specified
                    default:
                        System.Console.WriteLine("Invalid choice!");
                        System.Console.ReadLine();
                        Stack.DisplayMenu();
                        break;
                }
        }
        catch (FormatException e)
        {
            System.Console.WriteLine("Please enter a numeric value only. Exiting now...");
            System.Console.ReadLine();
            Stack.DisplayMenu();
        }
        }
        static void Main(string[] args)
        {
            // Short and sweet
            Stack.DisplayMenu();
        }
    }
}
