using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Aluno_Alter_Aluno : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        //if (Session["acesso"] == "1") { MessageBox.Show("Entrada Negada"); Response.Redirect("../Login.aspx"); }
    }

    protected void ddlid_SelectedIndexChanged(object sender, EventArgs e)
    {
        string id = ddlid.SelectedValue;
        SqlDataReader DR = Conexao.ExecutaQuery("SELECT al_nome, al_ano_ingresso FROM ASP_Aluno where al_cod = '" + id + "'");
        while (DR.Read())
        {
            nome.Text = Convert.ToString(DR["al_nome"]);
            ano.Text = Convert.ToString(DR["al_ano_ingresso"]);
        }

        DR = Conexao.ExecutaQuery("SELECT usu_end, usu_tel, usu_email FROM ASP_Usuario where usu_cod = '" + id + "'");
        while (DR.Read())
        {
            end.Text = Convert.ToString(DR["usu_end"]);
            tel.Text = Convert.ToString(DR["usu_tel"]);
            email.Text = Convert.ToString(DR["usu_email"]);
        }

    }
       public Boolean validaCampos() {
        Boolean b = true;
        int x;
	if (tel.Text == "")
	    b = false;
        if (nome.Text == "")
            b = false;
        if (end.Text == "")
            b = false;
        if (!email.Text.Contains("@") && !email.Text.Contains("."))
            b = false;
        if (ano.Text == "")
            b = false;
        if (ano.Text.Length == 4)
            if (!int.TryParse(ano.Text, out x))
                b = false;

        return b;


    }
     
    protected void Button1_Click(object sender, EventArgs e)
    {
        if (validaCampos())
        {
            string id = ddlid.SelectedValue;
            DialogResult result1 = MessageBox.Show("Deseja Alterar?", "Alterar", MessageBoxButtons.YesNo, MessageBoxIcon.Question, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
            if (Convert.ToString(result1) == "Yes")
            {
                Conexao.ExecutaNaoQuery("Update ASP_Aluno set al_nome = '" + nome.Text + "' , al_ano_ingresso = '" + ano.Text + "' where al_cod = '" + id + "'");
                Conexao.ExecutaNaoQuery("Update ASP_Usuario set usu_end = '" + end.Text + "' , usu_tel = '" + tel.Text + "' , usu_email = '" + email.Text + "' where usu_cod = '" + id + "'");
                MessageBox.Show("Alterado Com Sucesso", "", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
                Response.Redirect("../ADM/Adm.aspx");

            }
        }
        else 
            MessageBox.Show("Preencha todos os campos corretamente", "", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
    }
}