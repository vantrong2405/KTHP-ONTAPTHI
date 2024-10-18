using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebEvents
{
    public partial class giohang : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string tenhang = Context.Items["tenhang"] + "";
            lbTenhang.Text = tenhang;
            int dongia = Context.Items["dongia"] != null ? int.Parse(Context.Items["dongia"] + "") : 0;
            lbDongia.Text = dongia + "";
            int soluong = Context.Items["soluong"] != null ? int.Parse(Context.Items["soluong"] + "") : 0;
            lbSoluong.Text = soluong + "";
            string doituong = Context.Items["doituong"] + "";
            if(doituong== "2")
            {
                lbGiamgia.Text = "10%";
                lbthanhtien.Text = (soluong * dongia * 0.9).ToString();
            }
            else
            {
                lbthanhtien.Text = (soluong * dongia).ToString();
            }
        }
    }
}