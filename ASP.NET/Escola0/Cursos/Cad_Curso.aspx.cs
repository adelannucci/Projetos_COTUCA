using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Cursos_cad_curso : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
    }

    public Boolean validaCodigo(string cod)
    {
        SqlDataReader DR = Conexao.ExecutaQuery("select count(cur_cod) as qtd from ASP_Curso where cur_cod =" + cod);
        DR.Read();
        if (Convert.ToString(DR["qtd"]) == "1")
            return false;
        else
            return true;
    }

    public Boolean validaCampos()
    {
        Boolean b = true;
        int x;
        if (codigo.Text == ""){
            if (!int.TryParse(codigo.Text, out x))
                b = false;
        }
        if (nome.Text == "")
            b = false;
        return b;


    }

    protected void btnCadastrar_Click(object sender, EventArgs e)
    {
        if (validaCampos())
        {
            if (validaCodigo(codigo.Text))
            {
                string cmd = "Insert into ASP_Curso values(" + codigo.Text + " ,'" + nome.Text + "' , " + Periodo.SelectedIndex + ")";
                if (Conexao.ExecutaNaoQuery(cmd) > 0) 
                { 
                    MessageBox.Show("Cadastrado com Sucesso ", "", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
                    Response.Redirect("../ADM/Adm.aspx");
                }  
            }
            else {  MessageBox.Show("Código de Curso ja existente", "", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly); }
        }
        else { MessageBox.Show("Preencha todos os campos corretamente", "", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly); }

    }
    protected void ano_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}