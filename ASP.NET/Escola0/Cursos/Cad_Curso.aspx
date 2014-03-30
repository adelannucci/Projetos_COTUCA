<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Cad_Curso.aspx.cs" Inherits="Cursos_cad_curso" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>Cadastro de Curso.</h1>
    <p>&nbsp;</p>
    <asp:Label ID="Label1" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Codigo : "></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:TextBox ID="codigo" runat="server" Width="311px"></asp:TextBox>
    <br />
    <br />
    <asp:Label ID="Label6" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Nome :"></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:TextBox ID="nome" runat="server" Width="311px"></asp:TextBox>
    <br />
    <br />
    <asp:Label ID="Label7" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Período :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:DropDownList ID="Periodo" runat="server" Width="120px">
        <asp:ListItem>Vespertino</asp:ListItem>
        <asp:ListItem>Matutino</asp:ListItem>
        <asp:ListItem>Noturno</asp:ListItem>
        <asp:ListItem>Integral</asp:ListItem>
    </asp:DropDownList>
    <br />
    <br />
    &nbsp;&nbsp;
    <br />
    <asp:Button ID="btnCadastrar" runat="server" CssClass="btn" Text="Cadastrar" 
        onclick="btnCadastrar_Click" />
    <br />
    <br />
</asp:Content>

