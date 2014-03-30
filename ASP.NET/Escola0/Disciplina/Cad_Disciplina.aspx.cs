using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Disciplina_Cad_Disciplina : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    
    public Boolean validaCodigo(string cod) {
        SqlDataReader DR = Conexao.ExecutaQuery("select count(dis_cod) as qtd from ASP_Disciplina where dis_cod = '" + cod + "'");
        DR.Read();
        if (Convert.ToString(DR["qtd"]) == "1")
            return false;
        else
            return true;
         }

   
    public Boolean validaCampos() {
        Boolean b = true;
         if (cod.Text == "")
            b = false;
        if (nome.Text == "")
            b = false;
        if (emen.Text == "")
            b = false;
        

        return b;


    }
    protected void cadastrar_Click(object sender, EventArgs e)
    {
        if (validaCampos())
        {
            if (validaCodigo(cod.Text))
            {
                    Conexao.ExecutaNaoQuery("Insert into ASP_Disciplina values('" + cod.Text + "' , '" + emen.Text + "' , '" + nome.Text + "')");
                    MessageBox.Show("Disciplina Cadastrada com Sucesso", "Cadastrado", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
                    Response.Redirect("../ADM/Adm.aspx");



            }
            else { MessageBox.Show("Código já existe", "Resultado", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly); }
        }
        else { MessageBox.Show("Preencha todos os campos corretamente", "Erro", MessageBoxButtons.OK, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly); }
    }
}