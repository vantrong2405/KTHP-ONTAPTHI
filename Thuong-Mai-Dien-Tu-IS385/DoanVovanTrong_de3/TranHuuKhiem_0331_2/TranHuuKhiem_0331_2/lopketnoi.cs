using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;
using System.Data.SqlClient;

namespace TranHuuKhiem_0331_2
{
    public class lopketnoi
    {
        SqlConnection con;
        private void moketnoi()
        {
            string sqlCon = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=D:\is\TranHuuKhiem_0331_2\TranHuuKhiem_0331_2\App_Data\Data.mdf;Integrated Security=True";
            con = new SqlConnection(sqlCon);
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
        public int capnhatdulieu(string sql)
        {
            int ketqua = 0;
            try
            {
                moketnoi();
                SqlCommand cmd = new SqlCommand(sql, con);
                ketqua = cmd.ExecuteNonQuery();
            }
            catch
            {
                ketqua = 0;
            }
            finally
            {
                dongketnoi();
            }
            return ketqua;
        }
    }
}