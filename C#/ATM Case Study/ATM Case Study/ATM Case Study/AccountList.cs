using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Collections;

namespace ATM_Case_Study
{
    public partial class AccountList : Form
    {
        public AccountList()
        {
            InitializeComponent();
        }

        private void AccountList_Load(object sender, EventArgs e)
        {
            ArrayList accountList = new ArrayList();
            String accountEntry = "";
            SqlConnection myConnection = Backend.Connection;
            SqlCommand myCommand = new SqlCommand("SELECT Account_ID, Account_Type FROM Account WHERE Cust_ID='" + Login.customerID + "'", myConnection);
            SqlDataReader myReader = myCommand.ExecuteReader();
            while (myReader.Read())
            {
                accountEntry = myReader["Account_ID"].ToString() + " - " + myReader["Account_Type"].ToString();
                accountList.Add(accountEntry);
            }
            comboBox1.DataSource = accountList;
            myReader.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Login.accountID = comboBox1.Text.Substring(0,8);
            MainMenu mm = new MainMenu();
            mm.Show();
        }
    }
}