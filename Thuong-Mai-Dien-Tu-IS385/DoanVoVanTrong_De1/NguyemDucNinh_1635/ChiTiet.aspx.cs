using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace DoanVoVanTrong_2906
{
    public partial class ChiTiet : System.Web.UI.Page
    {
        Ketnoi kn = new Ketnoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            string mahang = Request.QueryString["mh"] + "";
            string sql = "";
            if (mahang != "")
            {
                sql = "select * from SANPHAM where MALOAI=" + mahang;
                dl_chitiet.DataSource = kn.docdulieu(sql);
                dl_chitiet.DataBind();
            }
        }
        protected void Button1_Click(object sender, EventArgs e)
        {
            string tendangnhap = Session["username"] + "";
            if (tendangnhap != "")
            {
                string mahang = ((Button)sender).CommandArgument;

                Button bt_mua = ((Button)sender);
                DataListItem item = (DataListItem)bt_mua.Parent;
                TextBox txtSL = (TextBox)item.FindControl("txtSoLuong");
                string soluong = txtSL.Text;

                string sql = "insert into DONHANG values('" + tendangnhap + "'," + mahang + "," + soluong + ")";
                int kq = kn.capnhatduieu(sql);
                if (kq > 0) lbthongbao.Text = "Thành công";
                else lbthongbao.Text = "Không thành công";
            }
        }
    }
}