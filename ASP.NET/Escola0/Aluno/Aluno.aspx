<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Aluno.aspx.cs" Inherits="Aluno" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <p>
        ALUNO</p>
    <p>
        <asp:Button ID="btnMaterias" runat="server" onclick="btnMaterias_Click" 
            Text="Visualizar Materias" />
    </p>
    <p>
        &nbsp;</p>
</asp:Content>

