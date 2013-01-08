using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace LoginForm
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String username = textBox1.Text;
            String password = textBox2.Text;
            // Check if username is 'xyz' and password is 'Accenture'
            // If the username and password match, display a success message
            if (username.Equals("xyz") && password.Equals("Accenture"))
            {
                MessageBox.Show("Login successful");
            }
            // If the username and password do not match, display an error message
            else
            {
                MessageBox.Show("Error! Username / password incorrect", MessageBoxIcon.Error);
                this.Close();
            }
        }

    }
}