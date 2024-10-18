<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="default.aspx.cs" Inherits="NguyenQuocKhanh_4770._default" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:DataList ID="DataList1" runat="server" style="margin-right: 65px" RepeatColumns="2">
        <ItemTemplate>
            <asp:ImageButton ID="ImageButton1" runat="server" CommandArgument='<%# Eval("MATUIXACH") %>' ImageUrl='<%# "assets/hinh1.jpg"+Eval("HINHANH") %>' Width="150px" Height="150px" OnClick="ImageButton1_Click"/>
            <br />
            <asp:LinkButton ID="LinkButton2" runat="server" CommandArgument='<%# Eval("MATUIXACH") %>' Text='<%# Eval("TENTUIXACH") %>' OnClick="LinkButton2_Click"></asp:LinkButton>
            <br />
            <asp:LinkButton ID="LinkButton3" runat="server" CommandArgument='<%# Eval("MATUIXACH") %>' OnClick="LinkButton3_Click">Đơn giá: </asp:LinkButton>
            <asp:LinkButton ID="LinkButton4" runat="server" CommandArgument='<%# Eval("MATUIXACH") %>' Text='<%# Eval("DONGIA") %>' OnClick="LinkButton4_Click"></asp:LinkButton>
            <br />
            <asp:LinkButton ID="LinkButton5" runat="server" CommandArgument='<%# Eval("MATUIXACH") %>' OnClick="LinkButton5_Click">Màu sắc: </asp:LinkButton>
            <asp:LinkButton ID="LinkButton6" runat="server" CommandArgument='<%# Eval("MATUIXACH") %>' Text='<%# Eval("MAUSAC") %>' OnClick="LinkButton6_Click"></asp:LinkButton>
        </ItemTemplate>
    </asp:DataList>
</asp:Content>
