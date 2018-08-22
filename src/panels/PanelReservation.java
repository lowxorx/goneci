package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import events.EvePanelReservation;
import metier.Film;
import vue.PagePrincipale;

@SuppressWarnings("serial")
public class PanelReservation extends JPanel {

	private PagePrincipale pgPrinc;
	private JLabel imageFilm;
	private JLabel nomFilm;
	private JTextPane txtpnSynopsys;
	private JComboBox<Film> HeureSéance;
	private JComboBox<Film> DateSeance;
	private JButton btnReservation;
	private int idFilm;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private DefaultComboBoxModel defo = new DefaultComboBoxModel(new Date[] {});
	private EvePanelReservation evePanelReservation;
	private JSpinner spinnerNbPlace;
	private JLabel lblDate;
	private JLabel lblSanceDe;
	private JLabel lblNombreDePlaces;
	private JButton btnRetour;
	private JLabel lblVersion;
	private JLabel lblVersionTxt;
	private JCheckBox chckbxis3d;
	private Image img;
	ImageObserver imageObserver;

	@SuppressWarnings("unchecked")
	public PanelReservation(PagePrincipale pagePrincipale) {

		this.pgPrinc = pagePrincipale;

		// img = Toolkit.getDefaultToolkit().createImage("pel.jpg");

		ImageIcon icon = new ImageIcon("maxresdefault.jpg");
		img = icon.getImage();
		imageObserver = icon.getImageObserver();

		Font font = new Font("Arial", Font.BOLD, 16);
		imageFilm = new JLabel("affiche");
		imageFilm.setBounds(31, 168, 334, 566);
		imageFilm.setToolTipText("");

		nomFilm = new JLabel("NomFilm");
		nomFilm.setForeground(Color.WHITE);
		nomFilm.setHorizontalAlignment(SwingConstants.CENTER);
		nomFilm.setBounds(375, 185, 618, 20);
		nomFilm.setFont(font);

		txtpnSynopsys = new JTextPane();
		txtpnSynopsys.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnSynopsys.setBounds(588, 259, 844, 144);
		txtpnSynopsys.setText("synopsys");

		HeureSéance = new JComboBox<Film>();
		HeureSéance.setBounds(786, 505, 178, 29);
		HeureSéance.setFont(font);

		DateSeance = new JComboBox<Film>(defo);
		DateSeance.setBounds(786, 434, 178, 30);
		DateSeance.setFont(font);

		btnReservation = new JButton("Reservez");
		btnReservation.setBounds(1141, 724, 144, 58);
		btnReservation.setFont(font);

		evePanelReservation = new EvePanelReservation(this);

		HeureSéance.addActionListener(evePanelReservation);
		DateSeance.addActionListener(evePanelReservation);
		btnReservation.addActionListener(evePanelReservation);

		spinnerNbPlace = new JSpinner();
		spinnerNbPlace.setBounds(1200, 507, 85, 25);
		spinnerNbPlace.setFont(font);

		setLayout(null);
		add(imageFilm);
		add(nomFilm);
		add(txtpnSynopsys);
		add(DateSeance);
		add(HeureSéance);
		add(btnReservation);
		add(spinnerNbPlace);

		lblDate = new JLabel("Date :");
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(588, 441, 64, 17);
		lblDate.setFont(font);
		add(lblDate);

		lblSanceDe = new JLabel("Séance :");
		lblSanceDe.setForeground(Color.WHITE);
		lblSanceDe.setBounds(588, 512, 106, 14);
		lblSanceDe.setFont(font);

		add(lblSanceDe);

		lblNombreDePlaces = new JLabel("Nombre de places :");
		lblNombreDePlaces.setForeground(Color.WHITE);
		lblNombreDePlaces.setBounds(1004, 512, 155, 15);
		lblNombreDePlaces.setFont(font);

		add(lblNombreDePlaces);

		btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Arial", Font.BOLD, 16));
		btnRetour.setBounds(855, 724, 144, 58);
		btnRetour.addActionListener(evePanelReservation);
		add(btnRetour);

		lblVersion = new JLabel("Version :");
		lblVersion.setForeground(Color.WHITE);
		lblVersion.setFont(new Font("Arial", Font.BOLD, 16));
		lblVersion.setBounds(1004, 441, 85, 17);
		add(lblVersion);

		lblVersionTxt = new JLabel("Version ");
		lblVersionTxt.setForeground(Color.WHITE);
		lblVersionTxt.setFont(new Font("Arial", Font.BOLD, 16));
		lblVersionTxt.setBounds(1200, 441, 85, 17);
		add(lblVersionTxt);

		chckbxis3d = new JCheckBox("Film en 3d");
		chckbxis3d.setForeground(Color.WHITE);
		chckbxis3d.setBounds(1093, 605, 192, 23);
		chckbxis3d.setFont(font);
		add(chckbxis3d);

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), imageObserver);
		setOpaque(false);
		super.paint(g);
		setOpaque(true);
	}

	@SuppressWarnings("rawtypes")
	public DefaultComboBoxModel getDefo() {
		return defo;
	}

	@SuppressWarnings("unchecked")
	public void setDefo(Date date) {
		if (defo.getIndexOf(date) == -1) {

			defo.addElement(date);

		}
	}

	public PagePrincipale getPgPrinc() {
		return pgPrinc;
	}

	public void setPgPrinc(PagePrincipale pgPrinc) {
		this.pgPrinc = pgPrinc;
	}

	public JLabel getImageFilm() {
		return imageFilm;
	}

	public void setImageFilm(JLabel imageFilm) {
		this.imageFilm = imageFilm;
	}

	public JLabel getNomFilm() {
		return nomFilm;
	}

	public void setNomFilm(JLabel nomFilm) {
		this.nomFilm = nomFilm;
	}

	public JTextPane getTextPane() {
		return txtpnSynopsys;
	}

	public void setTextPane(JTextPane textPane) {
		this.txtpnSynopsys = textPane;
	}

	public JButton getBtnReservation() {
		return btnReservation;
	}

	public void setBtnReservation(JButton btnReservation) {
		this.btnReservation = btnReservation;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getHeureSéance() {
		return HeureSéance;
	}

	@SuppressWarnings("unchecked")
	public void setHeureSéance(@SuppressWarnings("rawtypes") JComboBox heureSéance) {
		HeureSéance = heureSéance;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getDateSeance() {
		return DateSeance;
	}

	@SuppressWarnings("unchecked")
	public void setDateSeance(@SuppressWarnings("rawtypes") JComboBox dateSeance) {
		DateSeance = dateSeance;
	}

	public int getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	public JSpinner getSpinnerNbPlace() {
		return spinnerNbPlace;
	}

	public void setSpinnerNbPlace(JSpinner spinnerNbPlace) {
		this.spinnerNbPlace = spinnerNbPlace;
	}

	public JButton getBtnRetour() {
		return btnRetour;
	}

	public void setBtnRetour(JButton btnRetour) {
		this.btnRetour = btnRetour;
	}

	public EvePanelReservation getEvePanelReservation() {
		return evePanelReservation;
	}

	public void setEvePanelReservation(EvePanelReservation evePanelReservation) {
		this.evePanelReservation = evePanelReservation;
	}

	public JLabel getLblDate() {
		return lblDate;
	}

	public void setLblDate(JLabel lblDate) {
		this.lblDate = lblDate;
	}

	public JLabel getLblSanceDe() {
		return lblSanceDe;
	}

	public void setLblSanceDe(JLabel lblSanceDe) {
		this.lblSanceDe = lblSanceDe;
	}

	public JLabel getLblNombreDePlaces() {
		return lblNombreDePlaces;
	}

	public void setLblNombreDePlaces(JLabel lblNombreDePlaces) {
		this.lblNombreDePlaces = lblNombreDePlaces;
	}

	public JLabel getLblVersion() {
		return lblVersion;
	}

	public void setLblVersion(JLabel lblVersion) {
		this.lblVersion = lblVersion;
	}

	public JLabel getLblVersionTxt() {
		return lblVersionTxt;
	}

	public void setLblVersionTxt(JLabel lblVersionTxt) {
		this.lblVersionTxt = lblVersionTxt;
	}

	public JCheckBox getChckbxis3d() {
		return chckbxis3d;
	}

	public void setChckbxis3d(JCheckBox chckbxis3d) {
		this.chckbxis3d = chckbxis3d;
	}

	public void setDefo(@SuppressWarnings("rawtypes") DefaultComboBoxModel defo) {
		this.defo = defo;
	}

}
