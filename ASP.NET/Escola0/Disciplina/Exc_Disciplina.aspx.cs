﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class Disciplina_Exc_Disciplina : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void excluir_Click(object sender, EventArgs e)
    {
        string id = ddlid.SelectedValue;
        DialogResult result1 = MessageBox.Show("Deseja Excluir?", "Excluir", MessageBoxButtons.YesNo);
        if (Convert.ToString(result1) == "Yes")
        {
            if (Conexao.ExecutaNaoQuery("Delete from ASP_Disciplina where dis_nome = '" + id + "'") > 0)
            {

                MessageBox.Show("Excluido com Sucesso ", "Excluido", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly);
                Response.Redirect("../ADM/Adm.aspx");
            }
        }
    }
}