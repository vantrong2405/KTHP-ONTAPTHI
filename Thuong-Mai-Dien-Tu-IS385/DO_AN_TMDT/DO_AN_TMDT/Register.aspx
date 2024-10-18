<%@ Page Title="" Language="C#" MasterPageFile="~/EmptyMaster2.Master" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="DO_AN_TMDT.Register" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
     <div class="wrapper">
		<div class="d-flex align-items-center justify-content-center my-5 my-lg-0">
			<div class="container" style="margin-top:220px">
				<div class="row row-cols-1 row-cols-lg-2 row-cols-xl-2">
					<div class="col mx-auto">
						<div class="card">
							<div class="card-body">
								<div class="border p-4 rounded">
									<div class="text-center">
										<h3 class="">Sign Up</h3>
										<p>Already have an account? <a href="Login.aspx">Sign in here</a>
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
												Password: <br />
													<asp:TextBox ID="txtpass" runat="server" Width="100%" TextMode="Password"></asp:TextBox> <br />
												<asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                ErrorMessage="You must type your password!"
                ControlToValidate="txtpass"
                Display="Dynamic" Font-Bold="true" ForeColor="Red"
                ></asp:RequiredFieldValidator>
											</div>
											<br />
											<div class="col-12">
												Confirm Password: <br />
													<asp:TextBox ID="txtpass1" runat="server" Width="100%" TextMode="Password"></asp:TextBox> <br />
												<asp:CompareValidator ID="CompareValidator1" runat="server" ErrorMessage="Password and confirm password must be same!"
												 ControlToValidate="txtpass1" ControlToCompare="txtpass"
													 Operator="Equal" Type="String" Display="Dynamic"
                ></asp:CompareValidator>
											</div>
											<div class="login-separater text-center mb-4">
										<hr>
									</div>
											<div class="col-12 mt-3">
												<div class="d-grid">
													<asp:Button ID="btnsignup" runat="server" Text="Sign Up" OnClick="btnsignup_Click" />
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
