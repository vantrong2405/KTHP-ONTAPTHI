using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebEvents
{
    public partial class _default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
        {
            lbthongbao.Text = drl_tinh.SelectedItem.Text;
        }

        protected void Capnhat(object sender, EventArgs e)
        {
            //hoten=txtTen.Text;
            //lop=txtLop.Text;
            Button btt = (Button)sender;
            if(btt.ID == "bt_them")
            {
                lbthongbao.Text = "Thêm mới";
                //lệnh insert vào CSDL
            }
            else if(btt.ID== "bt_sua")
            {
                lbthongbao.Text = "Chỉnh sửa";
            }
            else
            {
                lbthongbao.Text = "Xóa";
            }
        }
    }
}