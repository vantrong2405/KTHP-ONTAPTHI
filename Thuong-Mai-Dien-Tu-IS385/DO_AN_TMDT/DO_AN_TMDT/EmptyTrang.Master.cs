using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace DO_AN_TMDT
{
    public partial class EmptyTrang : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            string tendangnhap = Session["username"] + "";
            if (tendangnhap != "")
            {
                lblUser.Text = tendangnhap;
            }
            else
            {
                lblUser.Text = "";
            }
        }
    }
}