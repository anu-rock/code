// Day 10 of Stream Training

/* A simple program with just one Win Form that fetches 
 * everything from the Title table of Activity_5.x database 
 * using ADO.NET objects - SqlConnection, DataSet, DataApapter.
 * 
 * Anurag Bhandari
 * 09-10-2009
 */


using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace ADOWinForm
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
            Application.Run(new Form1());
        }
    }
}