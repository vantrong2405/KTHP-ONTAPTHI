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
    public partial class ChiTiet : System.Web.UI.Page
    {
        Class1 ketnoi = new Class1();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            string mahang = Request.QueryString["mh"] + "";
            if (mahang != "")
            {
                string sql = "select * from MATHANG where MAHANG=" + mahang;
                DataList1.DataSource = ketnoi.docdulieu(sql);
                DataList1.DataBind();
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string tendangnhap = Session["username"] + "";
            if (tendangnhap != "")
            {
                string mahang = ((Button)sender).CommandArgument;
                Button btnMua = (Button)sender;
                DataListItem item = (DataListItem)btnMua.Parent;
                TextBox txtSL = (TextBox)item.FindControl("txtSoLuong");
                
                int sl = int.Parse(txtSL.Text);
                if (sl > 0 && txtSL.Text != "")
                {
                    string soluong = txtSL.Text;

                    string sqlHang = "select * from DONHANG where TENDANGNHAP='" + tendangnhap + "'and MAHANG=" + mahang;
                    DataTable dt = ketnoi.docdulieu(sqlHang);

                    string sql = "";
                    if (dt.Rows.Count > 0)
                    {
                        sql = "update DONHANG Set SOLUONG=SOLUONG+" + soluong + " where TENDANGNHAP='" + tendangnhap + "' and MAHANG=" + mahang;
                    }
                    else
                    {
                        sql = "insert into DONHANG values('" + tendangnhap + "'," + mahang + "," + soluong + ")";
                    }

                    int kq = ketnoi.capnhatdulieu(sql);
                    if (kq > 0) lblthongbao.Text = "Bạn đã thêm vào giỏ hàng thành công!";
                    else lblthongbao.Text = "Bạn đã thêm vào giỏ hàng thất bại!";
                } 
            }
            else
            {
                lblthongbao.Text = "Bạn phải đăng nhập để có thể mua hàng.";
            }
        }
    }
}