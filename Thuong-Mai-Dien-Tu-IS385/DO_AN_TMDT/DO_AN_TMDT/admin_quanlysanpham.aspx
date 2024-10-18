<%@ Page Title="" Language="C#" MasterPageFile="~/masterAdmin.Master" AutoEventWireup="true"
    CodeBehind="admin_quanlysanpham.aspx.cs" Inherits="DO_AN_TMDT.admin_quanlysanpham" %>
    <asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    </asp:Content>
    <asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
        <div class="row mb-3">
            <div class="col-md-12">
                <div class="card text-dark border border-2 border-primary">
                    <div class="card-body">
                        <div class="row">
                               <div class="col-md-4"><label for=""><b>#</b></label>
                                        <div class="input-group mb-2 mt-2"><span class="input-group-text"><i
                                                    class="fa-regular fa-money-bill-1"></i></span>
                                            <asp:TextBox ID="TextBox1" CssClass="form-control shadow-none"
                                                runat="server"></asp:TextBox>
                                        </div>
                                    </div>
                            <div class="col-md-4"><label for=""><b>Hình ảnh</b></label>
                                <div class="input-group mb-2 mt-2"><span class="input-group-text"><i
                                            class="fa-solid fa-image"></i></span>
                                    <asp:FileUpload ID="FileUpload1" runat="server" /> <asp:Button ID="Button2" runat="server" Text="Add" OnClick="Button2_Click" />
                                    <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
                                </div>
                            </div>
                            <div class="col-md-4"><label for=""><b>Tên hàng</b></label>
                                <div class="input-group mb-2 mt-2"><span class="input-group-text"><i
                                            class="fa-solid fa-staff-snake"></i></span>
                                    <asp:TextBox ID="ten_hang" CssClass="form-control shadow-none" runat="server">
                                    </asp:TextBox>
                                </div>
                            </div>
                            <div class="col-md-4"><label for=""><b>Mô tả</b></label>
                                <div class="input-group mb-2 mt-2"><span class="input-group-text"><i
                                            class="fa-solid fa-bookmark"></i></span>
                                    <asp:TextBox ID="mo_ta" CssClass="form-control shadow-none" runat="server">
                                    </asp:TextBox>
                                </div>
                            </div>
                            <div class="col-md-4"><label for=""><b>Giá cũ</b></label>
                                <div class="input-group mb-2 mt-2"><span class="input-group-text"><i
                                            class="fa-solid fa-money-bill"></i></span>
                                    <asp:TextBox ID="gia_cu" CssClass="form-control shadow-none" runat="server">
                                    </asp:TextBox>
                                </div>
                            </div>
                                <div class="col-md-4"><label for=""><b>Giá hiện tại</b></label>
                                    <div class="input-group mb-2 mt-2"><span class="input-group-text"><i
                                                class="fa-regular fa-money-bill-1"></i></span>
                                        <asp:TextBox ID="gia_moi" CssClass="form-control shadow-none" runat="server">
                                        </asp:TextBox>
                                    </div>
                                </div>
                                    <div class="col-md-4"><label for=""><b>Mã loại sản phẩm</b></label>
                                        <div class="input-group mb-2 mt-2"><span class="input-group-text"><i
                                                    class="fa-regular fa-money-bill-1"></i></span>
                                            <asp:TextBox ID="ma_loai" CssClass="form-control shadow-none"
                                                runat="server"></asp:TextBox>
                                        </div>
                                    </div>
                                        <div class="col-md-4"><label for=""><b>Còn lại</b></label>
                                            <div class="input-group mb-2 mt-2"><span class="input-group-text"><i
                                                        class="fa-regular fa-money-bill-1"></i></span>
                                                <asp:TextBox ID="con_lai" CssClass="form-control shadow-none"
                                                    runat="server"></asp:TextBox>
                                            </div>
                                        </div>
                            <div class="card-footer d-flex justify-content-end">
                                            <asp:Button ID="Button3" runat="server" CssClass="btn btn-primary" Text="Update" OnClick="Button3_Click"/>
                                        </div>
                            <div>
                                <asp:Label ID="Label1" runat="server" Text=""></asp:Label>
                            </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    <div class="row">
                        <div class="card" style="border-bottom: 5px solid  #AB826B;">
                            <div class="card-header ">
                                <h4 class=" mb-0 text-center align-middle py-2" style="color: #AB826B;"><b>Product Management</b>
                                </h4>
                            </div>
                            <div class="card-body">
                                <div class="">
                                   <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" Width="100%">
                                       <Columns>
                                           <asp:BoundField DataField="MAHANG" HeaderText="#" ItemStyle-Width="5%" ItemStyle-HorizontalAlign="Center">
                                           </asp:BoundField>
                                           <asp:TemplateField HeaderText="Image" ItemStyle-Width="15%" ItemStyle-HorizontalAlign="Center">
                                               <ItemTemplate>
                                                   <asp:Image ID="Image1" runat="server" ImageUrl='<%# "Hinhanh/"+Eval("HINH") %>' Width="100%" Height="200px"/>
                                               </ItemTemplate>

                                           </asp:TemplateField>
                                           <asp:BoundField DataField="TENHANG" HeaderText="Product Name" ItemStyle-Width="20%" ItemStyle-HorizontalAlign="Center">
                                           </asp:BoundField>
                                           <asp:BoundField DataField="MOTA" HeaderText="Description" ItemStyle-Width="30%" ItemStyle-HorizontalAlign="Center">
                                           </asp:BoundField>
                                           <asp:BoundField DataField="MALOAI" HeaderText="Type" ItemStyle-Width="5%" ItemStyle-HorizontalAlign="Center"/>
                                           <asp:BoundField DataField="GIACU" HeaderText="Old Price" ItemStyle-Width="7%" ItemStyle-HorizontalAlign="Center">
                                           </asp:BoundField>
                                           <asp:BoundField DataField="GIAMOI" HeaderText="Price" ItemStyle-Width="5%" ItemStyle-HorizontalAlign="Center">
                                           </asp:BoundField>
                                           <asp:BoundField DataField="CONLAI" HeaderText="Quantity" ItemStyle-Width="5%" ItemStyle-HorizontalAlign="Center">
                                           </asp:BoundField>
                                           <asp:TemplateField ItemStyle-Width="8%" ItemStyle-HorizontalAlign="Center">
                                               <ItemTemplate>
                                                   <asp:LinkButton ID="LinkButton1" runat="server" CommandArgument='<%# Eval("MAHANG") %>' OnClick="LinkButton1_Click" >Delete</asp:LinkButton>
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
    </asp:Content>