<%@ Page Title="" Language="C#" MasterPageFile="~/masterAdmin.Master" AutoEventWireup="true"
    CodeBehind="quanlytaikhoan.aspx.cs" Inherits="DO_AN_TMDT.quanlytaikhoan" %>
    <asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    </asp:Content>
    <asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
                        <div class="col-md-12">
                <div class="card text-dark border border-2 border-primary">
                    <div class="card-body">
                        <div class="row">
                               <div class="col-md-4"><label for=""><b>User Name</b></label>
                                        <div class="input-group mb-2 mt-2"><span class="input-group-text"><i
                                                    class="fa-regular fa-money-bill-1"></i></span>
                                            <asp:TextBox ID="txtUser" CssClass="form-control shadow-none"
                                                runat="server"></asp:TextBox>
                                        </div>
                                    </div>
                            <div class="col-md-4"><label for=""><b>Password</b></label>
                                <div class="input-group mb-2 mt-2"><span class="input-group-text"><i
                                            class="fa-solid fa-staff-snake"></i></span>
                                    <asp:TextBox ID="txtPass" CssClass="form-control shadow-none" runat="server">
                                    </asp:TextBox>
                                </div>
                            </div>
                            <div class="card-footer d-flex justify-content-end">
                                            <asp:Button ID="Button3" runat="server" CssClass="btn btn-primary" Text="Update" OnClick="Button3_Click"/>
                                        </div>
                            <div>
                                <asp:Label ID="Label2" runat="server" Text=""></asp:Label>
                            </div>
                                    </div>
                                </div>
                            </div>
                        </div>
        <div class="row mt-4">

            <div class="card mt-3">

                <div class="mt-3">
                    <h4><b>Account Management</b></h4>
                </div>
                <div class="card-body">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-lg-flex align-items-center mb-4 gap-3">
                            </div>
                            <div class="table-responsive">
                                <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" Width="100%">
                                    <Columns>
                                        <asp:BoundField DataField="TENDANGNHAP" HeaderText="User Name" ItemStyle-Width="40%" ItemStyle-HorizontalAlign="Center"/>
                                        <asp:BoundField DataField="MATKHAU" HeaderText="Password" ItemStyle-Width="40%" ItemStyle-HorizontalAlign="Center"/>
                                        <asp:TemplateField ItemStyle-Width="20%">
                                            <ItemTemplate>
                                                <asp:LinkButton ID="LinkButton1" runat="server" CommandArgument='<%# Eval("TENDANGNHAP") %>' OnClick="LinkButton1_Click" ItemStyle-HorizontalAlign="Center">Delete</asp:LinkButton>
                                            </ItemTemplate>
                                        </asp:TemplateField>
                                    </Columns>
                                    <HeaderStyle HorizontalAlign="Center"/>
                                </asp:GridView>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <hr>



        </div>
    </asp:Content>