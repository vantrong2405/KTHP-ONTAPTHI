using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace DO_AN_TMDT
{
    public partial class quanlytaikhoan : System.Web.UI.Page
    {
        Class1 ketnoi = new Class1();
        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            {
                BindData();
            }
        }
        private void BindData()
        {
            string sql = "select TENDANGNHAP, MATKHAU" +
                " from KHACHHANG";
            GridView1.DataSource = ketnoi.docdulieu(sql);
            GridView1.DataBind();
        }
        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            string username = ((LinkButton)sender).CommandArgument;
            string sql = "delete from KHACHHANG where TENDANGNHAP='" + username + "'";
            int kq = ketnoi.capnhatdulieu(sql);
            if (kq > 0) Label2.Text = "Deleted User Successfully!";
            else Label2.Text = "Failed!";
            BindData();
        }

        protected void Button3_Click(object sender, EventArgs e)
        {
            string username = txtUser.Text;
            string password = txtPass.Text;
            string sql = "update KHACHHANG Set TENDANGNHAP='" + username + "', MATKHAU='" + password + "' where TENDANGNHAP='" + username + "'";
            int kq = ketnoi.capnhatdulieu(sql);
            if (kq > 0) Label2.Text = "Update Successfully!";
            else Label2.Text = "Failed!";
            BindData();
        }
    }
}