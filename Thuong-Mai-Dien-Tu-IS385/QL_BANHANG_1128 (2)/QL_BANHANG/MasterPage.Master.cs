using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;

namespace QL_BANHANG
{
    public partial class MasterPage : System.Web.UI.MasterPage
    {
        LopKetNoi ketnoi = new LopKetNoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack == true) return;
           
            string sql = "select * from LOAIHANG";
            DataList1.DataSource = ketnoi.docdulieu(sql);
            DataList1.DataBind();

        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            string maloai = ((LinkButton)sender).CommandArgument;
            ////server
            //Context.Items["ml"] = maloai;
            //Server.Transfer("default.aspx");

            //response
            Response.Redirect("default.aspx?ml=" + maloai);
        }

        protected void Login1_Authenticate(object sender, AuthenticateEventArgs e)
        {
            string username = Login1.UserName;
            string pass = Login1.Password;

            string sql = "select * from KHACHHANG where TenDangNhap='" + username
                + "' and MatKhau='" + pass + "'";

            DataTable dt = ketnoi.docdulieu(sql);
            if(dt!=null && dt.Rows.Count > 0)
            {
                Session["username"] = username;
                Response.Redirect("default.aspx");
            }
            else
            {
                Login1.FailureText = "Tên đăng nhập và mật khẩu không đúng";
            }
        }
    }
}