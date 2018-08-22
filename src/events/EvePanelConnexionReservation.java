package events;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.time.DateUtils;

import dao.ReservationsDAO;
import dao.UtilisateurDAO;
import metier.Reservation;
import metier.Utilisateur;
import panels.PanelConnexionReservation;

public class EvePanelConnexionReservation implements ActionListener {

	private PanelConnexionReservation pCoReserv;
	private UtilisateurDAO utilDao;
	private ReservationsDAO reservDao;

	public EvePanelConnexionReservation(PanelConnexionReservation panCoReserv) {

		super();
		this.pCoReserv = panCoReserv;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == pCoReserv.getButtonConnexion()) {
			CheckConnexion();
		}

		if (e.getSource() == pCoReserv.getButtonConnexionNumReserv()) {

			System.out.println("Clic Bouton connexion NumReserv");

			if (pCoReserv.getTextreservation().getText().equals("")) {

				JOptionPane.showMessageDialog(pCoReserv, "Vous n'avez pas entré un numéro de réservation");

			} else {

				CheckNumReserv(pCoReserv.getTextreservation().getText());

			}

		}

		if (e.getSource() == pCoReserv.getBtnRetour()) {

			pCoReserv.getpPrinc().getCl().show(pCoReserv.getpPrinc().getCardLayoutContent(), "paneldem");

		}

	}

	public void CheckConnexion() {

		// Check si le champ login est vide

		Utilisateur util;
		List<Reservation> reservations;

		if (pCoReserv.getTextNumFi().getText().equals("")) {

			JOptionPane.showMessageDialog(pCoReserv, "Vous n'avez pas entré un numéro de fidélité");

		} else {

			utilDao = new UtilisateurDAO();
			util = utilDao.findByNumAbo(pCoReserv.getTextNumFi().getText());

			if (util == null) {

				JOptionPane.showMessageDialog(pCoReserv, "Aucun utilisateur ne correspond");

			} else {

				// pCoReserv.getpPrinc().getPanelListReservation().getListReservation().removeAllElements();

				System.out.println("tout va bien, récupération de la liste des réservations");
				reservDao = new ReservationsDAO();

				reservations = reservDao.findByClient(util.getIdUtilisateur());

				System.out.println(reservations);

				for (int i = 0; i < reservations.size(); i++) {

					pCoReserv.getpPrinc().getPanelListReservation().getListReservation()
							.addElement(reservations.get(i));

				}

				pCoReserv.getpPrinc().getCl().show(pCoReserv.getpPrinc().getCardLayoutContent(), "ListeReservation");
			}
		}
	}

	public void CheckNumReserv(String numReserv) {

		ReservationsDAO reservDao = new ReservationsDAO();
		Reservation reserv = new Reservation();

		reserv = reservDao.findByNumReserv(numReserv);

		if (reserv == null) {

			JOptionPane.showMessageDialog(pCoReserv, "Aucun utilisateur ne correspond");

		} else {

			pCoReserv.getpPrinc().getPanelChangementReservation().setRéservationEnCours(reserv);

			pCoReserv.getpPrinc().getPanelChangementReservation().getTxtpnSynopsys()
					.setText(reserv.getSéance().getFilm().getSynopsys());

			URL affiche = null;
			try {
				affiche = new URL("http://image.tmdb.org/t/p/w500" + reserv.getSéance().getFilm().getUrlAffiche());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			ImageIcon icon = new ImageIcon(affiche);
			Image img = icon.getImage();
			Image newImg = img.getScaledInstance(350, 700, Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(newImg);

			pCoReserv.getpPrinc().getPanelChangementReservation().getLblImageFilm().setIcon(image);
			pCoReserv.getpPrinc().getPanelChangementReservation().getLblImageFilm().setText("");

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
			Date currentTime_1 = reserv.getSéance().getDateSeance();
			String dateString = formatter.format(currentTime_1);

			pCoReserv.getpPrinc().getPanelChangementReservation().getLblDateReservation().setText(dateString);
			pCoReserv.getpPrinc().getPanelChangementReservation().getLblHeureseance()
					.setText(reserv.getSéance().getHeureDebut());
			pCoReserv.getpPrinc().getPanelChangementReservation().getLblNbdeplaces()
					.setText(String.valueOf(reserv.getNbPlace()));

			pCoReserv.getpPrinc().getPanelChangementReservation().getLblNomFilm()
					.setText(reserv.getSéance().getFilm().getTitre());
			pCoReserv.getpPrinc().getPanelChangementReservation().setRéservationEnCours(reserv);
			pCoReserv.getpPrinc().getPanelChangementReservation().getLblVersiontxt()
					.setText(reserv.getSéance().getVersion());
			pCoReserv.getpPrinc().getPanelChangementReservation().getChckbx3D()
					.setSelected(reserv.getSéance().isIs3D());

			pCoReserv.getpPrinc().getCl().show(pCoReserv.getpPrinc().getCardLayoutContent(), "ChangementReservation");

			Date dateReservation = reserv.getSéance().getDateSeance();
			Date dateDuJour = new Date();

			boolean bla = DateUtils.isSameDay(dateReservation, dateDuJour);

			dateDuJour.before(dateReservation);

			System.out.println(bla);

			if (bla == true) {

				System.out.println("Réservation = dateDujour");
				pCoReserv.getpPrinc().getPanelChangementReservation().getBtnRemboursement().setVisible(false);
				pCoReserv.getpPrinc().getPanelChangementReservation().getLblNonModification().setVisible(true);

			} else {

				if (dateReservation.before(dateDuJour) == true) {

					System.out.println("Réservation before dateDujour");
					pCoReserv.getpPrinc().getPanelChangementReservation().getBtnRemboursement().setVisible(false);
					pCoReserv.getpPrinc().getPanelChangementReservation().getLblNonModification().setVisible(true);

				} else {

					pCoReserv.getpPrinc().getPanelChangementReservation().getLblNonModification().setVisible(false);

				}

			}
		}

	}
}
