using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.SqlClient;
using System.Data;
namespace QL_BANHANG
{
    public class LopKetNoi
    {
        SqlConnection con;
        void moKetNoi()
        {
            string sqlCon = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=D:\THUONG_MAI_DIEN_TU\QL_BANHANG\QL_BANHANG\App_Data\QLBANHANG.mdf;Integrated Security=True";
            con = new SqlConnection(sqlCon);
            con.Open();
        }

        void dongKetNoi()
        {
            if (con.State == ConnectionState.Open)
            { // kieemr tra cos mowr ko 
                con.Close();
            }
        }

        public DataTable docDuLieu(string sql)
        {
            DataTable dt = new DataTable();
           
            try
            {
                moKetNoi();
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

        public int capNhatDuLieu(string sql)
        {
            int ketqua = 0;
            try
            {
                moKetNoi();
                SqlCommand cmd = new SqlCommand(sql, con);
                cmd.ExecuteNonQuery();//lệnh này làm thay đổi dữ liệu nên dùng ExecuteNonQueRy
                dongKetNoi();
            }
            catch
            {
                ketqua = 0; 
            }
            finally
            {
                dongKetNoi();
            }

            return ketqua;

        }

      
    }
}