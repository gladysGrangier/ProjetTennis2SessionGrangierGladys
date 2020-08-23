package be.grangier.poco;

public class Court 
{
	private int id;
	private String nomCourt;
	
	public Court() {}
	
	
	public Court(int id, String nomCourt)
	{
		this.id = id;
		this.nomCourt = nomCourt;
	}
	
	
	public int getId() 
	{
		return id;
	}
	
	
	public String getNomCourt() 
	{
		return nomCourt;
	}
}