<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Disciplina_Professor.aspx.cs" Inherits="Relacionamentos_Disciplina_Professor" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">

<h1>ATRIBUIÇÃO DIDATICA</h1>
    <p>
    <asp:Label ID="Label8" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Disciplina :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:DropDownList ID="ddlDis" runat="server" AutoPostBack="True" 
    DataSourceID="SqlDataSource4" DataTextField="dis_nome" DataValueField="dis_cod" 
    onprerender="Page_Load" Height="21px" Width="333px">
        </asp:DropDownList>
        &nbsp;&nbsp;
    <asp:SqlDataSource ID="SqlDataSource4" runat="server" 
    ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
    
        
            
            SelectCommand="SELECT * FROM [Asp_Disciplina]">
        </asp:SqlDataSource>
    </p>
    <p>
    <asp:Label ID="Label9" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Professor :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:DropDownList ID="ddlProf" runat="server" AutoPostBack="True" 
    DataSourceID="SqlDataSource5" DataTextField="prof_nome" DataValueField="prof_cod" 
    onprerender="Page_Load" Height="21px" Width="333px">
        </asp:DropDownList>
        &nbsp;&nbsp;&nbsp;
        <asp:SqlDataSource ID="SqlDataSource5" runat="server" 
    ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
    
        
            
            SelectCommand="SELECT * FROM [Asp_Professor]">
        </asp:SqlDataSource>
    </p>
    <p>
    <asp:Label ID="Label10" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Semestre :"></asp:Label>
        <asp:RadioButtonList ID="rbSemestre" runat="server">
            <asp:ListItem Value="1">Primeiro Semestre</asp:ListItem>
            <asp:ListItem Value="2">Segundo Semestre</asp:ListItem>
        </asp:RadioButtonList>
    </p>
    <p>
    <asp:Label ID="Label7" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Período :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:DropDownList ID="ddlPer" runat="server" Width="120px">
        <asp:ListItem>Vespertino</asp:ListItem>
        <asp:ListItem>Matutino</asp:ListItem>
        <asp:ListItem>Noturno</asp:ListItem>
        <asp:ListItem>Integral</asp:ListItem>
    </asp:DropDownList>
    </p>
    <p>
    <asp:Label ID="Label11" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Ano :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
    <asp:DropDownList ID="ddlAno" runat="server" 
            onselectedindexchanged="ano_SelectedIndexChanged">
    </asp:DropDownList>
    </p>
    <p>
    <asp:Label ID="Label12" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Turma :"></asp:Label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:DropDownList ID="ddlTurma" runat="server">
            <asp:ListItem>A</asp:ListItem>
            <asp:ListItem>B</asp:ListItem>
            <asp:ListItem>C</asp:ListItem>
            <asp:ListItem>D</asp:ListItem>
            <asp:ListItem>E</asp:ListItem>
            <asp:ListItem>F</asp:ListItem>
            <asp:ListItem>G</asp:ListItem>
            <asp:ListItem>H</asp:ListItem>
            <asp:ListItem>I</asp:ListItem>
            <asp:ListItem>J</asp:ListItem>
            <asp:ListItem>K</asp:ListItem>
            <asp:ListItem>L</asp:ListItem>
            <asp:ListItem>M</asp:ListItem>
            <asp:ListItem>N</asp:ListItem>
            <asp:ListItem>O</asp:ListItem>
            <asp:ListItem>P</asp:ListItem>
            <asp:ListItem>Q</asp:ListItem>
            <asp:ListItem>R</asp:ListItem>
            <asp:ListItem>S</asp:ListItem>
            <asp:ListItem>T</asp:ListItem>
            <asp:ListItem>U</asp:ListItem>
            <asp:ListItem>V</asp:ListItem>
            <asp:ListItem>X</asp:ListItem>
            <asp:ListItem>Z</asp:ListItem>
            <asp:ListItem>W</asp:ListItem>
            <asp:ListItem>Y</asp:ListItem>
        </asp:DropDownList>
    </p>
    <p>
        <asp:Button ID="btnAtribuir" runat="server" onclick="btnAtribuir_Click" 
            Text="Atribuir" />
    </p>
    <p>&nbsp;</p>
</asp:Content>

