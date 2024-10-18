<%@ Page Title="" Language="C#" MasterPageFile="~/TrangChinh.Master" AutoEventWireup="true" CodeBehind="chitiet.aspx.cs" Inherits="TranHuuKhiem_0331_2.chitiet" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div>
        <asp:DataList ID="dl_chitiet" runat="server">
            <ItemTemplate>
                <table style="width:100%;">
                    <tr>
                        <td rowspan="6">
                            <asp:Image ID="Image1" runat="server" ImageUrl='<%# "img/"+Eval("HINHANH") %>' Width="300px" />
                        </td>
                        <td class="auto-style1"><asp:Label ID="Label3" runat="server" Text='<%# Eval("TENSANPHAM") %>'></asp:Label>
                        </td>    
                    </tr>
                    <tr>
                        <td class="auto-style1"><asp:Label ID="Label2" runat="server" Text='<%# Eval("MOTA") %>'></asp:Label>
                        </td>
                    </tr>      
                    <tr>
                        <td><asp:Label ID="Label4" runat="server" Text='<%# Eval("GIA") %>'></asp:Label>
                        </td>
                    </tr>
                    <tr>
                        <td>so luong:
                            <asp:TextBox ID="txtSoluong" runat="server"></asp:TextBox> <br /> 
                            <asp:Button ID="btMua" runat="server" Text="mua" CommandArgument='<%# Eval("MASANPHAM") %>' OnClick="btMua_Click"  />
                            <a style="margin-left: 70px" href="giohang.aspx">Xem giỏ hàng</a>
                        </td>
                    </tr>

                </table>
            </ItemTemplate>
        </asp:DataList>
          <asp:Label ID="lbthongbao" runat="server" Text=""></asp:Label>
    </div>
</asp:Content>
