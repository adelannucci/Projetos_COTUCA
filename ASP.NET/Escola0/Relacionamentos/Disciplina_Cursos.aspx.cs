using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Relacionamentos_Disciplina_Cursos : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        for (int yyyy = 2000; yyyy <= 2030; yyyy++)
            ddlAno.Items.Add(Convert.ToString(yyyy));
    }

    public Boolean validaDisciplina()
    {
        string cur_cod = ddlCur.SelectedValue;
        string dis_cod = ddlDis.SelectedValue;
        string cur_ano = ddlAno.SelectedValue;
        SqlDataReader DR = Conexao.ExecutaQuery("select count(cur_cod) as qtd from ASP_Catalogo where cur_cod = " + cur_cod + " and dis_cod = '" + dis_cod + "' and cur_ano = '" + cur_ano + "'");
        DR.Read();
        if (Convert.ToInt32(DR["qtd"]) > 0)
            return false;
        else
            return true;
    }

    protected void btn_relacionar_Click(object sender, EventArgs e)
    {
        string cur_cod = ddlCur.SelectedValue;
        string dis_cod = "";
           
    
        for (int i = 0; i < ltDisc.Items.Count; i++) {
            dis_cod = ltDisc.Items[i].Value; 
            if (validaDisciplina())
                Conexao.ExecutaNaoQuery("Insert into ASP_Catalogo values('" + ddlAno.SelectedItem + "', '" + dis_cod + "', " + cur_cod + ")");
            else 
                MessageBox.Show("Disciplina ja Relacionada. Não inserida! "+dis_cod, "Relacionamento", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
        }
        MessageBox.Show("Relacionamento concluido", "Relacionamento", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
            
        //MessageBox.Show("Disciplina não Relacionada", "Relacionamento", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
            Response.Redirect("../ADM/Adm.aspx");
    }
    protected void ddlCur_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
    private bool findListItem(ListItem lt)
    {
        for (int i = 0; ltDisc.Items.Count > i; i++)
            if (lt.Value == ltDisc.Items[i].Value)
                return false;
        return true;
    }
    protected void btnAdd_Click(object sender, EventArgs e)
    {
        string nome;
        string cod;
        nome = Convert.ToString(ddlDis.SelectedItem);
        cod = Convert.ToString(ddlDis.SelectedValue);
        ListItem lt = new ListItem();
        lt.Value = cod;
        lt.Text = cod+" - " + nome;
        if(findListItem(lt))
        ltDisc.Items.Add(lt);
 
    }

    protected void ltDisc_SelectedIndexChanged(object sender, EventArgs e)
    {
        btnExc.Enabled = true;


    }
    protected void btnExc_Click(object sender, EventArgs e)
    {
        //ltDisc.Items.Remove();
        ltDisc.Items.Remove(ltDisc.SelectedItem);
        
        
    }
    protected void ddlAno_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
    protected void ddlDis_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}