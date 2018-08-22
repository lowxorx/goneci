package vue;

import java.awt.Component;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import metier.Film;

public class MonCellRenderer extends JLabel implements ListCellRenderer<Film> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonCellRenderer() {

		// this.add(lab);

		// TODO Auto-generated constructor stub
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Film> list, Film value, int index, boolean isSelected,
			boolean cellHasFocus) {

		URL affiche = null;
		try {
			affiche = new URL("http://image.tmdb.org/t/p/w500" + value.getUrlAffiche());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(affiche);
		Image img = icon.getImage().getScaledInstance(300, 420, Image.SCALE_SMOOTH);
		ImageIcon icored = new ImageIcon(img);
		setIcon(icored);
		return this;
	}

}
