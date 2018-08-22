package dao;

import java.util.List;

import metier.Reservation;

public interface IReservationsDAO {

	public Reservation saveOrUpdate(Reservation reservation);

	public List<Reservation> getAll();

	public boolean remove(Reservation reservation);

	public boolean removeAll();

	public Reservation findById(int idReservation);

	public Reservation findByNumReserv(String numReserv);

	public List<Reservation> findBySeance(int idSeance);

	public List<Reservation> findByClient(int idClient);

	public List<Reservation> findByFilm(int idFilm);

	public List<Reservation> findByCinema(int idCinema);

}
