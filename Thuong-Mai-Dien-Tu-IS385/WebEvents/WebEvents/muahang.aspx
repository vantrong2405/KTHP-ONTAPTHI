<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="muahang.aspx.cs" Inherits="WebEvents.muahang" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            Tên hàng:
            <asp:DropDownList ID="ddl_tenhang" runat="server">
                <asp:ListItem Text="Áo sơ mi tay dài"></asp:ListItem>
                <asp:ListItem Text="Áo thun"></asp:ListItem>
                <asp:ListItem Text="Quần tây"></asp:ListItem>
            </asp:DropDownList>
        </div>
        <div>
            Đơn giá:
            <asp:TextBox ID="txtDongia" runat="server"></asp:TextBox>
        </div>
        <div>
            Số lượng:
            <asp:TextBox ID="txtSoluong" runat="server"></asp:TextBox>
        </div>
        <div>
            Đối tượng: 
            <asp:RadioButtonList ID="rd_doituong" runat="server">
                <asp:ListItem Text="Bình thường" Value="1"></asp:ListItem>
                <asp:ListItem Text="Giảm giá" Value="2"></asp:ListItem>
            </asp:RadioButtonList>
        </div>
        <div>
            <asp:Button ID="bt_mua" runat="server" Text="Mua hàng" OnClick="bt_mua_Click" />
            <asp:Button ID="bt_xoa" runat="server" Text="Xóa" OnClick="bt_xoa_Click" />
        </div>
    </form>
</body>
</html>
