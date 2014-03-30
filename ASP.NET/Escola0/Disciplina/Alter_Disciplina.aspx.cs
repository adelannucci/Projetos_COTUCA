using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Disciplina_Alter_Disciplina : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void ddlid_SelectedIndexChanged(object sender, EventArgs e)
    {
        string nom = ddlid.SelectedValue;
        SqlDataReader DR = Conexao.ExecutaQuery("SELECT dis_nome, dis_ementa FROM ASP_Disciplina where dis_nome = '" + nom + "'");
        while (DR.Read())
        {
            nome.Text = Convert.ToString(DR["dis_nome"]);
            emen.Text = Convert.ToString(DR["dis_ementa"]);
        }
    }
    public Boolean validaCampos()
    {
        Boolean b = true;
        
        if (nome.Text == "")
            b = false;
        if (emen.Text == "")
            b = false;


        return b;


    }
    protected void altera_Click(object sender, EventArgs e)
    {
        if (validaCampos())
        {
            string id = ddlid.SelectedValue;
            DialogResult result1 = MessageBox.Show("Deseja Alterar?", "Alterar", MessageBoxButtons.YesNo, MessageBoxIcon.Question, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
            if (Convert.ToString(result1) == "Yes")
            {
                Conexao.ExecutaNaoQuery("Update ASP_Disciplina set dis_nome = '" + nome.Text + "' , dis_ementa = '" + emen.Text + "' where dis_nome = '" + id + "'");
                MessageBox.Show("Alterado Com Sucesso", "Alterado", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
                Response.Redirect("../ADM/Adm.aspx");
            }
        }
        else
            MessageBox.Show("Preencha todos os campos corretamente", "", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
    }
}