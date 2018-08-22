package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;

import dao.UtilisateurDAO;
import metier.Utilisateur;
import panels.PanelCreationClient;

public class EvePanelCreationClient implements ActionListener {

	private PanelCreationClient panCreaClient;

	public EvePanelCreationClient(PanelCreationClient panelCreationClient) {

		this.panCreaClient = panelCreationClient;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == panCreaClient.getBtnCreation()) {

			if (panCreaClient.getTextFieldNom().getText().equals("")) {

				JOptionPane.showMessageDialog(panCreaClient, "Vous n'avez pas saisie de nom");

			} else {

				if (panCreaClient.getTextMail().getText().equals("")) {

					JOptionPane.showMessageDialog(panCreaClient, "Vous n'avez pas saisie de mail");

				} else {

					if (panCreaClient.getTextPrenom().getText().equals("")) {

						JOptionPane.showMessageDialog(panCreaClient, "Vous n'avez pas saisie de prénom");

					} else {

						Utilisateur util = new Utilisateur();

						util.setNom(panCreaClient.getTextFieldNom().getText());
						util.setPrenom(panCreaClient.getTextPrenom().getText());
						util.setEmail(panCreaClient.getTextMail().getText());
						util.setGenrePref((String) panCreaClient.getComboBoxGenre().getSelectedItem());
						util.setCinePref((String) panCreaClient.getComboBoxCinema().getSelectedItem());

						if (panCreaClient.getCheckPublicité().isSelected() == true) {

							System.out.println("true");
							util.setAutorisationPub(true);

						} else {

							System.out.println("false");
							util.setAutorisationPub(false);

						}

						System.out.println(util);
						CreationClient(util);

					}

				}

			}

		}

		if (e.getSource() == panCreaClient.getButtonRetour()) {

			Retour();

		}
	}

	public void CreationClient(Utilisateur util) {

		UtilisateurDAO daoUtil = new UtilisateurDAO();
		String numRand = String.valueOf(randInt(1, 5000));
		String numFidelité = util.getNom().substring(0, 1) + util.getPrenom().substring(0, 1) + numRand;
		util.setNumFidélité(numFidelité);
		daoUtil.saveOrUpdate(util);

		Utilisateur utilEncours = new Utilisateur();
		utilEncours = daoUtil.findByNumAbo(numFidelité);

		panCreaClient.getPgPrincipale().getCl().show(panCreaClient.getPgPrincipale().getCardLayoutContent(),
				"panelPaiementReservation");

		panCreaClient.getPgPrincipale().getPanelPaiementReservation().getLblHeureDebut()
				.setText("Heure de la séance " + panCreaClient.getSéanceEncours().getHeureDebut());
		panCreaClient.getPgPrincipale().getPanelPaiementReservation().getLblNbDePlaces()
				.setText("Nombres de places :" + String.valueOf(panCreaClient.getNbPlaces()));
		panCreaClient.getPgPrincipale().getPanelPaiementReservation().getLblNomFilm()
				.setText(panCreaClient.getSéanceEncours().getFilm().getTitre());
		panCreaClient.getPgPrincipale().getPanelPaiementReservation().getLblSalle().setText(
				String.valueOf("Numéro de la salle " + panCreaClient.getSéanceEncours().getSalle().getNuméro()));
		panCreaClient.getPgPrincipale().getPanelPaiementReservation().getLblNomPrénom()
				.setText(utilEncours.getNom() + " " + utilEncours.getPrenom());

		long prix = panCreaClient.getNbPlaces() * 8;

		panCreaClient.getPgPrincipale().getPanelPaiementReservation().setPrix((int) prix);
		panCreaClient.getPgPrincipale().getPanelPaiementReservation().getLblPrix().setText(String.valueOf(prix) + " €");

		panCreaClient.getPgPrincipale().getPanelPaiementReservation()
				.setSéanceEnCoursDeReservation(panCreaClient.getSéanceEncours());
		panCreaClient.getPgPrincipale().getPanelPaiementReservation().setUtilisateur(utilEncours);
		panCreaClient.getPgPrincipale().getPanelPaiementReservation().setNbDePlaces(panCreaClient.getNbPlaces());

	}

	public static int randInt(int min, int max) {

		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public void Retour() {

		panCreaClient.getPgPrincipale().getCl().show(panCreaClient.getPgPrincipale().getCardLayoutContent(),
				"panelReservation");

	}

}
