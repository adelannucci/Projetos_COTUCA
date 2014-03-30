using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Default3 : System.Web.UI.Page
{
    

    
    protected void Page_Load(object sender, EventArgs e)
    {
        //if (Session["acesso"] == "1") { Messagebox.Show("Entrada Negada"); Response.Redirect("../Login.aspx"); }
    }


	public Boolean validaMatricula(string cod) {
        SqlDataReader DR = Conexao.ExecutaQuery("select count(prof_cod) as qtd from ASP_Professor where prof_cod = '" + cod + "'");
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

    public Boolean validaCampos() {
        Boolean b = true;
        if (matricula.Text == "")
            b = false;
        if (nome.Text == "")
            b = false;
        if (!email.Text.Contains("@") && !email.Text.Contains("."))
            b = false;
        if (end.Text == "")
            b = false;
        if (forma.Text == "")
            b = false;
        if (tel.Text == "")
            b = false;
        if (log.Text == "")
            b = false;
        if (senha.Text == "")
            b = false;
        return b;


    }





    protected void Button1_Click(object sender, EventArgs e)
    {
        if (validaMatricula(matricula.Text))
        {
            if (validaLogin(log.Text))
            {
                if (validaCampos())
                {
                    if (Conexao.ExecutaNaoQuery("Insert into ASP_Usuario values('" + matricula.Text + "' , '" + end.Text + "' , '" + tel.Text + "' , '" + email.Text + "' , '" + log.Text + "', '" + senha.Text + "'  , 2)") > 0)
                    {
                        Conexao.ExecutaNaoQuery("Insert into ASP_Professor values('" + matricula.Text + "' , '" + nome.Text + "' , '" + forma.Text + "', '" + matricula.Text + "')");
                        MessageBox.Show("Professor cadastrado com sucesso?", "Cadastrar", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
                        Response.Redirect("../ADM/Adm.aspx");
                    }
                }
                else
                { MessageBox.Show("Preencha todos os campos corretamente", "", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly); }
            }
            else { MessageBox.Show("Login já existe", "", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);}
        }
        else { MessageBox.Show("Matricula já Existe", "", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly); }

    }
}