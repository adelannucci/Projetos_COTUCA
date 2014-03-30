<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Alt_Curso.aspx.cs" Inherits="Cursos_Alt_Curso" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>Alterar Curso.</h1>
    <p>
    <asp:DropDownList ID="ddlid" runat="server" AutoPostBack="True" 
    DataSourceID="SqlDataSource3" DataTextField="cur_nome" DataValueField="cur_cod" 
    onprerender="Page_Load" Height="21px" 
        onselectedindexchanged="ddlid_SelectedIndexChanged" Width="333px">
    </asp:DropDownList>
    <asp:SqlDataSource ID="SqlDataSource3" runat="server" 
    ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
    
        SelectCommand="SELECT [cur_nome], [cur_cod] FROM [ASP_Curso]">
    </asp:SqlDataSource>
        &nbsp;&nbsp;&nbsp;
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
    </p>
    <p>
        <asp:Button ID="btnAlterar" runat="server" onclick="Button1_Click" 
            Text="Alterar" />
    </p>
    <p>&nbsp;</p>
</asp:Content>

