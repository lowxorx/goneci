package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import events.EvePanelChangementReservation;
import metier.Reservation;
import vue.PagePrincipale;

@SuppressWarnings("serial")
public class PanelChangementReservation extends JPanel {

	private PagePrincipale pgPrinc;

	private JLabel lblImageFilm;
	private JTextPane txtpnSynopsys;
	private JLabel lblNomFilm;
	private JButton btnRemboursement;
	private JLabel lblNbDePlaces;
	private JLabel lblDebutSeance;
	private JLabel lblDateSéance;
	private JLabel lblDateReservation;
	private JLabel lblHeureseance;
	private JLabel lblNbdeplaces;
	private Reservation réservationEnCours;
	private EvePanelChangementReservation evePanelChangementReservation;
	private JLabel lblNonModification;
	private JButton btnRetour;
	private JLabel lblVersion;
	private JLabel lblVersiontxt;
	private JCheckBox chckbx3D;
	private Image img;
	ImageObserver imageObserver;

	public PanelChangementReservation(PagePrincipale pgPrincipale) {

		this.pgPrinc = pgPrincipale;

		Font font = new Font("Arial", Font.BOLD, 16);

		lblImageFilm = new JLabel("");
		lblImageFilm.setBounds(86, 244, 462, 558);
		lblImageFilm.setToolTipText("");

		ImageIcon icon = new ImageIcon("maxresdefault.jpg");
		img = icon.getImage();
		imageObserver = icon.getImageObserver();

		// img = Toolkit.getDefaultToolkit().createImage("pel.jpg");

		txtpnSynopsys = new JTextPane();
		txtpnSynopsys.setBounds(820, 279, 515, 140);
		txtpnSynopsys.setText("Ici ce situe le sysnopsys du film et c'est pas mal ce sera assez grand toussa");

		lblNomFilm = new JLabel("NomFilm");
		lblNomFilm.setForeground(Color.WHITE);
		lblNomFilm.setBounds(820, 206, 139, 23);
		lblNomFilm.setFont(font);
		lblNomFilm.setHorizontalAlignment(SwingConstants.CENTER);

		btnRemboursement = new JButton("Remboursement");
		btnRemboursement.setFont(new Font("Arial", Font.BOLD, 16));
		btnRemboursement.setBounds(1170, 738, 165, 64);
		btnRemboursement.setPreferredSize(new Dimension(250, 100));

		evePanelChangementReservation = new EvePanelChangementReservation(this);
		btnRemboursement.addActionListener(evePanelChangementReservation);

		setLayout(null);
		add(lblImageFilm);
		add(txtpnSynopsys);
		add(btnRemboursement);
		add(lblNomFilm);

		lblNbDePlaces = new JLabel("Nombre de places :");
		lblNbDePlaces.setForeground(Color.WHITE);
		lblNbDePlaces.setBounds(820, 543, 207, 14);
		lblNbDePlaces.setHorizontalAlignment(SwingConstants.LEFT);
		lblNbDePlaces.setFont(font);
		add(lblNbDePlaces);

		lblDebutSeance = new JLabel("Séance de :");
		lblDebutSeance.setForeground(Color.WHITE);
		lblDebutSeance.setBounds(820, 492, 96, 14);
		lblDebutSeance.setHorizontalAlignment(SwingConstants.LEFT);
		lblDebutSeance.setFont(font);
		add(lblDebutSeance);

		lblDateSéance = new JLabel("Date :");
		lblDateSéance.setForeground(Color.WHITE);
		lblDateSéance.setBounds(820, 445, 54, 14);
		lblDateSéance.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateSéance.setFont(font);
		add(lblDateSéance);

		lblDateReservation = new JLabel("DateReservation");
		lblDateReservation.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateReservation.setForeground(Color.WHITE);
		lblDateReservation.setBounds(1122, 445, 146, 14);
		lblDateReservation.setFont(font);
		add(lblDateReservation);

		lblHeureseance = new JLabel("HeureSeance");
		lblHeureseance.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeureseance.setForeground(Color.WHITE);
		lblHeureseance.setBounds(1122, 492, 195, 14);
		lblHeureseance.setFont(font);
		add(lblHeureseance);

		lblNbdeplaces = new JLabel("nbDePlaces");
		lblNbdeplaces.setHorizontalAlignment(SwingConstants.LEFT);
		lblNbdeplaces.setForeground(Color.WHITE);
		lblNbdeplaces.setBounds(1128, 543, 189, 14);
		lblNbdeplaces.setFont(font);
		add(lblNbdeplaces);

		lblNonModification = new JLabel("Vous ne pouvez plus modifiez cette réservation");
		lblNonModification.setForeground(Color.WHITE);
		lblNonModification.setBounds(862, 681, 462, 23);
		lblNonModification.setFont(font);
		add(lblNonModification);

		btnRetour = new JButton("Retour");
		btnRetour.setPreferredSize(new Dimension(250, 100));
		btnRetour.setBounds(862, 738, 165, 64);
		btnRetour.setFont(font);
		add(btnRetour);

		lblVersion = new JLabel("Version : ");
		lblVersion.setForeground(Color.WHITE);
		lblVersion.setHorizontalAlignment(SwingConstants.LEFT);
		lblVersion.setFont(new Font("Arial", Font.BOLD, 16));
		lblVersion.setBounds(1000, 601, 207, 14);
		lblVersion.setFont(font);
		add(lblVersion);

		lblVersiontxt = new JLabel("Versiontxt");
		lblVersiontxt.setForeground(Color.WHITE);
		lblVersiontxt.setHorizontalAlignment(SwingConstants.LEFT);
		lblVersiontxt.setFont(new Font("Arial", Font.BOLD, 16));
		lblVersiontxt.setBounds(1128, 601, 207, 14);
		lblVersiontxt.setFont(font);
		lblVersiontxt.setBackground(Color.BLACK);
		add(lblVersiontxt);

		chckbx3D = new JCheckBox("Séance en 3d");
		chckbx3D.setForeground(Color.WHITE);
		chckbx3D.setBounds(820, 597, 139, 23);
		chckbx3D.setFont(font);
		add(chckbx3D);
		btnRetour.addActionListener(evePanelChangementReservation);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), imageObserver);
		setOpaque(false);
		super.paint(g);
		setOpaque(true);
	}

	public PagePrincipale getPgPrinc() {
		return pgPrinc;
	}

	public void setPgPrinc(PagePrincipale pgPrinc) {
		this.pgPrinc = pgPrinc;
	}

	public JLabel getLblImageFilm() {
		return lblImageFilm;
	}

	public void setLblImageFilm(JLabel lblImageFilm) {
		this.lblImageFilm = lblImageFilm;
	}

	public JTextPane getTxtpnSynopsys() {
		return txtpnSynopsys;
	}

	public void setTxtpnSynopsys(JTextPane txtpnSynopsys) {
		this.txtpnSynopsys = txtpnSynopsys;
	}

	public JLabel getLblNomFilm() {
		return lblNomFilm;
	}

	public void setLblNomFilm(JLabel lblNomFilm) {
		this.lblNomFilm = lblNomFilm;
	}

	public JButton getBtnRemboursement() {
		return btnRemboursement;
	}

	public void setBtnRemboursement(JButton btnRemboursement) {
		this.btnRemboursement = btnRemboursement;
	}

	public JLabel getLblNbDePlaces() {
		return lblNbDePlaces;
	}

	public void setLblNbDePlaces(JLabel lblNbDePlaces) {
		this.lblNbDePlaces = lblNbDePlaces;
	}

	public JLabel getLblDebutSeance() {
		return lblDebutSeance;
	}

	public void setLblDebutSeance(JLabel lblDebutSeance) {
		this.lblDebutSeance = lblDebutSeance;
	}

	public JLabel getLblDateSéance() {
		return lblDateSéance;
	}

	public void setLblDateSéance(JLabel lblDateSéance) {
		this.lblDateSéance = lblDateSéance;
	}

	public JLabel getLblDateReservation() {
		return lblDateReservation;
	}

	public void setLblDateReservation(JLabel lblDateReservation) {
		this.lblDateReservation = lblDateReservation;
	}

	public JLabel getLblHeureseance() {
		return lblHeureseance;
	}

	public void setLblHeureseance(JLabel lblHeureseance) {
		this.lblHeureseance = lblHeureseance;
	}

	public JLabel getLblNbdeplaces() {
		return lblNbdeplaces;
	}

	public void setLblNbdeplaces(JLabel lblNbdeplaces) {
		this.lblNbdeplaces = lblNbdeplaces;
	}

	public Reservation getRéservationEnCours() {
		return réservationEnCours;
	}

	public void setRéservationEnCours(Reservation réservationEnCours) {
		this.réservationEnCours = réservationEnCours;
	}

	public JLabel getLblNonModification() {
		return lblNonModification;
	}

	public void setLblNonModification(JLabel lblNonModification) {
		this.lblNonModification = lblNonModification;
	}

	public JButton getBtnRetour() {
		return btnRetour;
	}

	public void setBtnRetour(JButton btnRetour) {
		this.btnRetour = btnRetour;
	}

	public JLabel getLblVersion() {
		return lblVersion;
	}

	public void setLblVersion(JLabel lblVersion) {
		this.lblVersion = lblVersion;
	}

	public JLabel getLblVersiontxt() {
		return lblVersiontxt;
	}

	public void setLblVersiontxt(JLabel lblVersiontxt) {
		this.lblVersiontxt = lblVersiontxt;
	}

	public JCheckBox getChckbx3D() {
		return chckbx3D;
	}

	public void setChckbx3D(JCheckBox chckbx3d) {
		chckbx3D = chckbx3d;
	}

}
