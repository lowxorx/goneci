package dao;

import java.util.Date;
import java.util.List;

import metier.Séance;

public interface ISeancesDAO {

	public Séance saveOrUpdate(Séance séance);

	public List<Séance> SearchSeance(Date date, int idFilm);

	public Séance findSeance(Date date, int idFilm, String heureDebut);

	public List<Séance> SearchSeanceByIdSalle(int idSalle);

	public Séance findSeanceById(int idSeance);

	public List<Séance> findByCine(int idcine);

	public List<Séance> findByCineAndFilm(int idCine, int idFilm);

}
