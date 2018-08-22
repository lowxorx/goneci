package panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import events.EvePanelConnexionReservation;
import vue.PagePrincipale;

public class PanelConnexionReservation extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PagePrincipale pPrinc;
	private EvePanelConnexionReservation evePanelCoReservation;
	private JTextField textreservation;
	private JButton buttonConnexion;
	private JButton buttonConnexionNumReserv;
	private JTextField textNumFi;
	private JLabel lblNumFi;
	private JButton btnRetour;
	private Image img;
	ImageObserver imageObserver;

	public PanelConnexionReservation(PagePrincipale pgPrinc) {

		this.pPrinc = pgPrinc;

		evePanelCoReservation = new EvePanelConnexionReservation(this);
		Font font = new Font("Arial", Font.BOLD, 16);

		// img = Toolkit.getDefaultToolkit().createImage("pel.jpg");

		ImageIcon icon = new ImageIcon("maxresdefault.jpg");
		img = icon.getImage();
		imageObserver = icon.getImageObserver();

		JLabel label_2 = new JLabel("Vous avez un compte?");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(650, 211, 188, 35);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(font);

		buttonConnexion = new JButton("Connexion");
		buttonConnexion.setFont(new Font("Arial", Font.BOLD, 16));
		buttonConnexion.setBounds(650, 498, 188, 61);

		buttonConnexion.addActionListener(evePanelCoReservation);

		buttonConnexionNumReserv = new JButton("Rechercher");
		buttonConnexionNumReserv.setFont(new Font("Arial", Font.BOLD, 16));
		buttonConnexionNumReserv.setBounds(1118, 498, 179, 61);

		buttonConnexionNumReserv.addActionListener(evePanelCoReservation);

		textreservation = new JTextField();
		textreservation.setBounds(1118, 380, 179, 31);
		textreservation.setColumns(10);

		JLabel label_3 = new JLabel("Un numéro de réservation?");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(1074, 219, 267, 19);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(font);

		JLabel label_4 = new JLabel("Numero de Réservation");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(1074, 265, 267, 24);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(font);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(569, 11, 19, 702);
		verticalStrut.setBackground(Color.BLACK);
		verticalStrut.setForeground(Color.BLACK);

		lblNumFi = new JLabel("Numéro fidélité :");
		lblNumFi.setForeground(Color.WHITE);
		lblNumFi.setBounds(650, 270, 188, 14);
		lblNumFi.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumFi.setFont(font);

		textNumFi = new JTextField();
		textNumFi.setBounds(650, 378, 188, 31);
		textNumFi.setFont(font);
		textNumFi.setColumns(10);
		setLayout(null);
		add(label_2);
		add(lblNumFi);
		add(textNumFi);
		add(buttonConnexion);
		add(verticalStrut);
		add(label_3);
		add(label_4);
		add(textreservation);
		add(buttonConnexionNumReserv);

		btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Arial", Font.BOLD, 16));
		btnRetour.setBounds(883, 652, 188, 61);
		btnRetour.addActionListener(evePanelCoReservation);
		add(btnRetour);

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), imageObserver);
		setOpaque(false);
		super.paint(g);
		setOpaque(true);
	}

	public PagePrincipale getpPrinc() {
		return pPrinc;
	}

	public void setpPrinc(PagePrincipale pPrinc) {
		this.pPrinc = pPrinc;
	}

	public EvePanelConnexionReservation getEvePanelCoReservation() {
		return evePanelCoReservation;
	}

	public void setEvePanelCoReservation(EvePanelConnexionReservation evePanelCoReservation) {
		this.evePanelCoReservation = evePanelCoReservation;
	}

	public JTextField getTextreservation() {
		return textreservation;
	}

	public void setTextreservation(JTextField textreservation) {
		this.textreservation = textreservation;
	}

	public JButton getButtonConnexion() {
		return buttonConnexion;
	}

	public void setButtonConnexion(JButton buttonConnexion) {
		this.buttonConnexion = buttonConnexion;
	}

	public JButton getButtonConnexionNumReserv() {
		return buttonConnexionNumReserv;
	}

	public void setButtonConnexionNumReserv(JButton buttonConnexionNumReserv) {
		this.buttonConnexionNumReserv = buttonConnexionNumReserv;
	}

	public JTextField getTextNumFi() {
		return textNumFi;
	}

	public void setTextNumFi(JTextField textNumFi) {
		this.textNumFi = textNumFi;
	}

	public JLabel getLblNumFi() {
		return lblNumFi;
	}

	public void setLblNumFi(JLabel lblNumFi) {
		this.lblNumFi = lblNumFi;
	}

	public JButton getBtnRetour() {
		return btnRetour;
	}

	public void setBtnRetour(JButton btnRetour) {
		this.btnRetour = btnRetour;
	}

}
