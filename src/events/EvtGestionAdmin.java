package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.UtilisateurDAO;
import metier.Utilisateur;
import panels.PanelGestionAdmin;

public class EvtGestionAdmin implements ActionListener {

	PanelGestionAdmin admin;

	public EvtGestionAdmin(PanelGestionAdmin panelGestionAdmin) {
		this.admin = panelGestionAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == admin.getBtnRetour()) {
			showadminpage();
		} else if (e.getSource() == admin.getBtCreer()) {
			creeradmin();
		} else if (e.getSource() == admin.getBtDelete()) {
			boolean delete = deleteadmin();
			if (delete != true) {
				JOptionPane.showMessageDialog(admin, "Erreur pendant la suppression de l'administrateur");
			} else {
				JOptionPane.showMessageDialog(admin, "Suppression effectuée.");
			}
		} else if (e.getSource() == admin.getBtMaj()) {
			updateadmin();
		} else if (e.getSource() == admin.getBtReset()) {
			resetfields();
		} else if (e.getSource() == admin.getBtRecherche()) {
			String adm = admin.getTbRechercheAdmin();
			searchadmin(adm);
		} else if (e.getSource() == admin.getCbListeAdmin()) {
			String adm = admin.getSelectedAdmin();
			searchadmin(adm);
		}

	}

	public void creeradmin() {
		Utilisateur newadm = new Utilisateur();
		newadm.setNom(admin.getTbNom());
		newadm.setPrenom(admin.getTbPrenom());
		newadm.setEmail(admin.getTbMail());
		newadm.setNumFidélité(admin.getTbLogin());
		newadm.setAdmin(true);
		newadm.setCinePref("ADMIN");
		newadm.setPtsFi(1);
		newadm.setGenrePref("ADMIN");

		String ps1 = new String(admin.getTbPass());
		String ps2 = new String(admin.getTbVerifPass());
		if (ps1.equals(ps2)) {
			newadm.setPassword(ps1);
			UtilisateurDAO utildao = new UtilisateurDAO();
			Utilisateur u = utildao.saveOrUpdate(newadm);
			if (u == null) {
				JOptionPane.showMessageDialog(admin, "Erreur pendant la création de l'administrateur");
			} else {
				JOptionPane.showMessageDialog(admin, "Administrateur créé avec succès");
			}
		} else {
			JOptionPane.showMessageDialog(admin, "Les mots de passe ne correspondent pas.");
		}
	}

	public void searchadmin(String adm) {
		Utilisateur administrateur = new Utilisateur();
		try {
			UtilisateurDAO utildao = new UtilisateurDAO();
			administrateur = utildao.findByNumAbo(adm);
			if (administrateur != null) {
				admin.setIdAdmin(administrateur.getIdUtilisateur());
				admin.setTbNom(administrateur.getNom());
				admin.setTbPrenom(administrateur.getPrenom());
				admin.setTbLogin(administrateur.getNumFidélité());
				admin.setTbPass(administrateur.getPassword());
				admin.setTbMail(administrateur.getEmail());

			} else {
				JOptionPane.showMessageDialog(admin, "Aucun résultat !");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public boolean deleteadmin() {
		Utilisateur adminToDel = new Utilisateur(admin.getIdAdmin());
		UtilisateurDAO utildao = new UtilisateurDAO();
		boolean delete = utildao.remove(adminToDel);
		return delete;
	}

	public void resetfields() {
		admin.setTbLogin("");
		admin.setTbMail("");
		admin.setTbNom("");
		admin.setTbPass("");
		admin.setTbPrenom("");
	}

	public void updateadmin() {
		UtilisateurDAO utildao = new UtilisateurDAO();
		Utilisateur admToUp = new Utilisateur();
		admToUp.setIdUtilisateur(admin.getIdAdmin());
		admToUp.setNom(admin.getTbNom());
		admToUp.setPrenom(admin.getTbPrenom());
		admToUp.setEmail(admin.getTbMail());
		admToUp.setNumFidélité(admin.getTbLogin());
		admToUp.setAdmin(true);
		admToUp.setCinePref("ADMIN");
		admToUp.setPtsFi(1);
		admToUp.setGenrePref("ADMIN");
		String ps1 = new String(admin.getTbPass());
		String ps2 = new String(admin.getTbVerifPass());
		if (ps1.equals(ps2)) {
			admToUp.setPassword(ps1);
			Utilisateur update = utildao.saveOrUpdate(admToUp);
			if (update == null) {
				JOptionPane.showMessageDialog(admin, "Erreur pendant la mise à jour de l'administrateur");
			} else {
				JOptionPane.showMessageDialog(admin, "Administrateur mis à jour avec succès");
			}
		} else {
			JOptionPane.showMessageDialog(admin, "Les mots de passe ne correspondent pas.");
		}
	}

	public void showadminpage() {
		admin.getCinego().getCl().show(admin.getCinego().getContent(), "Admin");
	}
}
