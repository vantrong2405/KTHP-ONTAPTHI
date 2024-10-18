<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="default.aspx.cs" Inherits="WebEvents._default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:DropDownList ID="drl_tinh" runat="server" OnSelectedIndexChanged="DropDownList1_SelectedIndexChanged"
                AutoPostBack="true">
                <asp:ListItem Text="Đà nẵng" Value="1"></asp:ListItem>
                <asp:ListItem Text="Quảng Nam" Value="2"></asp:ListItem>
                <asp:ListItem Text="Hà Nội"></asp:ListItem>
            </asp:DropDownList>
        </div>
        <div>
            <asp:Button ID="bt_them" runat="server" Text="Thêm mới" OnClick="Capnhat" />
            <asp:Button ID="bt_sua" runat="server" Text="Chỉnh sửa" OnClick="Capnhat" />
            <asp:Button ID="bt_xoa" runat="server" Text="Xóa" OnClick="Capnhat" />
        </div>
        <div>
            <asp:Label ID="lbthongbao" runat="server" Text=""></asp:Label>
        </div>
    </form>
</body>
</html>
