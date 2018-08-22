package panels;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import appli.CinegoAdmin;
import events.EvtGestionAdmin;

public class PanelGestionAdmin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CinegoAdmin cine;
	private JTextField tbRechercheAdmin;
	private JTextField tbLogin;
	private JTextField tbNom;
	private JTextField tbPrenom;
	private JTextField tbMail;
	private JPasswordField tbPass;
	private JPasswordField tbVerifPass;

	private JButton btReset;
	private JButton btnRetour;
	private JButton btMaj;
	private JButton btCreer;
	private JButton btDelete;
	private JButton btRecherche;

	@SuppressWarnings("rawtypes")
	private JComboBox cbListeAdmin;

	private int idAdmin;
	private JLabel lblListeDesAdministrateurs;

	@SuppressWarnings("rawtypes")
	public PanelGestionAdmin(CinegoAdmin cinego) {
		this.cine = cinego;

		EvtGestionAdmin event = new EvtGestionAdmin(this);

		JLabel lblGestionDesAdministrateurs = new JLabel("Gestion des administrateurs");
		lblGestionDesAdministrateurs.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGestionDesAdministrateurs.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblRechercherUnAdministrateur = new JLabel("Rechercher un administrateur :");
		lblRechercherUnAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);

		tbRechercheAdmin = new JTextField();
		tbRechercheAdmin.setColumns(10);

		btRecherche = new JButton("Rechercher");

		JSeparator separator = new JSeparator();

		JLabel lblNewLabel = new JLabel("Informations sur l'administrateur :");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblVrifierLeMot = new JLabel("Vérifier le mot de passe");
		lblVrifierLeMot.setHorizontalAlignment(SwingConstants.RIGHT);

		tbLogin = new JTextField();
		tbLogin.setHorizontalAlignment(SwingConstants.CENTER);
		tbLogin.setColumns(10);

		tbNom = new JTextField();
		tbNom.setHorizontalAlignment(SwingConstants.CENTER);
		tbNom.setColumns(10);

		tbPrenom = new JTextField();
		tbPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		tbPrenom.setColumns(10);

		tbMail = new JTextField();
		tbMail.setHorizontalAlignment(SwingConstants.CENTER);
		tbMail.setColumns(10);

		tbPass = new JPasswordField();
		tbPass.setHorizontalAlignment(SwingConstants.CENTER);

		tbVerifPass = new JPasswordField();
		tbVerifPass.setHorizontalAlignment(SwingConstants.CENTER);

		btReset = new JButton("Reinitialiser les champs");

		btnRetour = new JButton("Retour");

		btMaj = new JButton("Mettre à jour l'administrateur");

		btCreer = new JButton("Créer l'administrateur");

		btDelete = new JButton("Supprimer l'administrateur");

		lblListeDesAdministrateurs = new JLabel("Liste des administrateurs :");
		lblListeDesAdministrateurs.setHorizontalAlignment(SwingConstants.CENTER);

		cbListeAdmin = new JComboBox();

		btReset.addActionListener(event);
		btnRetour.addActionListener(event);
		btMaj.addActionListener(event);
		btCreer.addActionListener(event);
		btDelete.addActionListener(event);
		btRecherche.addActionListener(event);
		cbListeAdmin.addActionListener(event);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblGestionDesAdministrateurs,
						GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addComponent(lblRechercherUnAdministrateur, GroupLayout.PREFERRED_SIZE, 210,
								GroupLayout.PREFERRED_SIZE)
						.addGap(140).addComponent(lblListeDesAdministrateurs, GroupLayout.PREFERRED_SIZE, 210,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(
						groupLayout.createSequentialGroup().addGap(10)
								.addComponent(tbRechercheAdmin, GroupLayout.PREFERRED_SIZE, 210,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(btRecherche).addGap(40).addComponent(cbListeAdmin,
										GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
				.addComponent(separator, GroupLayout.PREFERRED_SIZE, 790, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblNewLabel,
						GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(42)
						.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE).addGap(55)
						.addComponent(tbLogin, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE).addGap(33)
						.addComponent(btMaj))
				.addGroup(groupLayout.createSequentialGroup().addGap(42)
						.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE).addGap(55)
						.addComponent(tbNom, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE).addGap(33)
						.addComponent(btCreer, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(42)
						.addComponent(lblPrnom, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE).addGap(55)
						.addComponent(tbPrenom, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE).addGap(33)
						.addComponent(btDelete, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(42)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE).addGap(55)
						.addComponent(tbMail, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(42)
						.addComponent(lblMotDePasse, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
						.addGap(55).addComponent(tbPass, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
				.addGroup(
						groupLayout.createSequentialGroup().addGap(42)
								.addComponent(lblVrifierLeMot, GroupLayout.PREFERRED_SIZE, 199,
										GroupLayout.PREFERRED_SIZE)
								.addGap(55)
								.addComponent(tbVerifPass, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(296).addComponent(btReset,
						GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(btnRetour,
						GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(11).addComponent(lblGestionDesAdministrateurs).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblRechercherUnAdministrateur)
						.addComponent(lblListeDesAdministrateurs))
				.addGap(11)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(tbRechercheAdmin,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btRecherche)
						.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(cbListeAdmin,
								GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
				.addGap(30)
				.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(lblNewLabel).addGap(46)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(lblLogin))
						.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(tbLogin,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btMaj))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(lblNom))
						.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(tbNom,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btCreer))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(lblPrnom))
						.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(tbPrenom,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btDelete))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblEmail))
						.addComponent(tbMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblMotDePasse))
						.addComponent(tbPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblVrifierLeMot))
						.addComponent(tbVerifPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btReset).addGap(77).addComponent(btnRetour)));
		setLayout(groupLayout);

	}

	public CinegoAdmin getCinego() {
		return cine;
	}

	public String getTbRechercheAdmin() {
		return tbRechercheAdmin.getText();
	}

	public void setTbRechercheAdmin(String tbRechercheAdmin) {
		this.tbRechercheAdmin.setText(tbRechercheAdmin);
	}

	public String getTbLogin() {
		return tbLogin.getText();
	}

	public void setTbLogin(String tbLogin) {
		this.tbLogin.setText(tbLogin);
	}

	public String getTbNom() {
		return tbNom.getText();
	}

	public void setTbNom(String tbNom) {
		this.tbNom.setText(tbNom);
	}

	public String getTbPrenom() {
		return tbPrenom.getText();
	}

	public void setTbPrenom(String tbPrenom) {
		this.tbPrenom.setText(tbPrenom);
	}

	public String getTbMail() {
		return tbMail.getText();
	}

	public void setTbMail(String tbMail) {
		this.tbMail.setText(tbMail);
	}

	public char[] getTbPass() {
		return tbPass.getPassword();
	}

	public void setTbPass(String tbPass) {
		this.tbPass.setText(tbPass);
		this.tbVerifPass.setText(tbPass);
	}

	public char[] getTbVerifPass() {
		return tbVerifPass.getPassword();
	}

	public JButton getBtReset() {
		return btReset;
	}

	public JButton getBtnRetour() {
		return btnRetour;
	}

	public JButton getBtMaj() {
		return btMaj;
	}

	public JButton getBtCreer() {
		return btCreer;
	}

	public JButton getBtRecherche() {
		return btRecherche;
	}

	public JButton getBtDelete() {
		return btDelete;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbListeAdmin() {
		return cbListeAdmin;
	}

	public String getSelectedAdmin() {
		return cbListeAdmin.getSelectedItem().toString();
	}

	@SuppressWarnings("unchecked")
	public void setCbListeAdmin(String cbListeAdmin) {
		this.cbListeAdmin.addItem(cbListeAdmin);
	}

	public void clearCb() {
		this.cbListeAdmin.removeAllItems();
	}

}
