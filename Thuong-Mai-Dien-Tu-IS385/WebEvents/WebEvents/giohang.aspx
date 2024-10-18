<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="giohang.aspx.cs" Inherits="WebEvents.giohang" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>GIỎ HÀNG
        </div>
        <table>
            <tr>
                <td>Tên hàng</td>
                <td>Đơn giá</td>
                <td>Số lượng</td>
                <td>Giảm giá</td>
                <td>Thành tiền</td>
            </tr>
            <tr>
                <td>
                    <asp:Label ID="lbTenhang" runat="server" Text=""></asp:Label></td>
                <td>
                    <asp:Label ID="lbDongia" runat="server" Text=""></asp:Label></td>
                <td>
                    <asp:Label ID="lbSoluong" runat="server" Text=""></asp:Label></td>
                <td>
                    <asp:Label ID="lbGiamgia" runat="server" Text=""></asp:Label></td>
                <td>
                    <asp:Label ID="lbthanhtien" runat="server" Text=""></asp:Label></td>
            </tr>
        </table>
    </form>
</body>
</html>
