package panels;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import appli.CinegoAdmin;
import events.EvtPageAdmin;

public class PanelAdminPage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CinegoAdmin cine;

	private JButton btCreerSalle;
	private JButton btImportSalle;
	private JButton btGestionSalle;
	private JButton btGestionClients;
	private JButton btGestionFilms;
	private JButton btGestionSeances;
	private JButton btLogout;
	private JButton btGestionAdmins;

	public PanelAdminPage(CinegoAdmin cinego) {
		this.cine = cinego;
		EvtPageAdmin event = new EvtPageAdmin(this);

		JLabel lblEspaceDadministration = new JLabel("Espace d'administration CINEGO");
		lblEspaceDadministration.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEspaceDadministration.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblGestionDesSalles = new JLabel("Salles & Cinémas");
		lblGestionDesSalles.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblGestionDesClients = new JLabel("Clients & Administateurs");
		lblGestionDesClients.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblGestionDesScances = new JLabel("Films & Scéances");
		lblGestionDesScances.setHorizontalAlignment(SwingConstants.CENTER);

		btCreerSalle = new JButton("Créer une salle");

		btImportSalle = new JButton("Importer une salle");

		btGestionSalle = new JButton("Gérer les cinémas");

		btGestionClients = new JButton("Gestion des clients");

		btGestionFilms = new JButton("Gestion des films");

		btGestionSeances = new JButton("Gestion des séances");

		btGestionAdmins = new JButton("Gestion des administrateurs");

		btLogout = new JButton("Déconnexion");

		// Action listeners

		btCreerSalle.addActionListener(event);
		btImportSalle.addActionListener(event);
		btGestionSalle.addActionListener(event);
		btGestionClients.addActionListener(event);
		btGestionFilms.addActionListener(event);
		btGestionSeances.addActionListener(event);
		btGestionAdmins.addActionListener(event);
		btLogout.addActionListener(event);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblEspaceDadministration,
								GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(304).addComponent(lblGestionDesSalles,
								GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(304).addComponent(btCreerSalle,
								GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(304).addComponent(btImportSalle,
								GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(304).addComponent(btGestionSalle,
								GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(304).addComponent(lblGestionDesClients,
								GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(304).addComponent(btGestionClients,
								GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(304).addComponent(btGestionAdmins,
								GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(304).addComponent(lblGestionDesScances,
								GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(304).addComponent(btGestionFilms,
								GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(304).addComponent(btGestionSeances,
								GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(btLogout)))
				.addContainerGap(10, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(11).addComponent(lblEspaceDadministration)
						.addGap(76).addComponent(lblGestionDesSalles).addGap(18).addComponent(btCreerSalle).addGap(11)
						.addComponent(btImportSalle).addGap(11).addComponent(btGestionSalle).addGap(18)
						.addComponent(lblGestionDesClients).addGap(18).addComponent(btGestionClients).addGap(18)
						.addComponent(btGestionAdmins).addGap(18).addComponent(lblGestionDesScances).addGap(18)
						.addComponent(btGestionFilms).addGap(18).addComponent(btGestionSeances).addGap(84)
						.addComponent(btLogout).addContainerGap()));
		setLayout(groupLayout);
	}

	public JButton getBtCreerSalle() {
		return btCreerSalle;
	}

	public JButton getBtImportSalle() {
		return btImportSalle;
	}

	public JButton getBtGestionSalle() {
		return btGestionSalle;
	}

	public JButton getBtGestionClients() {
		return btGestionClients;
	}

	public JButton getBtGestionFilms() {
		return btGestionFilms;
	}

	public JButton getBtGestionSeances() {
		return btGestionSeances;
	}

	public JButton getBtLogout() {
		return btLogout;
	}

	public JButton getBtGestionAdmins() {
		return btGestionAdmins;
	}

	public CinegoAdmin getCinego() {
		return cine;
	}
}
