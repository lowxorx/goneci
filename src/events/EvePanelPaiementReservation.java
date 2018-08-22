package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.ReservationsDAO;
import metier.Reservation;
import panels.PanelPaiementReservation;

public class EvePanelPaiementReservation implements ActionListener {

	private PanelPaiementReservation panelPaiReservation;

	/**
	 * @wbp.parser.entryPoint
	 */
	public EvePanelPaiementReservation(PanelPaiementReservation panelPaiementReservation) {

		this.panelPaiReservation = panelPaiementReservation;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == panelPaiReservation.getBtnValiderReservation()) {

			InsertReservation();

		}

	}

	public void InsertReservation() {

		ReservationsDAO reservDao = new ReservationsDAO();

		Reservation reservation = new Reservation(panelPaiReservation.getUtilisateur(),
				panelPaiReservation.getSéanceEnCoursDeReservation(), panelPaiReservation.getPrix(),
				panelPaiReservation.getNbDePlaces(), false);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		Date currentTime_1 = new Date();
		String dateString = formatter.format(currentTime_1);

		String numReservation = dateString + String.valueOf(panelPaiReservation.getUtilisateur().getIdUtilisateur())
				+ String.valueOf(panelPaiReservation.getSéanceEnCoursDeReservation().getIdSéance());

		System.out.println(numReservation);

		reservation.setNumReservation(numReservation);

		reservDao.saveOrUpdate(reservation);

		panelPaiReservation.getPgPrincipale().getCl().show(panelPaiReservation.getPgPrincipale().getCardLayoutContent(),
				"panelConfirmationReservation");
		panelPaiReservation.getPgPrincipale().getPanelConfirmationReservation().getLblNumeroDeRservation()
				.setText(numReservation);

	}

}
