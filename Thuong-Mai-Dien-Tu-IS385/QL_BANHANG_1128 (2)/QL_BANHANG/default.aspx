<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="default.aspx.cs" Inherits="QL_BANHANG._default" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <h1>DANH SÁCH SẢN PHẨM</h1>
    <asp:DataList ID="dl_mathang" runat="server" RepeatColumns="2" RepeatDirection="Horizontal">
        <ItemTemplate>
            <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl='<%# "hinhanh/"+Eval("Hinh") %>' Width="100px" CommandArgument='<%# Eval("MaHang") %>' OnClick="ImageButton1_Click" />
            <br />
            <asp:LinkButton ID="LinkButton2" runat="server" Text='<%# Eval("TenHang") %>' CommandArgument='<%# Eval("MaHang") %>' OnClick="LinkButton2_Click"></asp:LinkButton>
            <br />
            <asp:LinkButton ID="LinkButton3" runat="server" CommandArgument='<%# Eval("MaHang") %>' OnClick="LinkButton3_Click">Chi tiết</asp:LinkButton>
        </ItemTemplate>
    </asp:DataList>
</asp:Content>
