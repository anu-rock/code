// Day 9 of Stream Training

/* This is the user data validation form. Asks for user's:
 * - Name
 * - Account Number
 * - Phone Number
 * - Address
 * 
 * It also makes sure name and phone number are filled in 
 * correctly.
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
using System.Text.RegularExpressions;
using System.Windows.Forms;

namespace BankApplicationForm
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String errorMessage = "";
            int errorFlag = 0;
            // Regular expression for characters (and spaces)-only pattern
            Regex characterRegex = new Regex("^[a-zA-Z ]+$");
            // Regular expression for 10 digit numbers-only pattern
            Regex numberRegex = new Regex("^[0-9]{10}$");

            if (!characterRegex.IsMatch(textBox1.Text))
            {
                errorMessage = errorMessage + "\nMake sure the Name field contains only characters and spaces.";
                errorFlag = 1;
            }
            if(!numberRegex.IsMatch(textBox3.Text))
            {
                errorMessage = errorMessage + "\nMake sure the Phone Number field contains only numbers (a 10 digit mobile number or a 10 digit landline number including STD code).";
                errorFlag = 1;
            }

            if (errorFlag == 1)
            {
                MessageBox.Show(errorMessage);
            }
            else
            {
                MessageBox.Show("Submitted successfully");
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // Set tool tips for all the fields of the form
            toolTip1.AutoPopDelay = 0;
            toolTip1.InitialDelay = 0;
            toolTip1.ReshowDelay = 0;
            toolTip1.SetToolTip(this.textBox1, "Your full name");
            toolTip1.SetToolTip(this.textBox2, "Your bank account number");
            toolTip1.SetToolTip(this.textBox3, "Your 10 digit phone number (landline/mobile)");
            toolTip1.SetToolTip(this.textBox4, "Your permanent address");
        }
    }
}