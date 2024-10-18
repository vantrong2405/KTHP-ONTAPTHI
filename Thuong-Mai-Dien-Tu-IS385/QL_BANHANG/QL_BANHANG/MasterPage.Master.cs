using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

namespace QL_BANHANG
{
    public partial class MasterPage : System.Web.UI.MasterPage
    {
        LopKetNoi ketnoi = new LopKetNoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            string sqlCon = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=D:\THUONG_MAI_DIEN_TU\QL_BANHANG\QL_BANHANG\App_Data\QLBANHANG.mdf;Integrated Security=True";
            SqlConnection con = new SqlConnection(sqlCon);// lấy dữ liệu trong biến sqlCon
            con.Open();//mở kết nối

            string sql = "select * from LOAIHANG";
            DataTable dt = ketnoi.docDuLieu(sql);
            dl_loai.DataSource = dt; // đổ dữ liệu ra datalist
            dl_loai.DataBind();// đổ dữ liệu 
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            string maloai = ((LinkButton)sender).CommandArgument;// lấy value của commandargument onclick vào thẳng nào thì 
            //thằng đấy lấy data -> dc value maloai
            Context.Items["maloai"] = maloai;
            Server.Transfer("default.aspx");
        }

        protected void dl_loai_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}