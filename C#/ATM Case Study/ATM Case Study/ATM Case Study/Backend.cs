using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace ATM_Case_Study
{
    class Backend
    {
        public static SqlConnection Connection = null;

        static Backend()
        {
            try
            {
                Connection = new SqlConnection("Data Source=SQLSVR2005\\SQLEXPRESS; Initial Catalog=ATMDB; Integrated Security=SSPI");
                Connection.Open();
            }
            catch (Exception e)
            {
                MessageBox.Show(e.Message);
            }
        }

        public static void CloseConnection()
        {
            if (Connection != null)
                Connection.Close();
        }
    }
}