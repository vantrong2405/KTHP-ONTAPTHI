<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="giohang.aspx.cs" Inherits="NguyenQuocKhanh_4770.giohang" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False">
        <Columns>
            <asp:BoundField DataField="TENTUIXACH" HeaderText="Sản phẩm" />
            <asp:BoundField DataField="MAUSAC" HeaderText="Màu sắc" />
            <asp:BoundField DataField="DONGIA" HeaderText="Đơn giá" />
            <asp:BoundField DataField="SOLUONG" HeaderText="Số lượng" />
            <asp:BoundField DataField="THANHTIEN" HeaderText="Thành tiền" />
            <asp:TemplateField HeaderText="Xóa">
                <ItemTemplate>
                    <asp:LinkButton ID="LinkButton2" runat="server">Xóa</asp:LinkButton>
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
    </asp:GridView>

    <asp:GridView ID="GridView2" runat="server">

    </asp:GridView>
</asp:Content>
