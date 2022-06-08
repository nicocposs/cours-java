package org.eclipse.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.services.SalleService;
import org.eclipse.classes.Salle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Crud extends JFrame {

	private SalleService salleService;
	
	private List<Salle> salles;
	
	private JPanel contentPane;
	private JTable tbSalle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalleService salleService = new SalleService();
					// On a injecte la dependance d'une nouvelle instance SalleService dans Crud par son constructeur
					Crud frame = new Crud(salleService);
					// Rendre la fenêtre visible
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// les objects de la classe C1 dependent des objets de la classe C2 quand :
	// -> C1 a un attribut objet de la classe C2
	// -> C1 herite de C2
	// -> Une methode de C1, ici Crud, appelle une methode de C2, ici SalleService
	// Et pour ca on a utilise l'injection de dependance
	public Crud(SalleService salleService) {
		this.salleService = salleService;
		
		setTitle("Crud");
		initFrame();
		fetch();
	}

	private void initFrame() {
		// La fenêtre doit se fermer quand on clique sur la croix rouge
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Definit la position et la taille setBounds(int x, int y, int width, int
		// height)
		setBounds(100, 100, 865, 501);
		// Creation du container Jpanel qui va comprendre un layout et des composants
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tbSalle = new JTable();
		tbSalle.setBounds(322, 73, 501, 286);
		tbSalle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Code", "Libelle"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(tbSalle);
		scrollPane.setBounds(412, 11, 427, 440);
		contentPane.add(scrollPane);
		// Attribue une taille minimale a notre fenetre (jute assez pour voir tous les composants)
		// pack();
	}

	
	private void fetch() {
		salles = salleService.findAll();
		DefaultTableModel model = (DefaultTableModel) tbSalle.getModel();
		for(Salle s : salles) {
			Object[] row = new Object[3];
			row[0] = s.getId();
			row[1] = s.getCode();
			row[2] = s.getLibelle();
			model.addRow(row);
		}
	}
}
