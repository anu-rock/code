// Day 9 of Stream Training

/* Starting point of our bank application. It specifies that 
 * our initial form will be the Login form.
 * 
 * (C) 2009 Gang of Five (GoF)
 * Anurag Bhandari
 * Aman Mehra
 * Ankit
 * Avinash Anand
 * Mayank Bhatnagar
 * 
 * 08-10-2009
 */

using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace BankApplicationForm
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Login());
        }
    }
}