using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebEvents
{
    public partial class muahang : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void bt_xoa_Click(object sender, EventArgs e)
        {
            txtDongia.Text = "";
            txtSoluong.Text = "";
        }

        protected void bt_mua_Click(object sender, EventArgs e)
        {
            System.Collections.IDictionary items = Context.Items;
            items["tenhang"] = ddl_tenhang.SelectedItem.Text;
            Context.Items["soluong"] = txtSoluong.Text;
            Context.Items["dongia"] = txtDongia.Text;
            // Context.Items["doituong"] = rd_doituong.SelectedItem.Text;
            Context.Items["doituong"] = rd_doituong.SelectedItem.Value;
            Server.Transfer("giohang.aspx");
        }
    }
}