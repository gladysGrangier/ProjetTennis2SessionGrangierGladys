package be.grangier.poco;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import be.grangier.dao.ArbitreDAO;
import be.grangier.dao.CourtDAO;
import be.grangier.dao.DAO;
import be.grangier.dao.JoueurDAO;
import be.grangier.dao.ProjetConnection;



public class Ordonnancement 
{
	private ArrayList<Joueur> aj;
	private ArrayList<Arbitre> aa;
	private ArrayList<Court> ac;
	private ArrayList<Equipe> ae = new ArrayList<Equipe>();
	private ArrayList<Match> am = new ArrayList<Match>();
	private String type;
	private int nbrSetsGagnants;
	private LocalDateTime date =LocalDateTime.of(2020, 5, 18, 8, 0);
	private Equipe tab [][];
	
	
	public Ordonnancement(String type, int nbrSetsGagnants)
	{
		this.type = type;
		this.nbrSetsGagnants = nbrSetsGagnants;
		loadListJoueurs();
		loadListArbitres();
		loadListCourts();
		creationEquipes();
		if(type == "doubleMonsieurs" || type == "doubleMessieurs" )
		{
			date = LocalDateTime.of(2020, 5, 18, 8, 0).plusDays(10);
		}
		if(type == "doubleMixte")
		{
			date = LocalDateTime.of(2020, 5, 18, 8, 0).plusDays(20);
		}
		//this.date=date;
		//this.tab=tab;
	}
	
	public ArrayList<Equipe> getAe() 
	{
		return ae;
	}
	
	public ArrayList<Joueur> getAj() 
	{
		return aj;
	}
	
	public ArrayList<Match> getAm()
	{
		return am;
	}
	
	private void loadListJoueurs()
	{
		DAO<Joueur> joueurDAO = new JoueurDAO(ProjetConnection.getInstance());
		aj = joueurDAO.getListObjects();		
	}
	
	private void loadListArbitres() 
	{
		DAO<Arbitre> arbitreDAO = new ArbitreDAO(ProjetConnection.getInstance());
		aa = arbitreDAO.getListObjects();
	}
	
	private void loadListCourts() 
	{
		DAO<Court> courtDAO = new CourtDAO(ProjetConnection.getInstance());
		ac = courtDAO.getListObjects();
	}
	
	public Equipe[][] getOrdonnancement() 
	{
		return tab;
	}
	
	public void setEquipe(Equipe[][] tab) 
	{
		this.tab = tab;
	}
	
	
	private void creationEquipes() 
	{
		Collections.shuffle(aj); // mélange aléatoire de la liste des joueurs
		ArrayList<Joueur> a = new ArrayList<Joueur>();
		int possition =0;
		//int conteur = 0;
		if(type == "monsieur" || type == "dames")
		{		
			tab = new Equipe[8][];
			tab[0]=new Equipe[128];
			if(type == "monsieur")
			{
				//aj= tous les joueurs
				//ajout tous les joueurs M
			for(Joueur j : aj) {
				if(j.getSexe().equals("m")) a.add(j);
				
			}
			//Ajout joueurs M dans arrayList equipe
			for(Joueur j : a) { 
				ae.add(new Equipe(j));	
			}
			
			//Position des joueurs avec les 128 places
			for(Equipe j : ae) { 
				tab[0][possition++] =j;					
			}
			}
			//tableau dame
			else
			{
				for(Joueur j : aj) {
					if(j.getSexe().equals("f")) a.add(j);
					//tab[0][possition++]=j.getId();
				}
				for(Joueur j : a) { // Attribution des équipes dans le tableau ae
					ae.add(new Equipe(j));
				}
				for(Equipe j : ae) { // Attribution des équipes dans le tableau ae
					tab[0][possition++] =j;				
				}
			}
				
		}
		//autre que match simples
		else
		{
			tab = new Equipe[7][];
			tab[0]=new Equipe[64];
			if(type == "doubleMonsieurs")
			{
				for(Joueur j : aj) {
					if(j.getSexe().equals("m"))a.add(j);
					//tab[0][possition++]=j.getId();
				}
				//creation des equipes par coéquipier
				for(int i=0, j=64; i<64; i++, j++) {
					ae.add(new Equipe(a.get(i),a.get(j)));
				}
				//equipe dans tableau
				for(Equipe j : ae) { 
					tab[0][possition++] =j;			
				}
				
			}
			if(type == "doubleDames" ) 
			{
				for(Joueur j : aj) {
					if(j.getSexe().equals("f"))a.add(j);
					//tab[0][possition++]=j.getId();
				}
				for(int i=0, j=64; i<64; i++, j++) {
					ae.add(new Equipe(a.get(i),a.get(j)));
				}
				for(Equipe j : ae) { // Attribution des équipes dans le tableau ae
					tab[0][possition++] =j;			
				}
			}
			if(type == "doubleMixte" )
			{
				ArrayList<Joueur> a2 = new ArrayList<Joueur>();
				List<Joueur> m;
				List<Joueur> f;
				for(Joueur j : aj) {
					if(j.getSexe().equals("m"))
						{
						a.add(j);
						}
					else
						{
						a2.add(j);
						}
					
					
				}
				m = a.subList(0, 64); // tronquage à 64 hommes
				f = a2.subList(0, 64); // tronquage à 64 femmes
				for(int i=0; i<m.size();i++) { // Attribution des équipes dans le tableau ae
					ae.add(new Equipe(m.get(i),f.get(i)));
				}
				for(Equipe j : ae) { // Attribution des équipes dans le tableau ae
					tab[0][possition++] =j;			
				}
			}
		}
		
			
	}
	

	public void startBracket() 
	{
		//ListIterator<Equipe> bracket = ae.listIterator(); // on supprime au fur et à mesure les joueurs du bracket 
		//int tour=1;
		int flag; // court et arbitre
		int compteur=0; // nbr matchs joués
		int limite;
		int condition;
		
		if(type == "dames"  || type == "doubleDames") 
		{
			//condition pour ne pas avoir le meme arbritre ni le meme terrain
			flag =8;
			condition =1;
			
		}
		else
		{
			flag=0;
			condition = 0;
		}
		//simple ou double --> gerer le premier [] tab
		limite = (tab[0].length>64)? 7:6; // nbr tours varie en fonction du nombre d'equipes !
		
		//int cont =0;
				int start = 0,solo ,position;
				//obliger car [0] est deja pris
				for (int i = 1; i <limite + 1; i++) 
				{
					//reprendre la taille precedente et diviser par 2
			    	tab[i] = new Equipe[(tab[i-1].length)/2];
			    	solo=0;
			    	//System.out.println(tab[i].length);
			    	for (int j = 0; j < tab[start].length; j++) 
			    	{
					//System.out.println("total" + cont++ + " jeux " +tab[start].length);
						am.add(new Match(date,i, ac.get(flag), nbrSetsGagnants,aa.get(flag++),tab[start][j],tab[start][++j]));
						am.get(compteur).playMatch(); // lancement du match
							if(am.get(compteur).getResultatSets()[0]>am.get(compteur++).getResultatSets()[1])
							{
								//oblige -1 car on prend 1 par un
								position = j-1;
								tab[i][solo]= tab[start][position];
					
							}
							else
							{
								tab[i][solo]= tab[start][j];
							}
							solo++;
					
							if(condition == 0 && flag==8 || condition == 1 && flag==16) 
							{ // qd 8 matchs ont été joués 
								if((compteur)%24!=0) 
								{
									date=date.plusHours(4); // 3 matchs par court par jour à 8, 12, 16h -> 24 matchs par jours avant les 8eme de finale
								}
								else
								{
									date=date.plusHours(16); //qd 3 matchs joues sur le meme court par jour on rejoue le lendemain à 8h
								}

								if(condition == 0) 
								{
									flag =0;
								}
								else
								{
									flag =8;
								}
							  }	
					
					/* 1/4 de finale
					 * ---------------------------*/
							else if((limite==6 && i == 4) || limite==7 && i ==5) 
							{ 
								//4 matchs/jour -> 2 matchs à 8h du mat sur les courts 1, 2 et 2 matchs à 16h sur les courts 3, et 4
								if(condition == 0 && flag==2 || condition == 1 && flag==10) 
								{
									date=date.plusHours(8);
								}
								else if(condition == 0 && flag==4 || condition == 1 && flag==12)
								{
									date=date.plusHours(16);
									
									if(condition == 0) 
									{
										flag =0;
									}
									else
									{
										flag =8;
									}
								}
							}
					
					/* 1/2 finale
					 * ---------------------------*/
					else if((limite==6 && i == 5) || limite==7 && i ==6)
					{ 
						// 2 matchs/jour -> 1 match à 8h du mat sur le court 1, et 1 autre à 16h sur le court 2
						date=date.plusHours(8);
						
						if(condition == 0 && flag==2 || condition == 1 && flag==10) 
						{
							date=date.plusHours(14); // finale le landemain à 14h sur court 1
							if(condition == 0) 
							{
								flag =0;
							}
							else
							{
								flag =8;
							}
						}
					}
				}
			    	
				start++;
			}				
	}
	
}
