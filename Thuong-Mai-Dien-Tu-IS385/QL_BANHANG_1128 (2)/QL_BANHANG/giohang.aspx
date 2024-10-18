<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="giohang.aspx.cs" Inherits="QL_BANHANG.giohang" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <h1>GIỎ HÀNG</h1>
    <asp:GridView ID="gv_giohang" runat="server" AutoGenerateColumns="False">
        <Columns>
            <asp:BoundField DataField="MaHang" HeaderText="Mã Hàng" />
            <asp:BoundField DataField="TenHang" HeaderText="Tên sản phẩm" />
            <asp:BoundField DataField="MoTa" HeaderText="Mô tả sản phẩm" />
            <asp:BoundField DataField="DonGia" HeaderText="Đơn giá" />
            <asp:BoundField DataField="ThanhTien" HeaderText="Thành tiền" />
            <asp:TemplateField HeaderText="Số lượng">
                <ItemTemplate>
                    <asp:TextBox ID="TextBox1" runat="server" Text='<%# Eval("SoLuong") %>'></asp:TextBox>
                    <asp:Button ID="Button1" runat="server" Text="Sửa" />
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
    </asp:GridView>
</asp:Content>
