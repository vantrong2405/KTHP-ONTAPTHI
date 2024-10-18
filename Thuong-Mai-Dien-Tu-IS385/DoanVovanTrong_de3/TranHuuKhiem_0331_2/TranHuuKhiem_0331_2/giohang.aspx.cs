using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;

namespace TranHuuKhiem_0331_2
{
    public partial class giohang : System.Web.UI.Page
    {
        lopketnoi ketnoi = new lopketnoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            string tenDN = Session["username"] + "";

            string sql = "select SANPHAM.MASANPHAM, TENSANPHAM, MOTA, GIA, SOLUONG, DONGIA * SoLuong AS ThanhTien" +
                " from SANPHAM, DONHANG" +
                " where SANPHAM.MASANPHAM = DONHANG.MASANPHAM and TENKHACHHANG='" + tenDN + "'";
            DataTable dt = ketnoi.docdulieu(sql);

            gv_giohang.DataSource = dt;
            gv_giohang.DataBind();
        }
    }
}