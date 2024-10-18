<%@ Page Title="" Language="C#" MasterPageFile="~/EmptyTrang.Master" AutoEventWireup="true" CodeBehind="ChiTiet.aspx.cs" Inherits="DO_AN_TMDT.ChiTiet" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div style="margin-top:100px">
         <h2 style="color:red; font-weight:bold">Product Details</h2>
    <div class="card pt-4" style=" background-color:transparent">
        <asp:DataList ID="DataList1" runat="server">
            <ItemTemplate>
                <table style="width:100%;">
                    <tr>
                        <td rowspan="5" style="width:35%">
                            <asp:Image ID="Image1" runat="server" CssClass="rounded" Width="90%" Height="350px" ImageUrl='<%# "Hinhanh/"+Eval("HINH") %>'/>
                        </td>
                        <td style="width:65%">
                            <asp:Label ID="Label1" Style="color:white ; font-size:25px ; font-weight:bold" runat="server" Text='<%# Eval("TENHANG") %>'></asp:Label></td>
                    </tr>
                    <tr>
                        <td style="width:65%">
                            <div class="text-decoration-line-through">
                                <asp:Label ID="Label5" runat="server" Text="$" Style="color:red"></asp:Label>
                                <asp:Label ID="Label2"  Style="color:red" runat="server" Text='<%# Eval("GIACU") %>'></asp:Label>
                            </div>
                            <div>
                            <asp:Label ID="Label6" runat="server" Text="$" Style="color:green; font-weight:bold; font-size:x-large"></asp:Label>
                            <asp:Label ID="Label3" Style="color:green ;  font-weight:bold; font-size:x-large" runat="server" Text='<%# Eval("GIAMOI") %>'></asp:Label>
                                </div>
                                </td>
                    </tr>
                    <tr>
                        <td style="width:65%">
                            <asp:Label ID="Label7" runat="server" Text="Description" Style="color:darkred; font-weight:bold; font-size:large"></asp:Label> <br />
                            <asp:Label ID="Label4" runat="server" Style="color:white ;" Text='<%# Eval("MOTA") %>'></asp:Label>
                        </td>
                    </tr>
                         <tr>
                        <td style="width:65%;color:darkred ;">
                            Quantity: <asp:TextBox ID="txtSoLuong" runat="server" ></asp:TextBox>
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
                ErrorMessage="Please enter the quantity!"
                ControlToValidate="txtSoLuong"
                Display="Dynamic" Font-Bold="true" ForeColor="Red"
                ></asp:RequiredFieldValidator>
                            <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ErrorMessage="Please enter a number greater than 0!"
                                ControlToValidate="txtSoLuong" Display="Dynamic" Font-Bold="true" ForeColor="Red" ValidationExpression="^\d+$"
                                ></asp:RegularExpressionValidator>
                        </td>
                    </tr>
                    <tr>
                        <td style="width:65%">
                            <asp:Button ID="Button1" runat="server" Style="width:130px" CssClass="btn btn-danger" Text="Add To Cart" OnClick="Button1_Click" CommandArgument='<%# Eval("MAHANG") %>' />
                   <a href="GioHang.aspx" class="btn btn-success text-nowrap"  style="width:130px">View Cart</a>
                            </td>
                    </tr>
                        
                </table>
            </ItemTemplate>
        </asp:DataList>
            <hr/>
		</div>

    </div>
                                <asp:Label ID="lblthongbao" runat="server" Text="" ForeColor="White"></asp:Label>

   
</asp:Content>
