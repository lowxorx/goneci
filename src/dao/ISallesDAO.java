package dao;

import java.util.List;

import metier.Salle;

public interface ISallesDAO {
	public Salle saveOrUpdate(Salle salle);

	public List<Salle> getAll();

	public List<Salle> getAllByCine(int idCine);

	public boolean remove(Salle salle);

	public boolean removeAll();

	public List<Salle> findByNom(String nomSalle);

	public Salle getOneByNumSalle(int idCine, int numSalle);

}
