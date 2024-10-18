<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="hoa.aspx.cs" Inherits="WebEvents.hoa" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:CheckBoxList ID="cbl_hoa" runat="server" OnSelectedIndexChanged="cbl_hoa_SelectedIndexChanged" 
                AutoPostBack="true">
                <asp:ListItem Text="Hoa hồng" Value="15000"></asp:ListItem>
                <asp:ListItem Text="Hoa Tulip" Value="30000"></asp:ListItem>
                <asp:ListItem Text="Hoa Thủy tiên" Value="25000"></asp:ListItem>
            </asp:CheckBoxList>
        </div>
        <div>
            <asp:Label ID="lbthongbao" runat="server" Text=""></asp:Label>
        </div>
    </form>
</body>
</html>
