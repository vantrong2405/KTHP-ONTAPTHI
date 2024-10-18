<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="chitiet.aspx.cs" Inherits="QL_BANHANG.chitiet" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <h1>CHI TIẾT SẢN PHẨM</h1>
    <div>
        <asp:DataList ID="dl_chitiet" runat="server">
            <ItemTemplate>
                <table style="width:100%;">
                    <tr>
                        <td rowspan="4">
                            <asp:Image ID="Image1" runat="server" ImageUrl='<%# "hinhanh/"+Eval("Hinh") %>' />
                        </td>
                        <td>tên:
                            <asp:Label ID="Label1" runat="server" Text='<%# Eval("TenHang") %>'></asp:Label>
                        </td>
                    </tr>
                    <tr>
                        <td>mô tả:
                            <asp:Label ID="Label2" runat="server" Text='<%# Eval("MoTa") %>'></asp:Label>
                        </td>
                    </tr>
                    <tr>
                        <td>Đơn giá:
                            <asp:Label ID="Label3" runat="server" Text='<%# Eval("DonGia") %>'></asp:Label>
                        </td>
                    </tr>
                    <tr>
                        <td>Số lượng :
                            <asp:TextBox ID="txtSoluong" runat="server"></asp:TextBox>
                            <asp:Button ID="btMua" runat="server" Text="Mua" CommandArgument='<%# Eval("MaHang") %>' OnClick="btMua_Click" />
                            <a href="giohang.aspx">Giỏ hàng</a>
                        </td>
                    </tr>
                </table>
            </ItemTemplate>
        </asp:DataList>
        <asp:Label ID="lbthongbao" runat="server" Text=""></asp:Label>
    </div>
</asp:Content>
