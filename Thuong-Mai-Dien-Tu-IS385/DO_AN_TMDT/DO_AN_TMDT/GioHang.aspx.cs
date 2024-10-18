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
    public partial class GioHang : System.Web.UI.Page
    {
        Class1 ketnoi = new Class1();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                BindData();
            }
            
        }
        private void BindData()
        {
            string tendangnhap = Session["username"] + "";
            if (tendangnhap != "")
            {
                string sql = "select MATHANG.MAHANG, TENHANG, MOTA, GIAMOI, SOLUONG, GIAMOI * SOLUONG AS THANHTIEN" +
                    " from MATHANG, DONHANG" +
                    " where MATHANG.MAHANG = DONHANG.MAHANG AND TENDANGNHAP='" + tendangnhap + "'";
                GridView1.DataSource = ketnoi.docdulieu(sql);
                GridView1.DataBind();
            }
        }
        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            string tendangnhap = Session["username"] + "";
            string mahang = ((LinkButton)sender).CommandArgument;
            string sql = "delete from DONHANG where TENDANGNHAP='" + tendangnhap + "' and MAHANG=" + mahang;
            int kq = ketnoi.capnhatdulieu(sql);
            if (kq > 0) lblthongbao.Text = "Deleted Successfully!";
            else lblthongbao.Text = "Deleted Failed!";
            BindData();
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string tendangnhap = Session["username"] + "";
            if (tendangnhap != "")
            {
                string mahang = ((Button)sender).CommandArgument;
                Button btnMua = (Button)sender;
                DataControlFieldCell item = (DataControlFieldCell)btnMua.Parent;
                TextBox txtSL = (TextBox)item.FindControl("TextBox1");
                string soluong = txtSL.Text;
                string sql = "update DONHANG Set SOLUONG=" + soluong + " where TENDANGNHAP='" + tendangnhap + "' and MAHANG=" + mahang;
                int kq = ketnoi.capnhatdulieu(sql);
                if (kq > 0) lblthongbao.Text = "Update Successfully!";
                else lblthongbao.Text = "Update Failed!";
            }
            BindData();
        }
    }
}