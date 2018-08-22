package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.UtilisateurDAO;
import metier.Utilisateur;
import panels.PanelLoginReservation;

public class EvePanelLoginReservation implements ActionListener {

	private PanelLoginReservation panCoReservation;

	public EvePanelLoginReservation(PanelLoginReservation panelCoReservation) {

		this.panCoReservation = panelCoReservation;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == panCoReservation.getBtnContinuerSansCompte()) {

			ReservationClientNonInscrit();

		}

		if (e.getSource() == panCoReservation.getBtnConnexion()) {

			if (panCoReservation.getTextFieldNumAbo().getText().equals("")) {

				JOptionPane.showMessageDialog(panCoReservation, "Vous n'avez pas entré un numéro de fidélité");

			} else {

				RecupClientInscrit(panCoReservation.getTextFieldNumAbo().getText());

			}

		}

		if (e.getSource() == panCoReservation.getBtnRetour()) {

			panCoReservation.getPagePrincipale().getCl()
					.show(panCoReservation.getPagePrincipale().getCardLayoutContent(), "panelReservation");

		}

		if (e.getSource() == panCoReservation.getBtnCreerUnCompte()) {

			panCoReservation.getPagePrincipale().getCl()
					.show(panCoReservation.getPagePrincipale().getCardLayoutContent(), "panelCreationClient");
			panCoReservation.getPagePrincipale().getPanelCreationClient().getTextFieldNom().setText("");
			panCoReservation.getPagePrincipale().getPanelCreationClient().getTextMail().setText("");
			panCoReservation.getPagePrincipale().getPanelCreationClient().getTextPrenom().setText("");
			panCoReservation.getPagePrincipale().getPanelCreationClient()
					.setSéanceEncours(panCoReservation.getSéanceEncours());
			panCoReservation.getPagePrincipale().getPanelCreationClient().setNbPlaces(panCoReservation.getNbPlaces());

		}

	}

	public void RecupClientInscrit(String numFi) {

		Utilisateur util = new Utilisateur();
		UtilisateurDAO utilDao = new UtilisateurDAO();
		util = utilDao.findByNumAbo(numFi);

		if (util == null) {

			System.out.println("aucun utilisateur");

		} else {

			System.out.println(util);

			panCoReservation.getPagePrincipale().getCl()
					.show(panCoReservation.getPagePrincipale().getCardLayoutContent(), "panelPaiementReservation");

			panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblHeureDebut()
					.setText("Heure de la séance " + panCoReservation.getSéanceEncours().getHeureDebut());
			panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblNbDePlaces()
					.setText("Nombres de places :" + String.valueOf(panCoReservation.getNbPlaces()));
			panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblNomFilm()
					.setText(panCoReservation.getSéanceEncours().getFilm().getTitre());
			panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblSalle().setText(
					String.valueOf("Numéro de la salle " + panCoReservation.getSéanceEncours().getSalle().getNuméro()));
			panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblNomPrénom()
					.setText(util.getNom() + " " + util.getPrenom());

			long prix = panCoReservation.getNbPlaces() * 8;

			panCoReservation.getPagePrincipale().getPanelPaiementReservation().setPrix((int) prix);
			panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblPrix()
					.setText(String.valueOf(prix) + " €");

			panCoReservation.getPagePrincipale().getPanelPaiementReservation()
					.setSéanceEnCoursDeReservation(panCoReservation.getSéanceEncours());
			panCoReservation.getPagePrincipale().getPanelPaiementReservation().setUtilisateur(util);
			panCoReservation.getPagePrincipale().getPanelPaiementReservation()
					.setNbDePlaces(panCoReservation.getNbPlaces());

		}

	}

	public void ReservationClientNonInscrit() {

		Utilisateur guest = new Utilisateur();
		UtilisateurDAO utilDao = new UtilisateurDAO();

		guest = utilDao.findByNumAbo("guest");

		panCoReservation.getPagePrincipale().getCl().show(panCoReservation.getPagePrincipale().getCardLayoutContent(),
				"panelPaiementReservation");

		panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblHeureDebut()
				.setText("Heure de la séance " + panCoReservation.getSéanceEncours().getHeureDebut());
		panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblNbDePlaces()
				.setText("Nombres de places :" + String.valueOf(panCoReservation.getNbPlaces()));
		panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblNomFilm()
				.setText(panCoReservation.getSéanceEncours().getFilm().getTitre());
		panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblSalle().setText(
				String.valueOf("Numéro de la salle " + panCoReservation.getSéanceEncours().getSalle().getNuméro()));
		panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblNomPrénom().setText("" + " " + "");

		long prix = panCoReservation.getNbPlaces() * 8;

		panCoReservation.getPagePrincipale().getPanelPaiementReservation().setPrix((int) prix);
		panCoReservation.getPagePrincipale().getPanelPaiementReservation().getLblPrix()
				.setText(String.valueOf(prix) + " €");

		panCoReservation.getPagePrincipale().getPanelPaiementReservation()
				.setSéanceEnCoursDeReservation(panCoReservation.getSéanceEncours());
		panCoReservation.getPagePrincipale().getPanelPaiementReservation().setUtilisateur(guest);
		panCoReservation.getPagePrincipale().getPanelPaiementReservation()
				.setNbDePlaces(panCoReservation.getNbPlaces());

	}

}
