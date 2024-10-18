using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace TranHuuKhiem_0331_2
{
    public partial class SanPham : System.Web.UI.Page
    {
        lopketnoi ketnoi = new lopketnoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                sanpham();
            }
        }
        private void sanpham()
        {
            string danhmuc = Request.QueryString["dm"] + "";
            string sql = "";
            if (danhmuc == "")

                sql = "select * from SANPHAM";
            else
                sql = "select * from SANPHAM where MASANPHAM=" + danhmuc;
            DataList1.DataSource = ketnoi.docdulieu(sql);
            DataList1.DataBind();
        }
        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            string danhmuc = ((ImageButton)sender).CommandArgument;
            Response.Redirect("chitiet.aspx?dm=" + danhmuc);
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            string danhmuc = ((LinkButton)sender).CommandArgument;
            Response.Redirect("chitiet.aspx?dm=" + danhmuc);
        }
    }
}