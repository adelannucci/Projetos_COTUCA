using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

public partial class teste : System.Web.UI.Page
{
    public class Conexão
    {
        public SqlConnection Conexao;
        public SqlCommand Comando;
        public SqlDataReader DR;

        public Conexão()
        {
            Conexao = new SqlConnection();
            Comando = new SqlCommand();
        }
        public void Open()
        {
            try
            {
                Conexao.ConnectionString = ("Data Source=REGULUS;Initial Catalog=BD11248;User ID=bd11248;Password=BD11248");
                Comando.Connection = Conexao;
                Conexao.Open();
            }
            catch (Exception Ex) { throw Ex; }
        }

    }
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Login1_Authenticate(object sender, AuthenticateEventArgs e)
    {
        
            if ((Login1.UserName == "" ) || (Login1.Password == ""))
            {
                Login1.FailureText = "Usuario ou Senha não informada";
            }

            Conexão minhaConexao = new Conexão();
            minhaConexao.Open();
            string comando;
            comando = "Select usu_cod, usu_tipo from ASP_Usuario where usu_login ='" + Login1.UserName + "' and usu_senha='" + Login1.Password + "'";
            SqlCommand comSQLSelect = new SqlCommand(comando, minhaConexao.Conexao);

            minhaConexao.DR = comSQLSelect.ExecuteReader();
                        
            if (minhaConexao.DR.Read())
            {
                int x = (int) minhaConexao.DR["usu_tipo"];
                Session["usu_cod"] = minhaConexao.DR["usu_cod"].ToString();
                switch (x) {
                    case 3: 
                        Session["acesso"] = "3";
                        Response.Redirect("ADM/Adm.aspx");
                        break;
                    case 2:
                        Session["acesso"] = "2";
                        Response.Redirect("Professor/Professor.aspx");
                        break;
                    case 1:
                        Session["acesso"] = "1";
                        Response.Redirect("Aluno/Aluno.aspx");
                        break;
                }
                minhaConexao.DR.Close();
            }
            

    }
}