package panels;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import appli.CinegoAdmin;
import events.EvtImportSalle;

public class PanelImportSalle extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CinegoAdmin cine;

	private JTextField tbSelectXml;
	private JButton btParcourir;
	private JButton btImporter;
	private JButton btRetour;
	private JButton btValider;

	private JTextField tbCineRattach;
	private JTextField tbNomSalle;
	private JTextField tbNumSalle;
	private JTextField tbNbRangees;
	private JTextField tbNbPlaces;
	private JTextField tbNbPlacesH;
	private JTextField tbTypeSon;
	private JTextField tbTypeEcran;

	public PanelImportSalle(CinegoAdmin cinego) {
		this.cine = cinego;
		EvtImportSalle event = new EvtImportSalle(this);

		JLabel lblImporterUneSalle = new JLabel("Importer une salle");
		lblImporterUneSalle.setFont(new Font("Dialog", Font.BOLD, 18));
		lblImporterUneSalle.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSlectionnerUnFichier = new JLabel("Sélectionner un fichier XML :");
		lblSlectionnerUnFichier.setFont(new Font("Dialog", Font.PLAIN, 15));

		tbSelectXml = new JTextField();
		tbSelectXml.setText("Cliquez sur \"Parcourir\" pour sélectionner un fichier...");
		tbSelectXml.setColumns(10);

		btParcourir = new JButton("Parcourir");

		btImporter = new JButton("Importer");
		btImporter.setEnabled(false);

		btRetour = new JButton("Retour");

		JLabel lblCinmaDeRattachement = new JLabel("Cinéma de rattachement :");
		lblCinmaDeRattachement.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNomDeLa = new JLabel("Nom de la salle : ");
		lblNomDeLa.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNumroDeLa = new JLabel("Numéro de la salle :");
		lblNumroDeLa.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNombreDeRanges = new JLabel("Nombre de rangées :");
		lblNombreDeRanges.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNombreDePlaces = new JLabel("Nombre de places (total) :");
		lblNombreDePlaces.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNombreDePlaces_1 = new JLabel("Nombre de places handicapés :");
		lblNombreDePlaces_1.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTypeDeSon = new JLabel("Type de son :");
		lblTypeDeSon.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTypeDcran = new JLabel("Type d'écran :");
		lblTypeDcran.setHorizontalAlignment(SwingConstants.RIGHT);

		tbCineRattach = new JTextField();
		tbCineRattach.setColumns(10);

		tbNomSalle = new JTextField();
		tbNomSalle.setColumns(10);

		tbNumSalle = new JTextField();
		tbNumSalle.setColumns(10);

		tbNbRangees = new JTextField();
		tbNbRangees.setColumns(10);

		tbNbPlaces = new JTextField();
		tbNbPlaces.setColumns(10);

		tbNbPlacesH = new JTextField();
		tbNbPlacesH.setColumns(10);

		tbTypeSon = new JTextField();
		tbTypeSon.setColumns(10);

		tbTypeEcran = new JTextField();
		tbTypeEcran.setColumns(10);

		btValider = new JButton("Valider la salle");
		btValider.setEnabled(false);

		btParcourir.addActionListener(event);
		btImporter.addActionListener(event);
		btRetour.addActionListener(event);
		btValider.addActionListener(event);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblImporterUneSalle,
								GroupLayout.PREFERRED_SIZE, 790, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(95).addComponent(lblSlectionnerUnFichier))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(95)
										.addComponent(tbSelectXml, GroupLayout.PREFERRED_SIZE, 424,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btParcourir).addGap(18).addComponent(btImporter))
						.addGroup(groupLayout.createSequentialGroup().addGap(22)
								.addComponent(lblCinmaDeRattachement, GroupLayout.PREFERRED_SIZE, 325,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(tbCineRattach, GroupLayout.PREFERRED_SIZE, 166,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(22)
										.addComponent(lblNomDeLa, GroupLayout.PREFERRED_SIZE, 325,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(tbNomSalle, GroupLayout.PREFERRED_SIZE, 166,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(22)
										.addComponent(lblNumroDeLa, GroupLayout.PREFERRED_SIZE, 325,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(tbNumSalle, GroupLayout.PREFERRED_SIZE, 166,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(22)
								.addComponent(lblNombreDeRanges, GroupLayout.PREFERRED_SIZE, 325,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(tbNbRangees, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(22)
								.addComponent(lblNombreDePlaces, GroupLayout.PREFERRED_SIZE, 325,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(tbNbPlaces, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(22)
								.addComponent(lblNombreDePlaces_1, GroupLayout.PREFERRED_SIZE, 325,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(tbNbPlacesH, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(22)
										.addComponent(lblTypeDeSon, GroupLayout.PREFERRED_SIZE, 325,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(tbTypeSon, GroupLayout.PREFERRED_SIZE, 166,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(22)
										.addComponent(lblTypeDcran, GroupLayout.PREFERRED_SIZE, 325,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(tbTypeEcran, GroupLayout.PREFERRED_SIZE, 166,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(365).addComponent(btValider,
								GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(22).addComponent(btRetour,
								GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(11).addComponent(lblImporterUneSalle).addGap(42)
				.addComponent(lblSlectionnerUnFichier).addGap(12)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(tbSelectXml,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btParcourir).addComponent(btImporter))
				.addGap(47)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblCinmaDeRattachement))
						.addComponent(tbCineRattach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblNomDeLa))
						.addComponent(tbNomSalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblNumroDeLa))
						.addComponent(tbNumSalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblNombreDeRanges))
						.addComponent(tbNbRangees, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblNombreDePlaces))
						.addComponent(tbNbPlaces, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(21)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblNombreDePlaces_1))
						.addComponent(tbNbPlacesH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblTypeDeSon))
						.addComponent(tbTypeSon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblTypeDcran))
						.addComponent(tbTypeEcran, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btValider).addGap(30).addComponent(btRetour)));
		setLayout(groupLayout);

	}

	public JButton getBtRetour() {
		return btRetour;
	}

	public CinegoAdmin getCinego() {
		return cine;
	}

	public JButton getBtParcourir() {
		return btParcourir;
	}

	public JButton getBtImporter() {
		return btImporter;
	}

	public String getPath() {
		return tbSelectXml.getText();
	}

	public void setPath(String s) {
		tbSelectXml.setText(s);
	}

	public void setImportEnable(boolean b) {
		btImporter.setEnabled(b);
	}

	public void setValidEnable(boolean b) {
		btValider.setEnabled(b);
	}

	public String getTbCineRattach() {
		return tbCineRattach.getText();
	}

	public void setTbCineRattach(String tbCineRattach) {
		this.tbCineRattach.setText(tbCineRattach);
	}

	public String getTbNomSalle() {
		return tbNomSalle.getText();
	}

	public void setTbNomSalle(String tbNomSalle) {
		this.tbNomSalle.setText(tbNomSalle);
	}

	public String getTbNumSalle() {
		return tbNumSalle.getText();
	}

	public void setTbNumSalle(String tbNumSalle) {
		this.tbNumSalle.setText(tbNumSalle);
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

	public String getTbTypeSon() {
		return tbTypeSon.getText();
	}

	public void setTbTypeSon(String tbTypeSon) {
		this.tbTypeSon.setText(tbTypeSon);
	}

	public String getTbTypeEcran() {
		return tbTypeEcran.getText();
	}

	public void setTbTypeEcran(String tbTypeEcran) {
		this.tbTypeEcran.setText(tbTypeEcran);
	}

	public JButton getBtValider() {
		return btValider;
	}

}
