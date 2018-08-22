package events;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.lang3.time.DateUtils;

import metier.Reservation;
import panels.PanelListReservation;

public class EvePanelListReservation implements ListSelectionListener {

	private PanelListReservation panelListReservation;

	public EvePanelListReservation(PanelListReservation panelListreserv) {

		super();
		this.panelListReservation = panelListreserv;

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		// if(!e.getSource() ==
		// panelListReservation.getListe())checkReservationSelect();

		if (!e.getValueIsAdjusting()) {

			checkReservationSelect();

		}

	}

	public void checkReservationSelect() {

		Reservation reservation = panelListReservation.getListe().getSelectedValue();

		// System.out.println(reservation);

		// System.out.println(reservation.getSéance().getHeureFin());

		panelListReservation.getPagePrinc().getPanelChangementReservation().getTxtpnSynopsys()
				.setText(reservation.getSéance().getFilm().getSynopsys());

		URL affiche = null;
		try {
			affiche = new URL("http://image.tmdb.org/t/p/w500" + reservation.getSéance().getFilm().getUrlAffiche());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		ImageIcon icon = new ImageIcon(affiche);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(350, 700, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);

		panelListReservation.getPagePrinc().getPanelChangementReservation().getLblImageFilm().setIcon(image);
		panelListReservation.getPagePrinc().getPanelChangementReservation().getLblImageFilm().setText("");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		Date currentTime_1 = reservation.getSéance().getDateSeance();
		String dateString = formatter.format(currentTime_1);

		panelListReservation.getPagePrinc().getPanelChangementReservation().getLblDateReservation().setText(dateString);
		panelListReservation.getPagePrinc().getPanelChangementReservation().getLblHeureseance()
				.setText(reservation.getSéance().getHeureDebut());
		panelListReservation.getPagePrinc().getPanelChangementReservation().getLblNbdeplaces()
				.setText(String.valueOf(reservation.getNbPlace()));

		panelListReservation.getPagePrinc().getPanelChangementReservation().getLblNomFilm()
				.setText(reservation.getSéance().getFilm().getTitre());
		panelListReservation.getPagePrinc().getPanelChangementReservation().setRéservationEnCours(reservation);
		panelListReservation.getPagePrinc().getPanelChangementReservation().getChckbx3D()
				.setSelected(reservation.getSéance().isIs3D());
		panelListReservation.getPagePrinc().getPanelChangementReservation().getLblVersiontxt()
				.setText(reservation.getSéance().getVersion());

		panelListReservation.getPagePrinc().getCl().show(panelListReservation.getPagePrinc().getCardLayoutContent(),
				"ChangementReservation");

		Date dateReservation = reservation.getSéance().getDateSeance();
		Date dateDuJour = new Date();

		boolean bla = DateUtils.isSameDay(dateReservation, dateDuJour);

		System.out.println(bla);

		if (bla == true) {

			panelListReservation.getPagePrinc().getPanelChangementReservation().getBtnRemboursement().setVisible(false);
			panelListReservation.getPagePrinc().getPanelChangementReservation().getLblNonModification()
					.setVisible(true);

		} else {

			panelListReservation.getPagePrinc().getPanelChangementReservation().getLblNonModification()
					.setVisible(false);

		}

	}

}
