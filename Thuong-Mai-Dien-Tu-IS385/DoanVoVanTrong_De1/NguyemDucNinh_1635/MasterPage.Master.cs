using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace DoanVoVanTrong_2906
{
    public partial class MasterPage : System.Web.UI.MasterPage
    {
        Ketnoi kn = new Ketnoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                string sqlcon = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=" + Server.MapPath("/App_Data/Database.mdf") + ";Integrated Security=True";
                SqlConnection con = new SqlConnection(sqlcon);
                con.Open();
                string sql = "select * from LOAIDODUNG";
                SqlDataAdapter da = new SqlDataAdapter(sql, con);

                DataSet ds = new DataSet();
                da.Fill(ds);
                DataTable dt = ds.Tables[0];

                dtl1.DataSource = dt;
                dtl1.DataBind();

                con.Close();
            }
        }
        protected void dtl1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
        protected void Login1_Authenticate(object sender, EventArgs e)
        {
            string username = Login1.UserName;
            string pass = Login1.Password;
            string sql = "select * from KHACHHANG where TENKHACHHANG='" + username + "' and MATKHAU='" + pass + "'";

            DataTable dt = kn.docdulieu(sql);
            if (dt != null && dt.Rows.Count > 0)
            {
                Session["username"] = username;
                Response.Redirect("DanhMuc.aspx");
            }
            else
            {
                Login1.FailureText = "Tên đăng nhập và mật khẩu không đúng";
            }
        }
        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            string maloai = ((LinkButton)sender).CommandArgument;
            Response.Redirect("DanhMuc.aspx?ml=" + maloai);
        }

       
    }
}