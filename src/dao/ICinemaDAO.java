package dao;

import java.util.List;

import metier.Cinema;

public interface ICinemaDAO {
	public Cinema saveOrUpdate(Cinema cine);

	public List<Cinema> getAll();

	public boolean remove(Cinema cine);

	public boolean removeAll();

	public int findIdByNom(String nomCine);

	public Cinema findByNom(String nomCine);
}
