/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.UtilisateurDAO;
import panels.PanelLogin;

/**
 *
 * @author Bastien
 */
public class EvtLoginAdmin implements ActionListener {

	PanelLogin login;

	public EvtLoginAdmin(PanelLogin panelLogin) {
		this.login = panelLogin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login.getBtConnexion()) {
			checkconnexion();
		} else if (e.getSource() == login.getBtQuit()) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter ?", "Confirmation",
					dialogButton);
			if (dialogResult == JOptionPane.YES_OPTION) {
				System.exit(0);
			}

		}

	}

	public void checkconnexion() {
		String usr = login.gettbusername();
		String ps;
		ps = new String(login.gettbpassword());

		if (usr.isEmpty() || ps.isEmpty()) {
			JOptionPane.showMessageDialog(login, "Nom d'utilisateur ou mot de passe incorrect.");
		} else {
			UtilisateurDAO utildao = new UtilisateurDAO();
			if (utildao.isAdmin(usr, ps) == true) {
				showadminpage();
			} else {
				JOptionPane.showMessageDialog(login, "Vous n'êtes pas autorisé à afficher cette page !");
			}
		}

	}

	public void showadminpage() {
		login.getCinego().getCl().show(login.getCinego().getContent(), "Admin");
	}
}
