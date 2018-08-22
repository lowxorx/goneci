package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import metier.Reservation;

public class ReservationsDAO implements IReservationsDAO {

	private EntityManager eM = EntityManagerUtil.getEntityManager();

	public ReservationsDAO() {
	}

	@Override
	public Reservation saveOrUpdate(Reservation reservation) {

		if (reservation == null)
			return null;

		try {

			eM.getTransaction().begin();
			if (eM.find(Reservation.class, reservation.getIdReservation()) == null) {
				eM.persist(reservation);
			} else if (eM.find(Reservation.class, reservation.getIdReservation()) != null) {
				eM.merge(reservation);
			}
			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return reservation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> getAll() {

		List<Reservation> reservations = new ArrayList<Reservation>();

		try {

			eM.getTransaction().begin();

			reservations = eM.createQuery("from Reservation").getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return reservations;
	}

	@Override
	public boolean remove(Reservation reservation) {

		boolean removed = false;

		if (reservation == null)
			return removed;

		try {

			eM.getTransaction().begin();

			if (eM.find(Reservation.class, reservation.getIdReservation()) != null) {
				eM.remove(eM.find(Reservation.class, reservation.getIdReservation()));
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

			eM.createQuery("from Reservation").getResultList().forEach(reservation -> eM.remove(reservation));

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
	public Reservation findById(int idReservation) {

		Reservation reservation = null;

		try {

			eM.getTransaction().begin();

			reservation = eM.find(Reservation.class, idReservation);

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return reservation;
	}

	@Override
	public List<Reservation> findBySeance(int idSeance) {

		List<Reservation> reservations = new ArrayList<Reservation>();

		try {

			eM.getTransaction().begin();

			reservations = eM
					.createQuery("select r from Reservation r where r.séance.idSéance =:idSeance", Reservation.class)
					.setParameter("idSeance", idSeance).getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return reservations;
	}

	@Override
	public List<Reservation> findByClient(int idClient) {

		List<Reservation> reservations = new ArrayList<Reservation>();

		try {

			eM.getTransaction().begin();

			reservations = eM.createQuery("select r from Reservation r where r.client.idUtilisateur =:idClient",
					Reservation.class).setParameter("idClient", idClient).getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return reservations;
	}

	@Override
	public List<Reservation> findByFilm(int idFilm) {

		List<Reservation> reservations = new ArrayList<Reservation>();

		try {

			eM.getTransaction().begin();

			reservations = eM
					.createQuery("select r from Reservation r where r.séance.film.idFilm =:idFilm", Reservation.class)
					.setParameter("idFilm", idFilm).getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return reservations;
	}

	@Override
	public List<Reservation> findByCinema(int idCinema) {

		List<Reservation> reservations = new ArrayList<Reservation>();

		try {

			eM.getTransaction().begin();

			reservations = eM.createQuery("select r from Reservation r where r.séance.salle.cinema.idCinema =:idCinema",
					Reservation.class).setParameter("idCinema", idCinema).getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return reservations;
	}

	@Override
	public Reservation findByNumReserv(String numReserv) {

		Reservation reservation = null;

		try {

			eM.getTransaction().begin();

			reservation = eM.createQuery("SELECT r from Reservation r where r.numReservation =:numReservation",
					Reservation.class).setParameter("numReservation", numReserv).getSingleResult();
			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return reservation;
	}

}
