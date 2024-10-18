using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebEvents
{
    public partial class bai1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void txtTen_TextChanged(object sender, EventArgs e)
        {
            lbthongbao.Text = "Chào bạn " + txtTen.Text + ". Lớp " + txtLop.Text;
        }

       

        //protected void txtLop_TextChanged(object sender, EventArgs e)
        //{
        //    lbthongbao.Text = "Chào bạn " + txtTen.Text + ". Lớp " + txtLop.Text;
        //}
    }
}