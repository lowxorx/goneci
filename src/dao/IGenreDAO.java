package dao;

import java.util.List;

import metier.Genre;

public interface IGenreDAO {

	public List<Genre> getAll();

	boolean findByNom(String nomGenre);

	public boolean addGenre(String nomGenre);

}
