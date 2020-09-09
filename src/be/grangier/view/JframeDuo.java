package be.grangier.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.grangier.poco.Tournois;

public class JframeDuo extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public JframeDuo(JframeStart framestart,Tournois t) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);		
		JframeDuo thisframe = this;
		
		JButton btn_matchDuoHomme = new JButton("Homme");
		JButton btn_matchDuoFemme = new JButton("Femme");
		JButton btn_matchDuoMix = new JButton("Mixte");
		
		btn_matchDuoHomme.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent arg0) 
			{
				JframeBracketDuo frame = new JframeBracketDuo(thisframe, t.getAo().get(2)); // envoi de l'objet acceuil et de l'ordennencement des messieurs
				thisframe.setVisible(false);
				}
			});
		
		
		btn_matchDuoFemme.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent arg0)
			{
				JframeBracketDuo frame = new JframeBracketDuo(thisframe, t.getAo().get(3)); 
				thisframe.setVisible(false);
				}
			});
		
		btn_matchDuoMix.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent arg0)
			{
				JframeBracketDuo frame = new JframeBracketDuo(thisframe, t.getAo().get(4)); 
				thisframe.setVisible(false);
				}
			});
		

		
		btn_matchDuoHomme.setBounds(26, 36, 172, 37);
		btn_matchDuoFemme.setBounds(226, 36, 172, 37);
		btn_matchDuoMix.setBounds(129, 99, 172, 37);
		
		btn_matchDuoHomme.setVisible(true);
		btn_matchDuoFemme.setVisible(true);
		btn_matchDuoMix.setVisible(true);
				
		contentPane.add(btn_matchDuoHomme);
		contentPane.add(btn_matchDuoFemme);
		contentPane.add(btn_matchDuoMix);
		
		
		JButton btn_retourAcceuil = new JButton("Accueil");
		btn_retourAcceuil.setBounds(10, 225, 110, 25);
		
		btn_retourAcceuil.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				framestart.setVisible(true);
				thisframe.dispose();			
			}
		});

		contentPane.add(btn_retourAcceuil);
	}	

	}
