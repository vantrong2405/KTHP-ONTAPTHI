<%@ Page Title="" Language="C#" MasterPageFile="~/TrangChinh.Master" AutoEventWireup="true" CodeBehind="SanPham.aspx.cs" Inherits="TranHuuKhiem_0331_2.SanPham" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
     <style>
        .TENHANG {
            color: #000000;
            font-weight: bold; 
            font-size: 20px;
            text-decoration: none;
            
        }
        .sp{
            padding: 10px;
        }
    </style>
    <div>
        <asp:DataList ID="DataList1" runat="server" RepeatColumns="2" RepeatDirection="Horizontal">
            <ItemTemplate>
                <div class="sp">
                <asp:ImageButton ID="ImageButton1" runat="server" Width="350px" ImageUrl='<%# "img/"+Eval("HINHANH") %>' CommandArgument='<%# Eval("MALOAI") %>' OnClick="ImageButton1_Click" /><br />
                <asp:LinkButton CssClass="TENHANG" ID="LinkButton1" runat="server" Text='<%# Eval("TENSANPHAM") %>' CommandArgument='<%# Eval("MALOAI") %>' OnClick="LinkButton1_Click"></asp:LinkButton><br />
                Đơn giá:
                <asp:Label ID="Label1" runat="server" Text='<%# Eval("GIA") %>' CommandArgument='<%# Eval("MALOAI") %>'></asp:Label>
                    </div>
            </ItemTemplate>
        </asp:DataList>
    </div>
</asp:Content>
