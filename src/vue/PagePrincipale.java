package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import metier.Cinema;
import panels.PanelBotCinego;
import panels.PanelChangementReservation;
import panels.PanelChoixFilm;
import panels.PanelConfirmationReservation;
import panels.PanelConnexionReservation;
import panels.PanelCreationClient;
import panels.PanelDemarrage;
import panels.PanelGaucheDroite;
import panels.PanelListReservation;
import panels.PanelLoginReservation;
import panels.PanelPaiementReservation;
import panels.PanelReservation;
import panels.PanelTopCinego;

public class PagePrincipale extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel cardLayoutContent;
	private JPanel borderLayout;
	private PanelTopCinego panelTop;
	private PanelBotCinego panelBot;
	private PanelGaucheDroite panelGauche;
	private PanelGaucheDroite panelDroite;
	private PanelDemarrage panelDem;
	private PanelChoixFilm panelChoixFilm;
	private PanelConnexionReservation panelConnexionReservation;
	private PanelListReservation panelListReservation;
	private PanelChangementReservation panelChangementReservation;
	private PanelReservation panelReservation;
	private PanelLoginReservation panelCoReservation;
	private PanelPaiementReservation panelPaiementReservation;
	private PanelConfirmationReservation panelConfirmationReservation;
	private PanelCreationClient panelCreationClient;
	private Cinema cine;

	private CardLayout cl = new CardLayout();

	public PagePrincipale(Cinema cine) throws MalformedURLException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		// mise en place de la frame principale
		super("Cinego");
		this.cine = cine;
		setSize(900, 900);
		System.out.println(this.cine);

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		borderLayout = new JPanel(new BorderLayout());
		setContentPane(borderLayout);

		cardLayoutContent = new JPanel();
		cardLayoutContent.setLayout(cl);

		panelTop = new PanelTopCinego();
		panelBot = new PanelBotCinego();
		panelGauche = new PanelGaucheDroite();
		panelDroite = new PanelGaucheDroite();
		panelDem = new PanelDemarrage(this);
		panelChoixFilm = new PanelChoixFilm(this);
		panelConnexionReservation = new PanelConnexionReservation(this);
		panelListReservation = new PanelListReservation(this);
		panelChangementReservation = new PanelChangementReservation(this);
		panelReservation = new PanelReservation(this);
		panelCoReservation = new PanelLoginReservation(this);
		panelPaiementReservation = new PanelPaiementReservation(this);
		panelConfirmationReservation = new PanelConfirmationReservation(this);
		panelCreationClient = new PanelCreationClient(this);

		cardLayoutContent.add(panelDem, "paneldem");
		cardLayoutContent.add(panelChoixFilm, "panelChoixFilm");
		cardLayoutContent.add(panelReservation, "panelReservation");
		cardLayoutContent.add(panelConnexionReservation, "PanelCoReservation");
		cardLayoutContent.add(panelListReservation, "ListeReservation");
		cardLayoutContent.add(panelChangementReservation, "ChangementReservation");
		cardLayoutContent.add(panelCoReservation, "panelReservationConnexion");
		cardLayoutContent.add(panelPaiementReservation, "panelPaiementReservation");
		cardLayoutContent.add(panelConfirmationReservation, "panelConfirmationReservation");
		cardLayoutContent.add(panelCreationClient, "panelCreationClient");

		cl.show(cardLayoutContent, "paneldem");

		// borderLayout.add(panelTop,BorderLayout.NORTH);
		// borderLayout.add(panelBot,BorderLayout.SOUTH);
		borderLayout.add(cardLayoutContent, BorderLayout.CENTER);
		// borderLayout.add(panelGauche,BorderLayout.WEST);
		// borderLayout.add(panelDroite,BorderLayout.EAST);

		validate();
	}

	public JPanel getCardLayoutContent() {
		return cardLayoutContent;
	}

	public void setCardLayoutContent(JPanel cardLayoutContent) {
		this.cardLayoutContent = cardLayoutContent;
	}

	public JPanel getBorderLayout() {
		return borderLayout;
	}

	public void setBorderLayout(JPanel borderLayout) {
		this.borderLayout = borderLayout;
	}

	public PanelTopCinego getPanelTop() {
		return panelTop;
	}

	public void setPanelTop(PanelTopCinego panelTop) {
		this.panelTop = panelTop;
	}

	public PanelBotCinego getPanelBot() {
		return panelBot;
	}

	public void setPanelBot(PanelBotCinego panelBot) {
		this.panelBot = panelBot;
	}

	public CardLayout getCl() {
		return cl;
	}

	public void setCl(CardLayout cl) {
		this.cl = cl;
	}

	public PanelDemarrage getPanelDem() {
		return panelDem;
	}

	public void setPanelDem(PanelDemarrage panelDem) {
		this.panelDem = panelDem;
	}

	public PanelChoixFilm getPanelChoixFilm() {
		return panelChoixFilm;
	}

	public void setPanelChoixFilm(PanelChoixFilm panelChoixFilm) {
		this.panelChoixFilm = panelChoixFilm;
	}

	public PanelConnexionReservation getPanelConnexionReservation() {
		return panelConnexionReservation;
	}

	public void setPanelConnexionReservation(PanelConnexionReservation panelConnexionReservation) {
		this.panelConnexionReservation = panelConnexionReservation;
	}

	public PanelListReservation getPanelListReservation() {
		return panelListReservation;
	}

	public void setPanelListReservation(PanelListReservation panelListReservation) {
		this.panelListReservation = panelListReservation;
	}

	public PanelChangementReservation getPanelChangementReservation() {
		return panelChangementReservation;
	}

	public void setPanelChangementReservation(PanelChangementReservation panelChangementReservation) {
		this.panelChangementReservation = panelChangementReservation;
	}

	public PanelGaucheDroite getPanelGauche() {
		return panelGauche;
	}

	public void setPanelGauche(PanelGaucheDroite panelGauche) {
		this.panelGauche = panelGauche;
	}

	public PanelGaucheDroite getPanelDroite() {
		return panelDroite;
	}

	public void setPanelDroite(PanelGaucheDroite panelDroite) {
		this.panelDroite = panelDroite;
	}

	public PanelReservation getPanelReservation() {
		return panelReservation;
	}

	public void setPanelReservation(PanelReservation panelReservation) {
		this.panelReservation = panelReservation;
	}

	public PanelLoginReservation getPanelCoReservation() {
		return panelCoReservation;
	}

	public void setPanelCoReservation(PanelLoginReservation panelCoReservation) {
		this.panelCoReservation = panelCoReservation;
	}

	public PanelPaiementReservation getPanelPaiementReservation() {
		return panelPaiementReservation;
	}

	public void setPanelPaiementReservation(PanelPaiementReservation panelPaiementReservation) {
		this.panelPaiementReservation = panelPaiementReservation;
	}

	public PanelConfirmationReservation getPanelConfirmationReservation() {
		return panelConfirmationReservation;
	}

	public void setPanelConfirmationReservation(PanelConfirmationReservation panelConfirmationReservation) {
		this.panelConfirmationReservation = panelConfirmationReservation;
	}

	public PanelCreationClient getPanelCreationClient() {
		return panelCreationClient;
	}

	public void setPanelCreationClient(PanelCreationClient panelCreationClient) {
		this.panelCreationClient = panelCreationClient;
	}

	public Cinema getCine() {
		return cine;
	}

	public void setCine(Cinema cine) {
		this.cine = cine;
	}

}
