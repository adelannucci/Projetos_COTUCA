<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Exc_Prof.aspx.cs" Inherits="Exc_Prof" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>Excluir Professor</h1>
    <br />
    <asp:DropDownList ID="ddlid" runat="server" AutoPostBack="True" 
    DataSourceID="SqlDataSource3" DataTextField="prof_nome" DataValueField="prof_cod" 
    onprerender="Page_Load" Height="21px" Width="333px">
</asp:DropDownList>
<asp:SqlDataSource ID="SqlDataSource3" runat="server" 
    ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
    
        SelectCommand="SELECT [prof_cod], [prof_nome] FROM [ASP_Professor]">
</asp:SqlDataSource>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <br />
    <asp:Button ID="excluir" runat="server" CssClass="btn" onclick="excluir_Click" 
        Text="Excluir" />
    <br />
    <br />
    <br />
</asp:Content>

