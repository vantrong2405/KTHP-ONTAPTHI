using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

namespace OnTapThi
{
    public partial class Master : System.Web.UI.MasterPage
    {
        ketnoi kn = new ketnoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            string sql = "select * from DANHMUC";
            DataTable dt = kn.docDuLieu(sql);
            DataList1.DataSource = dt; 
            DataList1.DataBind();
        }

        protected void Login1_Authenticate(object sender, AuthenticateEventArgs e)
        {
            string username = Login1.UserName;
            string password = Login1.Password;
            string sql = "select * from KHACHHANG where TENKHACHHANG='" + username + "' and MATKHAU='" + password + "'";
            DataTable dt = kn.docDuLieu(sql);
            if (dt != null && dt.Rows.Count > 0)
            {
                Session["username"] = username;
                Response.Redirect("default.aspx");

            }
            else
            {
                Login1.FailureText = "login thaats baij";
            }

        }
    }
}