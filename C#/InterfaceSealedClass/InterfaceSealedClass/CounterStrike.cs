// Day 4 of Stream Training

/* Contains:
 * - an interface (set of common methods for both Counter Terrorists and Terrorists)
 * - a sealed class for Counter Terrorists which implements the interface
 * - a sealed class for Terrorists which implements the interface
 * 
 * Aman Mehra
 * Anurag Bhandari
 * Mayank Bhatnagar
 * Munish Bhatia
 * 
 * 30-09-2009
 */

using System;
using System.Collections.Generic;
using System.Text;

namespace InterfaceSealedClass
{
    interface CSCharacter
    {
        void Jump(); // the character jumps
        void Walk(); // the character walks slowly
        void Shoot(); // the character shoots using a gun
        void Bomb(); // the character thrown a bomb
        void ReportGuysLeft(int num); // the character reports number of opponents left to other team members
        void InitTalk(); // the character says the initial talk
        void VictoryTalk(); // the character says the victory talk
        void DyingTalk(); // the character says the dying talk
    }

    sealed public class CounterTerrorist : CSCharacter
    {
        /* Member fields */
        public static int counter = 0;
        public int number;
        
        /* Constructor */
        public CounterTerrorist()
        {
            // A number is automatically assigned to a new character to identify him
            CounterTerrorist.counter += 1;
            number = CounterTerrorist.counter;
        }

        /* Methods */
        public void Jump()
        {
            System.Console.WriteLine("Jumped a bit");
        }
        public void Walk()
        {
            System.Console.WriteLine("Walking silently");
        }
        public void Shoot()
        {
            System.Console.WriteLine("Shooting with Maverick. Chewnn chewnn chewnn chewnn chewnn....");
        }
        public void Bomb()
        {
            System.Console.WriteLine("Fire in the hole");
        }
        public void ReportGuysLeft(int num)
        {
            if (num == 1)
                System.Console.WriteLine("There's 1 guy left");
            else if (num > 1)
                System.Console.WriteLine("{0} guys left", num);
            else
            {
                // do nothing
            }
        }
        public void InitTalk()
        {
            System.Console.WriteLine("OK, let's move now");
        }
        public void VictoryTalk()
        {
            System.Console.WriteLine("They never knew what hit 'em");
        }
        public void DyingTalk()
        {
            System.Console.WriteLine("Aaaa...");
        }
    }

    sealed public class Terrorist : CSCharacter
    {
        /* Member fields */
        public static int counter = 0;
        public int number;

        /* Constructor */
        public Terrorist()
        {
            // A number is automatically assigned to a new character to identify him
            Terrorist.counter += 1;
            number = Terrorist.counter;
        }

        /* Methods */
        public void Jump()
        {
            System.Console.WriteLine("Jumped up high");
        }
        public void Walk()
        {
            System.Console.WriteLine("Walking very silently");
        }
        public void Shoot()
        {
            System.Console.WriteLine("Shooting with AK-47. Thug thug thug thug thug...");
        }
        public void Bomb()
        {
            System.Console.WriteLine("Fire in the hole");
        }
        public void ReportGuysLeft(int num)
        {
            if (num == 1)
                System.Console.WriteLine("There's 1 guy left");
            else if (num > 1)
                System.Console.WriteLine("{0} guys left", num);
            else
            {
                // do nothing
            }
        }
        public void InitTalk()
        {
            System.Console.WriteLine("Go go go...");
        }
        public void VictoryTalk()
        {
            System.Console.WriteLine("I am dangerous");
        }
        public void DyingTalk()
        {
            System.Console.WriteLine("Ohhhh...");
        }
    }
}
