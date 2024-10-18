<%@ Page Title="" Language="C#" MasterPageFile="~/masterpage.Master" AutoEventWireup="true" CodeBehind="default.aspx.cs" Inherits="DO_AN_TMDT._default" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

    <div class="row py-3">
        <div class="col-md-12 text-center">
            <span class="fs-1 text-danger" style="text-transform: uppercase; font-weight: 800"><b>our products</b></span>
        </div>
    </div>
    <div class="row py-3 text-center">
        <div class="col-md-12 text-center d-flex justify-content-center">
            <asp:DataList ID="DataList1" runat="server" RepeatColumns="4">
                <ItemTemplate>
                    <asp:LinkButton CssClass="btn text-danger me-2 list-items text-center" ID="LinkButton1" runat="server" CommandArgument='<%# Eval("MALOAI") %>' Text='<%# Eval("TENLOAI") %>' OnClick="LinkButton1_Click"></asp:LinkButton>
                </ItemTemplate>
            </asp:DataList>
        </div>
    </div>
    <div class="row">
        <asp:DataList ID="DataList2" runat="server" RepeatColumns="5">
            <ItemTemplate>

                <div class="col-md-12">
                    <table style="width:100%; background-color:transparent" class="card card-product">
                        <tr class=" card-product">
                            <td style="width:280px ; height:240px;">
                                <asp:ImageButton CssClass="text-center rounded card-product"  Style="background-size: 100% 100%;" ID="ImageButton1" runat="server" CommandArgument='<%# Eval("MAHANG") %>' ImageUrl='<%# "Hinhanh/"+Eval("HINH") %>' Width="100%" Height="100%"  OnClick="ImageButton1_Click" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="my-3 tenhang" style="font-weight: bold;
">
                                    <asp:LinkButton ID="tensanpham" Style="font-weight: bold;
    overflow: hidden;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    line-height: 1.2em;
    max-height: 1.2em;" CssClass="link-button" ForeColor="white" runat="server" CommandArgument='<%# Eval("MAHANG") %>' Text='<%# Eval("TENHANG") %>' OnClick="tensanpham_Click"></asp:LinkButton>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span>
                                    <div class="text-decoration-line-through">
                                    <asp:LinkButton ID="LinkButton4" ForeColor="Red" CommandArgument='<%# Eval("MAHANG") %>' runat="server" OnClick="LinkButton4_Click">$</asp:LinkButton>
                                    <asp:LinkButton ID="LinkButton2" ForeColor="Red"  runat="server" CommandArgument='<%# Eval("MAHANG") %>' Text='<%# Eval("GIACU") %>' OnClick="giacu_Click"></asp:LinkButton>
                                    </div>
                                    <div>
                                    <asp:LinkButton ID="LinkButton5" ForeColor="#0aef17" runat="server" OnClick="LinkButton5_Click">$</asp:LinkButton>
                                    <asp:LinkButton ID="LinkButton3" ForeColor="#0aef17" runat="server" CommandArgument='<%# Eval("MAHANG") %>' Text='<%# Eval("GIAMOI") %>' OnClick="giamoi_Click"></asp:LinkButton>
                                    </div>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <asp:LinkButton ID="lkconlai" runat="server" ForeColor="White" CommandArgument='<%# Eval("MAHANG") %>' OnClick="lkconlai_Click">Qty: </asp:LinkButton>
                                <asp:LinkButton ID="conlai" ForeColor="white" runat="server"
                                    CommandArgument='<%# Eval("MAHANG") %>'
                                    Text='<%# Eval("CONLAI") %>' OnClick="conlai_Click"></asp:LinkButton>
                            </td>
                        </tr>
                    </table>
                </div>

            </ItemTemplate>
        </asp:DataList>
    </div>
</asp:Content>
