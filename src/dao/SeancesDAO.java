package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import metier.Cinema;
import metier.Film;
import metier.Salle;
import metier.Séance;

public class SeancesDAO implements ISeancesDAO {

	private EntityManager eM = EntityManagerUtil.getEntityManager();

	@Override
	public Séance saveOrUpdate(Séance séance) {
		if (séance == null)
			return null;

		try {

			eM.getTransaction().begin();

			if (eM.find(Séance.class, séance.getIdSéance()) == null) {
				eM.persist(séance);
			} else if (eM.find(Séance.class, séance.getIdSéance()) != null) {
				eM.merge(séance);
			}
			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}

		return séance;

	}

	@Override
	public List<Séance> SearchSeance(Date date, int idFilm) {

		Film film = new Film(idFilm);

		List<Séance> séance = new ArrayList<Séance>();

		try {

			eM.getTransaction().begin();

			séance = eM.createQuery("select s from Séance s where s.dateSeance =:date AND s.film =:film", Séance.class)
					.setParameter("date", date).setParameter("film", film).getResultList();

			eM.getTransaction().commit();

			System.out.println(séance);

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}

		return séance;
	}

	@Override
	public List<Séance> SearchSeanceByIdSalle(int idSalle) {

		List<Séance> séance = new ArrayList<Séance>();
		Salle salle = new Salle(idSalle);

		try {

			eM.getTransaction().begin();

			séance = eM.createQuery("SELECT s FROM Séance s WHERE s.salle =:Salle", Séance.class)
					.setParameter("Salle", salle).getResultList();

			eM.getTransaction().commit();

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}

		return séance;
	}

	@Override
	public Séance findSeance(Date date, int idFilm, String heureDebut) {

		System.out.println("entrée dans findSéance");
		Séance séance = null;

		Film film = new Film(idFilm);

		System.out.println(date);
		System.out.println(idFilm);
		System.out.println(heureDebut);

		try {

			eM.getTransaction().begin();

			séance = eM
					.createQuery(
							"select s from Séance s where s.dateSeance =:date AND s.film =:film AND s.heureDebut =:heureDebut",
							Séance.class)
					.setParameter("date", date).setParameter("film", film).setParameter("heureDebut", heureDebut)
					.getSingleResult();

			eM.getTransaction().commit();

			System.out.println(séance);

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}

		return séance;
	}

	@Override
	public Séance findSeanceById(int idSeance) {

		Séance séance = new Séance(idSeance);

		try {

			eM.getTransaction().begin();

			séance = eM.createQuery("select s from Séance s where s.idSéance =:idSeance", Séance.class)
					.setParameter("idSeance", idSeance).getSingleResult();

			eM.getTransaction().commit();

			System.out.println(séance);

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}

		return séance;
	}

	@Override
	public List<Séance> findByCine(int idCine) {

		List<Séance> séances = new ArrayList<Séance>();
		Cinema cine = new Cinema(idCine);

		try {

			eM.getTransaction().begin();

			séances = eM.createQuery("SELECT s FROM Séance s WHERE s.salle.cinema =:cinema", Séance.class)
					.setParameter("cinema", cine).getResultList();

			eM.getTransaction().commit();

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}

		return séances;
	}

	@Override
	public List<Séance> findByCineAndFilm(int idCine, int idFilm) {

		List<Séance> séances = new ArrayList<Séance>();
		Cinema cine = new Cinema(idCine);
		Film film = new Film(idFilm);

		try {

			eM.getTransaction().begin();

			séances = eM
					.createQuery("SELECT s FROM Séance s WHERE s.salle.cinema =:cinema AND s.film =:film", Séance.class)
					.setParameter("cinema", cine).setParameter("film", film).getResultList();

			eM.getTransaction().commit();

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}

		return séances;
	}

}
