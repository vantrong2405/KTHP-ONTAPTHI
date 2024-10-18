<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="chitiet.aspx.cs" Inherits="NguyenQuocKhanh_4770.chitiet" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:DataList ID="DataList1" runat="server">
        <ItemTemplate>
            <table style="width:100%;">
                <tr>
                    <td rowspan="6">
                        <asp:Image ID="Image1" runat="server" ImageUrl='<%# "assets/hinh1.jpg"+Eval("HINHANH") %>' Width="150px" Height="150px" />
                    </td>
                    <td>
                        <asp:Label ID="Label1" runat="server" Text='<%# Eval("TENTUIXACH") %>'></asp:Label></td>
                </tr>
                <tr>
                    <td>
                        <asp:Label ID="Label2" runat="server" Text='<%# Eval("MOTA") %>'></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td>
                        Đơn giá: <asp:Label ID="Label3" runat="server" Text='<%# Eval("DONGIA") %>'></asp:Label></td>
                </tr>
                <tr>
                    <td>
                        Màu sắc: <asp:Label ID="Label4" runat="server" Text='<%# Eval("MAUSAC") %>'></asp:Label></td>
                </tr>
                <tr>
                    <td>
                       Số lượng: <asp:TextBox ID="txtSoLuong" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>
                        <asp:Button ID="Button1" runat="server" Text="Mua" CommandArgument='<%# Eval("MATUIXACH") %>' OnClick="Button1_Click" />
                        <a href="giohang.aspx">Xem giỏ hàng</a>
                    </td>
                </tr>
            </table>
        </ItemTemplate>
    </asp:DataList>
    <asp:Label ID="lblthongbao" runat="server" Text=""></asp:Label>
</asp:Content>
