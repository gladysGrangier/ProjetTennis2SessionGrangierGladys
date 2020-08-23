package be.grangier.poco;

public class Joueur extends Personne
{
	private int classement;
	
	public Joueur() {}
	
	public Joueur(int id, String nom, String sexe, int classement) 
	{
		super(id, nom, sexe);
		this.classement = classement;
	}
	
	
	public Joueur(String nom, String sexe, int classement)
	{
		super(nom, sexe);
		this.classement = classement;
	}
	
	
	public int getClassement() 
	{
		return classement;
	}
}