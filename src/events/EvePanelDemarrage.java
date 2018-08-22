package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import panels.PanelDemarrage;

public class EvePanelDemarrage implements ActionListener {

	private PanelDemarrage paneldem;

	public EvePanelDemarrage(PanelDemarrage paneldem) {
		super();
		this.paneldem = paneldem;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == paneldem.getBtndemarrage())
			switchPanChoixFilm();
		if (e.getSource() == paneldem.getBtnReservation())
			switchPanConnexionReservation();

	}

	public void switchPanChoixFilm() {

		paneldem.getpPrinc().getCl().show(paneldem.getpPrinc().getCardLayoutContent(), "panelChoixFilm");

	}

	public void switchPanConnexionReservation() {

		paneldem.getpPrinc().getPanelCoReservation().getTextFieldNumAbo().setText("");
		paneldem.getpPrinc().getPanelCoReservation().getTextField().setText("");
		paneldem.getpPrinc().getCl().show(paneldem.getpPrinc().getCardLayoutContent(), "PanelCoReservation");

	}

}
