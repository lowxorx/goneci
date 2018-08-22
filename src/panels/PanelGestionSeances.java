package panels;

import java.awt.Font;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import appli.CinegoAdmin;
import events.EvtGestionSeances;
import metier.Cinema;
import metier.Film;
import metier.Salle;
import metier.Séance;
import util.DateLabelFormatter;

public class PanelGestionSeances extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CinegoAdmin cine;

	private JComboBox<Cinema> cbCinema;
	private JComboBox<Film> cbFilms;
	private JComboBox<Salle> cbSalles;
	private JComboBox<Séance> cbSeancesDispo;
	@SuppressWarnings("rawtypes")
	private JComboBox cbHHd;
	@SuppressWarnings("rawtypes")
	private JComboBox cbMMd;
	@SuppressWarnings("rawtypes")
	private JComboBox cbHHf;
	@SuppressWarnings("rawtypes")
	private JComboBox cbMMf;
	@SuppressWarnings("rawtypes")
	private JComboBox cbSalleProj;
	@SuppressWarnings("rawtypes")
	private JComboBox cbVersion;

	private JCheckBox chk3d;
	private JCheckBox chknum;

	private int idSalle;

	private JLabel lblListeDesCinmas;
	private JLabel lblListeDesSalles;
	private JLabel lblFilm;
	private JLabel lblVersion;
	private JLabel lblDate;

	private JButton btRefresh;
	private JButton btRetour;
	private JButton btValidSc;
	private JButton btModif;
	private JLabel label_1;
	private JLabel lblHeureDeFin;

	private JDatePickerImpl datePicker;
	private SpringLayout springLayout;
	private JDatePanelImpl datePanel;
	private UtilDateModel model;
	private Properties p;

	private int idSeance = 0;
	private boolean modifSeance = false;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelGestionSeances(CinegoAdmin cinego) {
		this.cine = cinego;
		EvtGestionSeances event = new EvtGestionSeances(this);

		JLabel lblGestionDesSances = new JLabel("Gestion des séances");
		lblGestionDesSances.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGestionDesSances.setHorizontalAlignment(SwingConstants.CENTER);

		cbCinema = new JComboBox<Cinema>();
		cbCinema.addActionListener(event);

		cbFilms = new JComboBox<Film>();

		cbSalles = new JComboBox<Salle>();

		cbSeancesDispo = new JComboBox<Séance>();

		model = new UtilDateModel();

		p = new Properties();
		p.put("text.today", "Aujourd'hui");
		p.put("text.month", "Mois");
		p.put("text.year", "Année");
		datePanel = new JDatePanelImpl(model, p);

		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.WEST, datePicker.getJFormattedTextField(), 0, SpringLayout.WEST,
				datePicker);

		JLabel lblNewLabel = new JLabel("Séances disponibles pour la salle sélectionnée :");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("Ajouter ou modifier une séance :");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		btRefresh = new JButton("Récupérer les séances");
		btRefresh.addActionListener(event);

		lblListeDesCinmas = new JLabel("Liste des cinémas :");

		lblListeDesSalles = new JLabel("Liste des salles du cinéma :");

		lblFilm = new JLabel("Film");
		lblFilm.setHorizontalAlignment(SwingConstants.RIGHT);

		chk3d = new JCheckBox("3D ");

		JLabel lblTypeDeProjection = new JLabel("Type de projection");
		lblTypeDeProjection.setHorizontalAlignment(SwingConstants.RIGHT);

		chknum = new JCheckBox("Numérique");

		JLabel lblHeureDeLa = new JLabel("Heure de début");
		lblHeureDeLa.setHorizontalAlignment(SwingConstants.RIGHT);

		cbHHd = new JComboBox();
		cbHHd.setModel(new DefaultComboBoxModel(new String[] { "09", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "00" }));

		cbMMd = new JComboBox();
		cbMMd.setModel(new DefaultComboBoxModel(new String[] { "00", "15", "30", "45" }));

		JLabel label = new JLabel(":");
		label.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSalleDeProjection = new JLabel("Salle de projection");
		lblSalleDeProjection.setHorizontalAlignment(SwingConstants.RIGHT);

		cbSalleProj = new JComboBox();

		cbVersion = new JComboBox();
		cbVersion.setModel(new DefaultComboBoxModel(new String[] { "V.F.", "V.O.S.T", "V.O." }));

		lblVersion = new JLabel("Version");
		lblVersion.setHorizontalAlignment(SwingConstants.RIGHT);

		lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);

		btRetour = new JButton("Retour");
		btRetour.addActionListener(event);

		JSeparator separator = new JSeparator();

		btValidSc = new JButton("Valider la séance");
		btValidSc.addActionListener(event);

		btModif = new JButton("Modifier >>");
		btModif.addActionListener(event);

		cbHHf = new JComboBox();
		cbHHf.setModel(new DefaultComboBoxModel(new String[] { "10", "11", "12", "13", "14", "15", "16", "17", "18",
				"19", "20", "21", "22", "23", "00", "01" }));

		cbMMf = new JComboBox();
		cbMMf.setModel(new DefaultComboBoxModel(new String[] { "00", "15", "30", "45" }));

		label_1 = new JLabel(":");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);

		lblHeureDeFin = new JLabel("Heure de fin");
		lblHeureDeFin.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(lblGestionDesSances,
								GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(12)
								.addComponent(lblListeDesCinmas, GroupLayout.PREFERRED_SIZE, 179,
										GroupLayout.PREFERRED_SIZE)
								.addGap(79).addComponent(lblListeDesSalles))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(12)
										.addComponent(cbCinema, GroupLayout.PREFERRED_SIZE, 194,
												GroupLayout.PREFERRED_SIZE)
										.addGap(64).addComponent(cbSalles, GroupLayout.PREFERRED_SIZE, 163,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(separator,
								GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(460).addComponent(lblNewLabel_1,
								GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(12)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 342,
												GroupLayout.PREFERRED_SIZE)
										.addGap(106)
										.addComponent(lblFilm, GroupLayout.PREFERRED_SIZE, 126,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26).addComponent(cbFilms, GroupLayout.PREFERRED_SIZE, 148,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(12)
										.addComponent(cbSeancesDispo, GroupLayout.PREFERRED_SIZE, 342,
												GroupLayout.PREFERRED_SIZE)
										.addGap(11)
										.addComponent(btModif, GroupLayout.PREFERRED_SIZE, 91,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4)
										.addComponent(lblTypeDeProjection, GroupLayout.PREFERRED_SIZE, 126,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26).addComponent(chk3d).addGap(8).addComponent(chknum))
						.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(btRefresh).addGap(299)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblHeureDeLa, GroupLayout.PREFERRED_SIZE, 126,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHeureDeFin, GroupLayout.PREFERRED_SIZE, 126,
												GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(cbHHd,
												GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
										.addComponent(cbHHf, GroupLayout.PREFERRED_SIZE, 57,
												GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(label_1,
												GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
								.addGap(15)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(cbMMd, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbMMf, GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(460)
								.addComponent(lblSalleDeProjection, GroupLayout.PREFERRED_SIZE, 126,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(cbSalleProj, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(530)
										.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 56,
												GroupLayout.PREFERRED_SIZE)
										.addGap(29).addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 145,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(530)
										.addComponent(lblVersion, GroupLayout.PREFERRED_SIZE, 56,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26).addComponent(cbVersion, GroupLayout.PREFERRED_SIZE, 148,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(612).addComponent(btValidSc,
								GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(btRetour,
								GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(12)
								.addComponent(lblGestionDesSances, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblListeDesCinmas).addComponent(lblListeDesSalles))
								.addGap(8)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(cbCinema, GroupLayout.PREFERRED_SIZE,
												22, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbSalles, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addGap(21)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addGap(19)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout.createSequentialGroup().addGap(14).addComponent(lblNewLabel,
														GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblFilm))
										.addComponent(cbFilms, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addGap(9)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(16).addComponent(
												cbSeancesDispo, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addGap(15).addComponent(btModif))
										.addGroup(groupLayout.createSequentialGroup().addGap(3)
												.addComponent(lblTypeDeProjection))
										.addComponent(chk3d).addComponent(chknum))
								.addGap(3)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout.createSequentialGroup().addGap(16).addComponent(btRefresh))
										.addGroup(groupLayout.createSequentialGroup().addGap(2)
												.addComponent(lblHeureDeLa).addGap(21).addComponent(lblHeureDeFin))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(cbHHd, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE)
												.addGap(17).addComponent(cbHHf, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(label).addGap(23)
												.addComponent(label_1))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(cbMMd, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE)
												.addGap(17).addComponent(cbMMf, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(22)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(2)
												.addComponent(lblSalleDeProjection))
										.addComponent(cbSalleProj, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addGap(22)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(lblDate))
										.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(29)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout.createSequentialGroup().addGap(2).addComponent(lblVersion))
										.addComponent(cbVersion, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addGap(22).addComponent(btValidSc).addGap(58).addComponent(btRetour)));
		setLayout(groupLayout);
	}

	public CinegoAdmin getCinego() {
		return cine;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbCinema() {
		return cbCinema;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbFilms() {
		return cbFilms;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbSalles() {
		return cbSalles;
	}

	public JButton getBtRefresh() {
		return btRefresh;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbSeancesDispo() {
		return cbSeancesDispo;
	}

	public String getSelectedCinema() {
		return cbCinema.getSelectedItem().toString();
	}

	public void clearsalles() {
		cbSalles.removeAllItems();
	}

	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbHH() {
		return cbHHd;
	}

	public void setCbHH(String cbHH) {
		this.cbHHd.setSelectedItem(cbHH);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbMM() {
		return cbMMd;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbHHf() {
		return cbHHf;
	}

	public void setCbHHf(String cbHHf) {
		this.cbHHf.setSelectedItem(cbHHf);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbMMf() {
		return cbMMf;
	}

	public void setCbMMf(String cbMMf) {
		this.cbMMf.setSelectedItem(cbMMf);
	}

	public void setCbMM(String cbMM) {
		this.cbMMd.setSelectedItem(cbMM);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbSalleProj() {
		return cbSalleProj;
	}

	public void setCbSalleProj(String cbSalleProj) {
		this.cbSalleProj.setSelectedItem(cbSalleProj);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbVersion() {
		return cbVersion;
	}

	public void setCbVersion(String cbVersion) {
		this.cbVersion.setSelectedItem(cbVersion);
	}

	public JButton getBtRetour() {
		return btRetour;
	}

	public JButton getBtValidSc() {
		return btValidSc;
	}

	public JButton getBtModif() {
		return btModif;
	}

	public JCheckBox getChk3d() {
		return chk3d;
	}

	public JCheckBox getChknum() {
		return chknum;
	}

	public UtilDateModel getModel() {
		return model;
	}

	public int getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public boolean isModifSeance() {
		return modifSeance;
	}

	public void setModifSeance(boolean modifSeance) {
		this.modifSeance = modifSeance;
	}

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

}
