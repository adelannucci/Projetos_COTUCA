using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Cursos_Alt_Curso : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
    }

    public Boolean validaCampos()
    {
        Boolean b = true;
        if (nome.Text == "")
            b = false;
        return b;
    }

    protected void Button1_Click(object sender, EventArgs e)
    {
        if (validaCampos())
        {
            string id = ddlid.SelectedValue;
            DialogResult result1 = MessageBox.Show("Deseja Excluir?", "Excluir", MessageBoxButtons.YesNo, MessageBoxIcon.Question, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
            if (Convert.ToString(result1) == "Yes")
            {
                Conexao.ExecutaNaoQuery("Update ASP_Curso set cur_nome = '" + nome.Text + "' , cur_periodo = " + Periodo.SelectedIndex + " where cur_cod = '" + id + "'");
                MessageBox.Show("Alterado Com Sucesso", "", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
                Response.Redirect("../ADM/Adm.aspx");
            }
        }
        else MessageBox.Show("Preencha todos os campos corretamente", "", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
    }

    protected void ddlid_SelectedIndexChanged(object sender, EventArgs e)
    {
        String a;
        int p;
        string id = ddlid.SelectedValue;
        SqlDataReader DR = Conexao.ExecutaQuery("SELECT * FROM ASP_Curso where cur_cod = '" + id + "'");
        while (DR.Read())
        {
            nome.Text = Convert.ToString(DR["cur_nome"]);
            p = Convert.ToInt32(DR["cur_periodo"]);
            Periodo.SelectedIndex = p;
        }

    }
}