using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Data;
using System.Web.UI.WebControls;

namespace TranHuuKhiem_0331_2
{
    public partial class chitiet : System.Web.UI.Page
    {
        lopketnoi ketnoi = new lopketnoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            string mahang = Request.QueryString["dm"] + "";
            string sql = "";
            if (mahang != "")
            {
                sql = "select * from SANPHAM where MASANPHAM=" + mahang;
                dl_chitiet.DataSource = ketnoi.docdulieu(sql);
                dl_chitiet.DataBind();
            }
        }

        protected void btMua_Click(object sender, EventArgs e)
        {
            string tendangnhap = Session["username"] + "";
            if (tendangnhap != "")
            {
                string mahang = ((Button)sender).CommandArgument;

                Button btmua = (Button)sender;
                DataListItem item = (DataListItem)btmua.Parent;
                TextBox txtSL = (TextBox)item.FindControl("txtsoluong");
                string soluong = txtSL.Text;

                string sqldonhang = "select * from DONHANG where TENKHACHHANG= '" + tendangnhap + "' and MASANPHAM=" + mahang;
                DataTable dt = ketnoi.docdulieu(sqldonhang);
                string sql = "";
                if (dt == null)
                {
                    sql = "insert into DONHANG values('" + mahang + "'," + tendangnhap + "," + soluong + ")";

                }
                else
                {
                    sql = "update DONHANG Set SOLUONG = SOLUONG + " + soluong + " where TENDN= '" + tendangnhap + "' and MASANPHAM=" + mahang;
                }
                int kq = ketnoi.capnhatdulieu(sql);
                if (kq > 0) lbthongbao.Text = "Thành công";
                else lbthongbao.Text = "Không thành công";
            }
        }

    }
}