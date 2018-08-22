package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import events.EvePanelPaiementReservation;
import metier.Séance;
import metier.Utilisateur;
import vue.PagePrincipale;

public class PanelPaiementReservation extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Séance séanceEnCoursDeReservation;
	private Utilisateur utilisateur;
	private int nbDePlaces;
	private int prix;

	private JLabel lblRcapitulatif;
	private JLabel lblNomFilm;
	private JLabel lblHeureDebut;
	private JLabel lblSalle;
	private JLabel lblNomPrénom;
	private JButton btnValiderReservation;
	private JLabel lblNbDePlaces;
	private JLabel lblPrix;
	private EvePanelPaiementReservation evePaiementReservation;
	private Image img;
	ImageObserver imageObserver;

	private PagePrincipale pgPrincipale;

	public PanelPaiementReservation(PagePrincipale pagePrincipale) {

		this.pgPrincipale = pagePrincipale;

		Font font = new Font("Arial", Font.BOLD, 16);

		// img = Toolkit.getDefaultToolkit().createImage("pel.jpg");

		ImageIcon icon = new ImageIcon("maxresdefault.jpg");
		img = icon.getImage();
		imageObserver = icon.getImageObserver();

		lblRcapitulatif = new JLabel("Récapitulatif de votre Réservation ");
		lblRcapitulatif.setHorizontalAlignment(SwingConstants.CENTER);
		lblRcapitulatif.setForeground(Color.WHITE);
		lblRcapitulatif.setFont(font);

		lblNomFilm = new JLabel("nomFilm");
		lblNomFilm.setForeground(Color.WHITE);
		lblNomFilm.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomFilm.setFont(font);

		lblHeureDebut = new JLabel("HeureDebut");
		lblHeureDebut.setForeground(Color.WHITE);
		lblHeureDebut.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeureDebut.setFont(font);

		lblSalle = new JLabel("Salle Numéro");
		lblSalle.setForeground(Color.WHITE);
		lblSalle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalle.setFont(font);

		lblNomPrénom = new JLabel("nomPrenom");
		lblNomPrénom.setForeground(Color.WHITE);
		lblNomPrénom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomPrénom.setFont(font);

		btnValiderReservation = new JButton("Valider");
		btnValiderReservation.setFont(font);

		lblNbDePlaces = new JLabel("NombreDePlaces");
		lblNbDePlaces.setForeground(Color.WHITE);
		lblNbDePlaces.setHorizontalAlignment(SwingConstants.CENTER);
		lblNbDePlaces.setFont(font);

		lblPrix = new JLabel("Prix");
		lblPrix.setForeground(Color.WHITE);
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setFont(font);

		evePaiementReservation = new EvePanelPaiementReservation(this);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(370)
						.addComponent(lblRcapitulatif, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE).addGap(369))
				.addGroup(groupLayout.createSequentialGroup().addGap(370)
						.addComponent(lblNomPrénom, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE).addGap(369))
				.addGroup(groupLayout.createSequentialGroup().addGap(370)
						.addComponent(lblNomFilm, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE).addGap(369))
				.addGroup(groupLayout.createSequentialGroup().addGap(370)
						.addComponent(lblHeureDebut, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE).addGap(369))
				.addGroup(groupLayout.createSequentialGroup().addGap(370)
						.addComponent(lblSalle, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE).addGap(369))
				.addGroup(groupLayout.createSequentialGroup().addGap(370)
						.addComponent(lblNbDePlaces, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE).addGap(369))
				.addGroup(groupLayout.createSequentialGroup().addGap(370)
						.addComponent(lblPrix, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE).addGap(369))
				.addGroup(groupLayout.createSequentialGroup().addGap(414).addComponent(btnValiderReservation,
						GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)));
		groupLayout
				.setVerticalGroup(
						groupLayout
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addGap(94)
												.addComponent(lblRcapitulatif, GroupLayout.DEFAULT_SIZE, 31,
														Short.MAX_VALUE)
												.addGap(32)
												.addComponent(lblNomPrénom, GroupLayout.DEFAULT_SIZE, 24,
														Short.MAX_VALUE)
												.addGap(40)
												.addComponent(lblNomFilm, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
												.addGap(48)
												.addComponent(lblHeureDebut, GroupLayout.PREFERRED_SIZE, 14,
														Short.MAX_VALUE)
												.addGap(54)
												.addComponent(lblSalle, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
												.addGap(50)
												.addComponent(lblNbDePlaces, GroupLayout.PREFERRED_SIZE, 14,
														Short.MAX_VALUE)
												.addGap(68)
												.addComponent(lblPrix, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
												.addGap(44).addComponent(btnValiderReservation,
														GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
												.addGap(97)));
		setLayout(groupLayout);

		btnValiderReservation.addActionListener(evePaiementReservation);

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), imageObserver);
		setOpaque(false);
		super.paint(g);
		setOpaque(true);
	}

	public Séance getSéanceEnCoursDeReservation() {
		return séanceEnCoursDeReservation;
	}

	public void setSéanceEnCoursDeReservation(Séance séanceEnCoursDeReservation) {
		this.séanceEnCoursDeReservation = séanceEnCoursDeReservation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getNbDePlaces() {
		return nbDePlaces;
	}

	public void setNbDePlaces(int nbDePlaces) {
		this.nbDePlaces = nbDePlaces;
	}

	public PagePrincipale getPgPrincipale() {
		return pgPrincipale;
	}

	public void setPgPrincipale(PagePrincipale pgPrincipale) {
		this.pgPrincipale = pgPrincipale;
	}

	public JLabel getLblRcapitulatif() {
		return lblRcapitulatif;
	}

	public void setLblRcapitulatif(JLabel lblRcapitulatif) {
		this.lblRcapitulatif = lblRcapitulatif;
	}

	public JLabel getLblNomFilm() {
		return lblNomFilm;
	}

	public void setLblNomFilm(JLabel lblNomFilm) {
		this.lblNomFilm = lblNomFilm;
	}

	public JLabel getLblHeureDebut() {
		return lblHeureDebut;
	}

	public void setLblHeureDebut(JLabel lblHeureDebut) {
		this.lblHeureDebut = lblHeureDebut;
	}

	public JLabel getLblSalle() {
		return lblSalle;
	}

	public void setLblSalle(JLabel lblSalle) {
		this.lblSalle = lblSalle;
	}

	public JLabel getLblNomPrénom() {
		return lblNomPrénom;
	}

	public void setLblNomPrénom(JLabel lblNomPrénom) {
		this.lblNomPrénom = lblNomPrénom;
	}

	public JButton getBtnValiderReservation() {
		return btnValiderReservation;
	}

	public void setBtnValiderReservation(JButton btnValiderReservation) {
		this.btnValiderReservation = btnValiderReservation;
	}

	public JLabel getLblNbDePlaces() {
		return lblNbDePlaces;
	}

	public void setLblNbDePlaces(JLabel lblNbDePlaces) {
		this.lblNbDePlaces = lblNbDePlaces;
	}

	public JLabel getLblPrix() {
		return lblPrix;
	}

	public void setLblPrix(JLabel lblPrix) {
		this.lblPrix = lblPrix;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

}
