using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace ATM_Case_Study
{
    public partial class Login : Form
    {
        public static String customerID;
        public static String accountID;
        public static String atmID;
        public Login()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlConnection myConnection = Backend.Connection;
            SqlCommand myCommand = new SqlCommand("SELECT * FROM Customer WHERE Cust_ID='" + textBox1.Text + "'", myConnection);
            SqlDataReader myReader = myCommand.ExecuteReader();
            if (myReader.Read())
            {
                if (textBox2.Text.Equals(myReader["PIN"].ToString()))
                {
                    customerID = myReader["Cust_ID"].ToString();
                    MessageBox.Show("Success");
                    AccountList al = new AccountList();
                    myReader.Close();
                    al.Show();
                }
                else
                    MessageBox.Show("Sorry, incorrect PIN.");
            }
            else
            {
                MessageBox.Show("Customer does not exist");
            }
            myReader.Close();
        }
    }
}