using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.SqlClient;
using System.Data;
namespace bai_so_1
{
    public class LopKetNoi
    {
        SqlConnection con;
        private void moketnoi()
        {
            string sqlCon = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename='E:\bai tap asp\IS385C\QL_BANHANG\QL_BANHANG\App_Data\BANHANG.mdf';Integrated Security=True";
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