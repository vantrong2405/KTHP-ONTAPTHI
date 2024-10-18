using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

namespace DO_AN_TMDT
{
    public partial class admin_quanlysanpham : System.Web.UI.Page
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
            string sql = "select MAHANG, TENHANG, MOTA, GIACU, GIAMOI, HINH, MALOAI, CONLAI" +
                " from MATHANG";
                GridView1.DataSource = ketnoi.docdulieu(sql);
                GridView1.DataBind();
        }
        string fileName = "";
        protected void Button2_Click(object sender, EventArgs e)
        {
            if (FileUpload1.HasFile)
            {
                fileName = Path.GetFileName(FileUpload1.FileName);
                string uploadPath = Server.MapPath("~/Hinhanh/");

                if (!Directory.Exists(uploadPath))
                {
                    Directory.CreateDirectory(uploadPath);
                }
                // Đọc dữ liệu từ InputStream của FileUpload
                byte[] imageData;
                using (Stream stream = FileUpload1.PostedFile.InputStream)
                {
                    using (BinaryReader reader = new BinaryReader(stream))
                    {
                        imageData = reader.ReadBytes((int)stream.Length);
                    }
                }
                // Lưu dữ liệu vào tệp
                File.WriteAllBytes(Path.Combine(uploadPath, fileName), imageData);
                Response.Write("Upload Successfully");
            }
            else
            {
                Response.Write("Failed");
            }
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            string mahang = ((LinkButton)sender).CommandArgument;
            string sql = "delete from MATHANG where MAHANG=" + mahang;
            int kq = ketnoi.capnhatdulieu(sql);
            if (kq > 0) Label1.Text = "Deleted Successfully!";
            else Label1.Text = "Delete Failed!";
            BindData();
        }

        protected void Button3_Click(object sender, EventArgs e)
        {
            string mahang = TextBox1.Text;
            string tenhang = ten_hang.Text;
            string mota = mo_ta.Text;
            string giacu = gia_cu.Text;
            string giamoi = gia_moi.Text;
            string conlai = con_lai.Text;
            string maloai = ma_loai.Text;
            string hinhanh = TextBox2.Text;
            string sql = "update MATHANG Set TENHANG='"+tenhang+"', MOTA='"+mota+"', GIACU="+giacu+", GIAMOI="+giamoi+", HINH='"+hinhanh+"', MALOAI="+maloai+", CONLAI="+conlai+" where MAHANG="+mahang;
            int kq = ketnoi.capnhatdulieu(sql);
            if (kq > 0) Label1.Text = "Updated Successfully!";
            else Label1.Text = "Update Failed!";
            BindData();
        }
    }
}