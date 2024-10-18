<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="DanhMuc.aspx.cs" Inherits="DoanVoVanTrong_2906.DanhMuc" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <h1>San Pham</h1>
    <asp:DataList ID="ddl_sanpham" runat="server" RepeatColumns="2" RepeatDirection="Horizontal">
        <ItemTemplate>
            <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl='<%# "img/"+Eval("HINHANH") %>' OnClick="ImageButton1_Click"/>
            <br />
            <asp:LinkButton ID="LinkButton2" runat="server" CommandArgument='<%# Eval("MASANPHAM") %>' Text='<%# Eval("TENSANPHAM") %>' OnClick="LinkButton1_Click"></asp:LinkButton>
            <br />
            <asp:Label ID="Label1" runat="server" Text="Đơn giá : "></asp:Label>
            &nbsp;<asp:Label ID="Label2" runat="server" Text='<%# Eval("GIA") %>'></asp:Label>
            </div>
        </ItemTemplate>

    </asp:DataList>
</asp:Content>
