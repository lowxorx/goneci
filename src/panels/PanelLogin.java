package panels;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import appli.CinegoAdmin;
import events.EvtLoginAdmin;

public class PanelLogin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CinegoAdmin cine;
	private JTextField tbUsername;
	private JPasswordField tbPassword;
	private JButton btConnexion;
	private JButton btQuit;

	/**
	 * Create the panel.
	 */
	public PanelLogin(CinegoAdmin cinego) {
		this.cine = cinego;
		EvtLoginAdmin event = new EvtLoginAdmin(this);
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblConnexionLespace = new JLabel("Connexion à l'espace d'administration");
		lblConnexionLespace.setFont(new Font("Dialog", Font.BOLD, 18));
		lblConnexionLespace.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblEntrezVosInformations = new JLabel("Entrez vos informations d'identification :");
		lblEntrezVosInformations.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEntrezVosInformations.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur :");
		lblNomDutilisateur.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);

		tbUsername = new JTextField();
		tbUsername.setColumns(10);

		tbPassword = new JPasswordField();

		btConnexion = new JButton("Connexion");
		btConnexion.addActionListener(event);

		btQuit = new JButton("Quitter");
		btQuit.addActionListener(event);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblConnexionLespace,
								GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblEntrezVosInformations,
								GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(180)
								.addComponent(lblNomDutilisateur, GroupLayout.PREFERRED_SIZE, 181,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(tbUsername, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(180)
								.addComponent(lblMotDePasse, GroupLayout.PREFERRED_SIZE, 181,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(tbPassword, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(379).addComponent(btConnexion,
								GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(btQuit,
								GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(11)
										.addComponent(lblConnexionLespace).addGap(152)
										.addComponent(lblEntrezVosInformations).addGap(48)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(3)
														.addComponent(lblNomDutilisateur))
												.addComponent(tbUsername, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(2)
														.addComponent(lblMotDePasse))
												.addComponent(tbPassword, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18).addComponent(btConnexion).addGap(206).addComponent(btQuit)));
		setLayout(groupLayout);

	}

	public JButton getBtConnexion() {
		return btConnexion;
	}

	public String gettbusername() {
		return tbUsername.getText();
	}

	public char[] gettbpassword() {
		return tbPassword.getPassword();
	}

	public JButton getBtQuit() {
		return btQuit;
	}

	public JPasswordField getTBPASS() {
		return tbPassword;
	}

	public void setTbPassword(String tbPassword) {
		this.tbPassword.setText(tbPassword);
	}

	public CinegoAdmin getCinego() {
		return cine;
	}
}
