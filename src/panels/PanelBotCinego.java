package panels;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBotCinego extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel copyright;

	public PanelBotCinego() {

		copyright = new JLabel("Copyright CESI RILA 2015");
		Font font = new Font("Arial", Font.BOLD, 16);
		copyright.setFont(font);
		this.add(copyright);

	}

}
