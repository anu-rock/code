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
    public partial class Deposit : Form
    {
        public Deposit()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlConnection myConnection = Backend.Connection;
            SqlDataReader myReader = null;

            // Regular expression for numbers-only pattern   
            Regex numberRegex = new Regex("^[0-9]+$");
            if (numberRegex.IsMatch(textBox1.Text))
            {
                SqlCommand myCommand_1 = new SqlCommand("SELECT Balance FROM Account WHERE Cust_ID='" + Login.customerID + "'", myConnection);
                myReader = myCommand_1.ExecuteReader();
                myReader.Read();
                String BalanceLocal = myReader["Balance"].ToString();
                myReader.Close();

                SqlCommand myCommand_2 = new SqlCommand("INSERT INTO Transact (Cust_ID, Account_ID, ATM_ID, IsDebit, Old_Balance, New_Balance, Dt_Transaction, Amount) VALUES ('" + Login.customerID + "', " + Login.accountID + ", '" + Login.atmID + "', 0," + BalanceLocal + "," + "(" + BalanceLocal + " + " + textBox1.Text + "), CURRENT_TIMESTAMP, " + textBox1.Text + ")", myConnection);
                myCommand_2.ExecuteNonQuery();

                SqlCommand myCommand_3 = new SqlCommand("UPDATE Account SET Balance=(SELECT Balance FROM Account WHERE Cust_ID='" + Login.customerID + "') + " + Convert.ToInt32(textBox1.Text) + " WHERE Cust_ID='" + Login.customerID + "'", myConnection);
                myCommand_3.ExecuteNonQuery();

                MessageBox.Show("Deposit was successful.");
            }
            else
            {
                MessageBox.Show("Please enter a valid amount");
            }
        }
    }
}