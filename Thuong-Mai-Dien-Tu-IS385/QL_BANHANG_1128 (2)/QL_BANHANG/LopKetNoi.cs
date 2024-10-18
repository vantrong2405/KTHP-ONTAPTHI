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
        private void moketnoi()
        {
            string sqlCon = @"
Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=D:\THUONG_MAI_DIEN_TU\QL_BANHANG_1128(2)\QL_BANHANG\App_Data\BANHANG.mdf;Integrated Security=True";
            con = new SqlConnection(sqlCon);//tạo 1 chuỗi là đường dẫn kết nối rùi dùng Sqlconnection để kết nối
            con.Open();//mở kn
        }
        private void dongketnoi()
        {
            if (con.State == ConnectionState.Open) // nếu trạng thái của nó mà mở thì  đóng lại
                con.Close();
        }
        public DataTable docdulieu(string sql)
        {
            DataTable dt = new DataTable(); // tạo 1 bảng ảo để lưu dữ liệu từ kết quả truy vấn
            try
            {
                moketnoi();//Dọc dữ liệu database -> b1 mở kết nối
                SqlDataAdapter da = new SqlDataAdapter(sql, con); //Tạo 1 đối tượng da chứa csdl và đổ nó lên Datatable
                //SqlDataAdapter là một phần của ADO.NET
                //được sử dụng để điều khiển quá trình truyền dữ liệu giữa cơ sở dữ liệu và DataTable
                da.Fill(dt);//Thực hiện truy vấn SQL và điền dữ liệu từ kết quả vào đối tượng DataTable đã được tạo trước đó.
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