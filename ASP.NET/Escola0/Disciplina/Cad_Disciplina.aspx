<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Cad_Disciplina.aspx.cs" Inherits="Disciplina_Cad_Disciplina" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>
        Cadastro de DISCIPLINA</h1>
    <p>
        &nbsp;</p>
    <asp:Label ID="Label5" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Código : "></asp:Label>
&nbsp;&nbsp;&nbsp;<asp:TextBox ID="cod" runat="server" MaxLength="12" Width="157px"></asp:TextBox>
    <br />
    <br />
    <asp:Label ID="Label1" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Nome : "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:TextBox ID="nome" runat="server" Width="311px"></asp:TextBox>
    <br />
    <br />
    <asp:Label ID="Label6" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Ementa : "></asp:Label>
&nbsp;&nbsp;
    <asp:TextBox ID="emen" runat="server" Width="311px"></asp:TextBox>
    <br />
    <br />
    <br />
    <asp:Button ID="cadastrar" runat="server" onclick="cadastrar_Click" 
        Text="Cadastrar" />
    <br />
    <br />
</asp:Content>

