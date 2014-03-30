using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Adm : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void CadProf_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Professor/Cad_Prof.aspx");
    }
    protected void ExcProf_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Professor/Exc_Prof.aspx");
    }
    protected void AltProf_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Professor/Alter_Prof.aspx");
    }
    protected void CadAlu_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Aluno/Cad_Aluno.aspx");
    }
    protected void AltAluno_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Aluno/Alter_Aluno.aspx");
    }
    protected void ExcAluno_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Aluno/exc_aluno.aspx");
    }
    protected void btdCadCurso_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Cursos/Cad_Curso.aspx");
    }
    protected void btnAltCur_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Cursos/Alt_Curso.aspx");
    }
    protected void btnExcCur_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Cursos/Exc_Curso.aspx");
    }
    protected void cad_dis_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Disciplina/Cad_Disciplina.aspx");
    }
    protected void alter_dis_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Disciplina/Alter_Disciplina.aspx");
    }
    protected void exc_dis_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Disciplina/Exc_Disciplina.aspx");
    }

}