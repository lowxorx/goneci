package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.SystemColor;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;

import metier.Reservation;

@SuppressWarnings("rawtypes")
public class ResaCellRenderer extends JTextPane implements ListCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	private JLabel lab = new JLabel();
	JTextPane pane = new JTextPane();
	private ImageIcon image;
	Calendar cal = Calendar.getInstance();

	/**
	 * TODO commenter le role du Constructeur
	 */
	public ResaCellRenderer() {
		setOpaque(false);
		this.setLayout(new BorderLayout());
		lab.setOpaque(false);
		pane.setOpaque(false);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		Reservation resa = (Reservation) value;

		ImageIcon icon = new ImageIcon(resa.getSéance().getFilm().getUrlAffiche());
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(220, 200, Image.SCALE_SMOOTH);
		image = new ImageIcon(newImg);
		lab.setIcon(image);
		pane.setText(resa.toString());
		this.add(lab, BorderLayout.WEST);
		this.add(pane, BorderLayout.CENTER);

		if (isSelected) {
			setForeground(SystemColor.textHighlight);
		} else {
			setForeground(Color.black);
		}

		return this;
	}
}
