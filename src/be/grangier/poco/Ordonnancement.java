package be.grangier.poco;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import be.grangier.dao.ArbitreDAO;
import be.grangier.dao.CourtDAO;
import be.grangier.dao.DAO;
import be.grangier.dao.JoueurDAO;
import be.grangier.dao.ProjetConnection;



public class Ordonnancement {
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
		if(type == "doubleMessieurs" || type == "doubleMessieurs" )
		{
			date = LocalDateTime.of(2020, 5, 18, 8, 0).plusDays(10);
		}
		if(type == "doubleMixte")
		{
			date = LocalDateTime.of(2020, 5, 18, 8, 0).plusDays(20);
		}
		this.date=date;
		this.tab=tab;
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
	
}
