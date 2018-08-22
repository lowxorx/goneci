package appli;

import java.net.MalformedURLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import vue.PageChoixCinema;

public class CinegoClient {

	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		//
		// PagePrincipale page = new PagePrincipale();
		// page.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// page.setVisible(true);

		//
		// PageChoixCinema pageChoixCinema = new PageChoixCinema();
		// pageChoixCinema.setVisible(true);
		//

		// SeancesDAO sDAO = new SeancesDAO();
		//
		// ArrayList<Séance> séances = new ArrayList<Séance>();
		//
		// séances = (ArrayList<Séance>) sDAO.findByCine(1);
		//
		// ArrayList<Integer> films = new ArrayList<Integer>();
		//
		// Film film = null;
		//
		// for (int i = 0; i < séances.size(); i++) {
		//
		// if(films.contains(séances.get(i).getFilm().getIdFilm()) == false){
		//
		// System.out.println("ne contient pas, ajoute");
		// films.add(séances.get(i).getFilm().getIdFilm());
		//
		// }else{
		//
		// System.out.println("existe déjà");
		//
		// }
		// }
		//
		// System.out.println(films);
		//
		// }

		PageChoixCinema pageChoixCinema = new PageChoixCinema();
		pageChoixCinema.setVisible(true);

	}
}
