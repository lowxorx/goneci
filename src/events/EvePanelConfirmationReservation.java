package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import panels.PanelConfirmationReservation;

public class EvePanelConfirmationReservation implements ActionListener {

	private PanelConfirmationReservation pConfirmationReservation;

	public EvePanelConfirmationReservation(PanelConfirmationReservation panConfReserv) {

		this.pConfirmationReservation = panConfReserv;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == pConfirmationReservation.getBtnRetourAuMenu()) {

			RetourEcranPrincipal();

		}

	}

	public void RetourEcranPrincipal() {

		pConfirmationReservation.getPgPrincipale().getCl()
				.show(pConfirmationReservation.getPgPrincipale().getCardLayoutContent(), "paneldem");

	}

}
