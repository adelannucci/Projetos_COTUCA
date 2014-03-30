using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Exc_Prof : System.Web.UI.Page
{

    protected void Page_Load(object sender, EventArgs e)
    {

    }


    protected void excluir_Click(object sender, EventArgs e)
    {
        string id = ddlid.SelectedValue;
        DialogResult result1 = MessageBox.Show("Deseja Excluir?", "Excluir", MessageBoxButtons.YesNo);
        if (Convert.ToString(result1)=="Yes")
        {
            if (Conexao.ExecutaNaoQuery("Delete from ASP_Professor where prof_cod = '" + id + "'") > 0)
            {
                Conexao.ExecutaNaoQuery("Delete from ASP_Usuario where usu_cod = '" + id + "'");
                MessageBox.Show("Excluido Com Sucesso", "", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
                Response.Redirect("../ADM/Adm.aspx");
            }
        }
        
    }
}