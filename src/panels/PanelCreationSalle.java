package panels;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import appli.CinegoAdmin;
import events.EvtCreationSalle;
import metier.Materiel;

public class PanelCreationSalle extends JPanel {

	CinegoAdmin cine;

	private static final long serialVersionUID = 1L;
	private JTextField tbNomSalle;
	private JTextField tbNbRangees;
	private JTextField tbNbPlaces;
	private JTextField tbNbPlacesH;
	private JTextField tbNumSalle;
	private JComboBox<Materiel> cdTypeSon;
	private JComboBox<Materiel> cbTypeEcran;
	@SuppressWarnings("rawtypes")
	private JComboBox cbCineRattachement;
	private JButton btCreerSalle;
	private JButton btRetour;
	private JButton btExportSalle;
	private JButton btResetFields;

	@SuppressWarnings("rawtypes")
	public PanelCreationSalle(CinegoAdmin cinego) {
		this.cine = cinego;
		EvtCreationSalle event = new EvtCreationSalle(this);

		JLabel lblCrerUneNouvelle = new JLabel("Créer une nouvelle salle");
		lblCrerUneNouvelle.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCrerUneNouvelle.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSpcifiezLesParamtres = new JLabel("Spécifiez les paramètres de la salle :");
		lblSpcifiezLesParamtres.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblSpcifiezLesParamtres.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNomDeLa = new JLabel("Nom de la salle :");
		lblNomDeLa.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNombreDeRanges = new JLabel("Nombre de rangées :");
		lblNombreDeRanges.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNombreDePlaces = new JLabel("Nombre de places total :");
		lblNombreDePlaces.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNombreDePlaces_1 = new JLabel("Nombre de places handicapés :");
		lblNombreDePlaces_1.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTypeDeSon = new JLabel("Type de son :");
		lblTypeDeSon.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTypeDcran = new JLabel("Type d'écran :");
		lblTypeDcran.setHorizontalAlignment(SwingConstants.RIGHT);

		tbNomSalle = new JTextField();
		tbNomSalle.setColumns(10);

		tbNbRangees = new JTextField();
		tbNbRangees.setColumns(10);

		tbNbPlaces = new JTextField();
		tbNbPlaces.setColumns(10);

		tbNbPlacesH = new JTextField();
		tbNbPlacesH.setColumns(10);

		cdTypeSon = new JComboBox<Materiel>();

		cbTypeEcran = new JComboBox<Materiel>();

		cbCineRattachement = new JComboBox();

		btCreerSalle = new JButton("Créer une salle");

		btRetour = new JButton("Retour");

		btResetFields = new JButton("Réinitialiser les champs");

		JLabel lblNumroDeLa = new JLabel("Numéro de la salle :");
		lblNumroDeLa.setHorizontalAlignment(SwingConstants.RIGHT);

		tbNumSalle = new JTextField();
		tbNumSalle.setColumns(10);

		JLabel lblCinmaDeRattachement = new JLabel("Cinéma de rattachement :");
		lblCinmaDeRattachement.setHorizontalAlignment(SwingConstants.RIGHT);

		btExportSalle = new JButton("Exporter en XML");

		// Action listeners

		btRetour.addActionListener(event);
		btCreerSalle.addActionListener(event);
		btResetFields.addActionListener(event);
		btExportSalle.addActionListener(event);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblCrerUneNouvelle,
						GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE))
				.addComponent(lblSpcifiezLesParamtres, GroupLayout.PREFERRED_SIZE, 790, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup().addGap(86)
						.addComponent(lblCinmaDeRattachement, GroupLayout.PREFERRED_SIZE, 272,
								GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addComponent(cbCineRattachement, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(86)
						.addComponent(lblNomDeLa, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addComponent(tbNomSalle, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(86)
						.addComponent(lblNumroDeLa, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addComponent(tbNumSalle, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(
						groupLayout.createSequentialGroup().addGap(86)
								.addComponent(lblNombreDeRanges, GroupLayout.PREFERRED_SIZE, 272,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(tbNbRangees, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(
						groupLayout.createSequentialGroup().addGap(86)
								.addComponent(lblNombreDePlaces, GroupLayout.PREFERRED_SIZE, 272,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(tbNbPlaces, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(
						groupLayout.createSequentialGroup().addGap(96)
								.addComponent(lblNombreDePlaces_1, GroupLayout.PREFERRED_SIZE, 262,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(tbNbPlacesH, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(106)
						.addComponent(lblTypeDeSon, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addComponent(cdTypeSon, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(116)
						.addComponent(lblTypeDcran, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addComponent(cbTypeEcran, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(384).addComponent(btCreerSalle,
						GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(384).addComponent(btResetFields,
						GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(384).addComponent(btExportSalle,
						GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(btRetour,
						GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(11)
								.addComponent(lblCrerUneNouvelle, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addGap(70)
								.addComponent(lblSpcifiezLesParamtres, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(3)
												.addComponent(lblCinmaDeRattachement))
										.addComponent(cbCineRattachement, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout.createSequentialGroup().addGap(3).addComponent(lblNomDeLa))
										.addComponent(tbNomSalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(3)
												.addComponent(lblNumroDeLa))
										.addComponent(tbNumSalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(3)
												.addComponent(lblNombreDeRanges))
										.addComponent(tbNbRangees, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(3)
												.addComponent(lblNombreDePlaces))
										.addComponent(tbNbPlaces, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(3)
												.addComponent(lblNombreDePlaces_1))
										.addComponent(tbNbPlacesH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(3)
												.addComponent(lblTypeDeSon))
										.addComponent(cdTypeSon, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(3)
												.addComponent(lblTypeDcran))
										.addComponent(cbTypeEcran, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addGap(20).addComponent(btCreerSalle).addGap(11).addComponent(btResetFields).addGap(11)
								.addComponent(btExportSalle).addGap(52).addComponent(btRetour)));
		setLayout(groupLayout);

	}

	public String getTbNomSalle() {
		return tbNomSalle.getText();
	}

	public void setTbNomSalle(String tbNomSalle) {
		this.tbNomSalle.setText(tbNomSalle);
	}

	public String getTbNbRangees() {
		return tbNbRangees.getText();
	}

	public void setTbNbRangees(String tbNbRangees) {
		this.tbNbRangees.setText(tbNbRangees);
	}

	public String getTbNbPlaces() {
		return tbNbPlaces.getText();
	}

	public void setTbNbPlaces(String tbNbPlaces) {
		this.tbNbPlaces.setText(tbNbPlaces);
	}

	public String getTbNbPlacesH() {
		return tbNbPlacesH.getText();
	}

	public void setTbNbPlacesH(String tbNbPlacesH) {
		this.tbNbPlacesH.setText(tbNbPlacesH);
	}

	public String getTbNumSalle() {
		return tbNumSalle.getText();
	}

	public void setTbNumSalle(String tbNumSalle) {
		this.tbNumSalle.setText(tbNumSalle);
	}

	public String getSelectedTypeSon() {
		return cdTypeSon.getSelectedItem().toString();
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCdTypeSon() {
		return cdTypeSon;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbTypeEcran() {
		return cbTypeEcran;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbCineRattachement() {
		return cbCineRattachement;
	}

	public void setCdTypeSon(Materiel cdTypeSon) {
		this.cdTypeSon.addItem(cdTypeSon);
	}

	public String getSelectedTypeEcran() {
		return cbTypeEcran.getSelectedItem().toString();
	}

	public void setCbTypeEcran(Materiel cbTypeEcran) {
		this.cbTypeEcran.addItem(cbTypeEcran);
	}

	public String getSelectedCineR() {
		return cbCineRattachement.getSelectedItem().toString();
	}

	@SuppressWarnings("unchecked")
	public void setCbCineRattachement(String cbCineRattachement) {
		this.cbCineRattachement.addItem(cbCineRattachement);
	}

	public CinegoAdmin getCinego() {
		return cine;
	}

	public JButton getBtCreerSalle() {
		return btCreerSalle;
	}

	public JButton getBtRetour() {
		return btRetour;
	}

	public JButton getBtResetFields() {
		return btResetFields;
	}

	public JButton getBtExportSalle() {
		return btExportSalle;
	}

}
