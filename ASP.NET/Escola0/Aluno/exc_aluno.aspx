<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="exc_aluno.aspx.cs" Inherits="Aluno_exc_aluno" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>Excluir Aluno</h1>
    <p>
    <asp:DropDownList ID="ddlid" runat="server" AutoPostBack="True" 
    DataSourceID="SqlDataSource3" DataTextField="al_nome" DataValueField="al_cod" 
    onprerender="Page_Load" Height="21px" Width="333px">
</asp:DropDownList>
<asp:SqlDataSource ID="SqlDataSource3" runat="server" 
    ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
    
        SelectCommand="SELECT [al_cod], [al_nome] FROM [ASP_Aluno]">
</asp:SqlDataSource>
    </p>
    <p>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <br />
    <asp:Button ID="btnExcluir" runat="server" CssClass="btn" onclick="excluir_Click" 
        Text="Excluir" />
    </p>
    <p>
        &nbsp;</p>
</asp:Content>

