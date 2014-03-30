<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Vizualizar_turmas.aspx.cs" Inherits="Professor_Vizualizar_turmas" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>
        Vizualizar turmas</h1>
    <h1>
    <asp:Label ID="Label1" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Disciplina : "></asp:Label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:DropDownList ID="DropDownList1" runat="server" 
            AutoPostBack="True" DataSourceID="SqlDataSource1" DataTextField="dadosDisc" 
            DataValueField="lec_cod" Height="36px" Width="306px">
        </asp:DropDownList>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
            ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
            SelectCommand="select lec_cod, 'Cod. Dis: ' + dis_cod + '; Per: ' + lec_nomeperiodo + '; Sem: ' + ltrim(str(lec_semestre)) + '; Turma: ' + lec_turma as 'dadosDisc' from vwProfDisc where prof_cod = @prof_cod">
            <SelectParameters>
                <asp:SessionParameter DefaultValue="null" Name="prof_cod" 
                    SessionField="prof_cod" />
            </SelectParameters>
        </asp:SqlDataSource>
    </h1>
    <p>
    <asp:Label ID="Label2" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Alunos : "></asp:Label>
    </p>
    <p>
        <asp:ListBox ID="ListBox1" runat="server" DataSourceID="SqlDataSource2" 
            DataTextField="al_nome" DataValueField="al_cod" Height="194px" 
            onselectedindexchanged="ListBox1_SelectedIndexChanged" Width="183px" 
            AutoPostBack="True">
        </asp:ListBox>
        &nbsp;&nbsp;
    <asp:Label ID="Label3" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Nota:"></asp:Label>
        &nbsp;
        <asp:TextBox ID="txNome" runat="server"></asp:TextBox>
&nbsp;&nbsp;
    <asp:Label ID="Label4" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Frequência:"></asp:Label>
        &nbsp;
        <asp:TextBox ID="txFre" runat="server"></asp:TextBox>
&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnAtualizarNota" runat="server" 
            onclick="btnAtualizarNota_Click1" Text="Atribuir" />
        <asp:SqlDataSource ID="SqlDataSource2" runat="server" 
            ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
            SelectCommand="select al.al_cod, al.al_nome from asp_aluno al where al.al_cod in (select ma.al_cod from asp_matricula ma where ma.lec_cod=@LECCOD)">
            <SelectParameters>
                <asp:ControlParameter ControlID="DropDownList1" DefaultValue="0" Name="LECCOD" 
                    PropertyName="SelectedValue" />
            </SelectParameters>
        </asp:SqlDataSource>
    </p>
    <p>
        <asp:Button ID="Button1" runat="server" CssClass="btn" onclick="Button1_Click" 
            Text="Voltar" />
    </p>
</asp:Content>

