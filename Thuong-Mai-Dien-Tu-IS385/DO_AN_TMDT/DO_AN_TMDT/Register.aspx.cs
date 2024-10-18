using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace DO_AN_TMDT
{
    public partial class Register : System.Web.UI.Page
    {
        Class1 ketnoi = new Class1();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnsignup_Click(object sender, EventArgs e)
        {
            string username = txtusername.Text;
            string pass = txtpass.Text;
            string sql = "insert into KHACHHANG values ('"+username+"','"+pass+"')";
            int kq = ketnoi.capnhatdulieu(sql);
            if (kq > 0) lblthongbao.Text = "Success!";
            else lblthongbao.Text = "User Name already exists.";
        }
    }
}