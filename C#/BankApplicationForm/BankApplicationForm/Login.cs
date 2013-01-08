// Day 9 of Stream Training

/* Login form of our bank application. This is the initial form 
 * that starts by default when the application loads. If 
 * user authentication succeeds, it redirects to the main app.
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
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String username = textBox1.Text;
            String password = textBox2.Text;
            // Check if username is 'xyz' and password is 'Accenture'
            // If the username and password match, redirect to main app interface
            if (username.Equals("xyz") && password.Equals("Accenture"))
            {
                Menu menuForm = new Menu();
                menuForm.Show();
            }
            // If the username and password do not match, display an error message and close the app
            else
            {
                MessageBox.Show("Error! Username / password incorrect");
                this.Close();
            }
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void Login_Load(object sender, EventArgs e)
        {

        }
    }
}