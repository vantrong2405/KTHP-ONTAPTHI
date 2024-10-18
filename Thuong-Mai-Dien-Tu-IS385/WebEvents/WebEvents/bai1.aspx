<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="bai1.aspx.cs" Inherits="WebEvents.bai1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            Tên: <asp:TextBox ID="txtTen" runat="server" OnTextChanged="txtTen_TextChanged" AutoPostBack="true"></asp:TextBox>
        </div>
        <div>
            Lớp: <asp:TextBox ID="txtLop" runat="server" AutoPostBack="true" OnTextChanged="txtTen_TextChanged"></asp:TextBox>
        </div>
        <div>
            <asp:Label ID="lbthongbao" runat="server" Text="Label"></asp:Label>
        </div>
    </form>
</body>
</html>
