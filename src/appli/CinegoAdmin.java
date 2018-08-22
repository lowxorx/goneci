package appli;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.PanelAdminPage;
import panels.PanelCreationSalle;
import panels.PanelGestionAdmin;
import panels.PanelGestionCinemas;
import panels.PanelGestionClients;
import panels.PanelGestionFilms;
import panels.PanelGestionSeances;
import panels.PanelImportSalle;
import panels.PanelLogin;

public class CinegoAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel content = new JPanel();
	private CardLayout cl = new CardLayout();

	private PanelGestionClients clients;
	private PanelLogin login;
	private PanelAdminPage admin;
	private PanelGestionCinemas gerersalles;
	private PanelImportSalle importsalle;
	private PanelGestionFilms gestionfilms;
	private PanelCreationSalle nouvellesalle;
	private PanelGestionAdmin gestionadmin;
	private PanelGestionSeances gestionseances;

	public CinegoAdmin() {
		initComponents();
		setContentPane(content);
		content.setLayout(cl);
		login = new PanelLogin(this);
		admin = new PanelAdminPage(this);
		importsalle = new PanelImportSalle(this);
		clients = new PanelGestionClients(this);
		gerersalles = new PanelGestionCinemas(this);
		gestionfilms = new PanelGestionFilms(this);
		nouvellesalle = new PanelCreationSalle(this);
		gestionadmin = new PanelGestionAdmin(this);
		gestionseances = new PanelGestionSeances(this);

		content.add(gestionseances, "GestionSeances");
		content.add(importsalle, "Importsalle");
		content.add(login, "Connexion");
		content.add(admin, "Admin");
		content.add(clients, "GestionClients");
		content.add(gerersalles, "GererSalles");
		content.add(gestionfilms, "GestionFilms");
		content.add(nouvellesalle, "NewSalle");
		content.add(gestionadmin, "GestionAdmin");

		cl.show(content, "Connexion");
	}

	public JPanel getContent() {
		return content;
	}

	public CardLayout getCl() {
		return cl;
	}

	public PanelGestionClients getClients() {
		return clients;
	}

	public PanelGestionSeances getPanelGestionSeances() {
		return gestionseances;
	}

	public PanelCreationSalle getNewSalle() {
		return nouvellesalle;
	}

	public PanelGestionAdmin getPanelGestionAdmin() {
		return gestionadmin;
	}

	public PanelGestionFilms getPanelGestionFilms() {
		return gestionfilms;
	}

	public PanelGestionCinemas getPanelGestionCinema() {
		return gerersalles;
	}

	public PanelGestionClients getPanelGestionClients() {
		return clients;
	}

	public PanelLogin getPanelLogin() {
		return login;
	}

	public void setClients(PanelGestionClients clients) {
		this.clients = clients;
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 848, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 653, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				CinegoAdmin cinego = new CinegoAdmin();
				cinego.setVisible(true);
			}
		});
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables
	// End of variables declaration//GEN-END:variables
}
