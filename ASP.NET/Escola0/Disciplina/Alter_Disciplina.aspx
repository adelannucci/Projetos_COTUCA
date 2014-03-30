<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Alter_Disciplina.aspx.cs" Inherits="Disciplina_Alter_Disciplina" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>
        Alterar DISCIPLINA</h1>
    <p>
        <asp:DropDownList ID="ddlid" runat="server" AutoPostBack="True" 
    DataSourceID="SqlDataSource3" DataTextField="dis_nome" DataValueField="dis_nome" 
    onprerender="ddlid_SelectedIndexChanged" Height="21px" 
        onselectedindexchanged="ddlid_SelectedIndexChanged" Width="333px">
        </asp:DropDownList>
        <asp:SqlDataSource ID="SqlDataSource3" runat="server" 
    ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
    
        SelectCommand="SELECT [dis_nome] FROM [ASP_Disciplina] ORDER BY [dis_nome]">
        </asp:SqlDataSource>
    </p>
    <p>
        <asp:Label ID="Label1" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Nome : "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:TextBox ID="nome" runat="server" Width="311px"></asp:TextBox>
        <br />
        <br />
        <asp:Label ID="Label6" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Ementa : "></asp:Label>
&nbsp;&nbsp;
        <asp:TextBox ID="emen" runat="server" Width="311px"></asp:TextBox>
    </p>
    <p>
        <asp:Button ID="altera" runat="server" onclick="altera_Click" Text="Alterar" />
    </p>
    <p>
        &nbsp;</p>
</asp:Content>

