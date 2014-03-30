using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Relacionamentos_Exc_atribuicao : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        for (int yyyy = 2000; yyyy <= 2030; yyyy++)
            ddlAno.Items.Add(Convert.ToString(yyyy));
    }
    protected void ano_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
    protected void ddlCur_SelectedIndexChanged(object sender, EventArgs e)
    {

    }

    public Boolean validaExcLec()
    {
        string lec_cod = "";
        SqlDataReader DR = Conexao.ExecutaQuery("select lec_cod from Asp_Leciona where lec_turma = '"+ddlTurma.SelectedValue+"' and lec_semestre ="+rbSemestre.SelectedValue+" and lec_ano = '"+ddlAno.SelectedValue+"'");
        while (DR.Read())
        {
            lec_cod = Convert.ToString(DR["lec_cod"]);
        }

        if (lec_cod != "")
        {
            DR = Conexao.ExecutaQuery("select count(*) as qtd from Asp_Matricula where lec_cod =" + lec_cod);
            DR.Read();
            if (Convert.ToInt32(DR["qtd"]) > 0)
                return false;
            else
                return true;
        }
        else
            return true;
    }

    protected void btnExc_Click(object sender, EventArgs e)
    {
        string cod = lbxDisc.SelectedValue;
        DialogResult result1 = MessageBox.Show("Deseja Excluir?", "Excluir", MessageBoxButtons.YesNo);
        if (Convert.ToString(result1) == "Yes")
        {
            if (validaExcLec())
            {
                Conexao.ExecutaNaoQuery("Delete from Asp_Leciona where lec_turma = '" + ddlTurma.SelectedValue + "' and lec_semestre = " + rbSemestre.SelectedValue + " and dis_cod = '" + cod + "' and lec_ano = '" + ddlAno.SelectedValue + "'");
                lbxDisc.DataBind();
                MessageBox.Show("Disciplina excluida", "Relacionamento", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
            }else
                MessageBox.Show("Disciplina não pode ser excluida", "Relacionamento", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);

        }

    }
}