package panels;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import events.EvePanelChoixFilm;
import events.EvePanelListReservation;
import metier.Reservation;
import util.ResaCellRenderer;
import vue.PagePrincipale;

@SuppressWarnings("serial")
public class PanelListReservation extends JPanel {

	private PagePrincipale pagePrinc;
	private GridBagConstraints gbc;
	private DefaultListModel<Reservation> listReservation = new DefaultListModel<>();
	private List<Reservation> mesReservations = new ArrayList<Reservation>();
	private EvePanelChoixFilm eveFilm;
	private JList<Reservation> liste;
	private EvePanelListReservation eveListReservation;
	private Image img;
	ImageObserver imageObserver;

	@SuppressWarnings("unchecked")
	public PanelListReservation(PagePrincipale pgPrinc) {

		this.pagePrinc = pgPrinc;
		eveListReservation = new EvePanelListReservation(this);

		// img = Toolkit.getDefaultToolkit().createImage("pel.jpg");

		ImageIcon icon = new ImageIcon("bg3.png");
		img = icon.getImage();
		imageObserver = icon.getImageObserver();
		setLayout(null);

		liste = new JList<>(listReservation);

		liste.setCellRenderer(new ResaCellRenderer());
		liste.setFixedCellHeight(500);
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liste.addListSelectionListener(eveListReservation);

		JScrollPane scrollPane = new JScrollPane(liste);
		scrollPane.setBounds(800, 120, 330, 1000);
		liste.setVisibleRowCount(1000);
		scrollPane.setViewportView(liste);
		scrollPane.setOpaque(false);
		add(scrollPane);

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), imageObserver);
		setOpaque(false);
		super.paint(g);
		setOpaque(true);
	}

	public PagePrincipale getPagePrinc() {
		return pagePrinc;
	}

	public void setPagePrinc(PagePrincipale pagePrinc) {
		this.pagePrinc = pagePrinc;
	}

	public GridBagConstraints getGbc() {
		return gbc;
	}

	public void setGbc(GridBagConstraints gbc) {
		this.gbc = gbc;
	}

	public DefaultListModel<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(DefaultListModel<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	public List<Reservation> getMesReservations() {
		return mesReservations;
	}

	public void setMesReservations(List<Reservation> mesReservations) {
		this.mesReservations = mesReservations;
	}

	public EvePanelChoixFilm getEveFilm() {
		return eveFilm;
	}

	public void setEveFilm(EvePanelChoixFilm eveFilm) {
		this.eveFilm = eveFilm;
	}

	public JList<Reservation> getListe() {
		return liste;
	}

	public void setListe(JList<Reservation> liste) {
		this.liste = liste;
	}

	public EvePanelListReservation getEveListReservation() {
		return eveListReservation;
	}

	public void setEveListReservation(EvePanelListReservation eveListReservation) {
		this.eveListReservation = eveListReservation;
	}

}
