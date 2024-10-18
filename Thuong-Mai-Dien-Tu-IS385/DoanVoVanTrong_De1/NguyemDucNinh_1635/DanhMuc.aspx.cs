using System;
using System.Web.UI.WebControls;

namespace DoanVoVanTrong_2906
{
    public partial class DanhMuc : System.Web.UI.Page
    {
        Ketnoi kn = new Ketnoi();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            //string maloai = Context.Items["ml"] + "";
            string maloai = Request.QueryString["ml"] + "";

            string sql = "";
            if (maloai == "")
            {
                sql = "select * from SANPHAM";
            }
            else
            {
                sql = "select * from SANPHAM where MALOAI=" + maloai;
            }

            ddl_sanpham.DataSource = kn.docdulieu(sql);
            ddl_sanpham.DataBind();
        }


        protected void ImageButton1_Click(object sender, EventArgs e)
        {
            string mahang = ((ImageButton)sender).CommandArgument;
            Response.Redirect("ChiTiet.aspx?mh=" + mahang);

        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            string mahang = ((LinkButton)sender).CommandArgument;
            Response.Redirect("ChiTiet.aspx?mh=" + mahang);

        }
    }
}