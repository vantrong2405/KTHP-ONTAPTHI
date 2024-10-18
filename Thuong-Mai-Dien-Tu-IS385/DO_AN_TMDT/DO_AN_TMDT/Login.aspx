<%@ Page Title="" Language="C#" MasterPageFile="~/EmptyMaster2.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="DO_AN_TMDT.Login" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="wrapper">
		<div class="section-authentication-signin d-flex align-items-center justify-content-center my-5 my-lg-0">
			<div class="container-fluid">
				<div class="row row-cols-1 row-cols-lg-2 row-cols-xl-3">
					<div class="col mx-auto">
						<div class="card">
							<div class="card-body">
								<div class="border p-4 rounded">
									<div class="text-center">
										<h3 class="">Sign In</h3>
										<p>Don't have an account yet? <a href="Register.aspx">Sign up here</a>
										</p>
									</div>
									<div class="login-separater text-center mb-4">
										<hr>
									</div>
									<div class="form-body">
										<form class="row g-3">
											<div class="col-12">
												User Name: <br />
												<asp:TextBox ID="txtusername" runat="server" Width="100%"></asp:TextBox> <br />
												<asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
                ErrorMessage="You must type your user name!"
                ControlToValidate="txtusername"
                Display="Dynamic" Font-Bold="true" ForeColor="Red"
                ></asp:RequiredFieldValidator>
											</div>
											<br />
											<div class="col-12">
												Enter Password: <br />
													<asp:TextBox ID="txtpassword" runat="server" Width="100%" TextMode="Password"></asp:TextBox> <br />
													<asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                ErrorMessage="You must type your password!"
                ControlToValidate="txtpassword"
                Display="Dynamic" Font-Bold="true" ForeColor="Red"
                ></asp:RequiredFieldValidator>
											</div>
											<div class="login-separater text-center mb-4">
										<hr>
									</div>
											<div class="col-12 mt-3">
												<div class="d-grid ">
													<asp:Button ID="btnsignin" runat="server" Text="Sign In" OnClick="btnsignin_Click" />
												</div>
											</div>
											<asp:Label ID="lblthongbao" runat="server" Text=""></asp:Label>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->
			</div>
		</div>
	</div>
</asp:Content>
