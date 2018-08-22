package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import events.EvePanelConfirmationReservation;
import metier.Reservation;
import vue.PagePrincipale;

public class PanelConfirmationReservation extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PagePrincipale pgPrincipale;
	private Reservation réservationEffectuée;
	private JLabel lblMerciDeVotre;
	private JLabel lblNumeroDeRservation;
	private JLabel lblABientotDans;
	private JButton btnRetourAuMenu;
	private String numReservation;
	private EvePanelConfirmationReservation eveConfirmationReservation;
	private Image img;
	ImageObserver imageObserver;

	public PanelConfirmationReservation(PagePrincipale pagePrincipale) {

		this.pgPrincipale = pagePrincipale;

		Font font = new Font("Arial", Font.BOLD, 16);
		// img = Toolkit.getDefaultToolkit().createImage("pel.jpg");

		ImageIcon icon = new ImageIcon("maxresdefault.jpg");
		img = icon.getImage();
		imageObserver = icon.getImageObserver();

		lblMerciDeVotre = new JLabel("Merci pour votre réservation");
		lblMerciDeVotre.setForeground(Color.WHITE);
		lblMerciDeVotre.setHorizontalAlignment(SwingConstants.CENTER);
		lblMerciDeVotre.setFont(font);

		lblNumeroDeRservation = new JLabel("Numéro de réservation");
		lblNumeroDeRservation.setForeground(Color.WHITE);
		lblNumeroDeRservation.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDeRservation.setFont(font);

		lblABientotDans = new JLabel("À bientôt dans votre cinéma préféré !");
		lblABientotDans.setForeground(Color.WHITE);
		lblABientotDans.setHorizontalAlignment(SwingConstants.CENTER);
		lblABientotDans.setFont(font);

		btnRetourAuMenu = new JButton("Retour au menu principal");
		btnRetourAuMenu.setFont(font);

		eveConfirmationReservation = new EvePanelConfirmationReservation(this);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(370)
						.addComponent(lblMerciDeVotre, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE).addGap(370))
				.addGroup(groupLayout.createSequentialGroup().addGap(370)
						.addComponent(lblNumeroDeRservation, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
						.addGap(370))
				.addGroup(groupLayout.createSequentialGroup().addGap(348)
						.addComponent(lblABientotDans, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE).addGap(350))
				.addGroup(groupLayout.createSequentialGroup().addGap(370)
						.addComponent(btnRetourAuMenu, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE).addGap(370)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addGap(136)
												.addComponent(lblMerciDeVotre, GroupLayout.DEFAULT_SIZE, 24,
														Short.MAX_VALUE)
												.addGap(79)
												.addComponent(lblNumeroDeRservation, GroupLayout.PREFERRED_SIZE, 14,
														Short.MAX_VALUE)
												.addGap(78)
												.addComponent(lblABientotDans, GroupLayout.DEFAULT_SIZE, 24,
														Short.MAX_VALUE)
												.addGap(78).addComponent(btnRetourAuMenu, GroupLayout.DEFAULT_SIZE, 88,
														Short.MAX_VALUE)
												.addGap(204)));
		setLayout(groupLayout);

		btnRetourAuMenu.addActionListener(eveConfirmationReservation);

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), imageObserver);
		setOpaque(false);
		super.paint(g);
		setOpaque(true);
	}

	public PagePrincipale getPgPrincipale() {
		return pgPrincipale;
	}

	public void setPgPrincipale(PagePrincipale pgPrincipale) {
		this.pgPrincipale = pgPrincipale;
	}

	public Reservation getRéservationEffectuée() {
		return réservationEffectuée;
	}

	public void setRéservationEffectuée(Reservation réservationEffectuée) {
		this.réservationEffectuée = réservationEffectuée;
	}

	public JLabel getLblMerciDeVotre() {
		return lblMerciDeVotre;
	}

	public void setLblMerciDeVotre(JLabel lblMerciDeVotre) {
		this.lblMerciDeVotre = lblMerciDeVotre;
	}

	public JLabel getLblNumeroDeRservation() {
		return lblNumeroDeRservation;
	}

	public void setLblNumeroDeRservation(JLabel lblNumeroDeRservation) {
		this.lblNumeroDeRservation = lblNumeroDeRservation;
	}

	public JLabel getLblABientotDans() {
		return lblABientotDans;
	}

	public void setLblABientotDans(JLabel lblABientotDans) {
		this.lblABientotDans = lblABientotDans;
	}

	public JButton getBtnRetourAuMenu() {
		return btnRetourAuMenu;
	}

	public void setBtnRetourAuMenu(JButton btnRetourAuMenu) {
		this.btnRetourAuMenu = btnRetourAuMenu;
	}

	public String getNumReservation() {
		return numReservation;
	}

	public void setNumReservation(String numReservation) {
		this.numReservation = numReservation;
	}

}
