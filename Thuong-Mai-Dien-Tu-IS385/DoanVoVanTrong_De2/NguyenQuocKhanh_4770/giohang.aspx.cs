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
    public partial class giohang : System.Web.UI.Page
    {
        Class1 ketnoi = new Class1();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return;
            string tendangnhap = Session["username"] + "";
            if (tendangnhap != "")
            {
                string sql = "select TUIXACH.MATUIXACH, TENTUIXACH, MOTA, MAUSAC, DONGIA, SOLUONG, DONGIA * SOLUONG AS THANHTIEN" +
                    " from TUIXACH, DONHANG" +
                    " where TUIXACH.MATUIXACH = DONHANG.MATUIXACH AND TENKHACHHANG='" + tendangnhap + "'";
                GridView1.DataSource = ketnoi.docdulieu(sql);
                GridView1.DataBind();
            }
        }
    }
}