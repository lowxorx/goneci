package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import dao.FilmsDAO;
import dao.SeancesDAO;
import events.EvePanelChoixFilm;
import metier.Film;
import metier.Séance;
import vue.MonCellRenderer;
import vue.PagePrincipale;

@SuppressWarnings("serial")
public class PanelChoixFilm extends JPanel {

	private PagePrincipale pagePrinc;
	// private GridBagConstraints gbc;
	private DefaultListModel<Film> listFilm = new DefaultListModel<>();
	private List<Film> mesfils = new ArrayList<Film>();
	private EvePanelChoixFilm eveFilm;
	private JList<Film> liste;
	private Image img;
	ImageObserver imageObserver;

	public PanelChoixFilm(PagePrincipale pgPrinc) {

		this.pagePrinc = pgPrinc;

		ImageIcon icon = new ImageIcon("bg2.jpg");
		img = icon.getImage();
		imageObserver = icon.getImageObserver();

		SeancesDAO sDAO = new SeancesDAO();

		ArrayList<Séance> séances = new ArrayList<Séance>();

		séances = (ArrayList<Séance>) sDAO.findByCine(this.getPgPrinc().getCine().getIdCinema());

		ArrayList<Integer> films = new ArrayList<Integer>();

		for (int i = 0; i < séances.size(); i++) {

			if (films.contains(séances.get(i).getFilm().getIdFilm()) == false) {

				System.out.println("ne contient pas, ajoute");
				films.add(séances.get(i).getFilm().getIdFilm());

			} else {
				System.out.println("existe déjà");
			}
		}
		System.out.println(films);

		FilmsDAO filmsDao = new FilmsDAO();

		for (int e = 0; e < films.size(); e++) {

			mesfils.add(filmsDao.findById(films.get(e).intValue()));
			System.out.println(filmsDao.findById(films.get(e).intValue()));

		}

		eveFilm = new EvePanelChoixFilm(this);

		// mesfils = daoFilm.getAll();
		for (int i = 0; i < mesfils.size(); i++) {
			System.out.println(mesfils.get(i).getTitre());
			listFilm.addElement(mesfils.get(i));
		}

		liste = new JList<>(listFilm);

		liste.setCellRenderer(new MonCellRenderer());
		liste.setFixedCellHeight(440);
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liste.addListSelectionListener(eveFilm);
		liste.setBackground(Color.BLACK);

		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBounds(600, 850, 165, 54);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				pgPrinc.getCl().show(pgPrinc.getCardLayoutContent(), "paneldem");

			}
		});
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(800, 120, 350, 1000);
		liste.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		liste.setVisibleRowCount(1000);
		scrollPane.setViewportView(liste);
		scrollPane.setOpaque(false);
		add(scrollPane);
		add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Liste des films à l'affiche");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(523, 11, 350, 28);
		add(lblNewLabel);

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), imageObserver);
		setOpaque(false);
		super.paint(g);
		setOpaque(true);
	}

	public PagePrincipale getPgPrinc() {
		return pagePrinc;
	}

	public void setPgPrinc(PagePrincipale pgPrinc) {
		this.pagePrinc = pgPrinc;
	}

	public DefaultListModel<Film> getListFilm() {
		return listFilm;
	}

	public void setListFilm(DefaultListModel<Film> listFilm) {
		this.listFilm = listFilm;
	}

	public List<Film> getMesfils() {
		return mesfils;
	}

	public void setMesfils(List<Film> mesfils) {
		this.mesfils = mesfils;
	}

	public JList<Film> getListe() {
		return liste;
	}

	public void setListe(JList<Film> liste) {
		this.liste = liste;
	}
}
