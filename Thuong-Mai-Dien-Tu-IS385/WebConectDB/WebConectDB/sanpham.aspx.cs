using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

namespace WebConectDB
{
    public partial class sanpham : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection();
            con.ConnectionString = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=D:\THUONG_MAI_DIEN_TU\WebConectDB\WebConectDB\App_Data\BANHANG.mdf;Integrated Security=True";
            con.Open();

            string sql = "select * from SANPHAM";
            SqlDataAdapter da = new SqlDataAdapter(sql, con);

            DataSet ds = new DataSet();
            da.Fill(ds);

            DataTable dt = ds.Tables[0];
            //foreach(DataRow dr in dt.Rows)
            //{
            //    // ddl_sanpham.Items.Add(dr[1] + "");
            //    ddl_sanpham.Items.Add(new ListItem(dr["TENSP"] + "", dr["MASP"] + ""));
            //}

            ddl_sanpham.DataSource = dt;
            ddl_sanpham.DataTextField = "TENSP";
            ddl_sanpham.DataValueField = "MASP";
            ddl_sanpham.DataBind();


            con.Close();
        }
    }
}