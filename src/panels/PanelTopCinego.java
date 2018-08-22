package panels;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelTopCinego extends JPanel {

	JLabel titre;

	public PanelTopCinego() {

		titre = new JLabel("Cinego : Réservez n'a jamais été aussi simple");
		Font font = new Font("Arial", Font.BOLD, 16);
		titre.setFont(font);
		this.add(titre);

	}

}
