package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import metier.Cinema;
import metier.Salle;

public class SallesDAO implements ISallesDAO {

	private EntityManager eM = EntityManagerUtil.getEntityManager();

	@Override
	public Salle saveOrUpdate(Salle salle) {
		if (salle == null)
			return null;

		try {

			eM.getTransaction().begin();
			if (eM.find(Salle.class, salle.getIdSalle()) == null) {
				eM.persist(salle);
			} else if (eM.find(Salle.class, salle.getIdSalle()) != null) {
				eM.merge(salle);
			}
			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}

		return salle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salle> getAll() {
		List<Salle> sallelist = new ArrayList<Salle>();

		try {

			eM.getTransaction().begin();

			sallelist = eM.createQuery("FROM Salle").getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return sallelist;
	}

	@Override
	public List<Salle> getAllByCine(int idCine) {
		List<Salle> sallelist = new ArrayList<Salle>();
		Cinema cinema = new Cinema();
		cinema.setIdCinema(idCine);
		try {

			eM.getTransaction().begin();

			sallelist = eM.createQuery("SELECT s FROM Salle s WHERE s.cinema =:idcine", Salle.class)
					.setParameter("idcine", cinema).getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return sallelist;
	}

	@Override
	public boolean remove(Salle salle) {
		if (salle == null) {
			return false;
		}
		int idSalleToDel = salle.getIdSalle();
		boolean isDeleted = false;
		try {
			eM.getTransaction().begin();

			salle = eM.createQuery("DELETE s FROM Salle s WHERE s.idSalle =:idSalleToDel", Salle.class)
					.setParameter("idSalleToDel", idSalleToDel).getSingleResult();

			eM.getTransaction().commit();
			isDeleted = true;
		} catch (Exception e) {
			isDeleted = false;
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return isDeleted;
	}

	@Override
	public boolean removeAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Salle> findByNom(String nomSalle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salle getOneByNumSalle(int idCine, int numSalle) {
		Salle salle = new Salle();
		Cinema cinema = new Cinema();
		cinema.setIdCinema(idCine);
		try {
			eM.getTransaction().begin();

			salle = eM.createQuery("SELECT s FROM Salle s WHERE s.cinema =:idcine AND s.numéro =:numsalle", Salle.class)
					.setParameter("idcine", cinema).setParameter("numsalle", numSalle).getSingleResult();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return salle;
	}
}
