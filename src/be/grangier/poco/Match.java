package be.grangier.poco;

import java.time.LocalDateTime;
import java.util.Random;

public class Match
{
	Equipe[] equipe = new Equipe[2];
	int[] resultatSets = new int[2];
	int[][] resultatJeux = new int[2][];
	int[][] resultatTieBreak = new int[2][];
	Court court;
	Arbitre arbitre;
	LocalDateTime date;
	int duree; // en seconde
	int tour;
	Random r = new Random();
	int nbrSetsGagnants;
	int numSet;
	
	
	public Match(LocalDateTime date, int tour, Court court,int nbrSetsGagnants, Arbitre arbitre, Equipe e1, Equipe e2) 
	{
		this.date = date;
		//this.duree=duree;
		this.tour = tour;
		this.court = court;
		this.nbrSetsGagnants = nbrSetsGagnants;
		this.arbitre = arbitre;
		equipe[0] = e1;
		equipe[1] = e2;
		resultatJeux[0] = new int[nbrSetsGagnants+2];
		resultatJeux[1] = new int[nbrSetsGagnants+2];
		resultatTieBreak[0] = new int[nbrSetsGagnants+1]; // +1 car pas de tie break l dernier set
		resultatTieBreak[1] = new int[nbrSetsGagnants+1];
		
	}
	
	
	public int[] getResultatSets() 
	{
		return resultatSets;
	}
	
	public int[][] getResultatJeux() 
	{
		return resultatJeux;
	}
	
	public int[][] getResultatTieBreaks()
	{
		return resultatTieBreak;
	}
	
	public int getDuree() 
	{
		return duree;
	}
	
	public LocalDateTime getDate()
	{
		return date;
	}
	
	public Court getCourt() 
	{
		return court;
	}
	
	public Equipe[] getEquipes()
	{
		return equipe;
	}
	
	public int getTour() 
	{
		return tour;
	}
	
	public Arbitre getArbitre()
	{
		return arbitre;
	}
	
	// attribution des points
	// true -> equipe1 marque, false -> equipe2 marque 

	
	private boolean playPoint() 
	{ 
		duree+=r.nextInt(90-15 +1)+15; // 10 à 50 sec par points
		if(r.nextInt(2)==0) return true; //  equipe 1 marque le point
		else return false; //  equipe 2 marque le point

	}
	
	
	private boolean playSet() 
	{
		
		//tant que joueur n'a pas 6
		
		while(resultatJeux[0][numSet]<6 && resultatJeux[1][numSet]<6)
		{
			if(playPoint()) 
				resultatJeux[0][numSet]++;
			else resultatJeux[1][numSet]++;
		}		
		
		//Verifier si 2 points d'écart --> oui --> fini 
		
		if(resultatJeux[0][numSet]-resultatJeux[1][numSet]>=2)
		{
			return true; // equipe 1
		} 
		else if(resultatJeux[0][numSet]-resultatJeux[1][numSet]<=-2) 
		{
			return false; // equipe 2	
		}
		
		//si pas 2 points (6/5) --> rejoueur 
		if (playPoint()) 
		{
			resultatJeux[0][numSet]++;
		}		
		else
		{
			resultatJeux[1][numSet]++;
		}
		
		
		//Verifier si 2 points d'écart --> oui --> fini
		if(resultatJeux[0][numSet]-resultatJeux[1][numSet]>=2)
		{
			return true; // equipe 1
		}
		else if(resultatJeux[0][numSet]-resultatJeux[1][numSet]<=-2)
		{
			return false; // equipe 2
		} 
		
		//score 6/6			
		// pas dernier set -> tie-break
		if(resultatSets[0]+resultatSets[1]<(nbrSetsGagnants*2)-2 )
		{
			if(playTieBreak()) 
			{
				resultatJeux[0][numSet]++;
				return true;
				
			}
			else 
			{
				resultatJeux[1][numSet]++;
				return false;
			}
		}
		
		//dernier set -> 2 jeux d'ecart
		else 
		{ 
			while(resultatJeux[0][numSet]-resultatJeux[1][numSet]<2 && resultatJeux[0][numSet]-resultatJeux[1][numSet]>-2) 
			{
				if(playPoint())
				{
					resultatJeux[0][numSet]++;
				}
				else
				{
					resultatJeux[1][numSet]++;
				}
			}
			
			if(resultatJeux[0][numSet]>resultatJeux[1][numSet]) 
			{
				return true; // equipe 1 gagne 
			}
			else 
			{
				return false;// equipe 2 gagne
			}	
		}	
	}
	
	
	private boolean playTieBreak() 
	{

		//tant que joueur n'a pas 7
		while(resultatTieBreak[0][numSet]<7 && resultatTieBreak[1][numSet]<7) 
		{
			if(playPoint())
			{
				resultatTieBreak[0][numSet]++;
			}
			else
			{
				resultatTieBreak[1][numSet]++;
			}
		}
		
		if(resultatTieBreak[0][numSet]-resultatTieBreak[1][numSet]>=2) 
		{
			return true; // equipe 1 gagne 
		}
		else if(resultatTieBreak[0][numSet]-resultatTieBreak[1][numSet]<=-2) 
		{
			return false; // equipe 2 gagne 
		}
		
		
		//verifier si 2 points d'écart
		else 
		{
			while(resultatTieBreak[0][numSet]-resultatTieBreak[1][numSet]<2 && resultatTieBreak[0][numSet]-resultatTieBreak[1][numSet]>-2) 
			{				
				if(playPoint())
				{
					resultatTieBreak[0][numSet]++;
				}
				else
				{
					resultatTieBreak[1][numSet]++;
				}
			}
			
			if(resultatTieBreak[0][numSet]>resultatTieBreak[1][numSet])
			{
				return true; // equipe 1 gagne
			}
			else
			{
				return false;// equipe 2 gagne 
			}	
		
		}
	}
	
	
	public void playMatch() 
	{
		while(resultatSets[0]<nbrSetsGagnants && resultatSets[1]<nbrSetsGagnants) 
		{
			if(playSet())
			{
				resultatSets[0]++;
			}	
			else 
			{
				resultatSets[1]++;
			}
			
			numSet++;
		}
		if (duree>13200) duree = 13200 ; // temps max par match : 3h40 -> 3 matchs/court par jour tt les 4 h j'usqu'en 1/8 eme de finale
	}
}
