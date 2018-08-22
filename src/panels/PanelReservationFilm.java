package panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import events.EvePanelReservation;
import metier.Séance;
import vue.PagePrincipale;

@SuppressWarnings("serial")
public class PanelReservationFilm extends JPanel {

	private PagePrincipale pgPrincipale;
	private JLabel lblTitre;
	private JLabel synopsys;
	private JLabel PosterFilm;
	private JButton retour;
	private EvePanelReservation EveReservation;
	private JComboBox<Séance> comboSeance;

	public PanelReservationFilm(PagePrincipale pgPrinc) {

		this.pgPrincipale = pgPrinc;
		// EveReservation = new EvePanelReservation(this);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblTitre = new JLabel();
		GridBagConstraints gbc_PosterFilm = new GridBagConstraints();
		gbc_PosterFilm.insets = new Insets(0, 0, 5, 0);
		gbc_PosterFilm.gridx = 7;
		gbc_PosterFilm.gridy = 0;
		add(lblTitre, gbc_PosterFilm);

		PosterFilm = new JLabel();
		// GridBagConstraints gbc_PosterFilm1 = new GridBagConstraints();
		gbc_PosterFilm.gridx = 0;
		gbc_PosterFilm.gridy = 5;
		add(PosterFilm, gbc_PosterFilm);

		synopsys = new JLabel();
		gbc_PosterFilm.gridx = 2;
		gbc_PosterFilm.gridy = 5;
		gbc_PosterFilm.insets = new Insets(10, 10, 10, 10);
		add(synopsys, gbc_PosterFilm);

		retour = new JButton("retour");
		gbc_PosterFilm.gridx = 0;
		gbc_PosterFilm.gridy = 10;
		add(retour, gbc_PosterFilm);

		comboSeance = new JComboBox<Séance>();
		gbc_PosterFilm.gridx = 10;
		gbc_PosterFilm.gridy = 5;
		add(comboSeance, gbc_PosterFilm);

		retour.addActionListener(EveReservation);
		comboSeance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == getComboSeance())
					getseance();

			}
		});

	}

	// public void paint(Graphics g) {
	// // Draws the img to the BackgroundPanel.
	// g.drawImage(img, 0, 0, null);
	// }

	public void getseance() {

		Object séance = getComboSeance().getSelectedItem();
		String value = ((Séance) séance).getHeureFin();
		System.out.println(value);

	}

	public JLabel getLblTitre() {
		return lblTitre;
	}

	public void setLblTitre(JLabel lblTitre) {
		this.lblTitre = lblTitre;
	}

	public JLabel getSynopsys() {
		return synopsys;
	}

	public void setSynopsys(JLabel synopsys) {
		this.synopsys = synopsys;
	}

	public JLabel getPosterFilm() {
		return PosterFilm;
	}

	public void setPosterFilm(JLabel posterFilm) {
		PosterFilm = posterFilm;
	}

	public PagePrincipale getPgPrincipale() {
		return pgPrincipale;
	}

	public void setPgPrincipale(PagePrincipale pgPrincipale) {
		this.pgPrincipale = pgPrincipale;
	}

	public JButton getRetour() {
		return retour;
	}

	public void setRetour(JButton retour) {
		this.retour = retour;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboSeance() {
		return comboSeance;
	}

	@SuppressWarnings("unchecked")
	public void setComboSeance(@SuppressWarnings("rawtypes") JComboBox comboSeance) {
		this.comboSeance = comboSeance;
	}

}
