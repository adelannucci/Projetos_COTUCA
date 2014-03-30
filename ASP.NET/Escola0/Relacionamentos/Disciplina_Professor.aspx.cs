using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Relacionamentos_Disciplina_Professor : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        for (int yyyy = 2000; yyyy <= 2030; yyyy++)
            ddlAno.Items.Add(Convert.ToString(yyyy));
    }

    protected void ano_SelectedIndexChanged(object sender, EventArgs e)
    {

    }

    public Boolean validaAtribuicao()
    {

        SqlDataReader DR = Conexao.ExecutaQuery("select count(*) as qtd from asp_leciona where lec_periodo = "+ddlPer.SelectedIndex+" and lec_semestre = "+rbSemestre.SelectedValue+" and lec_ano = '"+ddlAno.SelectedItem+"' and lec_turma = '"+ddlTurma.SelectedValue+"' and dis_cod = '"+ddlDis.SelectedValue+"'");
        DR.Read();
        if (Convert.ToInt32(DR["qtd"]) > 0)
            return false;
        else
            return true;
    }

    protected void btnAtribuir_Click(object sender, EventArgs e)
    {
        if(validaAtribuicao()){
            Conexao.ExecutaNaoQuery("Insert into ASP_Leciona values(" + ddlPer.SelectedIndex + " , " + rbSemestre.SelectedValue + ", '" + ddlAno.SelectedItem + "', '" + ddlTurma.SelectedValue + "', '" + ddlDis.SelectedValue + "', '" + ddlProf.SelectedValue + "')");
            MessageBox.Show("Atribuicao Concluida", "Cadastrado", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
        }else{
            MessageBox.Show("Atribuicao Não Concluida", "Não Cadastrado", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);  
        }
        Response.Redirect("../ADM/Adm.aspx");
    }
}