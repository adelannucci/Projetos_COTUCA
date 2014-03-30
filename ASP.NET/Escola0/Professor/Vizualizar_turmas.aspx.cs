using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Professor_Vizualizar_turmas : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        SqlDataReader DR = Conexao.ExecutaQuery("select prof_cod from Asp_Professor where usu_cod = '" + Session["usu_cod"] + "'");
        if ((DR != null) && (DR.Read())) {
            Session["prof_cod"] = DR["prof_cod"].ToString();
        
        }
    }

    protected void Button1_Click(object sender, EventArgs e)
    {
        Response.Redirect("Professor.aspx");
    }

    protected void ListBox1_SelectedIndexChanged(object sender, EventArgs e)
    {
        ListItem lt = ListBox1.SelectedItem;
        String lec_cod = DropDownList1.SelectedValue;
        String al_cod = lt.Value;
        String his_cod = "";

        SqlDataReader DR = Conexao.ExecutaQuery("SELECT his_cod from Asp_Matricula where lec_cod = " + lec_cod + " and al_cod = '" + al_cod + "'");
        while (DR.Read())
        {
            his_cod = Convert.ToString(DR["his_cod"]);
        }
        DR = Conexao.ExecutaQuery("select * from Asp_Historico where his_cod = " + his_cod);

        while (DR.Read())
        {
            txNome.Text = Convert.ToString(DR["his_nota"]);
            txFre.Text = Convert.ToString(DR["his_frequencia"]);
        }
    }

    protected void btnAtualizarNota_Click1(object sender, EventArgs e)
    {
        ListItem lt = ListBox1.SelectedItem;
        String lec_cod = DropDownList1.SelectedValue;
        String al_cod = lt.Value;
        String his_cod = "";
        //txNome.Text = lec_cod;
        //txFre.Text = al_cod;
         SqlDataReader DR = Conexao.ExecutaQuery("SELECT his_cod from Asp_Matricula where lec_cod = "+lec_cod+" and al_cod = '"+al_cod+"'");
          while (DR.Read()){
          his_cod = Convert.ToString(DR["his_cod"]);
          }
          Conexao.ExecutaNaoQuery("Update Asp_Historico set his_frequencia = " + txFre.Text + " , his_nota = " + txNome.Text + " where his_cod = " + his_cod);

    }
}