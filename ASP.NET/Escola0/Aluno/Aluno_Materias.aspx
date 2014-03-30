<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Aluno_Materias.aspx.cs" Inherits="Aluno_Aluno_Materias" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
        <h1>HISTORICO</h1>
        <p>

    <asp:Label ID="Label5" runat="server" BackColor="Silver" Font-Bold="True" 
        Font-Size="Medium" ForeColor="Black" Text="Disciplinas :"></asp:Label>
        </p>
        <p>
            <asp:ListBox ID="ListBox1" runat="server" AutoPostBack="True" 
                DataSourceID="SqlDataSource1" DataTextField="dis_cod" DataValueField="his_cod" 
                Width="179px"></asp:ListBox>
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
                ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" SelectCommand="select dis.dis_cod, dis.dis_nome, ma.his_cod 
from Asp_Disciplina dis, 
Asp_Leciona lec,
Asp_Matricula ma 
where 
ma.al_cod =@al_cod and 
lec.lec_cod = ma.lec_cod and
dis.dis_cod = lec.dis_cod">
                <SelectParameters>
                    <asp:SessionParameter Name="al_cod" SessionField="usu_cod" Type="String" />
                </SelectParameters>
            </asp:SqlDataSource>
        </p>
        <p>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" 
                DataSourceID="SqlDataSource2">
                <Columns>
                    <asp:BoundField DataField="his_nota" HeaderText="Nota" 
                        SortExpression="his_nota" />
                    <asp:BoundField DataField="his_frequencia" HeaderText="Frequencia" 
                        SortExpression="his_frequencia" />
                </Columns>
            </asp:GridView>
            <asp:SqlDataSource ID="SqlDataSource2" runat="server" 
                ConnectionString="<%$ ConnectionStrings:BD11248ConnectionString %>" 
                SelectCommand="SELECT [his_nota], [his_frequencia] FROM [Asp_Historico] WHERE ([his_cod] = @his_cod)">
                <SelectParameters>
                    <asp:ControlParameter ControlID="ListBox1" Name="his_cod" 
                        PropertyName="SelectedValue" Type="Int32" />
                </SelectParameters>
            </asp:SqlDataSource>
        </p>
</asp:Content>

