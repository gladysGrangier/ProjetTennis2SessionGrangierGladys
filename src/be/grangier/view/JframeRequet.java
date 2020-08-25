package be.grangier.view;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class JframeRequet {

		public void JframeRequet(List liste)
		{
			try 
			{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			}
			catch(ClassNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, "Class de tennis introuvable " +e.getMessage());
			}
			
			Connection connec = null;
			Statement stmt = null;
			ResultSet res=null;
			
			try
			{
				connec = DriverManager.getConnection("jdbc:ucanaccess://./TennisBD.accdb");
				String requete = "SELECT * From Personne a inner join Joueur b on a.ID=b.ID where sexe like 'm'";
				stmt = connec.createStatement();
				res = stmt.executeQuery(requete);
			
				String nom;
				while(res.next())
				{
					nom = res.getString(1);
					liste.add(nom);
				}
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null,"Erreur JDBC :  " +e.getMessage());
			}
			finally
			{
				try
				{
					if(res !=null)
					{
						res.close();
					}
					if(res !=null)
					{
						stmt.close();
					}
					if(res !=null)
					{
						connec.close();
					}
				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}
			}
			
			}
	
	}

