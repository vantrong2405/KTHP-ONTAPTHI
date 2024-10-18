<%@ Page Title="" Language="C#" MasterPageFile="~/EmptyTrang.Master" AutoEventWireup="true" CodeBehind="Admin.aspx.cs" Inherits="DO_AN_TMDT.Admin" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
        <div class="row mt-5">
            <div class="col-5">
                <div class="card border-primary border-bottom border-3 border-0">
                    <div class="card-header">Thêm Mới Tài Khoản </div>
                    <div class="card-body">
                        <label class="mb-1 mt-1">Tên Đăng Nhập</label><input class="form-control" type="text"><label class="mb-1 mt-1">Mật Khẩu</label><input class="form-control" type="text"><label class="mb-1 mt-1">Email</label><input class="form-control" type="email"><label class="mb-1 mt-1">Tình trạng</label><select class="form-select" aria-label="Default select example"><option value="1">Hiển thị</option>
                            <option value="0">Tạm dừng</option>
                        </select></div>
                    <div class="card-footer text-end">
                        <button class="btn btn-primary">Thêm Mới</button></div>
                </div>
            </div>
            <div class="col-7">
                <div class="card border-primary border-bottom border-3 border-0">
                    <div class="card-header">Danh Sách Tài Khoản </div>
                    <div class="card-body">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="align-middle text-center">#</th>
                                    <th class="align-middle text-center">Tên Đăng Nhập</th>
                                    <th class="align-middle text-center">Email</th>
                                    <th class="align-middle text-center">Tình Trạng</th>
                                    <th class="align-middle text-center">Action</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                        <div class="modal fade" id="capNhatModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="#exampleModalLabel">Cập Nhật Chức Vụ</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <label class="mb-1 mt-1">Tên Đăng nhập</label><input class="form-control" type="text"><label class="mb-1 mt-1">Email</label><input class="form-control" type="email"><label class="mb-1 mt-1">Tình Trạng</label><select class="form-control"><option value="1">Hoạt Động </option>
                                            <option value="0">Tạm Tắt </option>
                                        </select></div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Thoát</button>
                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cập Nhật</button></div>
                                </div>
                            </div>
                        </div>
                        <div class="modal fade" id="xoaModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">Xóa Chức Vụ</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="alert alert-warning border-0 bg-warning alert-dismissible fade show py-2">
                                            <div class="d-flex align-items-center">
                                                <div class="font-35 text-dark"><i class="bx bx-info-circle"></i></div>
                                                <div class="ms-3">
                                                    <h6 class="mb-0 text-dark">Warning</h6>
                                                    <div class="text-dark">
                                                        <p>Bạn có muốn xóa tên đăng nhập <i><b></b></i>này không? </p>
                                                        <p><b>Lưu ý:</b> Điều này không thể hoàn tác! </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Thoát</button>
                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Xóa</button></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</asp:Content>
