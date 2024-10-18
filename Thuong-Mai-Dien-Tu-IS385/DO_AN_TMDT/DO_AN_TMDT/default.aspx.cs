using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

namespace DO_AN_TMDT
{
    public partial class _default : System.Web.UI.Page
    {
        Class1 ketnoi = new Class1();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            string sql = "select * from LOAIHANG";
            DataTable dt = ketnoi.docdulieu(sql);
            DataList1.DataSource = dt;
            DataList1.DataBind();

            string sql1 = "";
            string maloai = Context.Items["maloai"] + "";
            if(maloai == "")
            {
                sql1 = "select * from MATHANG";
            } else
            {
                sql1 = "select * from MATHANG where MALOAI="+maloai;
            }
            DataList2.DataSource = ketnoi.docdulieu(sql1);
            DataList2.DataBind();
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            string maloai = ((LinkButton)sender).CommandArgument;
            Context.Items["maloai"] = maloai;
            Server.Transfer("default.aspx");
        }

        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            string mahang = ((ImageButton)sender).CommandArgument;
            Response.Redirect("ChiTiet.aspx?mh=" + mahang);
        }

        protected void tensanpham_Click(object sender, EventArgs e)
        {
            string mahang = ((LinkButton)sender).CommandArgument;
            Response.Redirect("ChiTiet.aspx?mh=" + mahang);
        }

        protected void conlai_Click(object sender, EventArgs e)
        {
            string mahang = ((LinkButton)sender).CommandArgument;
            Response.Redirect("ChiTiet.aspx?mh=" + mahang);
        }

        protected void giacu_Click(object sender, EventArgs e)
        {
            string mahang = ((LinkButton)sender).CommandArgument;
            Response.Redirect("ChiTiet.aspx?mh=" + mahang);
        }

        protected void giamoi_Click(object sender, EventArgs e)
        {
            string mahang = ((LinkButton)sender).CommandArgument;
            Response.Redirect("ChiTiet.aspx?mh=" + mahang);
        }

        protected void LinkButton5_Click(object sender, EventArgs e)
        {
            string mahang = ((LinkButton)sender).CommandArgument;
            Response.Redirect("ChiTiet.aspx?mh=" + mahang);
        }

        protected void lkconlai_Click(object sender, EventArgs e)
        {
            string mahang = ((LinkButton)sender).CommandArgument;
            Response.Redirect("ChiTiet.aspx?mh=" + mahang);
        }

        protected void LinkButton4_Click(object sender, EventArgs e)
        {
            string mahang = ((LinkButton)sender).CommandArgument;
            Response.Redirect("ChiTiet.aspx?mh=" + mahang);
        }
    }
}