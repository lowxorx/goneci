package panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import events.EvePanelLoginReservation;
import metier.Séance;
import vue.PagePrincipale;

@SuppressWarnings("serial")
public class PanelLoginReservation extends JPanel {

	private Séance séanceEncours = new Séance();
	private int nbPlaces;

	private PagePrincipale pagePrincipale;
	private JButton btnConnexion;

	private EvePanelLoginReservation evePanelLoginReservation;
	private JLabel lblEntrezNumFi;
	private JTextField textFieldNumAbo;
	private JButton btnContinuerSansCompte;
	private JButton btnCreerUnCompte;
	private JLabel lblVousNtesPas;
	private JButton btnRetour;
	private Image img;
	ImageObserver imageObserver;

	public PanelLoginReservation(PagePrincipale pgPrinc) {

		this.pagePrincipale = pgPrinc;
		evePanelLoginReservation = new EvePanelLoginReservation(this);

		// img = Toolkit.getDefaultToolkit().createImage("pel.jpg");

		ImageIcon icon = new ImageIcon("maxresdefault.jpg");
		img = icon.getImage();
		imageObserver = icon.getImageObserver();

		Font font = new Font("Arial", Font.BOLD, 16);

		JLabel lblDejClient = new JLabel("Déjà Client?");
		lblDejClient.setForeground(Color.WHITE);
		lblDejClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblDejClient.setFont(font);

		btnConnexion = new JButton("Reservez");
		btnConnexion.addActionListener(evePanelLoginReservation);
		btnConnexion.setFont(font);

		lblEntrezNumFi = new JLabel("Entrez votre numéro fidélité !");
		lblEntrezNumFi.setForeground(Color.WHITE);
		lblEntrezNumFi.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrezNumFi.setFont(font);

		textFieldNumAbo = new JTextField();
		textFieldNumAbo.setFont(font);
		textFieldNumAbo.setColumns(10);

		Component horizontalStrut = Box.createHorizontalStrut(20);

		lblVousNtesPas = new JLabel("Vous n'êtes pas encore client ?");
		lblVousNtesPas.setForeground(Color.WHITE);
		lblVousNtesPas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVousNtesPas.setFont(font);

		btnCreerUnCompte = new JButton("Créer un compte !");
		btnCreerUnCompte.setFont(font);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);

		btnContinuerSansCompte = new JButton("Continuer sans compte !");
		btnContinuerSansCompte.setFont(font);

		btnRetour = new JButton("Retour");
		btnRetour.setFont(font);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(431)
						.addComponent(lblDejClient, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE).addGap(432))
				.addGroup(groupLayout.createSequentialGroup().addGap(384)
						.addComponent(lblEntrezNumFi, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE).addGap(384))
				.addGroup(groupLayout.createSequentialGroup().addGap(431)
						.addComponent(textFieldNumAbo, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE).addGap(432))
				.addGroup(groupLayout.createSequentialGroup().addGap(390)
						.addComponent(btnConnexion, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE).addGap(391))
				.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(horizontalStrut,
						GroupLayout.PREFERRED_SIZE, 1005, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(384)
						.addComponent(lblVousNtesPas, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE).addGap(384))
				.addGroup(groupLayout.createSequentialGroup().addGap(395)
						.addComponent(btnCreerUnCompte, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE).addGap(396))
				.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(horizontalStrut_1,
						GroupLayout.PREFERRED_SIZE, 1005, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(395)
						.addComponent(btnContinuerSansCompte, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addGap(396))
				.addGroup(groupLayout.createSequentialGroup().addGap(395)
						.addComponent(btnRetour, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE).addGap(396)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addGap(46)
												.addComponent(lblDejClient, GroupLayout.DEFAULT_SIZE, 19,
														Short.MAX_VALUE)
												.addGap(38)
												.addComponent(lblEntrezNumFi, GroupLayout.PREFERRED_SIZE, 14,
														Short.MAX_VALUE)
												.addGap(17)
												.addComponent(textFieldNumAbo, GroupLayout.DEFAULT_SIZE, 33,
														Short.MAX_VALUE)
												.addGap(11)
												.addComponent(btnConnexion, GroupLayout.DEFAULT_SIZE, 47,
														Short.MAX_VALUE)
												.addGap(25)
												.addComponent(horizontalStrut, GroupLayout.PREFERRED_SIZE, 12,
														GroupLayout.PREFERRED_SIZE)
												.addGap(20)
												.addComponent(lblVousNtesPas, GroupLayout.DEFAULT_SIZE, 19,
														Short.MAX_VALUE)
												.addGap(43)
												.addComponent(btnCreerUnCompte, GroupLayout.DEFAULT_SIZE, 47,
														Short.MAX_VALUE)
												.addGap(42)
												.addComponent(horizontalStrut_1, GroupLayout.PREFERRED_SIZE, 12,
														GroupLayout.PREFERRED_SIZE)
												.addGap(38)
												.addComponent(btnContinuerSansCompte, GroupLayout.DEFAULT_SIZE, 53,
														Short.MAX_VALUE)
												.addGap(55)
												.addComponent(btnRetour, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
												.addGap(79)));
		setLayout(groupLayout);

		btnConnexion.addActionListener(evePanelLoginReservation);
		btnContinuerSansCompte.addActionListener(evePanelLoginReservation);
		btnCreerUnCompte.addActionListener(evePanelLoginReservation);
		btnRetour.addActionListener(evePanelLoginReservation);

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), imageObserver);
		setOpaque(false);
		super.paint(g);
		setOpaque(true);
	}

	public Séance getSéanceEncours() {
		return séanceEncours;
	}

	public void setSéanceEncours(Séance séanceEncours) {
		this.séanceEncours = séanceEncours;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public PagePrincipale getPagePrincipale() {
		return pagePrincipale;
	}

	public void setPagePrincipale(PagePrincipale pagePrincipale) {
		this.pagePrincipale = pagePrincipale;
	}

	public JButton getBtnConnexion() {
		return btnConnexion;
	}

	public void setBtnConnexion(JButton btnConnexion) {
		this.btnConnexion = btnConnexion;
	}

	public EvePanelLoginReservation getEvePanelLoginReservation() {
		return evePanelLoginReservation;
	}

	public void setEvePanelLoginReservation(EvePanelLoginReservation evePanelLoginReservation) {
		this.evePanelLoginReservation = evePanelLoginReservation;
	}

	public JLabel getLblEntrezNumFi() {
		return lblEntrezNumFi;
	}

	public void setLblEntrezNumFi(JLabel lblEntrezNumFi) {
		this.lblEntrezNumFi = lblEntrezNumFi;
	}

	public JTextField getTextField() {
		return textFieldNumAbo;
	}

	public void setTextField(JTextField textField) {
		this.textFieldNumAbo = textField;
	}

	public JButton getBtnContinuerSansCompte() {
		return btnContinuerSansCompte;
	}

	public void setBtnContinuerSansCompte(JButton btnContinuerSansCompte) {
		this.btnContinuerSansCompte = btnContinuerSansCompte;
	}

	public JButton getBtnCreerUnCompte() {
		return btnCreerUnCompte;
	}

	public void setBtnCreerUnCompte(JButton btnCreerUnCompte) {
		this.btnCreerUnCompte = btnCreerUnCompte;
	}

	public JLabel getLblVousNtesPas() {
		return lblVousNtesPas;
	}

	public void setLblVousNtesPas(JLabel lblVousNtesPas) {
		this.lblVousNtesPas = lblVousNtesPas;
	}

	public JTextField getTextFieldNumAbo() {
		return textFieldNumAbo;
	}

	public void setTextFieldNumAbo(JTextField textFieldNumAbo) {
		this.textFieldNumAbo = textFieldNumAbo;
	}

	public JButton getBtnRetour() {
		return btnRetour;
	}

	public void setBtnRetour(JButton btnRetour) {
		this.btnRetour = btnRetour;
	}

}
