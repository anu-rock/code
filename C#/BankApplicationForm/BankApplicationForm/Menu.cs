// Day 9 of Stream Training

/* Presents the user with a simple interface to use all the 
 * features provided by the bank. Basically acts as the start 
 * point for the main user data validation form.
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
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace BankApplicationForm
{
    public partial class Menu : Form
    {
        public Menu()
        {
            InitializeComponent();
        }

        // Show the user data validation form when user selects 'Start > Bank Application Form'
        private void bankApplicationFormToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form1 form1 = new Form1();
            form1.Show();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}