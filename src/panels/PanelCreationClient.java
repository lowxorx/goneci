package panels;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.CinemaDAO;
import dao.GenreDAO;
import events.EvePanelCreationClient;
import metier.Cinema;
import metier.Genre;
import metier.Séance;
import vue.PagePrincipale;

public class PanelCreationClient extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PagePrincipale pgPrincipale;
	private Séance séanceEncours;
	private int nbPlaces;
	private JTextField textFieldNom;
	private JTextField textPrenom;
	private JTextField textMail;
	private JLabel lblEmail;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxGenre;
	private JLabel lblGenrePref;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxCinema;
	private JLabel lblCinemaPrfr;
	private JButton btnCreation;
	private CinemaDAO cineDao;
	private GenreDAO genreDao;
	private EvePanelCreationClient evePanelCreationClient;
	private JCheckBox CheckPublicité;
	private JButton buttonRetour;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelCreationClient(PagePrincipale pagePrincipale) {

		this.pgPrincipale = pagePrincipale;

		Font font = new Font("Arial", Font.BOLD, 16);

		JLabel lblCrationDeCompte = new JLabel("Création de compte ");
		lblCrationDeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrationDeCompte.setFont(font);

		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(font);

		textFieldNom = new JTextField();
		textFieldNom.setFont(font);
		textFieldNom.setColumns(10);

		JLabel lblPrnom = new JLabel("Prénom :");
		lblPrnom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrnom.setFont(font);

		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setFont(font);

		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setFont(font);

		lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(font);

		comboBoxGenre = new JComboBox();
		comboBoxGenre.setFont(font);

		lblGenrePref = new JLabel("Genre préféré :");
		lblGenrePref.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenrePref.setFont(font);

		comboBoxCinema = new JComboBox();
		comboBoxCinema.setFont(font);

		lblCinemaPrfr = new JLabel("Cinema préféré :");
		lblCinemaPrfr.setHorizontalAlignment(SwingConstants.CENTER);
		lblCinemaPrfr.setFont(font);

		btnCreation = new JButton("Création");
		btnCreation.setFont(font);

		evePanelCreationClient = new EvePanelCreationClient(this);

		CheckPublicité = new JCheckBox("Recevoir de la publicité ?");
		CheckPublicité.setHorizontalAlignment(SwingConstants.CENTER);
		CheckPublicité.setFont(font);

		buttonRetour = new JButton("Retour");
		buttonRetour.setFont(new Font("Arial", Font.BOLD, 16));
		buttonRetour.addActionListener(evePanelCreationClient);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(lblCrationDeCompte, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(lblNom, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(textFieldNom, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(lblPrnom, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(textPrenom, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(textMail, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(lblGenrePref, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(comboBoxGenre, 0, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(lblCinemaPrfr, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(comboBoxCinema, 0, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(373)
						.addComponent(CheckPublicité, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(435))
				.addGroup(groupLayout.createSequentialGroup().addGap(95)
						.addComponent(buttonRetour, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(280)
						.addComponent(btnCreation, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(155)));
		groupLayout
				.setVerticalGroup(
						groupLayout
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addGap(35)
												.addComponent(lblCrationDeCompte, GroupLayout.DEFAULT_SIZE, 20,
														Short.MAX_VALUE)
												.addGap(22)
												.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
												.addGap(22)
												.addComponent(textFieldNom, GroupLayout.DEFAULT_SIZE, 41,
														Short.MAX_VALUE)
												.addGap(28)
												.addComponent(lblPrnom, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
												.addGap(22)
												.addComponent(textPrenom, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
												.addGap(22)
												.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
												.addGap(22)
												.addComponent(textMail, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
												.addGap(22)
												.addComponent(lblGenrePref, GroupLayout.DEFAULT_SIZE, 25,
														Short.MAX_VALUE)
												.addGap(11)
												.addComponent(comboBoxGenre, GroupLayout.DEFAULT_SIZE, 41,
														Short.MAX_VALUE)
												.addGap(28)
												.addComponent(lblCinemaPrfr, GroupLayout.DEFAULT_SIZE, 20,
														Short.MAX_VALUE)
												.addGap(16)
												.addComponent(comboBoxCinema, GroupLayout.DEFAULT_SIZE, 41,
														Short.MAX_VALUE)
												.addGap(22)
												.addComponent(CheckPublicité, GroupLayout.DEFAULT_SIZE, 35,
														Short.MAX_VALUE)
												.addGap(22)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(buttonRetour, GroupLayout.DEFAULT_SIZE, 41,
																Short.MAX_VALUE)
														.addComponent(btnCreation, GroupLayout.DEFAULT_SIZE, 41,
																Short.MAX_VALUE))
												.addGap(72)));
		setLayout(groupLayout);
		btnCreation.addActionListener(evePanelCreationClient);

		cineDao = new CinemaDAO();
		genreDao = new GenreDAO();

		ArrayList<Genre> genres = new ArrayList<Genre>();

		genres = (ArrayList<Genre>) genreDao.getAll();

		ArrayList<Cinema> cinemas = new ArrayList<Cinema>();

		cinemas = (ArrayList<Cinema>) cineDao.getAll();

		for (int i = 0; i < cinemas.size(); i++) {

			comboBoxCinema.addItem(cinemas.get(i).getNomcinema());

		}

		for (int i = 0; i < genres.size(); i++) {

			comboBoxGenre.addItem(genres.get(i).getGenre());

		}
	}

	public PagePrincipale getPgPrincipale() {
		return pgPrincipale;
	}

	public void setPgPrincipale(PagePrincipale pgPrincipale) {
		this.pgPrincipale = pgPrincipale;
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

	public JTextField getTextFieldNom() {
		return textFieldNom;
	}

	public void setTextFieldNom(JTextField textFieldNom) {
		this.textFieldNom = textFieldNom;
	}

	public JTextField getTextPrenom() {
		return textPrenom;
	}

	public void setTextPrenom(JTextField textPrenom) {
		this.textPrenom = textPrenom;
	}

	public JTextField getTextMail() {
		return textMail;
	}

	public void setTextMail(JTextField textMail) {
		this.textMail = textMail;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBoxGenre() {
		return comboBoxGenre;
	}

	public void setComboBoxGenre(@SuppressWarnings("rawtypes") JComboBox comboBoxGenre) {
		this.comboBoxGenre = comboBoxGenre;
	}

	public JLabel getLblGenrePref() {
		return lblGenrePref;
	}

	public void setLblGenrePref(JLabel lblGenrePref) {
		this.lblGenrePref = lblGenrePref;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBoxCinema() {
		return comboBoxCinema;
	}

	@SuppressWarnings("rawtypes")
	public void setComboBoxCinema(JComboBox comboBoxCinema) {
		this.comboBoxCinema = comboBoxCinema;
	}

	public JLabel getLblCinemaPrfr() {
		return lblCinemaPrfr;
	}

	public void setLblCinemaPrfr(JLabel lblCinemaPrfr) {
		this.lblCinemaPrfr = lblCinemaPrfr;
	}

	public CinemaDAO getCineDao() {
		return cineDao;
	}

	public void setCineDao(CinemaDAO cineDao) {
		this.cineDao = cineDao;
	}

	public GenreDAO getGenreDao() {
		return genreDao;
	}

	public void setGenreDao(GenreDAO genreDao) {
		this.genreDao = genreDao;
	}

	public EvePanelCreationClient getEvePanelCreationClient() {
		return evePanelCreationClient;
	}

	public void setEvePanelCreationClient(EvePanelCreationClient evePanelCreationClient) {
		this.evePanelCreationClient = evePanelCreationClient;
	}

	public JCheckBox getCheckPublicité() {
		return CheckPublicité;
	}

	public void setCheckPublicité(JCheckBox checkPublicité) {
		CheckPublicité = checkPublicité;
	}

	public JButton getBtnCreation() {
		return btnCreation;
	}

	public void setBtnCreation(JButton btnCreation) {
		this.btnCreation = btnCreation;
	}

	public JButton getButtonRetour() {
		return buttonRetour;
	}

	public void setButtonRetour(JButton buttonRetour) {
		this.buttonRetour = buttonRetour;
	}

}
