<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Disciplina_Cursos.aspx.cs" Inherits="Relacionamentos_Disciplina_Cursos" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
 <h1>RELACIONAR DISCIPLINA COM CURSO.</h1>
    <br />
    <br />
    
    <asp:Label ID="lbAno" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Ano :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:DropDownList ID="ddlAno" runat="server">
    </asp:DropDownList>
    <br />
    <br />
    
    <asp:Label ID="Label8" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Disciplina :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:DropDownList ID="ddlDis" runat="server" AutoPostBack="True" 
    DataSourceID="SqlDataSource4" DataTextField="dis_nome" DataValueField="dis_cod" 
    onprerender="Page_Load" Height="21px" Width="333px">
        </asp:DropDownList>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
    <br />
    &nbsp;<asp:Button ID="btnAdd" runat="server" Height="26px" 
        onclick="btnAdd_Click" Text="Adicionar" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:Button ID="btnExc" runat="server" Enabled="False" Text="Excluir" 
        onclick="btnExc_Click" />
        <asp:SqlDataSource ID="SqlDataSource4" runat="server" 
    ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
    
        
        SelectCommand="SELECT [dis_nome], [dis_cod] FROM [ASP_Disciplina] ORDER BY [dis_cod]"></asp:SqlDataSource>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    <br />
    <br />
    
    <asp:Label ID="Label7" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Curso :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:DropDownList ID="ddlCur" runat="server" AutoPostBack="True" 
    DataSourceID="SqlDataSource3" DataTextField="cur_nome" DataValueField="cur_cod" 
    onprerender="Page_Load" Height="21px" Width="333px" 
            onselectedindexchanged="ddlCur_SelectedIndexChanged">
        </asp:DropDownList>
        <asp:SqlDataSource ID="SqlDataSource3" runat="server" 
    ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
    
        SelectCommand="SELECT [cur_cod], [cur_nome] FROM [Asp_Curso]"></asp:SqlDataSource>
    <div style="position: relative; right: 0px; background-color: #00FF00; width: 200px; height: 200px; left: 500px; top: -150px;">
        <asp:ListBox ID="ltDisc" runat="server" Height="200px" Width="200px" 
            AutoPostBack="True" onselectedindexchanged="ltDisc_SelectedIndexChanged" ontextchanged="ltDisc_SelectedIndexChanged" 
            >
        </asp:ListBox>
    </div>
    
        <asp:Button ID="btn_relacionar" runat="server" CssClass="btn" 
            onclick="btn_relacionar_Click" Text="Relacionar" />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
    &nbsp;&nbsp; &nbsp; 
   
    </asp:Content>

