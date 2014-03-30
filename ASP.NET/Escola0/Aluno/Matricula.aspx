<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Matricula.aspx.cs" Inherits="Aluno_Matricula" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>Matricula</h1>
    <p>
    <asp:Label ID="Label11" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Ano :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
    <asp:DropDownList ID="ddlAno" runat="server" 
            onselectedindexchanged="ano_SelectedIndexChanged" AutoPostBack="True">
    </asp:DropDownList>
    </p>
    <asp:Label ID="Label10" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Semestre :"></asp:Label>
        <asp:RadioButtonList ID="rbSemestre" runat="server" AutoPostBack="True">
            <asp:ListItem Value="1">Primeiro Semestre</asp:ListItem>
            <asp:ListItem Value="2">Segundo Semestre</asp:ListItem>
        </asp:RadioButtonList>
    <p>
    <asp:Label ID="Label13" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Aluno :"></asp:Label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:DropDownList ID="ddlAluno" runat="server" 
            onselectedindexchanged="ano_SelectedIndexChanged" AutoPostBack="True" 
            DataSourceID="SqlDataSource2" DataTextField="al_cod" DataValueField="al_cod">
    </asp:DropDownList>
        <asp:SqlDataSource ID="SqlDataSource2" runat="server" 
            ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
            SelectCommand="SELECT * FROM [Asp_Aluno] WHERE ([al_ano_ingresso] = @al_ano_ingresso)">
            <SelectParameters>
                <asp:ControlParameter ControlID="ddlAno" Name="al_ano_ingresso" 
                    PropertyName="SelectedValue" Type="String" />
            </SelectParameters>
        </asp:SqlDataSource>
    </p>
    <p>
    <asp:Label ID="Label12" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Disciplinas Oferecidas :"></asp:Label>
    &nbsp;&nbsp;&nbsp;
        <asp:DropDownList ID="ddlDisOfer" runat="server" AutoPostBack="True" 
            DataSourceID="SqlDataSource1" DataTextField="dis_cod" 
            DataValueField="lec_cod" 
            onselectedindexchanged="ddlDisOfer_SelectedIndexChanged">
        </asp:DropDownList>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
            ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
            
            
            SelectCommand="SELECT [lec_cod], [dis_cod] FROM [Asp_Leciona] WHERE (([lec_ano] = @lec_ano) AND ([lec_semestre] = @lec_semestre))">
            <SelectParameters>
                <asp:ControlParameter ControlID="ddlAno" Name="lec_ano" 
                    PropertyName="SelectedValue" Type="String" />
                <asp:ControlParameter ControlID="rbSemestre" Name="lec_semestre" 
                    PropertyName="SelectedValue" Type="Int32" />
            </SelectParameters>
        </asp:SqlDataSource>
    </p>
    <p>
    <asp:Label ID="Label14" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Turma : "></asp:Label>
    &nbsp;&nbsp;&nbsp;
        <asp:DropDownList ID="ddlTurma" runat="server" 
            DataSourceID="SqlDataSource3" DataTextField="lec_turma" 
            DataValueField="lec_cod" AutoPostBack="True">
        </asp:DropDownList>
        <asp:SqlDataSource ID="SqlDataSource3" runat="server" 
            ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
            
            SelectCommand="SELECT DISTINCT [lec_cod], [lec_turma] FROM [Asp_Leciona] WHERE ([lec_cod] = @lec_cod)">
            <SelectParameters>
                <asp:ControlParameter ControlID="ddlDisOfer" Name="lec_cod" 
                    PropertyName="SelectedValue" Type="Int32" />
            </SelectParameters>
        </asp:SqlDataSource>
    </p>
    <p>
        <asp:Button ID="btnAdd" runat="server" Height="26px" 
        onclick="btnAdd_Click" Text="Adicionar" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:Button ID="btnExc" runat="server" Text="Excluir" 
        onclick="btnExc_Click" Width="83px" />
    </p>
    <p>
        <asp:ListBox ID="lbxDisSelected" runat="server" AutoPostBack="True" 
            onselectedindexchanged="ListBox1_SelectedIndexChanged" Width="191px">
        </asp:ListBox>
    </p>
    <p>
        <asp:Button ID="btnMatricula" runat="server" onclick="btnMatricula_Click" 
            Text="Realizar Matricula" Width="189px" />
    </p>
    <p>&nbsp;</p>
</asp:Content>

