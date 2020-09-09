package be.grangier.poco;


import java.util.ArrayList;

public class Tournois {
	private String nom;
	private String tableautype[] = {"monsieur", "dames","doubleMonsieurs" , "doubleDames","doubleMixte" };
	private ArrayList<Ordonnancement> ao = new ArrayList<Ordonnancement>();
	
	
	public Tournois(String nom)
	{	
		this.nom = nom;
		
		for(int i = 0 ; i <getTableauChaine().length;i++)
		{
			
			if(getTableauChaine()[i].contains("monsieur")) // 12
    		{
				ao.add(new Ordonnancement(getTableauChaine()[i],3));
    		}
			else
			{
				ao.add(new Ordonnancement(getTableauChaine()[i],2));
			}
		}
	}
	
	public ArrayList<Ordonnancement> getAo() 
	{
		return ao;
	}
	

	
	public String getNom() 
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	public String[] getTableauChaine() 
	{
		return tableautype;
	}
	public void setTableauChaine(String[] tableautype) 
	{
		this.tableautype = tableautype;
	}
	
	
	public void startAllBrackets() 
	{
		for(Ordonnancement o : ao) 
		{
			o.startBracket();			
		}
	}
}

