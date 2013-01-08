// Day 4 of Stream Training

/* Objects for Counter Terrorists and Terrorists are created here. They play with each other 
 * according to a pre-defined story script.
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
    class Program
    {
        static void Main(string[] args)
        {
            CounterTerrorist ct_1 = new CounterTerrorist();
            CounterTerrorist ct_2 = new CounterTerrorist();
            Terrorist t_1 = new Terrorist();
            System.Console.WriteLine("COUNTER STRIKE");
            System.Console.ReadLine();
            System.Console.WriteLine("Game started with 2 counter terrorists and 1 terrorist.");
            System.Console.ReadLine();

            // CT2 says the initial talk
            System.Console.Write("Counter Terrorist {0}: ", ct_2.number);
            ct_2.InitTalk();
            System.Console.ReadLine();
            
            // T1 says the initial talk
            System.Console.Write("Terrorist {0}: ", t_1.number);
            t_1.InitTalk();
            System.Console.ReadLine();
            
            // CT1 reports number of Ts left
            System.Console.Write("Counter Terrorist {0}: ", ct_1.number);
            ct_1.ReportGuysLeft(1);
            System.Console.ReadLine();
            
            // T1 reports number of CTs left
            System.Console.Write("Terrorist {0}: ", t_1.number);
            t_1.ReportGuysLeft(2);
            System.Console.ReadLine();
            
            // CT1 shoots at T1
            System.Console.Write("Counter Terrorist {0}: ", ct_1.number);
            ct_1.Shoot();
            System.Console.ReadLine();
            
            // T1 jumps and avoids attack
            System.Console.Write("Terrorist {0}: ", t_1.number);
            t_1.Jump();
            System.Console.ReadLine();
            
            // T1 shoots back at CT1
            System.Console.Write("Terrorist {0}: ", t_1.number);
            t_1.Shoot();
            System.Console.ReadLine();
            
            // CT1 jumps and avoids attack
            System.Console.Write("Counter Terrorist {0}: ", ct_1.number);
            ct_1.Jump();
            System.Console.ReadLine();
            
            // T1 bombs at CT1
            System.Console.Write("Terrorist {0}: ", t_1.number);
            t_1.Bomb();
            System.Console.ReadLine();
            
            // CT1 dies
            System.Console.Write("Counter Terrorist {0}: ", ct_1.number);
            ct_1.DyingTalk();
            System.Console.ReadLine();
            
            // T1 celebrates killing CT1
            System.Console.Write("Terrorist {0}: ", t_1.number);
            t_1.VictoryTalk();
            System.Console.ReadLine();
            
            // CT2 silently walks up to T1
            System.Console.Write("Counter Terrorist {0}: ", ct_2.number);
            ct_2.Walk();
            System.Console.ReadLine();
            
            // CT2 shoots at T1 from behind
            System.Console.Write("Counter Terrorist {0}: ", ct_2.number);
            ct_2.Shoot();
            System.Console.ReadLine();
            
            // T1 dies
            System.Console.Write("Terrorist {0}: ", t_1.number);
            t_1.DyingTalk();
            System.Console.ReadLine();
            
            // CT2 celebrates final victory
            System.Console.Write("Counter Terrorist {0}: ", ct_2.number);
            ct_2.VictoryTalk();
            System.Console.ReadLine();
            
            System.Console.WriteLine("\nGAME OVER!!!");
            System.Console.ReadLine();
        }
    }
}
