using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;

namespace TranHuuKhiem_0331_2
{
    public partial class TrangChinh : System.Web.UI.MasterPage
    {
        lopketnoi ketnoi = new lopketnoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack == true) return;

            string sql = "select * from LOAIDODUNG";
            DataList1.DataSource = ketnoi.docdulieu(sql);
            DataList1.DataBind();

        }
        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            string danhmuc = ((LinkButton)sender).CommandArgument;
            Response.Redirect("SanPham.aspx?dm=" + danhmuc);
        }
        protected void Login1_Authenticate(object sender, AuthenticateEventArgs e)
        {
            string username = Login1.UserName;
            string pass = Login1.Password;
            string sql = "select * from KHACHHANG where TENKHACHHANG='" + username + "' and MATKHAU ='" + pass + "'";
            DataTable dt = ketnoi.docdulieu(sql);
            if (dt != null && dt.Rows.Count > 0)
            {
                Session["username"] = username;
                Response.Redirect("SanPham.aspx");
            }
            else
            {
                Login1.FailureText = "sai";
            }
        }

        
    }
}