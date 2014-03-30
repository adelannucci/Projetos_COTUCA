<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="teste" %>

<asp:Content ID="Content" ContentPlaceHolderID="MainContent" Runat="Server">

   
    <center style="height: 429px">
        <asp:Login ID="Login1" runat="server" BorderStyle="None" 
        CreateUserIconUrl="~/xs.png" FailureText="Usuario ou senha incorretos" 
        Height="393px" PasswordLabelText="Senha:" RememberMeText="Lembrar Senha" 
        TitleText="Login" UserNameLabelText="Usuario:" Width="278px" BackColor="Silver" 
            ForeColor="Black" onauthenticate="Login1_Authenticate">
    </asp:Login>
    </center>
</asp:Content>

