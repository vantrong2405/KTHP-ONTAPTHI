using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace DoanVoVanTrong_2906
{
    public class Ketnoi
    {

        SqlConnection con;
        private void moketnoi()
        {
            string sqlcon = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=" + HttpContext.Current.Server.MapPath("~/App_Data/Database.mdf") + ";Integrated Security=True";
            con = new SqlConnection(sqlcon);
            con.Open();
        }

        private void dongketnoi()
        {
            if (con.State == ConnectionState.Open)
                con.Close();

        }

        public DataTable docdulieu(string sql)
        {
            DataTable dt = new DataTable();
            try
            {
                moketnoi();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                da.Fill(dt);
            }
            catch
            {
                dt = null;
            }
            finally
            {
                dongketnoi();
            }


            return dt;
        }
        public int capnhatduieu(string sql)
        {
            int kq = 0;
            try
            {
                moketnoi();
                SqlCommand cmd = new SqlCommand(sql, con);
                kq = cmd.ExecuteNonQuery();
            }
            catch
            {
                kq = 0;
            }
            finally
            {
                dongketnoi();
            }
            return kq;

        }
    }
}