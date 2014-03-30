<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Exc_Dis_Cur.aspx.cs" Inherits="Relacionamentos_Exc_Dis_Cur" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1>Excluir Relacionamento atribuição didatica</h1>
    <p>
    <asp:Label ID="Label11" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Ano :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<asp:DropDownList ID="ddlAno" 
            runat="server">
        </asp:DropDownList>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; </p>
    <asp:Label ID="Label7" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Curso :"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <asp:DropDownList ID="ddlCur" runat="server" AutoPostBack="True" 
        DataSourceID="sqlcurso" DataTextField="cur_nome" DataValueField="cur_cod">
    </asp:DropDownList>
    <asp:SqlDataSource ID="sqlcurso" runat="server" 
        ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
        SelectCommand="SELECT [cur_cod], [cur_nome] FROM [Asp_Curso]"></asp:SqlDataSource>
    <br />
    <br />
    <br />
    <asp:Label ID="Label8" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Disciplina :"></asp:Label>
    <div style="position: relative; right: -99px; background-color: #C0C0C0; width: 200px; height: 200px; left: 99px; top: -20px;">
        <asp:ListBox ID="lbxDisc" runat="server" AutoPostBack="True" 
            DataSourceID="sqlDisc" DataTextField="dis_cod" DataValueField="dis_cod" 
            Height="197px" Width="190px"></asp:ListBox>
        <asp:SqlDataSource ID="sqlDisc" runat="server" 
            ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
            
            SelectCommand="SELECT * FROM [Asp_Catalogo] WHERE (([cur_cod] = @cur_cod) AND ([cur_ano] = @cur_ano))">
            <SelectParameters>
                <asp:ControlParameter ControlID="ddlCur" Name="cur_cod" 
                    PropertyName="SelectedValue" Type="Int32" />
                <asp:ControlParameter ControlID="ddlAno" Name="cur_ano" 
                    PropertyName="SelectedValue" Type="String" />
            </SelectParameters>
        </asp:SqlDataSource>
    </div>
    <br />
    <asp:Button ID="btnExc" runat="server" onclick="btnExc_Click" Text="Excluir" 
        style="height: 26px" />
    <br />
</asp:Content>

