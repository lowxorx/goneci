package util;

import java.awt.Component;
import java.awt.Font;
import java.util.Map;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class FilmListRenderer extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, ImageIcon> imageMap;

	Font font = new Font("helvitica", Font.BOLD, 24);

	@Override
	public Component getListCellRendererComponent(@SuppressWarnings("rawtypes") JList list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {

		JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		label.setIcon(imageMap.get(value));
		label.setHorizontalTextPosition(SwingConstants.RIGHT);
		label.setFont(font);
		return label;

	}

}
