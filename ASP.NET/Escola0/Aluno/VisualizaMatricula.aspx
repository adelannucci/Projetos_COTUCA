<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="VisualizaMatricula.aspx.cs" Inherits="Aluno_VisualizaMatricula" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
<h1>Visualizar Matriculas</h1>
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
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" 
            DataKeyNames="mat_cod,al_cod,lec_cod,his_cod" DataSourceID="SqlDataSource1">
            <Columns>
                <asp:BoundField DataField="mat_cod" HeaderText="mat_cod" InsertVisible="False" 
                    ReadOnly="True" SortExpression="mat_cod" />
                <asp:BoundField DataField="al_cod" HeaderText="al_cod" ReadOnly="True" 
                    SortExpression="al_cod" />
                <asp:BoundField DataField="lec_cod" HeaderText="lec_cod" ReadOnly="True" 
                    SortExpression="lec_cod" />
                <asp:BoundField DataField="his_cod" HeaderText="his_cod" ReadOnly="True" 
                    SortExpression="his_cod" />
                <asp:BoundField DataField="mat_ano" HeaderText="mat_ano" 
                    SortExpression="mat_ano" />
                <asp:BoundField DataField="mat_semestre" HeaderText="mat_semestre" 
                    SortExpression="mat_semestre" />
            </Columns>
        </asp:GridView>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
            ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
            SelectCommand="SELECT * FROM [Asp_Matricula] WHERE (([al_cod] = @al_cod) AND ([mat_semestre] = @mat_semestre) AND ([mat_ano] = @mat_ano))">
            <SelectParameters>
                <asp:ControlParameter ControlID="ddlAluno" Name="al_cod" 
                    PropertyName="SelectedValue" Type="String" />
                <asp:ControlParameter ControlID="rbSemestre" Name="mat_semestre" 
                    PropertyName="SelectedValue" Type="Int32" />
                <asp:ControlParameter ControlID="ddlAno" Name="mat_ano" 
                    PropertyName="SelectedValue" Type="String" />
            </SelectParameters>
        </asp:SqlDataSource>
    </p>
    <p>
        <asp:Button ID="btnAlterar" runat="server" onclick="btnAlterar_Click" 
            Text="Alterar" />
    </p>
    <p>
        &nbsp;</p>
</asp:Content>


