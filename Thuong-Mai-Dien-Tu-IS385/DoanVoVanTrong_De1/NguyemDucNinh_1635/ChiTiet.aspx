<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="ChiTiet.aspx.cs" Inherits="DoanVoVanTrong_2906.ChiTiet" %>
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
                            <asp:Image ID="Image1" runat="server" ImageUrl='<%# "img/"+Eval("HINHANH") %>' />
                        </td>
                        <td>Tên<asp:Label ID="Label1" runat="server" Text='<%# Eval("TENSANPHAM") %>'></asp:Label>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>Mô tả<asp:Label ID="Label2" runat="server" Text='<%# Eval("MOTA") %>'></asp:Label>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>Đơn giá<asp:Label ID="Label3" runat="server" Text='<%# Eval("GIA") %>'></asp:Label>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            Số lượng 
                            <asp:TextBox ID="txtSoLuong" runat="server"></asp:TextBox>
                            <asp:Button ID="bt_mua" runat="server" Text="Mua" CommandArgument='<%# Eval("MALOAI") %>' OnClick="Button1_Click" />
                        </td>
                    </tr>
                </table>
            </ItemTemplate>
        </asp:DataList>

        <asp:Label ID="lbthongbao" runat="server" ></asp:Label>
    </div>
</asp:Content>
