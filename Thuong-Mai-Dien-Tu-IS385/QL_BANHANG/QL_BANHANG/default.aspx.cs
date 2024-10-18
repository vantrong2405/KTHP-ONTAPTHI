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
    public partial class _default : System.Web.UI.Page
    {
        LopKetNoi ketnoi = new LopKetNoi();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack) return; // khong goi lai ham khi bam vao su kien 
            string sqlCon = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=D:\THUONG_MAI_DIEN_TU\QL_BANHANG\QL_BANHANG\App_Data\QLBANHANG.mdf;Integrated Security=True";
            SqlConnection con = new SqlConnection(sqlCon);
            con.Open();//Mở kết nối 
            String sql = "";//lấy dữ liệu từ bảng mặt hàng 
            //Lấy lại data từ contextItems bên linkbutton
            string maloai = Context.Items["maloai"] + "";
            if(maloai == "")
            {
                sql = "select* from MATHANG";
            }
            else
            {
                sql = "select* from MATHANG where MALOAI=" + maloai;
            }
            dl_mathang.DataSource = ketnoi.docDuLieu(sql);
            dl_mathang.DataBind();
            //SqlDataAdapter da = new SqlDataAdapter(sql, con);//đổ dữ liệu vào data adapter
            //DataSet ds = new DataSet();
          

            //da.Fill(ds);//đổ dữ liệu từ data adapter vào data set 
            //DataTable dt = ds.Tables[0]; // lấy dữ liệu từ bảng đầu tiên 
            //// lấy nguồn dữ liệu  từ bảng đầu 
            //dl_mathang.DataSource = dt; 
            //dl_mathang.DataBind(); // đưa dữ liệu lên 
            //con.Close();// đóng connect
        }

        protected void LinkButton2_Click(object sender, EventArgs e)
        {
            // VIết sự kiện cho link button 
            //Chuyển từ trang này sang trang khác có 2 cách : server.tranfer , response.Redirect
            //(LinkButton)sender : lấy đúng đối tượng // CommandArgument xác định trường trong argment đã xác định từ trước  
            string maHang = ((LinkButton)sender).CommandArgument;
            Response.Redirect("WebForm1.aspx?mh=" + maHang);//truyen mahang cho ben webform1
        }
    }
}