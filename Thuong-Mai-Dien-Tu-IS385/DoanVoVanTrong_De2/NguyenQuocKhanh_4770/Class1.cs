using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.SqlClient;
using System.Data;

namespace NguyenQuocKhanh_4770
{
    public class Class1
    {
        SqlConnection con;
        void moketnoi()
        {
            string sqlCon = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=D:\NguyenQuocKhanh_4770\NguyenQuocKhanh_4770\App_Data\Database1.mdf;Integrated Security=True";
            con = new SqlConnection(sqlCon);
            con.Open();
        }
        void dongketnoi()
        {
            if (con.State == ConnectionState.Open)
            {
                con.Close();
            }
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