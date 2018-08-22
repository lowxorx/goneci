package dao;

import java.util.List;

import metier.Film;

public interface IFilmsDAO {

	public Film saveOrUpdate(Film film);

	public List<Film> getAll();

	public boolean remove(Film film);

	public boolean removeAll();

	public Film findById(int idFilm);

	public Film findByTitre(String titreFilm);

}
