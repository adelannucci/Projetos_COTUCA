using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.SqlClient;


public class Conexao
{
    public static bool Abre (SqlConnection con)
    {
        try
        {
            //casa
            //con.ConnectionString = "Data Source=ADELANNUCCI-PC\\ADELANNUCCI;Initial Catalog=regulus;Persist Security Info=True;User ID=bd11248;Password=BD11248";
            //escola
            con.ConnectionString = ("Data Source=REGULUS;Initial Catalog=BD11248;User ID=bd11248;Password=BD11248");
            con.Open();
        }
        catch (Exception Ex) { return false; }
        return true;
    }

    public static SqlDataReader ExecutaQuery(String Query)
    {
        SqlConnection con = new SqlConnection();
        if (Abre(con))
        {
            SqlCommand cmd = new SqlCommand(Query, con);
            return cmd.ExecuteReader();
        }
        return null;
    }

    public static int ExecutaNaoQuery(String cm)
	{
		SqlConnection con = new SqlConnection();
		if (Abre(con)) 
		{
			SqlCommand cmd = new SqlCommand(cm, con);
            return cmd.ExecuteNonQuery();
		}
		return (0);
	}

}