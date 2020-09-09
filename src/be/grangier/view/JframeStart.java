package be.grangier.view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.grangier.poco.Tournois;

public class JframeStart extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Tournois t;
	
	 //Launch the application.
	 
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					JframeStart frame = new JframeStart();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	 // Create the frame.
	 
	public JframeStart() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JframeStart thisframe = this;
		
		//Boutons
		JButton btn_launcher = new JButton("Lancer le tournoi");
		JButton btn_partiesolo = new JButton("Match solo");
		JButton btn_partieduo = new JButton("Match duo");
		JButton btn_partiemix = new JButton("Match mixte");
		JButton btn_joueur = new JButton("Liste des participants");
		
		btn_launcher.addActionListener(new ActionListener()
		{ 
			
			public void actionPerformed(ActionEvent arg0)
			{
				t = new Tournois("tournois");

					t.startAllOrdonnancement();
					
					btn_launcher.setVisible(false);
					btn_partiesolo.setVisible(true);
					btn_partieduo.setVisible(true);
					btn_partiemix.setVisible(true);
					btn_joueur.setVisible(true);						
				}
			});
		
		btn_partiesolo.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent arg0)
			{
				// envoi de l'objet acceuil et de l'ordennencement des messieurs
				JframeSolo frame = new JframeSolo(thisframe, t); 
				thisframe.setVisible(false);
			}
		});
		
		
		btn_partieduo.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent arg0) 
			{
				// envoi de l'objet acceuil et de l'ordennencement des messieurs
				JframeDuo frame = new JframeDuo(thisframe, t); 
				thisframe.setVisible(false);
				}
			});
	
		
		btn_joueur.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent arg0)
			{
				// envoi de l'objet acceuil et de l'ordennencement des messieurs
				JframeHF frame = new JframeHF(thisframe, t); 
				thisframe.setVisible(false);
				}
			});
		
		btn_launcher.setBounds(132, 26, 160, 25);
		btn_partiesolo.setBounds(132, 62, 160, 25);
		btn_partieduo.setBounds(132, 98, 160, 25);
		btn_joueur.setBounds(132, 208, 160, 42);
		
		btn_partiesolo.setVisible(false);
		btn_partieduo.setVisible(false);
		btn_joueur.setVisible(false);
		contentPane.setLayout(null);
		
		
		
		contentPane.add(btn_launcher);
		contentPane.add(btn_partiesolo);
		contentPane.add(btn_partieduo);
		contentPane.add(btn_joueur);		
		
	}
	
}

