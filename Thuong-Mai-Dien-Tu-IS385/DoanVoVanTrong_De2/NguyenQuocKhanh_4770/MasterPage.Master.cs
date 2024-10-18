using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

namespace NguyenQuocKhanh_4770
{
    public partial class MasterPage : System.Web.UI.MasterPage
    {
        Class1 ketnoi = new Class1();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack)
            {
                return;
            }
            string sql = "select * from DANHMUC";
            DataTable dt = ketnoi.docdulieu(sql);
            DataList1.DataSource = dt;
            DataList1.DataBind();
        }
        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            string maloai = ((LinkButton)sender).CommandArgument;
            Context.Items["maloai"] = maloai;
            Server.Transfer("default.aspx");
        }
        protected void Login1_Authenticate(object sender, AuthenticateEventArgs e)
        {
            string username = Login1.UserName;
            string pass = Login1.Password;
            string sql = "select * from KHACHHANG where TENKHACHHANG='" + username + "' and MATKHAU='" + pass + "'";
            DataTable dt = ketnoi.docdulieu(sql);
            if (dt != null && dt.Rows.Count > 0)
            {
                Session["username"] = username;
                Response.Redirect("default.aspx");
            }
            else
            {
                Login1.FailureText = "Ten dang nhap va mat khau khong dung!";
            }
        }

        
    }
}