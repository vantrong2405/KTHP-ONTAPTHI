using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace QL_BANHANG
{
    public partial class chitiet : System.Web.UI.Page
    {
        LopKetNoi ketnoi = new LopKetNoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            string mahang = Request.QueryString["mh"] + "";
            string sql = "";
            if (mahang != "")
            {
                sql = "select * from MATHANG where MAHANG=" + mahang;
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

                Button bt_mua = (Button)sender;
                DataListItem item = (DataListItem)bt_mua.Parent;
                TextBox txtSL = (TextBox)item.FindControl("txtSoluong");
                string soluong = txtSL.Text;

                string sqldonhang = "select * from DONHANG where TenDangNhap='" + tendangnhap
                    + "' and MaHang=" + mahang;
                DataTable dt = ketnoi.docdulieu(sqldonhang);
                string sql = "";
                if (dt == null) {
                    sql = "insert into DONHANG values('" + tendangnhap + "',"
                    + mahang + "," + soluong + ")";
                }
                else
                {
                    sql = "update DONHANG Set SoLuong = SoLuong + " + soluong 
                        + " where TenDangNhap='" + tendangnhap + "' and  MaHang=" + mahang;
                }
                               
                int kq = ketnoi.capnhatdulieu(sql);
                if (kq > 0) lbthongbao.Text = "Thành công";
                else lbthongbao.Text = "Không thành công";
            }
        }
    }
}