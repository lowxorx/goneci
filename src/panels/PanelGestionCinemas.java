package panels;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import appli.CinegoAdmin;
import events.EvtGestionCinemas;
import metier.Materiel;

public class PanelGestionCinemas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CinegoAdmin cine;

	private JTextField tbCine;
	private JTextField tbNbSieges;
	private JTextField tbNumSalle;
	private JTextField tbNbPlacesHandi;
	private JTextField tbNbRangees;

	private JButton btRefresh;
	private JButton btRefreshInfoSalle;
	private JButton btRetour;
	private JButton btUpdateSalle;
	private JButton btDelSalle;
	private JButton btUpdateCinema;
	private JButton btDelCinema;

	@SuppressWarnings("rawtypes")
	private JComboBox cbListSalles;
	@SuppressWarnings("rawtypes")
	private JComboBox cbListeCinemas;
	private JComboBox<Materiel> cbTypeSon;
	private JComboBox<Materiel> cbTypeEcran;

	private JLabel lblInformationsSurLe;
	private JLabel lblNewLabel_1;
	private JLabel lblTarifd;
	private JLabel lblNewLabel_2;
	private JLabel lblTarifEtudiant;
	private JLabel lblNombreDeSalles;
	private JTextField tbNomCine;
	private JTextField tbTarif3dCine;
	private JTextField tbTarifNormalCine;
	private JTextField tbTarifEtudiantCine;
	private JTextField tbNbSalleCine;
	private JTextField tbNbPlacesToTal;

	private int idSalle;
	private int idCine;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("rawtypes")
	public PanelGestionCinemas(CinegoAdmin cinego) {
		this.cine = cinego;
		EvtGestionCinemas event = new EvtGestionCinemas(this);

		JLabel lblNewLabel = new JLabel("Gestion des Cinemas");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 784, 18);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblListeDesSalles = new JLabel("Liste des Salles");
		lblListeDesSalles.setBounds(239, 47, 208, 18);
		lblListeDesSalles.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblListeDesCinmas = new JLabel("Liste des Cinémas");
		lblListeDesCinmas.setBounds(10, 47, 211, 18);
		lblListeDesCinmas.setAlignmentY(0.0f);
		lblListeDesCinmas.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblInformationsSurLa = new JLabel("Informations sur la salle :");
		lblInformationsSurLa.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblInformationsSurLa.setBounds(10, 146, 282, 18);
		lblInformationsSurLa.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCinmaDeRattachement = new JLabel("Cinéma de rattachement");
		lblCinmaDeRattachement.setBounds(10, 187, 142, 18);

		JLabel lblNombreDeRanges = new JLabel("Nombre de rangées");
		lblNombreDeRanges.setBounds(10, 227, 113, 18);

		JLabel lblNomrbeDeSiges = new JLabel("Nombre de sièges par rangée");
		lblNomrbeDeSiges.setBounds(10, 267, 170, 18);

		JLabel lblNumroDeSalle = new JLabel("Numéro de salle");
		lblNumroDeSalle.setBounds(10, 307, 94, 18);

		JLabel lblNombreDePlaces = new JLabel("Nombre de places handicapés");
		lblNombreDePlaces.setBounds(10, 347, 175, 18);

		cbListSalles = new JComboBox();
		cbListSalles.setBounds(239, 77, 208, 22);

		cbListeCinemas = new JComboBox();
		cbListeCinemas.setBounds(10, 77, 211, 22);

		btRefresh = new JButton("Actualiser");
		btRefresh.setBounds(465, 76, 74, 24);

		btRefreshInfoSalle = new JButton("Actualiser les infos");
		btRefreshInfoSalle.setBounds(318, 142, 148, 24);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 126, 784, 10);

		tbCine = new JTextField();
		tbCine.setBounds(213, 185, 148, 22);
		tbCine.setColumns(10);

		tbNbSieges = new JTextField();
		tbNbSieges.setBounds(213, 265, 148, 22);
		tbNbSieges.setColumns(10);

		tbNumSalle = new JTextField();
		tbNumSalle.setBounds(213, 305, 148, 22);
		tbNumSalle.setColumns(10);

		tbNbPlacesHandi = new JTextField();
		tbNbPlacesHandi.setBounds(213, 345, 148, 22);
		tbNbPlacesHandi.setColumns(10);

		tbNbRangees = new JTextField();
		tbNbRangees.setBounds(213, 225, 148, 22);
		tbNbRangees.setColumns(10);

		btRetour = new JButton("Retour");
		btRetour.setBounds(12, 565, 74, 24);

		btDelSalle = new JButton("Supprimer la salle");
		btDelSalle.setBounds(10, 500, 170, 24);

		btUpdateSalle = new JButton("Modifier la salle");
		btUpdateSalle.setBounds(212, 500, 149, 24);

		lblInformationsSurLe = new JLabel("Informations sur le cinéma :");
		lblInformationsSurLe.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblInformationsSurLe.setBounds(491, 146, 300, 18);
		lblInformationsSurLe.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel_1 = new JLabel("Nom du cinéma");
		lblNewLabel_1.setBounds(465, 187, 131, 18);

		lblTarifd = new JLabel("Tarif 3D");
		lblTarifd.setBounds(465, 227, 125, 18);

		lblNewLabel_2 = new JLabel("Tarif Normal");
		lblNewLabel_2.setBounds(465, 267, 131, 18);

		lblTarifEtudiant = new JLabel("Tarif Etudiant");
		lblTarifEtudiant.setBounds(465, 307, 131, 18);

		lblNombreDeSalles = new JLabel("Nombre de salles");
		lblNombreDeSalles.setBounds(465, 347, 131, 18);

		tbNomCine = new JTextField();
		tbNomCine.setBounds(614, 185, 149, 22);
		tbNomCine.setColumns(10);

		tbTarif3dCine = new JTextField();
		tbTarif3dCine.setBounds(614, 225, 149, 22);
		tbTarif3dCine.setColumns(10);

		tbTarifNormalCine = new JTextField();
		tbTarifNormalCine.setBounds(614, 265, 149, 22);
		tbTarifNormalCine.setColumns(10);

		tbTarifEtudiantCine = new JTextField();
		tbTarifEtudiantCine.setBounds(614, 305, 149, 22);
		tbTarifEtudiantCine.setColumns(10);

		tbNbSalleCine = new JTextField();
		tbNbSalleCine.setBounds(614, 345, 149, 22);
		tbNbSalleCine.setColumns(10);

		btUpdateCinema = new JButton("Modifier le cinéma");
		btUpdateCinema.setBounds(614, 384, 149, 24);

		btDelCinema = new JButton("Supprimer le cinéma");
		btDelCinema.setBounds(465, 384, 135, 24);

		JLabel lblNombreTotalDe = new JLabel("Nombre total de places");
		lblNombreTotalDe.setBounds(10, 387, 142, 18);

		JLabel lblTypeDeSon = new JLabel("Type de son");
		lblTypeDeSon.setBounds(10, 429, 142, 18);

		JLabel lblTypeDcran = new JLabel("Type d'écran");
		lblTypeDcran.setBounds(10, 469, 142, 18);

		tbNbPlacesToTal = new JTextField();
		tbNbPlacesToTal.setBounds(213, 385, 148, 22);
		tbNbPlacesToTal.setColumns(10);

		cbTypeSon = new JComboBox<Materiel>();
		cbTypeSon.setBounds(213, 427, 148, 22);

		cbTypeEcran = new JComboBox<Materiel>();
		cbTypeEcran.setBounds(213, 467, 148, 22);

		// Action listeners

		btRetour.addActionListener(event);
		btRefresh.addActionListener(event);
		btRefreshInfoSalle.addActionListener(event);
		btDelSalle.addActionListener(event);
		btUpdateSalle.addActionListener(event);
		cbListeCinemas.addActionListener(event);
		cbListSalles.addActionListener(event);
		btUpdateCinema.addActionListener(event);
		btDelCinema.addActionListener(event);
		setLayout(null);
		add(lblNewLabel);
		add(lblListeDesCinmas);
		add(lblListeDesSalles);
		add(cbListeCinemas);
		add(cbListSalles);
		add(btRefresh);
		add(separator);
		add(lblInformationsSurLa);
		add(btRefreshInfoSalle);
		add(lblInformationsSurLe);
		add(lblNomrbeDeSiges);
		add(tbNbSieges);
		add(lblNewLabel_2);
		add(tbTarifNormalCine);
		add(lblNumroDeSalle);
		add(tbNumSalle);
		add(lblTarifEtudiant);
		add(tbTarifEtudiantCine);
		add(lblNombreDePlaces);
		add(tbNbPlacesHandi);
		add(lblNombreDeSalles);
		add(tbNbSalleCine);
		add(lblNombreTotalDe);
		add(tbNbPlacesToTal);
		add(btDelCinema);
		add(btUpdateCinema);
		add(lblTypeDeSon);
		add(cbTypeSon);
		add(lblTypeDcran);
		add(cbTypeEcran);
		add(btDelSalle);
		add(btUpdateSalle);
		add(btRetour);
		add(lblCinmaDeRattachement);
		add(lblNombreDeRanges);
		add(tbNbRangees);
		add(lblTarifd);
		add(tbTarif3dCine);
		add(tbCine);
		add(lblNewLabel_1);
		add(tbNomCine);

	}

	public String getTbCine() {
		return tbCine.getText();
	}

	public void setTbCine(String tbCine) {
		this.tbCine.setText(tbCine);
	}

	public String getTbNbSieges() {
		return tbNbSieges.getText();
	}

	public void setTbNbSieges(String tbNbSieges) {
		this.tbNbSieges.setText(tbNbSieges);
	}

	public String getTbNumSalle() {
		return tbNumSalle.getText();
	}

	public void setTbNumSalle(String tbNumSalle) {
		this.tbNumSalle.setText(tbNumSalle);
	}

	public String getTbNbPlacesHandi() {
		return tbNbPlacesHandi.getText();
	}

	public void setTbNbPlacesHandi(String tbNbPlacesHandi) {
		this.tbNbPlacesHandi.setText(tbNbPlacesHandi);
	}

	public String getTbNbRangees() {
		return tbNbRangees.getText();
	}

	public void setTbNbRangees(String tbNbRangees) {
		this.tbNbRangees.setText(tbNbRangees);
	}

	public JButton getBtRefresh() {
		return btRefresh;
	}

	public JButton getBtRefreshInfoSalle() {
		return btRefreshInfoSalle;
	}

	public JButton getBtRetour() {
		return btRetour;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbListSalles() {
		return cbListSalles;
	}

	@SuppressWarnings("unchecked")
	public void setCbListSalles(String cbListSalles) {
		this.cbListSalles.addItem(cbListSalles);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbListeCinemas() {
		return cbListeCinemas;
	}

	@SuppressWarnings("unchecked")
	public void setCbListeCinemas(String cbListeCinemas) {
		this.cbListeCinemas.addItem(cbListeCinemas);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbTypeSon() {
		return cbTypeSon;
	}

	public String getSelectedSon() {
		return cbTypeSon.getSelectedItem().toString();
	}

	public void setCbTypeSon(String cbTypeSon) {
		this.cbTypeSon.setSelectedItem(cbTypeSon);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbTypeEcran() {
		return cbTypeEcran;
	}

	public String getSelectedEcran() {
		return cbTypeEcran.getSelectedItem().toString();
	}

	public void setCbTypeEcran(String cbTypeEcran) {
		this.cbTypeEcran.setSelectedItem(cbTypeEcran);
	}

	public String getTbNbPlacesToTal() {
		return tbNbPlacesToTal.getText();
	}

	public void setTbNbPlacesToTal(String tbNbPlacesToTal) {
		this.tbNbPlacesToTal.setText(tbNbPlacesToTal);
	}

	public String getSelectedCinema() {
		return cbListeCinemas.getSelectedItem().toString();
	}

	public String getSelectedSalle() {
		return cbListSalles.getSelectedItem().toString();
	}

	public JButton getBtUpdateSalle() {
		return btUpdateSalle;
	}

	public JButton getBtDelSalle() {
		return btDelSalle;
	}

	public CinegoAdmin getCinego() {
		return cine;
	}

	public void clearsalles() {
		cbListSalles.removeAllItems();
	}

	public void clearcine() {
		cbListeCinemas.removeAllItems();
	}

	public String getTbNomCine() {
		return tbNomCine.getText();
	}

	public void setTbNomCine(String tbNomCine) {
		this.tbNomCine.setText(tbNomCine);
	}

	public String getTbTarif3dCine() {
		return tbTarif3dCine.getText();
	}

	public void setTbTarif3dCine(String tbTarif3dCine) {
		this.tbTarif3dCine.setText(tbTarif3dCine);
	}

	public String getTbTarifNormalCine() {
		return tbTarifNormalCine.getText();
	}

	public void setTbTarifNormalCine(String tbTarifNormalCine) {
		this.tbTarifNormalCine.setText(tbTarifNormalCine);
	}

	public String getTbTarifEtudiantCine() {
		return tbTarifEtudiantCine.getText();
	}

	public void setTbTarifEtudiantCine(String tbTarifEtudiantCine) {
		this.tbTarifEtudiantCine.setText(tbTarifEtudiantCine);
	}

	public String getTbNbSalleCine() {
		return tbNbSalleCine.getText();
	}

	public void setTbNbSalleCine(String tbNbSalleCine) {
		this.tbNbSalleCine.setText(tbNbSalleCine);
	}

	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public JButton getBtUpdateCinema() {
		return btUpdateCinema;
	}

	public JButton getBtDelCinema() {
		return btDelCinema;
	}

	public int getIdCine() {
		return idCine;
	}

	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}

}
