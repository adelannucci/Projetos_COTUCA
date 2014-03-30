using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Alter_Prof : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        //if (Session["acesso"] == "1") { Messagebox.Show("Entrada Negada"); Response.Redirect("../Login.aspx"); }
    }




    protected void ddlid_SelectedIndexChanged(object sender, EventArgs e)
    {
        string id = ddlid.SelectedValue;
        SqlDataReader DR = Conexao.ExecutaQuery("SELECT prof_nome, prof_formacao FROM ASP_Professor where prof_cod = '" + id + "'");
        while (DR.Read())
        {
            nome.Text = Convert.ToString(DR["prof_nome"]);
            forma.Text = Convert.ToString(DR["prof_formacao"]);
        }

        DR = Conexao.ExecutaQuery("SELECT usu_end, usu_tel, usu_email FROM ASP_Usuario where usu_cod = '" + id + "'");
        while (DR.Read())
        {
            end.Text = Convert.ToString(DR["usu_end"]);
            tel.Text = Convert.ToString(DR["usu_tel"]);
            email.Text = Convert.ToString(DR["usu_email"]);
        }

    }

    public Boolean validaCampos()
    {
        Boolean b = true;
        if (tel.Text == "")
            b = false;
        if (nome.Text == "")
            b = false;
        if (end.Text == "")
            b = false;
        if (!email.Text.Contains("@") && !email.Text.Contains("."))
            b = false;
        if (forma.Text == "")
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
                Conexao.ExecutaNaoQuery("Update ASP_Professor set prof_nome = '" + nome.Text + "' , prof_formacao = '" + forma.Text + "' where prof_cod = '" + id + "'");
                Conexao.ExecutaNaoQuery("Update ASP_Usuario set usu_end = '" + end.Text + "' , usu_tel = '" + tel.Text + "' , usu_email = '" + email.Text + "' where usu_cod = '" + id + "'");

            }
        }
        else 
        { 
            MessageBox.Show("Preencha todos os campos corretamente", "", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1,MessageBoxOptions.DefaultDesktopOnly);
        }
    }
}