package be.grangier.view;


import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.grangier.poco.Tournois;
import javax.swing.JLabel;


public class JframeHF extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public JframeHF(JframeStart thisaccueil, Tournois t) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);		
		JframeHF thisframe= this;
		
		List list = new List();
		list.setBounds(34, 61, 144, 290);
		JframeRequet req = new JframeRequet();
		contentPane.setLayout(null);
		req.JframeRequet(list);
		contentPane.add(list);
		
		
		List liste = new List();
		liste.setBounds(287, 61, 155, 290);
		JframeRequetF reqe = new JframeRequetF();
		contentPane.setLayout(null);
		reqe.JframeRequetF(liste);
		contentPane.add(liste);
		
		
		
		JButton btn_retourAcceuil = new JButton("Accueil");
		btn_retourAcceuil.setBounds(183, 24, 97, 25);
		
		btn_retourAcceuil.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				thisaccueil.setVisible(true);
				thisframe.dispose();			
			}
		});

		contentPane.add(btn_retourAcceuil);
		
		JLabel lblHomme = new JLabel("Homme");
		lblHomme.setBounds(62, 29, 48, 14);
		contentPane.add(lblHomme);
		
		JLabel lblFemme = new JLabel("Femme");
		lblFemme.setBounds(332, 29, 48, 14);
		contentPane.add(lblFemme);
		
	}
}
