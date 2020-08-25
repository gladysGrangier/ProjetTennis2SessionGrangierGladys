package be.grangier.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.grangier.poco.Ordonnancement;
import be.grangier.poco.Tournois;

public class JframeSolo extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public JframeSolo(JframeStart framestart,Tournois t) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);		
		JframeSolo thisframe = this;
		
		JButton btn_matchHomme = new JButton("Homme");
		JButton btn_matchFemme = new JButton("Femme");
		
		
		btn_matchHomme.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent arg0) 
			{
				// envoi de l'objet acceuil et de l'ordennencement des messieurs
				JframeBracket frame = new JframeBracket(thisframe, t.getAo().get(0)); 
				thisframe.setVisible(false);
				}
			});
		
		btn_matchFemme.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent arg0)
			{
				JframeBracket frame = new JframeBracket(thisframe, t.getAo().get(1)); 
				thisframe.setVisible(false);
				}
			});
		
	
		
		btn_matchHomme.setBounds(26, 36, 172, 37);
		btn_matchFemme.setBounds(234, 36, 172, 37);
		
		btn_matchHomme.setVisible(true);
		btn_matchFemme.setVisible(true);
				
		contentPane.add(btn_matchHomme);
		contentPane.add(btn_matchFemme);
		
		
		JButton btn_retourAcceuil = new JButton("Acceuil");
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
