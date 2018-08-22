package util;

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import metier.Film;

@SuppressWarnings("rawtypes")
public class MonCellRenderer implements ListCellRenderer {

	private ImageIcon[] tab;
	private String[] tab2;

	public MonCellRenderer(ArrayList<Film> mesfils) throws MalformedURLException {
		tab = new ImageIcon[mesfils.size()];
		tab2 = new String[mesfils.size()];

		for (int i = 0; i < mesfils.size(); i++) {

			tab[i] = new ImageIcon(new URL("http://i.stack.imgur.com/NCsHu.png"));
			tab2[i] = mesfils.get(i).getTitre();
		}

	}

	@Override
	public Component getListCellRendererComponent(JList jlist, Object value, int cellIndex, boolean isSelected,
			boolean cellHasFocus) {
		return new JLabel(tab[cellIndex]);
	}

}
