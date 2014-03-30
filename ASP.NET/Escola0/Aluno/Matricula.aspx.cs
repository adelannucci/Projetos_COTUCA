using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Aluno_Matricula : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        for (int yyyy = 2000; yyyy <= 2030; yyyy++)
            ddlAno.Items.Add(Convert.ToString(yyyy));
    }
    protected void ano_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
    protected void ListBox1_SelectedIndexChanged(object sender, EventArgs e)
    {

    }

    protected void btnAdd_Click(object sender, EventArgs e)
    {
        string lec_cod = Convert.ToString(ddlDisOfer.SelectedValue);
        string dis_cod = Convert.ToString(ddlDisOfer.SelectedItem.Text);
        ListItem lt = new ListItem();
        lt.Value = lec_cod;
        lt.Text = dis_cod;
        if (findListItem(lt))
            lbxDisSelected.Items.Add(lt);
    }

    private bool findListItem(ListItem lt)
    {
        for (int i = 0; lbxDisSelected.Items.Count > i; i++)
            if (lt.Value == lbxDisSelected.Items[i].Value || ( lt.Text.Equals(lbxDisSelected.Items[i].Text) ) )
                return false;
        return true;
    }

    public Boolean validaMatricula(string lec_cod)
    {
        SqlDataReader DR = Conexao.ExecutaQuery("select count(*) as qtd from Asp_Matricula where al_cod = '"+ddlAluno.SelectedValue+"' and lec_cod ="+lec_cod);
        DR.Read();
        if (Convert.ToInt32(DR["qtd"]) > 0)
            return false;
        else
            return true;
    }
    
    protected void btnExc_Click(object sender, EventArgs e)
    {
        lbxDisSelected.Items.Remove(lbxDisSelected.SelectedItem);
    }

    protected void btnMatricula_Click(object sender, EventArgs e)
    {
        int len = lbxDisSelected.Items.Count;
        string lec_cod = "";
        string his_cod = "";

        for (int i = 0; i < len; i++) { 
            lec_cod = lbxDisSelected.Items[i].Value;
            if (validaMatricula(lec_cod))
            {
                if (Conexao.ExecutaNaoQuery("insert into Asp_Historico values (null, null, null)") > 0)
                {
                    SqlDataReader DR = Conexao.ExecutaQuery("select top 1 * from Asp_Historico order by his_cod desc");
                    while (DR.Read())
                    {
                        his_cod = Convert.ToString(DR["his_cod"]);
                    }
                }
                Conexao.ExecutaNaoQuery("Insert into Asp_Matricula values('" + ddlAluno.SelectedValue + "'," + lec_cod + ", " + his_cod + ",'"+ddlAno.SelectedValue+"','"+rbSemestre.SelectedValue+"')");
            }
            else
                MessageBox.Show("Disciplina ja Relacionada. Não inserida! " + lbxDisSelected.Items[i].Text, "Relacionamento", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
        }
        MessageBox.Show("Matricula concluida", "Relacionamento", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
        
    }
    protected void ddlDisOfer_SelectedIndexChanged(object sender, EventArgs e)
    {
        string turma = Convert.ToString(ddlDisOfer.SelectedValue);

        SqlDataReader DR = Conexao.ExecutaQuery("select top 1 * from Asp_Historico order by his_cod desc");
        while (DR.Read())
        {
            turma = Convert.ToString(DR["his_cod"]);
        }
    }
}