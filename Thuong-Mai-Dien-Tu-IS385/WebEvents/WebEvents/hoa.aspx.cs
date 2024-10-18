using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebEvents
{
    public partial class hoa : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void cbl_hoa_SelectedIndexChanged(object sender, EventArgs e)
        {
            int tong = 0;
            //for(int i = 0; i < cbl_hoa.Items.Count; i++)
            //{
            //    if (cbl_hoa.Items[i].Selected)
            //        tong = tong + int.Parse(cbl_hoa.Items[i].Value);
            //}

            foreach(ListItem item in cbl_hoa.Items)
            {
                if (item.Selected)
                    tong += Convert.ToInt32(item.Value);
            }
            lbthongbao.Text = "Giá phải trả: " + tong;
        }
    }
}