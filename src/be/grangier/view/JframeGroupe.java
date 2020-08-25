package be.grangier.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import be.grangier.poco.Equipe;
import be.grangier.poco.Match;

import javax.swing.SwingConstants;

public class JframeGroupe extends JFrame 
{
	
	private static final long serialVersionUID = 1L;
	
	
	private ArrayList<List<Match>> aTours= new ArrayList<List<Match>>();
	private ArrayList<JLabel> aJLabel = new ArrayList<JLabel>();
	private int compteur=0;
	private JPanel contentPane;
	private int w=80;
	private int h=25;
	private int i=0;
	

	public JframeGroupe(List<Match> tour1, List<Match> tour2, List<Match> tour3, List<Match> tour4, List<Match> tour5)
	{ 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 1600, 980);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
	
		aTours.add(tour1);
		aTours.add(tour2);
		aTours.add(tour3);
		aTours.add(tour4);
		aTours.add(tour5);
			
		drawTour(aTours.get(0), 10, 30, 5);
		drawTour(aTours.get(1), 310, 57, 60);
		drawTour(aTours.get(2), 610, 120, 170);
		drawTour(aTours.get(3), 910, 222, 395);
		drawTour(aTours.get(4), 1210, 435, 0);
	}
	
	
	public JframeGroupe(List<Match> finale) 
	{	 // finale si double
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 450, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
	
		aTours.add(finale);
		drawTour(aTours.get(0), 150, 50, 5);
	}

	
	private void drawTour(List<Match> lm, int x, int y, int intervale)
	{	
		for(Match m :lm) 
		{			
			for(Equipe e : m.getEquipes())
			{
				if(e.getA().size()==1) 
				{
					aJLabel.add(new JLabel(e.getA().get(0).getNom(),SwingConstants.CENTER));
					aJLabel.get(compteur++).setBounds(x, y, w, h);
					aJLabel.add(new JLabel(m.getResultatSets()[i++]+"", SwingConstants.CENTER));
					aJLabel.get(compteur--).setBounds(x+w, y, 20, h);
					
				}
				else 
				{
					aJLabel.add(new JLabel(e.getA().get(0).getNom() + " / " + e.getA().get(1).getNom(), SwingConstants.CENTER));
					aJLabel.get(compteur++).setBounds(x, y, w+80, h);
					aJLabel.add(new JLabel(m.getResultatSets()[i++]+"", SwingConstants.CENTER));
					aJLabel.get(compteur--).setBounds(x+w+80, y, 20, h);
				}
				aJLabel.get(compteur).setBorder(new LineBorder(new Color(0, 0, 0)));
				aJLabel.get(compteur).setOpaque(true);
				aJLabel.get(compteur).setBackground(Color.WHITE);
				aJLabel.get(compteur).addMouseListener(new LabelAdapter(m, x, y, i, 1));
				compteur++;
				aJLabel.get(compteur).setBorder(new LineBorder(new Color(0, 0, 0)));
				aJLabel.get(compteur).setOpaque(true);
				aJLabel.get(compteur).setBackground(Color.DARK_GRAY);
				aJLabel.get(compteur).setForeground(Color.WHITE);
				aJLabel.get(compteur).addMouseListener(new LabelAdapter(m, x, y, i, 2));
				compteur--;
				contentPane.add(aJLabel.get(compteur++));
				contentPane.add(aJLabel.get(compteur++));
				y+=25;	
			}	
			
			y+=intervale;
			i=0;
		}
	}
	
	
	private class LabelAdapter extends MouseAdapter 
	{
		Match m;
		int x;
		int y;
		int i;
		int etiquette;
		
		public LabelAdapter(Match m, int x, int y, int i, int etiquette)
		{
			super();
			this.m = m;
			this.x = x;
			this.y = y;
			this.i = i;
			this.etiquette=etiquette;
		}
		
		public final void mouseEntered(MouseEvent ev) 
		{
			if(etiquette ==1) 
			{
				ev.getComponent().setBackground(Color.ORANGE);
			}
			else 
			{
				ev.getComponent().setForeground(Color.ORANGE);
			}			
		}
		
		
		public final void mouseExited(MouseEvent ev)
		{
			if(etiquette ==1) 
			{
				ev.getComponent().setBackground(Color.WHITE);
			}
			else
			{
				ev.getComponent().setForeground(Color.WHITE);
			}
		}
		
		
		public final void mouseClicked(MouseEvent ev) 
		{
			JframeInfoMatch jframeInfoMatch = new JframeInfoMatch(m);
			
		}
	}
}

