<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Exc_atribuicao.aspx.cs" Inherits="Relacionamentos_Exc_atribuicao" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>
        Excluir Relacionamento atribuição didatica</h1>
    <p>
        <asp:Label ID="Label11" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Ano :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<asp:DropDownList ID="ddlAno" 
            runat="server">
        </asp:DropDownList>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; 
    </p>
    <asp:Label ID="Label7" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Semestre :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;
        <asp:RadioButtonList ID="rbSemestre" runat="server" AutoPostBack="True">
            <asp:ListItem Value="1">Primeiro Semestre</asp:ListItem>
            <asp:ListItem Value="2">Segundo Semestre</asp:ListItem>
        </asp:RadioButtonList>
    <br />
    <asp:Label ID="Label12" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Turma :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<asp:DropDownList ID="ddlTurma" 
            runat="server" AutoPostBack="True" DataSourceID="SqlDataSource1" 
        DataTextField="lec_turma" DataValueField="lec_turma">
    </asp:DropDownList>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
    <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
        ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
        
        SelectCommand="SELECT DISTINCT lec_turma FROM [Asp_Leciona] WHERE (([lec_ano] = @lec_ano) AND ([lec_semestre] = @lec_semestre))">
        <SelectParameters>
            <asp:ControlParameter ControlID="ddlAno" Name="lec_ano" 
                PropertyName="SelectedValue" Type="String" />
            <asp:ControlParameter ControlID="rbSemestre" Name="lec_semestre" 
                PropertyName="SelectedValue" Type="Int32" />
        </SelectParameters>
    </asp:SqlDataSource>
    <br />
    <asp:Label ID="Label8" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Disciplina :"></asp:Label>
    <div style="position: relative; right: -99px; background-color: #C0C0C0; width: 200px; height: 200px; left: 99px; top: -20px;">
        <asp:ListBox ID="lbxDisc" runat="server" AutoPostBack="True" 
            DataSourceID="sqlDisc" DataTextField="dis_cod" DataValueField="dis_cod" 
            Height="197px" Width="190px"></asp:ListBox>
        <asp:SqlDataSource ID="sqlDisc" runat="server" 
            ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
            
            
            SelectCommand="SELECT * FROM [Asp_Leciona] WHERE (([lec_ano] = @lec_ano) AND ([lec_semestre] = @lec_semestre) AND ([lec_turma] = @lec_turma))">
            <SelectParameters>
                <asp:ControlParameter ControlID="ddlAno" Name="lec_ano" 
                    PropertyName="SelectedValue" Type="String" />
                <asp:ControlParameter ControlID="rbSemestre" Name="lec_semestre" 
                    PropertyName="SelectedValue" Type="Int32" />
                <asp:ControlParameter ControlID="ddlTurma" Name="lec_turma" 
                    PropertyName="SelectedValue" Type="String" />
            </SelectParameters>
        </asp:SqlDataSource>
    </div>
    <br />
    <asp:Button ID="btnExc" runat="server" onclick="btnExc_Click" Text="Excluir" 
        style="height: 26px" />
</asp:Content>

