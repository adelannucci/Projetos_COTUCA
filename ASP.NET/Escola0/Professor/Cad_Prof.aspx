<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Cad_Prof.aspx.cs" Inherits="Default3" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>Cadastrar Professor</h1>
    <p>&nbsp;</p>
    <asp:Label ID="Label5" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Matricula : "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
    <asp:TextBox ID="matricula" runat="server" MaxLength="12" Width="157px"></asp:TextBox>
    <br />
    <br />
    <asp:Label ID="Label1" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Nome : "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:TextBox ID="nome" runat="server" Width="311px"></asp:TextBox>
    <br />
<br />
    <asp:Label ID="Label6" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Endereço : "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:TextBox ID="end" runat="server" Width="311px"></asp:TextBox>
    <br />
<br />
    <asp:Label ID="Label7" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Telefone : "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
    <asp:TextBox ID="tel" runat="server" Width="311px"></asp:TextBox>
    <br />
<br />
    <asp:Label ID="Label8" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="E-mail : "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;
    <asp:TextBox ID="email" runat="server" Width="311px"></asp:TextBox>
    <br />
<br />
    <asp:Label ID="Label9" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Formação : "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
    <asp:TextBox ID="forma" runat="server" Width="311px"></asp:TextBox>
    <br />
    <br />
    <asp:Label ID="Label3" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Login : "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:TextBox ID="log" runat="server"></asp:TextBox>
    <br />
    <br />
    <asp:Label ID="Label4" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Senha : "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:TextBox ID="senha" runat="server"></asp:TextBox>
    <br />
    <br />
    <br />
    <br />
    <asp:Button ID="Button1" runat="server" onclick="Button1_Click" 
        Text="Adicionar" CssClass="btn" />
    <br />
    <br />
    <br />
</asp:Content>

