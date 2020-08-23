package be.grangier.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.grangier.poco.Personne;

public class PersonneDAO extends DAO<Personne>
{
	public PersonneDAO(Connection connect) 
	{
		super(connect);		
	}
	

	public boolean create(Personne obj) 
	{
		
		return false;
	}
	
	public boolean delete(Personne obj)
	{
		return false;
	}
	
	public boolean update(Personne obj) 
	{
		return false;
	}
	
	
	public Personne find(int id) 
	{
		Personne Personne = new Personne();
		try
		{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Personne WHERE id = " + id);
					if(result.first())
					{
						Personne = new Personne(id, result.getString("nom"),result.getString("sexe"));

					}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return Personne;
	}
	
	
	public ArrayList<Personne> getListObjects()
	{
		ArrayList<Personne> a = new ArrayList<Personne>();
		return a;
	}
}

