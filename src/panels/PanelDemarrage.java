package panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import events.EvePanelDemarrage;
import vue.PagePrincipale;

@SuppressWarnings("serial")
public class PanelDemarrage extends JPanel {

	private PagePrincipale pPrinc;
	private JButton Btndemarrage;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private EvePanelDemarrage evePaneldem;
	private JButton btnNewButton;
	private JButton btnReservation;
	private Image img;
	ImageObserver imageObserver;

	public PanelDemarrage(PagePrincipale pagePrinc) {

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
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

		this.pPrinc = pagePrinc;
		this.gbl = new GridBagLayout();
		this.setLayout(gbl);
		this.evePaneldem = new EvePanelDemarrage(this);
		Font font = new Font("Arial", Font.BOLD, 16);

		ImageIcon icon = new ImageIcon("maxresdefault.jpg");
		img = icon.getImage();
		imageObserver = icon.getImageObserver();

		// img = Toolkit.getDefaultToolkit().createImage("maxresdefault.jpg");

		Btndemarrage = new JButton("Appuyez ici pour démarrer");
		Btndemarrage.setPreferredSize(new Dimension(400, 100));
		Btndemarrage.setFont(font);
		GridBagConstraints gbc_demarrage = new GridBagConstraints();
		gbc_demarrage.insets = new Insets(0, 0, 5, 0);
		gbc_demarrage.gridx = 0;
		gbc_demarrage.gridy = 0;
		this.add(Btndemarrage, gbc_demarrage);

		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(15, 15, 15, 15);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		btnReservation = new JButton("Acceder à une réservation");
		GridBagConstraints gbc_Reservation = new GridBagConstraints();
		gbc_Reservation.gridx = 0;
		gbc_Reservation.gridy = 3;
		btnReservation.setPreferredSize(new Dimension(400, 100));
		btnReservation.setFont(font);
		add(btnReservation, gbc_Reservation);

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;

		Btndemarrage.addActionListener(evePaneldem);
		btnReservation.addActionListener(evePaneldem);

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

	public GridBagLayout getGbl() {
		return gbl;
	}

	public void setGbl(GridBagLayout gbl) {
		this.gbl = gbl;
	}

	public GridBagConstraints getGbc() {
		return gbc;
	}

	public void setGbc(GridBagConstraints gbc) {
		this.gbc = gbc;
	}

	public EvePanelDemarrage getEvePaneldem() {
		return evePaneldem;
	}

	public void setEvePaneldem(EvePanelDemarrage evePaneldem) {
		this.evePaneldem = evePaneldem;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public JButton getBtndemarrage() {
		return Btndemarrage;
	}

	public void setBtndemarrage(JButton btndemarrage) {
		Btndemarrage = btndemarrage;
	}

	public JButton getBtnReservation() {
		return btnReservation;
	}

	public void setBtnReservation(JButton btnReservation) {
		this.btnReservation = btnReservation;
	}

}
