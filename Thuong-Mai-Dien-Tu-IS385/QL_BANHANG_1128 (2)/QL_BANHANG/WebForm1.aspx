<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="QL_BANHANG.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:DataList ID="ddl_loaihang" runat="server">
                <ItemTemplate>
                    <asp:LinkButton ID="LinkButton1" runat="server" Text='<%# Eval("TenLoai") %>'></asp:LinkButton>
                </ItemTemplate>
            </asp:DataList>
        </div>
        <div>
            <asp:DropDownList ID="dl_loai" runat="server"></asp:DropDownList>
        </div>
    </form>
</body>
</html>
