<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="default.aspx.cs" Inherits="QL_BANHANG._default" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <h1>DANH SÁCH SẢN PHẨM</h1>
    <asp:DataList ID="dl_mathang" runat="server">
        <ItemTemplate>
            <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl='<%# "hinhanh/"+Eval("HINH") %>' />
            <br />
            <asp:LinkButton ID="LinkButton2" runat="server" OnClick="LinkButton2_Click" CommandArgument='<%# Eval("MAHANG") %>' 
                Text='<%# Eval("TENHANG") %>'></asp:LinkButton>

        </ItemTemplate>
    </asp:DataList>

</asp:Content>
