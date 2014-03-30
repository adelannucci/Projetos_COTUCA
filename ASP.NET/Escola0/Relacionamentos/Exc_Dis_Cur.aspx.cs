using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Relacionamentos_Exc_Dis_Cur : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        for (int yyyy = 2000; yyyy <= 2030; yyyy++)
            ddlAno.Items.Add(Convert.ToString(yyyy));
    }
    protected void ano_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
    protected void ddlCur_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
    protected void btnExc_Click(object sender, EventArgs e)
    {
        string cod = lbxDisc.SelectedValue;
        DialogResult result1 = MessageBox.Show("Deseja Excluir?", "Excluir", MessageBoxButtons.YesNo);
        if (Convert.ToString(result1) == "Yes")
        {
            Conexao.ExecutaNaoQuery("Delete from Asp_Catalogo where cur_cod = " + ddlCur.SelectedValue + " and dis_cod = '" + cod + "' and cur_ano = '" + ddlAno.SelectedValue + "'");
            lbxDisc.DataBind();

        }
    }
}