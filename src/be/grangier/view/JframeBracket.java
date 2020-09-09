package be.grangier.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import be.grangier.poco.Ordonnancement;



public class JframeBracket extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public JframeBracket(JframeSolo thisframe2, Ordonnancement o) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);		
		JframeBracket thisframe = this;
		
		JButton btn_groupe = new JButton("Tournoi complet");
		JButton btn_groupeA = new JButton("Groupe 1");
		JButton btn_groupeB = new JButton("Groupe 2");
		JButton btn_groupeC = new JButton("Groupe 3");
		JButton btn_groupeD = new JButton("Groupe 4");
		
		btn_groupe.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent arg0) 
				{
					btn_groupe.setVisible(false);
					btn_groupeA.setVisible(true);
					btn_groupeB.setVisible(true);
					btn_groupeC.setVisible(true);
					btn_groupeD.setVisible(true);						
				}
			});
		
		
		btn_groupeA.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JframeGroupe frameA = new JframeGroupe(o.getAm().subList(0, 16), o.getAm().subList(64, 72),o.getAm().subList(96, 100), o.getAm().subList(112, 114), o.getAm().subList(120, 121)); 
			}
		});
		
		
		btn_groupeB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JframeGroupe frameB = new JframeGroupe(o.getAm().subList(16, 32), o.getAm().subList(72, 80), o.getAm().subList(100, 104), o.getAm().subList(114, 116), o.getAm().subList(121, 122));
			}
		});
		
			
			btn_groupeC.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					JframeGroupe frameC = new JframeGroupe(o.getAm().subList(32, 48), o.getAm().subList(80, 88), o.getAm().subList(104, 108), o.getAm().subList(116, 118), o.getAm().subList(122, 123)); 
				}
			});
			
			btn_groupeD.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					JframeGroupe frameD = new JframeGroupe(o.getAm().subList(48, 64),o.getAm().subList(88, 96), o.getAm().subList(108, 112), o.getAm().subList(118, 120), o.getAm().subList(123, 124)); 
				}
			});
				
			
		btn_groupe.setBounds(100, 58, 180, 25);
		btn_groupeA.setBounds(100, 94, 100, 25);
		btn_groupeB.setBounds(100, 150, 100, 25);
		btn_groupeC.setBounds(100, 200, 100, 25);
		btn_groupeD.setBounds(100, 250, 100, 25);
		
		btn_groupe.setVisible(true);
		btn_groupeA.setVisible(false);
		btn_groupeB.setVisible(false);
		btn_groupeC.setVisible(false);
		btn_groupeD.setVisible(false);
		
		contentPane.add(btn_groupe);
		contentPane.add(btn_groupeA);
		contentPane.add(btn_groupeB);
		contentPane.add(btn_groupeC);
		contentPane.add(btn_groupeD);
		
		
		JButton btn_groupe8me = new JButton("1/8");
		btn_groupe8me.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JframeGroupe frame8 = new JframeGroupe(o.getAm().subList(112, 120)); 
			}
		});
		
		JButton btn_groupe4eme = new JButton("1/4");
		btn_groupe4eme.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JframeGroupe frame4 = new JframeGroupe(o.getAm().subList(120, 124)); 
			}
		});
		
		
		JButton btn_groupe2eme = new JButton("1/2");
		btn_groupe2eme.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JframeGroupe frame2 = new JframeGroupe(o.getAm().subList(124, 126)); 
			}
		});
		
		
		JButton btn_groupefinal = new JButton("finale");
		btn_groupefinal.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JframeGroupe framefinal = new JframeGroupe(o.getAm().subList(126, 127)); 
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

		JButton btn_retourAcceuil = new JButton("Accueil");
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
