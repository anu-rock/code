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
    public partial class Withdraw : Form
    {
        public Withdraw()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlConnection myConnection = Backend.Connection;
            SqlCommand myCommand_1 = new SqlCommand("SELECT Withdrawl_Limit FROM Customer_Type WHERE Cust_Type=(SELECT Cust_Type FROM Customer WHERE Cust_ID='" + Login.customerID + "')", myConnection);
            SqlDataReader myReader_1 = myCommand_1.ExecuteReader();
            myReader_1.Read();
            String withdrawlLimit = myReader_1["Withdrawl_Limit"].ToString();
            // Regular expression for numbers-only pattern   
            Regex numberRegex = new Regex("^[0-9]+$");
            if (numberRegex.IsMatch(textBox1.Text))
            {
                myReader_1.Close();
                SqlCommand myCommand_2 = new SqlCommand("SELECT Balance FROM Account WHERE Cust_ID='" + Login.customerID + "'", myConnection);
                SqlDataReader myReader_2 = myCommand_2.ExecuteReader();
                myReader_2.Read();
                String balance = myReader_2["Balance"].ToString();
                myReader_2.Close();
                if (Convert.ToInt32(textBox1.Text) <= Convert.ToInt32(withdrawlLimit))
                {
                    if (Convert.ToInt32(balance) >= Convert.ToInt32(textBox1.Text))
                    {
                        SqlCommand myCommand_3 = new SqlCommand("INSERT INTO Transact (Cust_ID, Account_ID, ATM_ID, IsDebit, Old_Balance, New_Balance, Dt_Transaction, Amount) VALUES('" + Login.customerID + "', " + Login.accountID + ", '" + Login.atmID + "', 1, " + balance + ", (" + balance + " - " + textBox1.Text + "), CURRENT_TIMESTAMP, " + textBox1.Text + ")", myConnection);
                        myCommand_3.ExecuteNonQuery();
                        SqlCommand myCommand_4 = new SqlCommand("UPDATE Account SET Balance=(SELECT Balance FROM Account WHERE Cust_ID='" + Login.customerID + "') - " + Convert.ToInt32(textBox1.Text) + " WHERE Cust_ID='" + Login.customerID + "'", myConnection);
                        myCommand_4.ExecuteNonQuery();
                        MessageBox.Show("Withdrawl was successful.");
                    }
                    else
                    {
                        MessageBox.Show("You do not have sufficient balance");
                        myReader_1.Close();
                    }
                }
                else
                {
                    MessageBox.Show("You cannot exceed your withdrawl limit of " + withdrawlLimit);
                }
            }
            else
            {
                MessageBox.Show("Please enter a valid amount");
                myReader_1.Close();
            }
        }
    }
}