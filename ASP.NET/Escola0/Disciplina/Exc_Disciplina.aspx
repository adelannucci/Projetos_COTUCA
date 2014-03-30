<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Exc_Disciplina.aspx.cs" Inherits="Disciplina_Exc_Disciplina" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>
        Excluir DISCIPLINA</h1>
    <p>
        <asp:DropDownList ID="ddlid" runat="server" AutoPostBack="True" 
    DataSourceID="SqlDataSource3" DataTextField="dis_nome" DataValueField="dis_nome" 
    onprerender="Page_Load" Height="21px" Width="333px">
        </asp:DropDownList>
        <asp:SqlDataSource ID="SqlDataSource3" runat="server" 
    ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
    
        SelectCommand="SELECT [dis_nome] FROM [ASP_Disciplina]"></asp:SqlDataSource>
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

