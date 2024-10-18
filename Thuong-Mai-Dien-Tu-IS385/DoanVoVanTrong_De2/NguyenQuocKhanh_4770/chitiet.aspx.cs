using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

namespace NguyenQuocKhanh_4770
{
    public partial class chitiet : System.Web.UI.Page
    {
        Class1 ketnoi = new Class1();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            string mahang = Request.QueryString["mh"] + "";
            if (mahang != "")
            {
                string sql = "select * from TUIXACH where MATUIXACH=" + mahang;
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
                string soluong = txtSL.Text;
                string sqlHang = "select * from DONHANG where TENKHACHHANG='" + tendangnhap + "' and MATUIXACH=" + mahang;
                DataTable dt = ketnoi.docdulieu(sqlHang);

                string sql = "";
                if (dt.Rows.Count > 0)
                {
                    sql = "update DONHANG Set SOLUONG=SOLUONG+" + soluong + " where TENKHACHHANG='" + tendangnhap + "' and MATUIXACH=" + mahang;
                }
                else
                {
                    sql = "insert into DONHANG values("+mahang+",'" + tendangnhap + "'," + soluong + ")";
                }

                int kq = ketnoi.capnhatdulieu(sql);
                if (kq > 0) lblthongbao.Text = "success";
                else lblthongbao.Text = "failed";
            }
            else
            {
                lblthongbao.Text = "Ban phai dang nhap!";
            }
        }
    }
}