package panels;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelGaucheDroite extends JPanel {

	private JLabel lab = new JLabel();

	public PanelGaucheDroite() {

		ImageIcon icon = new ImageIcon("filmCinego.jpg");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(300, 900, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		lab.setIcon(image);

		this.setBackground(Color.WHITE);

		this.add(lab);
	}

}
