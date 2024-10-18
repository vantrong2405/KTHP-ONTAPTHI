using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

namespace DO_AN_TMDT
{
    public partial class Login : System.Web.UI.Page
    {
        Class1 ketnoi = new Class1();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnsignin_Click(object sender, EventArgs e)
        {
            string username = txtusername.Text;
            string pass = txtpassword.Text;
            string sql = "select * from KHACHHANG where TENDANGNHAP='" + username + "' and MATKHAU='" + pass + "'";
            DataTable dt = ketnoi.docdulieu(sql);
            if (dt != null && dt.Rows.Count > 0)
            {
                Session["username"] = username;
                Response.Redirect("default.aspx");
            }
            else
            {
                lblthongbao.Text = "Username or password is invalid!";
            }
        }
    }
}