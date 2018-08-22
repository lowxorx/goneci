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
import events.EvtGestionClients;

public class PanelGestionClients extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CinegoAdmin cine;

	private JTextField tbNumAbo;
	private JTextField tbPrenomClient;
	private JTextField tbMailClient;
	private JTextField tbPtsFidClient;
	private JTextField tbNomClient;
	private JTextField tbRechercheClient;

	private JButton btRechercheClient;
	private JButton btMajClient;
	private JButton btRetour;
	private JButton btCreerClient;
	private JButton btDeleteClient;
	private JButton btClearTb;

	private JPasswordField tbPassClient;
	private JPasswordField tbVerifPass;

	@SuppressWarnings("rawtypes")
	private JComboBox cbGenrePref;
	@SuppressWarnings("rawtypes")
	private JComboBox cbCinePref;
	@SuppressWarnings("rawtypes")
	private JComboBox cbResaClient;
	@SuppressWarnings("rawtypes")
	private JComboBox cbClientList;

	private int idClient;
	private JLabel lblRservations;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("rawtypes")
	public PanelGestionClients(CinegoAdmin cinego) {
		this.cine = cinego;
		EvtGestionClients event = new EvtGestionClients(this);

		JLabel lblNewLabel = new JLabel("Gestion des Clients");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblListeDesCinmas = new JLabel("Rechercher un client");
		lblListeDesCinmas.setAlignmentY(0.0f);
		lblListeDesCinmas.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblInformationsSurLa = new JLabel("Informations sur le client :");
		lblInformationsSurLa.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblInformationsSurLa.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCinmaDeRattachement = new JLabel("Numéro d'abonné");
		lblCinmaDeRattachement.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNombreDeRanges = new JLabel("Nom");
		lblNombreDeRanges.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNomrbeDeSiges = new JLabel("Prénom");
		lblNomrbeDeSiges.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNumroDeSalle = new JLabel("Email");
		lblNumroDeSalle.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNombreDePlaces = new JLabel("Points de fidélité");
		lblNombreDePlaces.setHorizontalAlignment(SwingConstants.RIGHT);

		btRechercheClient = new JButton("Rechercher");

		btMajClient = new JButton("Mettre à jour le client ");

		JSeparator separator = new JSeparator();

		tbNumAbo = new JTextField();
		tbNumAbo.setEditable(false);
		tbNumAbo.setColumns(10);

		tbPrenomClient = new JTextField();
		tbPrenomClient.setColumns(10);

		tbMailClient = new JTextField();
		tbMailClient.setColumns(10);

		tbPtsFidClient = new JTextField();
		tbPtsFidClient.setColumns(10);

		tbNomClient = new JTextField();
		tbNomClient.setColumns(10);

		btRetour = new JButton("Retour");

		tbPassClient = new JPasswordField();

		tbVerifPass = new JPasswordField();

		JLabel lblCinmaPrfr = new JLabel("Cinéma préféré");
		lblCinmaPrfr.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblGenrePrfr = new JLabel("Genre préféré");
		lblGenrePrfr.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblVrifierLeMot = new JLabel("Vérifier le mot de passe");
		lblVrifierLeMot.setHorizontalAlignment(SwingConstants.RIGHT);

		lblRservations = new JLabel("Réservations");
		lblRservations.setHorizontalAlignment(SwingConstants.RIGHT);

		cbResaClient = new JComboBox();

		tbRechercheClient = new JTextField();
		tbRechercheClient.setColumns(10);

		btCreerClient = new JButton("Créer le client");

		btDeleteClient = new JButton("Supprimer le client");

		btClearTb = new JButton("Reinitialiser les champs");

		cbGenrePref = new JComboBox();

		cbCinePref = new JComboBox();

		// Action listeners

		btRetour.addActionListener(event);
		btRechercheClient.addActionListener(event);
		btMajClient.addActionListener(event);
		btCreerClient.addActionListener(event);
		btDeleteClient.addActionListener(event);
		btClearTb.addActionListener(event);

		cbClientList = new JComboBox();
		cbClientList.addActionListener(event);

		JLabel lblListeDesClients = new JLabel("Liste des clients");
		lblListeDesClients.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblNewLabel,
								GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(separator,
								GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(lblInformationsSurLa,
								GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(100)
								.addComponent(lblCinmaDeRattachement, GroupLayout.PREFERRED_SIZE, 179,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(tbNumAbo, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(167)
								.addComponent(lblNombreDeRanges, GroupLayout.PREFERRED_SIZE, 112,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(tbNomClient, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(167)
								.addComponent(lblNomrbeDeSiges, GroupLayout.PREFERRED_SIZE, 112,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(tbPrenomClient, GroupLayout.PREFERRED_SIZE, 205,
										GroupLayout.PREFERRED_SIZE)
								.addGap(86)
								.addComponent(btMajClient, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(167)
								.addComponent(lblNumroDeSalle, GroupLayout.PREFERRED_SIZE, 112,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(tbMailClient, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
								.addGap(86).addComponent(btCreerClient, GroupLayout.PREFERRED_SIZE, 174,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(167)
								.addComponent(lblNombreDePlaces, GroupLayout.PREFERRED_SIZE, 112,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(tbPtsFidClient, GroupLayout.PREFERRED_SIZE, 205,
										GroupLayout.PREFERRED_SIZE)
								.addGap(86).addComponent(btDeleteClient, GroupLayout.PREFERRED_SIZE, 174,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(167)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCinmaPrfr, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblGenrePrfr, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(cbCinePref, GroupLayout.PREFERRED_SIZE, 205,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cbGenrePref, GroupLayout.PREFERRED_SIZE, 205,
												GroupLayout.PREFERRED_SIZE))
								.addGap(86)
								.addComponent(btClearTb, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(167)
								.addComponent(lblRservations, GroupLayout.PREFERRED_SIZE, 112,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26).addComponent(cbResaClient, GroupLayout.PREFERRED_SIZE, 205,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(167)
								.addComponent(lblMotDePasse, GroupLayout.PREFERRED_SIZE, 112,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26).addComponent(tbPassClient, GroupLayout.PREFERRED_SIZE, 205,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(btRetour,
								GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(142).addComponent(lblVrifierLeMot)
								.addGap(26)
								.addComponent(tbVerifPass, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(tbRechercheClient, GroupLayout.PREFERRED_SIZE, 211,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btRechercheClient))
								.addComponent(lblListeDesCinmas, GroupLayout.PREFERRED_SIZE, 211,
										GroupLayout.PREFERRED_SIZE))
								.addGap(35)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblListeDesClients, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbClientList, 0, 323, Short.MAX_VALUE))))
				.addGap(12)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(11).addComponent(lblNewLabel).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblListeDesCinmas)
						.addComponent(lblListeDesClients))
				.addGap(11)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(tbRechercheClient,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btRechercheClient)
								.addComponent(cbClientList, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(18).addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				.addGap(6).addComponent(lblInformationsSurLa).addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblCinmaDeRattachement))
						.addComponent(tbNumAbo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(12)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblNombreDeRanges))
						.addComponent(tbNomClient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(14).addComponent(lblNomrbeDeSiges))
						.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(tbPrenomClient,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btMajClient))
				.addGap(8)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(lblNumroDeSalle))
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(tbMailClient,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btCreerClient))
				.addGap(12)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblNombreDePlaces))
						.addComponent(tbPtsFidClient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(btDeleteClient)))
				.addGap(11)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblCinmaPrfr)
										.addGap(16).addComponent(lblGenrePrfr))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(cbCinePref, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addGap(12).addComponent(cbGenrePref, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(btClearTb)))
				.addGap(12)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblRservations))
						.addComponent(cbResaClient, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGap(13)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblMotDePasse))
						.addComponent(tbPassClient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(12)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblVrifierLeMot))
						.addComponent(tbVerifPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(52).addComponent(btRetour)));
		setLayout(groupLayout);

	}

	public JButton getBtRetour() {
		return btRetour;
	}

	public JButton getbtClearTb() {
		return btClearTb;
	}

	public CinegoAdmin getCinego() {
		return cine;
	}

	public String getTbNumAbo() {
		return tbNumAbo.getText();
	}

	public void setTbNumAbo(String tbNumAbo) {
		this.tbNumAbo.setText(tbNumAbo);
	}

	public String getTbPrenomClient() {
		return tbPrenomClient.getText();
	}

	public void setTbPrenomClient(String tbPrenomClient) {
		this.tbPrenomClient.setText(tbPrenomClient);
	}

	public String getTbMailClient() {
		return tbMailClient.getText();
	}

	public void setTbMailClient(String tbMailClient) {
		this.tbMailClient.setText(tbMailClient);
	}

	public String getTbPtsFidClient() {
		return tbPtsFidClient.getText();
	}

	public void setTbPtsFidClient(int tbPtsFidClient) {
		this.tbPtsFidClient.setText(String.valueOf(tbPtsFidClient));
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbResaClient() {
		return cbResaClient;
	}

	@SuppressWarnings("unchecked")
	public void setCbResaClient(String cbResaClient) {
		this.cbResaClient.addItem(cbResaClient);
	}

	public String getTbNomClient() {
		return tbNomClient.getText();
	}

	public void setTbNomClient(String tbNomClient) {
		this.tbNomClient.setText(tbNomClient);
	}

	public char[] getTbPassClient() {
		return tbPassClient.getPassword();
	}

	public void setTbPassClient(String tbPassClient) {
		this.tbPassClient.setText(tbPassClient);
		this.tbVerifPass.setText(tbPassClient);
	}

	public char[] getTbVerifPass() {
		return tbVerifPass.getPassword();
	}

	public String getTbRechercheClient() {
		return tbRechercheClient.getText();
	}

	public void setTbRechercheClient(String tbRechercheClient) {
		this.tbRechercheClient.setText(tbRechercheClient);
	}

	public JButton getBtRechercheClient() {
		return btRechercheClient;
	}

	public JButton getBtMajClient() {
		return btMajClient;
	}

	public JButton getBtCreerClient() {
		return btCreerClient;
	}

	public JButton getBtDeleteClient() {
		return btDeleteClient;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbGenrePref() {
		return cbGenrePref;
	}

	public String getSelectedCinema() {
		return cbCinePref.getSelectedItem().toString();
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbClientList() {
		return cbClientList;
	}

	@SuppressWarnings("unchecked")
	public void setCbClientList(String cbClientList) {
		this.cbClientList.addItem(cbClientList);
	}

	public String getSelectedGenre() {
		return cbGenrePref.getSelectedItem().toString();
	}

	public void setCbGenrePref(String cbGenrePref) {
		this.cbGenrePref.setSelectedItem(cbGenrePref);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbCinePref() {
		return cbCinePref;
	}

	public void setCbCinePref(String cbCinePref) {
		this.cbCinePref.setSelectedItem(cbCinePref);
	}

	public void clearcb() {
		cbGenrePref.removeAllItems();
		cbCinePref.removeAllItems();
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
}
