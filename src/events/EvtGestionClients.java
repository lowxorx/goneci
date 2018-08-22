package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import dao.UtilisateurDAO;
import metier.Reservation;
import metier.Utilisateur;
import panels.PanelGestionClients;

public class EvtGestionClients implements ActionListener {

	PanelGestionClients clients;

	public EvtGestionClients(PanelGestionClients panelGestionClients) {
		this.clients = panelGestionClients;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clients.getBtRetour()) {
			showadminpage();
		} else if (e.getSource() == clients.getBtRechercheClient()) {
			searchclient();

		} else if (e.getSource() == clients.getBtCreerClient()) {
			creerclient();

		} else if (e.getSource() == clients.getBtDeleteClient()) {
			boolean delete = deleteclient();
			if (delete != true) {
				JOptionPane.showMessageDialog(clients, "Erreur pendant la suppression du client");
			} else {
				JOptionPane.showMessageDialog(clients, "Suppression effectuée.");
			}

		} else if (e.getSource() == clients.getBtMajClient()) {
			UpdateUser();
		} else if (e.getSource() == clients.getbtClearTb()) {

			clients.setTbNomClient("");
			clients.setTbPrenomClient("");
			clients.setTbNumAbo("");
			clients.setTbPassClient("");
			clients.setTbPtsFidClient(0);
			clients.setTbMailClient("");
			clients.setTbRechercheClient("");
			clients.getCbResaClient().removeAllItems();
		} else if (e.getSource() == clients.getCbClientList()) {
			infosclient();
		}
	}

	public void showadminpage() {
		clients.getCinego().getCl().show(clients.getCinego().getContent(), "Admin");
	}

	public void infosclient() {
		String[] usr1 = clients.getCbClientList().getSelectedItem().toString().split(":");
		String usr = usr1[0];
		List<Reservation> resas;
		Utilisateur user = new Utilisateur();
		try {
			UtilisateurDAO utildao = new UtilisateurDAO();
			user = utildao.findByNumAbo(usr);
			if (user != null) {
				clients.setIdClient(user.getIdUtilisateur());
				clients.setTbNomClient(user.getNom());
				clients.setTbPrenomClient(user.getPrenom());
				clients.setTbNumAbo(user.getNumFidélité());
				clients.setTbPassClient(user.getPassword());
				clients.setTbPtsFidClient(user.getPtsFi());
				clients.setCbCinePref(user.getCinePref());
				clients.setCbGenrePref(user.getGenrePref());
				clients.setTbMailClient(user.getEmail());
				resas = user.getReservations();
				for (Iterator<Reservation> i = resas.iterator(); i.hasNext();) {
					Reservation r = i.next();
					clients.setCbResaClient(
							r.getSéance().getFilm().getTitre() + " -- " + r.getSéance().getHeureDebut());
				}
				System.out.println(clients.getIdClient());

			} else {
				JOptionPane.showMessageDialog(clients, "Aucun résultat !");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void searchclient() {
		String usr = clients.getTbRechercheClient();
		List<Reservation> resas;
		Utilisateur user = new Utilisateur();
		try {
			UtilisateurDAO utildao = new UtilisateurDAO();
			user = utildao.findByNumAbo(usr);
			if (user != null) {
				clients.setIdClient(user.getIdUtilisateur());
				clients.setTbNomClient(user.getNom());
				clients.setTbPrenomClient(user.getPrenom());
				clients.setTbNumAbo(user.getNumFidélité());
				clients.setTbPassClient(user.getPassword());
				clients.setTbPtsFidClient(user.getPtsFi());
				clients.setCbCinePref(user.getCinePref());
				clients.setCbGenrePref(user.getGenrePref());
				clients.setTbMailClient(user.getEmail());
				resas = user.getReservations();
				for (Iterator<Reservation> i = resas.iterator(); i.hasNext();) {
					Reservation r = i.next();
					clients.setCbResaClient(
							r.getSéance().getFilm().getTitre() + " -- " + r.getSéance().getHeureDebut());
				}
				System.out.println(clients.getIdClient());

			} else {
				JOptionPane.showMessageDialog(clients, "Aucun résultat !");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void creerclient() {
		Utilisateur newuser = new Utilisateur();
		newuser.setIdUtilisateur(clients.getIdClient());
		newuser.setNom(clients.getTbNomClient());
		newuser.setPrenom(clients.getTbPrenomClient());
		newuser.setEmail(clients.getTbMailClient());
		String numRand = String.valueOf(randInt(1, 5000));
		System.out.println(newuser.getNom().substring(0, 1));
		String numFidelité = newuser.getNom().substring(0, 1) + newuser.getPrenom().substring(0, 1) + numRand;
		newuser.setNumFidélité(numFidelité);
		newuser.setGenrePref(clients.getSelectedGenre());
		newuser.setCinePref(clients.getSelectedCinema());
		newuser.setPtsFi(Integer.parseInt(clients.getTbPtsFidClient()));

		String ps1 = new String(clients.getTbPassClient());
		String ps2 = new String(clients.getTbVerifPass());
		if (ps1.equals(ps2)) {
			newuser.setPassword(ps1);
			UtilisateurDAO utildao = new UtilisateurDAO();
			Utilisateur u = utildao.saveOrUpdate(newuser);
			if (u == null) {
				JOptionPane.showMessageDialog(clients, "Erreur pendant la création de l'utilisateur");
			} else {
				JOptionPane.showMessageDialog(clients, "Utilisateur créé avec succès");
			}
		} else {
			JOptionPane.showMessageDialog(clients, "Les mots de passe ne correspondent pas.");
		}
	}

	public static int randInt(int min, int max) {

		// Usually this can be a field rather than a method variable
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public boolean deleteclient() {
		Utilisateur userToDel = new Utilisateur(clients.getIdClient());
		UtilisateurDAO utildao = new UtilisateurDAO();
		boolean delete = utildao.remove(userToDel);
		return delete;
	}

	public void UpdateUser() {
		Utilisateur userToUp = new Utilisateur();
		UtilisateurDAO utildao = new UtilisateurDAO();
		userToUp.setIdUtilisateur(clients.getIdClient());
		userToUp.setNom(clients.getTbNomClient());
		userToUp.setPrenom(clients.getTbPrenomClient());
		userToUp.setEmail(clients.getTbMailClient());
		userToUp.setNumFidélité(clients.getTbNumAbo());
		userToUp.setGenrePref(clients.getSelectedGenre());
		userToUp.setCinePref(clients.getSelectedCinema());
		userToUp.setPtsFi(Integer.parseInt(clients.getTbPtsFidClient()));

		String ps1 = new String(clients.getTbPassClient());
		String ps2 = new String(clients.getTbVerifPass());
		if (ps1.equals(ps2)) {
			userToUp.setPassword(ps1);
			Utilisateur u = utildao.saveOrUpdate(userToUp);
			if (u == null) {
				JOptionPane.showMessageDialog(clients, "Erreur pendant la mise à jour de l'utilisateur");
			} else {
				JOptionPane.showMessageDialog(clients, "Utilisateur mis à jour avec succès");
			}
		} else {
			JOptionPane.showMessageDialog(clients, "Les mots de passe ne correspondent pas.");
		}
	}
}
