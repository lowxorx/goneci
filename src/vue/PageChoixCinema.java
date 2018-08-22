package vue;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import dao.CinemaDAO;
import metier.Cinema;

@SuppressWarnings("serial")
public class PageChoixCinema extends JFrame {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageChoixCinema() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(null);

		this.setSize(300, 300);

		this.setLocationRelativeTo(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(56, 101, 171, 28);
		getContentPane().add(comboBox);

		JLabel lblChoissisez = new JLabel("Choisissez votre cinema");
		lblChoissisez.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoissisez.setBounds(56, 46, 171, 14);
		getContentPane().add(lblChoissisez);

		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(97, 165, 89, 23);
		getContentPane().add(btnValider);

		CinemaDAO cineDao = new CinemaDAO();

		ArrayList<Cinema> cinemas = new ArrayList<Cinema>();

		cinemas = (ArrayList<Cinema>) cineDao.getAll();

		for (int i = 0; i < cinemas.size(); i++) {

			comboBox.addItem(cinemas.get(i));

		}

		btnValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cinema Cine = (Cinema) comboBox.getSelectedItem();

				try {

					PagePrincipale pgPrincipale = new PagePrincipale(Cine);
					pgPrincipale.setCine(Cine);
					pgPrincipale.setVisible(true);
					pgPrincipale.setExtendedState(Frame.MAXIMIZED_BOTH);

					getContentPane().setVisible(false);

				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}
}
