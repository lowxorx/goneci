package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import metier.Genre;

public class GenreDAO implements IGenreDAO {

	private EntityManager eM = EntityManagerUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> getAll() {
		List<Genre> genre = new ArrayList<Genre>();

		try {

			eM.getTransaction().begin();

			genre = eM.createQuery("FROM Genre").getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return genre;
	}

	@Override
	public boolean findByNom(String nomGenre) {
		Genre genre = new Genre();
		Boolean exist = false;
		try {

			eM.getTransaction().begin();

			genre = eM.createQuery("SELECT g FROM Genre g WHERE g.genre =:nomGenre", Genre.class)
					.setParameter("nomGenre", nomGenre).getSingleResult();
			if (genre != null) {
				exist = true;
			}

			eM.getTransaction().commit();

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			System.out.println("Le genre n'existe pas, ajout du genre dans la base.");
		} finally {
		}
		return exist;
	}

	@Override
	public boolean addGenre(String nomGenre) {
		Genre genre = new Genre();
		Boolean added = false;
		genre.setGenre(nomGenre);
		try {

			eM.getTransaction().begin();

			eM.persist(genre);
			added = true;
			eM.getTransaction().commit();

		} catch (Exception e) {

			if (eM.isOpen())
				eM.getTransaction().rollback();
			added = false;
			e.printStackTrace();
		} finally {
		}

		return added;
	}

}
