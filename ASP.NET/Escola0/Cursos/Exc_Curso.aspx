<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Exc_Curso.aspx.cs" Inherits="Cursos_Exc_Curso" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>Excluir Curso</h1>
    <p>&nbsp;</p>
    <asp:DropDownList ID="ddlid" runat="server" AutoPostBack="True" 
    DataSourceID="SqlDataSource3" DataTextField="cur_nome" DataValueField="cur_cod" 
    onprerender="Page_Load" Height="21px" Width="333px">
    </asp:DropDownList>
    <asp:SqlDataSource ID="SqlDataSource3" runat="server" 
    ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
    
        SelectCommand="SELECT [cur_nome], [cur_cod] FROM [ASP_Curso]">
    </asp:SqlDataSource>
    <br />
    <br />
        <asp:Button ID="btnExcluir" runat="server" onclick="Button1_Click" 
            Text="Excluir" CssClass="btn" />
    <br />
    </asp:Content>

