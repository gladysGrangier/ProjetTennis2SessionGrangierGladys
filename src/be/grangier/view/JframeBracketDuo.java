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

public class JframeBracketDuo extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public JframeBracketDuo(JframeDuo thisframe2, Ordonnancement ordonnancement)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);		
		JframeBracketDuo thisframe = this;
			
		JButton btn_groupe = new JButton("Tournoi complet");
		JButton btn_groupeA = new JButton("groupe A");
		JButton btn_groupeB = new JButton("groupe B");
		
		btn_groupe.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent arg0) 
			{
					btn_groupe.setVisible(false);
					btn_groupeA.setVisible(true);
					btn_groupeB.setVisible(true);					
				}
			});
		
		
		btn_groupeA.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JframeGroupe frameA = new JframeGroupe(ordonnancement.getAm().subList(0, 16), ordonnancement.getAm().subList(32, 40),ordonnancement.getAm().subList(48, 52), ordonnancement.getAm().subList(56, 58), ordonnancement.getAm().subList(60, 61)); 
			}			
		});
		
		
		btn_groupeB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JframeGroupe frameB = new JframeGroupe(ordonnancement.getAm().subList(16, 32), ordonnancement.getAm().subList(40, 48),ordonnancement.getAm().subList(52, 56), ordonnancement.getAm().subList(58, 60), ordonnancement.getAm().subList(61, 62));
			}
		});
		
		
		btn_groupe.setBounds(100, 50, 180, 25);
		btn_groupeA.setBounds(100, 100, 100, 25);
		btn_groupeB.setBounds(100, 150, 100, 25);
		
		btn_groupe.setVisible(true);
		btn_groupeA.setVisible(false);
		btn_groupeB.setVisible(false);
		
		contentPane.add(btn_groupe);
		contentPane.add(btn_groupeA);
		contentPane.add(btn_groupeB);
		
		
		JButton btn_groupe8me = new JButton("1/8");
		btn_groupe8me.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JframeGroupe frame8 = new JframeGroupe(ordonnancement.getAm().subList(48, 56)); 
			}
		});
		
		JButton btn_groupe4eme = new JButton("1/4");
		btn_groupe4eme.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JframeGroupe frame4 = new JframeGroupe(ordonnancement.getAm().subList(56, 60)); 
			}
		});
		
		JButton btn_groupe2eme = new JButton("1/2");
		btn_groupe2eme.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JframeGroupe frame2 = new JframeGroupe(ordonnancement.getAm().subList(60, 62)); 
			}
		});
		
		JButton btn_groupefinal = new JButton("final");
		btn_groupefinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JframeGroupe framefinal = new JframeGroupe(ordonnancement.getAm().subList(62, 63)); 
			}
		});
		
		btn_groupe8me.setBounds(315, 100, 83, 25);
		btn_groupe4eme.setBounds(315, 150, 83, 25);
		btn_groupe2eme.setBounds(315, 200, 83, 25);
		btn_groupefinal.setBounds(315, 250, 83, 25);
		
		btn_groupe8me.setVisible(true);
		btn_groupe4eme.setVisible(true);
		btn_groupe2eme.setVisible(true);
		btn_groupefinal.setVisible(true);
		
		contentPane.add(btn_groupe8me);
		contentPane.add(btn_groupe4eme);
		contentPane.add(btn_groupe2eme);
		contentPane.add(btn_groupefinal);


		JButton btn_retourAcceuil = new JButton("Acceuil");
		btn_retourAcceuil.setBounds(10, 327, 97, 25);
		
		btn_retourAcceuil.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				thisframe2.setVisible(true);
				thisframe.dispose();			
			}
		});
		

		contentPane.add(btn_retourAcceuil);						
	}
}
