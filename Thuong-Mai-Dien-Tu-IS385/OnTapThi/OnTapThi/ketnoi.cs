using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;
using System.Data.SqlClient;


namespace OnTapThi
{
    public class ketnoi
    {
        SqlConnection con; 
        void ketNoi()
        {
            string sqlcon = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=D:\THUONG_MAI_DIEN_TU\OnTapThi\OnTapThi\App_Data\QLCH.mdf;Integrated Security=True";
            con = new SqlConnection(sqlcon);
            con.Open();
        }

        void dongKetNoi()
        {
            if ( con!=null &&  con.State == ConnectionState.Open)
            {
                con.Close();
            }
        }

        public DataTable docDuLieu(string sql)
        {
            DataTable dt = new DataTable();
            try
            {
                ketNoi();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.Fill(dt);
            }
            catch
            {
                dt = null; 
            }
            finally
            {
                dongKetNoi();
            }
            return dt; 
        }
    }
}