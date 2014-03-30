using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Aluno_VisualizaMatricula : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        for (int yyyy = 2000; yyyy <= 2030; yyyy++)
            ddlAno.Items.Add(Convert.ToString(yyyy));
    }
    protected void ano_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
    protected void btnAlterar_Click(object sender, EventArgs e)
    {
        if (Conexao.ExecutaNaoQuery("delete from Asp_Matricula where al_cod = '"+ddlAluno.SelectedValue+"' and mat_ano ='"+ddlAno.SelectedValue+"' and mat_semestre ="+rbSemestre.SelectedValue) > 0)
        {
            Response.Redirect("Matricula.aspx");
        }
    }
}