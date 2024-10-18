using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;

namespace WebConectDB
{
    public partial class _default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)     
        {
          SqlConnection con = new SqlConnection();
          con.ConnectionString = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=D:\THUONG_MAI_DIEN_TU\WebConectDB\WebConectDB\App_Data\BANHANG.mdf;Integrated Security=True";
          con.Open();

          SqlCommand cmd = new SqlCommand("", con);
          cmd.CommandText = "select count(*) from LOAI_SP";
          int soluong = (int)cmd.ExecuteScalar();
          Response.Write(soluong);

          cmd.CommandText = "insert into LOAI_SP values(3,N'Túi xách')";
          int kq = cmd.ExecuteNonQuery();
          if (kq > 0) lbThongbao.Text = "Thành công";
          else lbThongbao.Text = "không thành công";

          cmd.CommandText = "select * from LOAI_SP";
          SqlDataReader dr = cmd.ExecuteReader();
          while (dr.Read())
          {
              ddl_loai.Items.Add(dr["TENLOAI"] + "");
          }
          dr.Close();

          con.Close();
        }
    }
}