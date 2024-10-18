<%@ Page Title="" Language="C#" MasterPageFile="~/TrangChinh.Master" AutoEventWireup="true" CodeBehind="giohang.aspx.cs" Inherits="TranHuuKhiem_0331_2.giohang" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:GridView ID="gv_giohang" runat="server" AutoGenerateColumns="False">
        <Columns>
            <asp:BoundField DataField="TENSANPHAM" HeaderText="sản phẩm" />
            <asp:BoundField DataField="MOTA" HeaderText="màu sắc" />
            <asp:BoundField DataField="GIA" HeaderText="đơn giá" />
            <asp:TemplateField HeaderText="Số lượng">
                <ItemTemplate>
                    <asp:TextBox ID="TextBox1" runat="server" Text='<%# Eval("SOLUONG") %>'></asp:TextBox>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:BoundField DataField="ThanhTien" HeaderText="Thành tiền" />
            <asp:TemplateField HeaderText="Xóa">
                <ItemTemplate>
                    <asp:Button ID="Button1" runat="server" Text="Xóa"  />
                </ItemTemplate>
            </asp:TemplateField>
            
        </Columns>
    </asp:GridView>
</asp:Content>
