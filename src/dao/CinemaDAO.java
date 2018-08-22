package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import metier.Cinema;

public class CinemaDAO implements ICinemaDAO {

	private EntityManager eM = EntityManagerUtil.getEntityManager();

	@Override
	public Cinema saveOrUpdate(Cinema cine) {
		if (cine == null)
			return null;

		try {

			eM.getTransaction().begin();
			if (eM.find(Cinema.class, cine.getIdCinema()) == null) {
				eM.persist(cine);
			} else if (eM.find(Cinema.class, cine.getIdCinema()) != null) {
				eM.merge(cine);
			}
			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}

		return cine;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cinema> getAll() {

		List<Cinema> cinelist = new ArrayList<Cinema>();

		try {

			eM.getTransaction().begin();

			cinelist = eM.createQuery("from Cinema").getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return cinelist;
	}

	@Override
	public boolean remove(Cinema cine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cinema findByNom(String nomCine) {
		Cinema cine = new Cinema();

		try {

			eM.getTransaction().begin();

			cine = eM.createQuery("select c from Cinema c where c.nomcinema =:nomCine", Cinema.class)
					.setParameter("nomCine", nomCine).getSingleResult();

			eM.getTransaction().commit();

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return cine;
	}

	@Override
	public int findIdByNom(String nomCine) {
		Cinema cine = new Cinema();

		try {

			eM.getTransaction().begin();

			cine = eM.createQuery("select c from Cinema c where c.nomcinema =:nomCine", Cinema.class)
					.setParameter("nomCine", nomCine).getSingleResult();

			eM.getTransaction().commit();

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return cine.getIdCinema();
	}

}
