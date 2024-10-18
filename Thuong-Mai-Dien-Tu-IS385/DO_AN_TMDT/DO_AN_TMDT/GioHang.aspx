<%@ Page Title="" Language="C#" MasterPageFile="~/EmptyTrang.Master" AutoEventWireup="true" CodeBehind="GioHang.aspx.cs"
    Inherits="DO_AN_TMDT.GioHang" %>
    <asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    </asp:Content>
    <asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
        <div style="margin-top: 100px;">
            <h2 style="color:red; font-weight:bold">Shopping Cart</h2>
            <div class="card pt-4" style="background-color:transparent">
                <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" Width="100%">
                    <Columns>
                        <asp:BoundField ItemStyle-ForeColor="whitesmoke" HeaderStyle-ForeColor="DarkRed"
                            DataField="TENHANG" HeaderText="Product Name" ItemStyle-Width="12%" />
                        <asp:BoundField ItemStyle-ForeColor="whitesmoke" HeaderStyle-ForeColor="DarkRed"
                            DataField="MOTA" HeaderText="Description" ItemStyle-Width="48%" />
                        <asp:BoundField ItemStyle-ForeColor="whitesmoke" ItemStyle-HorizontalAlign="Center" HeaderStyle-ForeColor="DarkRed"
                            DataField="GIAMOI" HeaderText="Price" ItemStyle-Width="12%" />
                        <asp:TemplateField HeaderText="Quantity" HeaderStyle-ForeColor="DarkRed"
                            ItemStyle-Width="12%">
                            <ItemTemplate>
                                <asp:TextBox ID="TextBox1" runat="server" Text='<%# Eval("SOLUONG") %>'></asp:TextBox>
                                <asp:Button ID="Button1" runat="server" Text="Adjust The Quantity"
                                    CommandArgument='<%# Eval("MAHANG") %>' OnClick="Button1_Click"/>
                            </ItemTemplate>
                        </asp:TemplateField>
                        <asp:BoundField ItemStyle-ForeColor="whitesmoke" ItemStyle-HorizontalAlign="Center" HeaderStyle-ForeColor="DarkRed"
                            DataField="THANHTIEN" HeaderText="Subtotal" ItemStyle-Width="12%" />
                        <asp:TemplateField ItemStyle-Width="4%">
                            <ItemTemplate>
                                <asp:LinkButton ID="LinkButton1" runat="server" OnClick="LinkButton1_Click"
                                    CommandArgument='<%# Eval("MAHANG") %>'><i style="cursor: pointer;" class="thungrac fa-solid fa-trash-can fa-2x text-danger"></i></asp:LinkButton>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                    <HeaderStyle HorizontalAlign="Center"/>
                </asp:GridView>
            </div>
        </div>
                        <asp:Label ID="lblthongbao" runat="server" Text="" ForeColor="White"></asp:Label>
    </asp:Content>