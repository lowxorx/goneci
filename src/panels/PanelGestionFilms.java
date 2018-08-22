package panels;

import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import appli.CinegoAdmin;
import events.EvtGestionFilms;

public class PanelGestionFilms extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CinegoAdmin cine;
	private JTextField tbTitreFilm;
	private JTextField tbGenreFilm;
	private JTextField tbRealFilm;
	private JTextField tbDateSortie;
	private JTextField tbDureeFilm;
	private JTextField tbUrlAffiche;

	private JButton btRetour;
	private JButton btMajFilm;
	private JButton btRefreshAlAffiche;

	@SuppressWarnings("rawtypes")
	private JComboBox cbFilmsAffiche;
	@SuppressWarnings("rawtypes")
	private JComboBox cbFilmsDispo;

	private JTextPane tbSynopsysFilm;

	private JLabel afficheFilm;

	private JCheckBox checkAffiche;

	private String urlAffiche;

	private int idFilm;

	@SuppressWarnings("rawtypes")
	public PanelGestionFilms(CinegoAdmin cinego) {
		this.cine = cinego;
		EvtGestionFilms event = new EvtGestionFilms(this);

		JLabel lblGestionDesFilms = new JLabel("Gestion des Films");
		lblGestionDesFilms.setBounds(10, 11, 774, 14);
		lblGestionDesFilms.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGestionDesFilms.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblFilmsActuellement = new JLabel("Films actuellement à l'affiche :");
		lblFilmsActuellement.setBounds(260, 52, 210, 14);

		cbFilmsAffiche = new JComboBox();
		cbFilmsAffiche.setBounds(260, 77, 210, 20);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 108, 774, 2);

		JLabel lblInformationsSurLe = new JLabel("Informations sur le film sélectionné :");
		lblInformationsSurLe.setBounds(10, 124, 774, 14);
		lblInformationsSurLe.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblInformationsSurLe.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setBounds(10, 169, 92, 14);
		lblTitre.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setBounds(10, 200, 92, 14);
		lblGenre.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblRalisateur = new JLabel("Réalisateur :");
		lblRalisateur.setBounds(10, 231, 92, 14);
		lblRalisateur.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblDateDeSortie = new JLabel("Date de sortie :");
		lblDateDeSortie.setBounds(10, 262, 92, 14);
		lblDateDeSortie.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblDure = new JLabel("Durée :");
		lblDure.setBounds(10, 293, 92, 14);
		lblDure.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblSynopsys = new JLabel("Synopsys :");
		lblSynopsys.setBounds(10, 410, 92, 14);
		lblSynopsys.setHorizontalAlignment(SwingConstants.RIGHT);

		tbTitreFilm = new JTextField();
		tbTitreFilm.setBounds(112, 166, 306, 20);
		tbTitreFilm.setColumns(10);

		tbGenreFilm = new JTextField();
		tbGenreFilm.setBounds(112, 197, 306, 20);
		tbGenreFilm.setColumns(10);

		tbRealFilm = new JTextField();
		tbRealFilm.setBounds(112, 228, 306, 20);
		tbRealFilm.setColumns(10);

		tbDateSortie = new JTextField();
		tbDateSortie.setBounds(112, 259, 306, 20);
		tbDateSortie.setColumns(10);

		tbDureeFilm = new JTextField();
		tbDureeFilm.setBounds(112, 290, 306, 20);
		tbDureeFilm.setColumns(10);

		btRetour = new JButton("Retour");
		btRetour.setBounds(10, 566, 75, 23);

		JLabel lblListeDesFilms = new JLabel("Liste des films disponibles :");
		lblListeDesFilms.setBounds(10, 52, 208, 14);

		cbFilmsDispo = new JComboBox();
		cbFilmsDispo.setBounds(10, 77, 208, 20);

		checkAffiche = new JCheckBox("A l'affiche actuellement");
		checkAffiche.setBounds(112, 318, 306, 23);

		afficheFilm = new JLabel("affiche");
		afficheFilm.setBounds(461, 149, 300, 420);
		afficheFilm.setHorizontalAlignment(SwingConstants.CENTER);

		btRefreshAlAffiche = new JButton("Actualiser");
		btRefreshAlAffiche.setBounds(479, 76, 110, 22);

		btMajFilm = new JButton("Mettre à jour les informations du film");
		btMajFilm.setBounds(112, 515, 306, 23);

		tbUrlAffiche = new JTextField();
		tbUrlAffiche.setBounds(112, 349, 306, 22);
		tbUrlAffiche.setColumns(10);

		JLabel lblUrlAffiche = new JLabel("URL Affiche :");
		lblUrlAffiche.setBounds(10, 350, 92, 18);
		lblUrlAffiche.setHorizontalAlignment(SwingConstants.RIGHT);
		setLayout(null);
		add(lblGestionDesFilms);
		add(lblListeDesFilms);
		add(lblFilmsActuellement);
		add(cbFilmsDispo);
		add(cbFilmsAffiche);
		add(btRefreshAlAffiche);
		add(separator);
		add(lblInformationsSurLe);
		add(lblTitre);
		add(lblGenre);
		add(lblRalisateur);
		add(lblDateDeSortie);
		add(lblDure);
		add(lblUrlAffiche);
		add(lblSynopsys);
		add(btRetour);
		add(tbTitreFilm);
		add(tbGenreFilm);
		add(tbRealFilm);
		add(tbDateSortie);
		add(tbDureeFilm);
		add(checkAffiche);
		add(tbUrlAffiche);
		add(btMajFilm);
		add(afficheFilm);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(112, 383, 306, 121);
		add(scrollPane);

		tbSynopsysFilm = new JTextPane();
		scrollPane.setViewportView(tbSynopsysFilm);
		btRetour.addActionListener(event);
		cbFilmsAffiche.addActionListener(event);
		cbFilmsDispo.addActionListener(event);
		btMajFilm.addActionListener(event);
		btRefreshAlAffiche.addActionListener(event);
	}

	public String getTbTitreFilm() {
		return tbTitreFilm.getText();
	}

	public void setTbTitreFilm(String tbTitreFilm) {
		this.tbTitreFilm.setText(tbTitreFilm);
	}

	public String getTbGenreFilm() {
		return tbGenreFilm.getText();
	}

	public void setTbGenreFilm(String tbGenreFilm) {
		this.tbGenreFilm.setText(tbGenreFilm);
	}

	public String getTbRealFilm() {
		return tbRealFilm.getText();
	}

	public void setTbRealFilm(String tbRealFilm) {
		this.tbRealFilm.setText(tbRealFilm);
	}

	public String getTbDateSortie() {
		return tbDateSortie.getText();
	}

	public void setTbDateSortie(String tbDateSortie) {
		this.tbDateSortie.setText(tbDateSortie);
	}

	public String getTbDureeFilm() {
		return tbDureeFilm.getText();
	}

	public void setTbDureeFilm(String tbDureeFilm) {
		this.tbDureeFilm.setText(tbDureeFilm);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbFilmsAffiche() {
		return cbFilmsAffiche;
	}

	@SuppressWarnings("unchecked")
	public void setCbFilmsAffiche(String cbFilmsAffiche) {
		this.cbFilmsAffiche.addItem(cbFilmsAffiche);
	}

	public String getTbSynopsysFilm() {
		return tbSynopsysFilm.getText();
	}

	public void setTbSynopsysFilm(String tbSynopsysFilm) {
		this.tbSynopsysFilm.setText(tbSynopsysFilm);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbFilmsDispo() {
		return cbFilmsDispo;
	}

	public String getSelectedFilmDispo() {
		if (this.cbFilmsDispo.getSelectedItem() != null) {
			return this.cbFilmsDispo.getSelectedItem().toString();
		} else {
			return null;
		}

	}

	public String getTbUrlAffiche() {
		return tbUrlAffiche.getText();
	}

	public void setTbUrlAffiche(String tbUrlAffiche) {
		this.tbUrlAffiche.setText(tbUrlAffiche);
	}

	public String getSelectedFilmAlAffiche() {
		return this.cbFilmsAffiche.getSelectedItem().toString();
	}

	public void setCbFilmsDispo(String cbFilmsDispo) {
		this.cbFilmsDispo.setSelectedItem(cbFilmsDispo);
	}

	public void setLblAffiche(URL url) {
		ImageIcon icon = new ImageIcon(url);
		Image img = icon.getImage().getScaledInstance(300, 420, Image.SCALE_SMOOTH);
		ImageIcon icored = new ImageIcon(img);
		this.afficheFilm.setIcon(icored);
	}

	public JButton getBtMajFilm() {
		return btMajFilm;
	}

	public void clearCb() {
		cbFilmsAffiche.removeAllItems();
		cbFilmsDispo.removeAllItems();
	}

	public JButton getBtRefreshAlAffiche() {
		return btRefreshAlAffiche;
	}

	public JButton getBtRetour() {
		return btRetour;
	}

	public String getUrlAffiche() {
		return urlAffiche;
	}

	public void setUrlAffiche(String urlAffiche) {
		this.urlAffiche = urlAffiche;
	}

	public boolean getCheckAffiche() {
		if (checkAffiche.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public int getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	public void setCheckAffiche(boolean checkAffiche) {
		this.checkAffiche.setSelected(checkAffiche);
	}

	public CinegoAdmin getCinego() {
		return cine;
	}
}
