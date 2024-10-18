using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;

namespace QL_BANHANG
{
    public partial class giohang : System.Web.UI.Page
    {
        LopKetNoi ketnoi = new LopKetNoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            string tenDN = Session["username"] + "";

            string sql = "select MATHANG.MaHang, TenHang, MoTa, DonGia, SoLuong, DonGia * SoLuong AS ThanhTien" +
                " from MATHANG, DONHANG" +
                " where MATHANG.MaHang = DONHANG.MaHang and TenDangNhap='" + tenDN + "'";
            DataTable dt = ketnoi.docdulieu(sql);

            gv_giohang.DataSource = dt;
            gv_giohang.DataBind();
        }
    }
}