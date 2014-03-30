<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Alter_Aluno.aspx.cs" Inherits="Aluno_Alter_Aluno" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>Alterar Aluno</h1>
    <p>
    <asp:DropDownList ID="ddlid" runat="server" AutoPostBack="True" 
    DataSourceID="SqlDataSource3" DataTextField="al_nome" DataValueField="al_cod" 
    onprerender="Page_Load" Height="21px" 
        onselectedindexchanged="ddlid_SelectedIndexChanged" Width="333px">
    </asp:DropDownList>
    <asp:SqlDataSource ID="SqlDataSource3" runat="server" 
    ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
    
        SelectCommand="SELECT [al_cod], [al_nome] FROM [ASP_Aluno]">
    </asp:SqlDataSource>
    </p>
    <p>
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
        Font-Size="Medium" ForeColor="Black" Text="Ano : "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="ano" runat="server" Width="312px"></asp:TextBox>
    <br />
    <br />
    <br />
    <asp:Button ID="btnAlterar" runat="server" onclick="Button1_Click" 
        Text="Alterar" CssClass="btn" />
    </p>
    <p>&nbsp;</p>

</asp:Content>

