using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Aluno_Cad_Aluno : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        //if (Session["acesso"] == "1") { MessageBox.Show("Entrada Negada"); Response.Redirect("../Login.aspx"); }
    }

    public Boolean validaMatricula(string cod)
    {
        SqlDataReader DR = Conexao.ExecutaQuery("select count(al_cod) as qtd from ASP_Aluno where al_cod = '" + cod + "'");
        DR.Read();
        if (Convert.ToString(DR["qtd"]) == "1")
            return false;
        else
            return true;
    }

    public Boolean validaLogin(string cod)
    {
        SqlDataReader DR = Conexao.ExecutaQuery("select count(usu_cod) as qtd from ASP_Usuario where usu_login = '" + cod + "'");
        DR.Read();
        if (Convert.ToInt32(DR["qtd"]) > 0)
            return false;
        else
            return true;
    }

    public Boolean validaCampos()
    {
        Boolean b = true;
        int x;
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

    protected void btnCadastrar_Click(object sender, EventArgs e)
    {
        if (validaCampos())
        {
            if (validaMatricula(matricula.Text))
            {
                if (validaLogin(log.Text))
                {
                    if (Conexao.ExecutaNaoQuery("Insert into ASP_Usuario values('" + matricula.Text + "' , '" + end.Text + "' , '" + tel.Text + "' , '" + email.Text + "' , '" + log.Text + "', '" + senha.Text + "'  , 1)") > 0)
                    {
                        Conexao.ExecutaNaoQuery("Insert into ASP_Aluno values('" + matricula.Text + "' , '" + ano.Text + "' , '" + nome.Text + "', '" + matricula.Text + "', "+ddlCurso.SelectedValue+")");
                        MessageBox.Show("Aluno Cadastrado com Sucesso", "", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
                        Response.Redirect("../ADM/Adm.aspx");
                    }
                }
                else { MessageBox.Show("Login já existe", "Resultado", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly); }
            }
            else { MessageBox.Show("Matricula já existe", "Resultado", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly); }
        }
        else { MessageBox.Show("Preencha todos os campos corretamente", "", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);  }

    }
    protected void ddlCurso_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}