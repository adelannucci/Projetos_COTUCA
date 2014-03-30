<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Adm.aspx.cs" Inherits="Adm" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" Runat="Server">
    <h1> Administrador </h1>
    <p> &nbsp;</p>
    <center>
        <asp:Menu ID="Menu1" runat="server" CssClass="menu" Orientation="Horizontal" 
            ForeColor="Lime">
            <Items>
                <asp:MenuItem Text="Cadastrar" Value="Cadastrar">
                    <asp:MenuItem Text="Administrador" Value="Administrador"></asp:MenuItem>
                    <asp:MenuItem NavigateUrl="~/Aluno/Cad_Aluno.aspx" Text="Aluno" Value="Aluno">
                    </asp:MenuItem>
                    <asp:MenuItem Text="Curso" Value="Curso" NavigateUrl="~/Cursos/Cad_Curso.aspx"></asp:MenuItem>
                    <asp:MenuItem Text="Disciplina" Value="Disciplina" 
                        NavigateUrl="~/Disciplina/Cad_Disciplina.aspx"></asp:MenuItem>
                    <asp:MenuItem Text="Professor" Value="Professor" 
                        NavigateUrl="~/Professor/Cad_Prof.aspx"></asp:MenuItem>
                </asp:MenuItem>
                <asp:MenuItem Text="Alterar" Value="Alterar">
                    <asp:MenuItem Text="Administrador" Value="Administrador"></asp:MenuItem>
                    <asp:MenuItem Text="Aluno" Value="Aluno" NavigateUrl="~/Aluno/Alter_Aluno.aspx"></asp:MenuItem>
                    <asp:MenuItem Text="Curso" Value="Curso" NavigateUrl="~/Cursos/Alt_Curso.aspx"></asp:MenuItem>
                    <asp:MenuItem Text="Disciplina" Value="Disciplina" 
                        NavigateUrl="~/Disciplina/Alter_Disciplina.aspx"></asp:MenuItem>
                    <asp:MenuItem Text="Professor" Value="Professor" 
                        NavigateUrl="~/Professor/Alter_Prof.aspx"></asp:MenuItem>
                </asp:MenuItem>
                <asp:MenuItem Text="Excluir" Value="Excluir">
                    <asp:MenuItem Text="Administrador" Value="Administrador"></asp:MenuItem>
                    <asp:MenuItem Text="Aluno" Value="Aluno" NavigateUrl="~/Aluno/exc_aluno.aspx"></asp:MenuItem>
                    <asp:MenuItem Text="Curso" Value="Curso" NavigateUrl="~/Cursos/Exc_Curso.aspx"></asp:MenuItem>
                    <asp:MenuItem Text="Disciplina" Value="Disciplina" 
                        NavigateUrl="~/Disciplina/Exc_Disciplina.aspx"></asp:MenuItem>
                    <asp:MenuItem Text="Professor" Value="Professor" 
                        NavigateUrl="~/Professor/Exc_Prof.aspx"></asp:MenuItem>
                </asp:MenuItem>
                <asp:MenuItem Text="Relacionamentos" Value="Relacionamentos">
                    <asp:MenuItem Text="Formar Grade" Value="Formar Grade">
                        <asp:MenuItem Text="Cadastrar Disciplinas e Cursos" 
                            Value="Disciplinas e Cursos" 
                            NavigateUrl="~/Relacionamentos/Disciplina_Cursos.aspx"></asp:MenuItem>
                        <asp:MenuItem Text="Excluir Disciplina de um Curso" 
                            Value="Excluir Disciplina de um Curso" 
                            NavigateUrl="~/Relacionamentos/Exc_Dis_Cur.aspx"></asp:MenuItem>
                    </asp:MenuItem>
                    <asp:MenuItem Text="Atribuição Didatica" Value="Atribuição Didatica">
                        <asp:MenuItem NavigateUrl="~/Relacionamentos/Disciplina_Professor.aspx" 
                            Text="Atribuir" Value="Atribuir"></asp:MenuItem>
                        <asp:MenuItem NavigateUrl="~/Relacionamentos/Exc_atribuicao.aspx" 
                            Text="Excluir" Value="Excluir"></asp:MenuItem>
                    </asp:MenuItem>
                </asp:MenuItem>
                <asp:MenuItem Text="Matricula" 
                    Value="Matricula">
                    <asp:MenuItem NavigateUrl="~/Aluno/Matricula.aspx" Text="Cadastrar" 
                        Value="Cadastrar"></asp:MenuItem>
                    <asp:MenuItem NavigateUrl="~/Aluno/VisualizaMatricula.aspx" Text="Alterar" 
                        Value="Alterar"></asp:MenuItem>
                </asp:MenuItem>
            </Items>
        </asp:Menu>
        <br />
    </center>
</asp:Content>

