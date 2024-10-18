using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;  

namespace QL_BANHANG
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string sqlCon = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename='E:\bai tap asp\IS385C\QL_BANHANG\QL_BANHANG\App_Data\BANHANG.mdf';Integrated Security=True";
            SqlConnection con = new SqlConnection(sqlCon);
            con.Open();
            string sql = "select * from LOAIHANG";
            SqlDataAdapter da = new SqlDataAdapter(sql, con);

            DataSet ds = new DataSet();
            da.Fill(ds);
            DataTable dt = ds.Tables[0];

            ddl_loaihang.DataSource = dt;
            ddl_loaihang.DataBind();

            //dropdownlist
            dl_loai.DataSource = dt;
            dl_loai.DataTextField = "TenLoai";
            dl_loai.DataValueField = "MaLoai";
            dl_loai.DataBind();
            con.Close();
        }
    }
}