package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import metier.Film;

public class FilmsDAO implements IFilmsDAO {

	private EntityManager eM = EntityManagerUtil.getEntityManager();

	public FilmsDAO() {
	}

	@Override
	public Film saveOrUpdate(Film film) {

		if (film == null)
			return null;

		try {

			eM.getTransaction().begin();
			if (eM.find(Film.class, film.getIdFilm()) == null) {
				eM.persist(film);
			} else if (eM.find(Film.class, film.getIdFilm()) != null) {
				eM.merge(film);
			}
			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}

		return film;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Film> getAll() {

		List<Film> films = new ArrayList<Film>();

		try {

			eM.getTransaction().begin();

			films = eM.createQuery("FROM Film").getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return films;
	}

	public List<Film> getAlaffiche() {

		List<Film> films = new ArrayList<Film>();
		boolean affiche = true;

		try {

			eM.getTransaction().begin();

			films = eM.createQuery("SELECT f FROM Film f WHERE f.aLaffiche =:affiche", Film.class)
					.setParameter("affiche", affiche).getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return films;
	}

	@Override
	public boolean remove(Film film) {

		boolean removed = false;

		if (film == null)
			return removed;

		try {

			eM.getTransaction().begin();

			if (eM.find(Film.class, film.getIdFilm()) != null) {
				eM.remove(eM.find(Film.class, film.getIdFilm()));
				removed = true;
			}

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return removed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean removeAll() {

		boolean removed = true;

		try {

			eM.getTransaction().begin();

			eM.createQuery("from Film").getResultList().forEach(film -> eM.remove(film));

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			removed = false;
			e.printStackTrace();
		} finally {
		}
		return removed;
	}

	@Override
	public Film findById(int idFilm) {

		Film film = null;

		try {

			eM.getTransaction().begin();

			film = eM.find(Film.class, idFilm);

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return film;
	}

	@Override
	public Film findByTitre(String titreFilm) {

		Film film = new Film();

		try {

			eM.getTransaction().begin();

			film = eM.createQuery("select f from Film f where f.titre =:titreFilm", Film.class)
					.setParameter("titreFilm", titreFilm).getSingleResult();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return film;
	}

	public EntityManager geteM() {
		return eM;
	}

}
