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
    public partial class ATMList : Form
    {
        public ATMList()
        {
            InitializeComponent();
        }

        private void ATMList_Load(object sender, EventArgs e)
        {
            ArrayList atmtList = new ArrayList();
            String atmEntry = "";
            SqlConnection myConnection = Backend.Connection;
            SqlCommand myCommand = new SqlCommand("SELECT * FROM ATM", myConnection);
            SqlDataReader myReader = myCommand.ExecuteReader();
            while (myReader.Read())
            {
                atmEntry = myReader["ATM_ID"].ToString() + " - " + myReader["ATM_Location"].ToString();
                atmtList.Add(atmEntry);
            }
            comboBox1.DataSource = atmtList;
            myReader.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Login.atmID = comboBox1.Text.Substring(0,8);
            Login l = new Login();
            l.Show();
        }
    }
}