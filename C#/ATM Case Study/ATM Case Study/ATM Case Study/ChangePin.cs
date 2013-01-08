using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Text.RegularExpressions;

namespace ATM_Case_Study
{
    public partial class ChangePin : Form
    {
        public ChangePin()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // Regular expression for numbers-only Pattern   
            Regex oneSpecialCharRegex = new Regex(@"\W\d{2}");//"[^a-zA-Z0-9]&[0-9]{6}"
            SqlConnection myConnection = Backend.Connection;
            SqlCommand myCommand_1 = new SqlCommand("SELECT PIN FROM Customer WHERE Cust_ID='" + Login.customerID + "'", myConnection);
            SqlDataReader myReader = myCommand_1.ExecuteReader();
            if (myReader.Read())
            {
                if (textBox3.Text.Equals(myReader["PIN"].ToString()))
                {
                    if (textBox1.Text.Equals(textBox2.Text))
                    {
                        if (oneSpecialCharRegex.IsMatch(textBox1.Text))
                        {
                            if (textBox1.Text.Equals(textBox3.Text))
                            {
                                MessageBox.Show("Current PIN and new PIN cannot be same");
                            }
                            else
                            {
                                // Close myReader as you cannot execute another SqlCommand before closing the existing SqlDataReader
                                myReader.Close();
                                SqlCommand myCommand_2 = new SqlCommand("UPDATE Customer SET PIN='" + textBox1.Text + "' WHERE Cust_ID='" + Login.customerID + "'", myConnection);
                                myCommand_2.ExecuteNonQuery();
                                MessageBox.Show("PIN successfully updated");
                            }
                        }
                        else
                            MessageBox.Show("Please make sure your new PIN is 6 characters long and contains at least one special character");
                    }
                    else
                        MessageBox.Show("New PINs don't match");
                }
                else
                    MessageBox.Show("Wrong current PIN entered");
            }
            else
            {
                MessageBox.Show("Customer does not exist");
            }
            myReader.Close();
        }
    }
}