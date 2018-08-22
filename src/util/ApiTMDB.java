package util;

import java.util.ArrayList;
import java.util.List;

import dao.FilmsDAO;
import dao.GenreDAO;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Credits;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import metier.Film;

public class ApiTMDB {

	// private static String apiKey = "046c5c88e6645f0443bb351d373cc14a";
	// private static TmdbApi tmdbApi = new TmdbApi(apiKey);
	// private static TmdbMovies movies = tmdbApi.getMovies();

	/** API KEY */
	private static String apiKey = "046c5c88e6645f0443bb351d373cc14a";
	/** Création de l'objet de l'objet d'appel de l'API tmdb */
	private static TmdbApi tmdbApi;
	/** Initialisation de la récupération de film */
	private static TmdbMovies tmdbMovies;

	private static MovieResultsPage nowMoviesPage;

	private static ArrayList<MovieDb> nowMoviesList;

	public static void main(String[] args) {

		tmdbApi = new TmdbApi(apiKey);
		tmdbMovies = tmdbApi.getMovies();
		nowMoviesPage = tmdbMovies.getNowPlayingMovies("fr", null);
		nowMoviesList = new ArrayList<MovieDb>(nowMoviesPage.getResults());

		System.out.println(nowMoviesList);

		FilmsDAO filmDao = new FilmsDAO();

		new ArrayList<String>();
		List<info.movito.themoviedbapi.model.Genre> listegenre = new ArrayList<info.movito.themoviedbapi.model.Genre>();
		new ArrayList<Credits>();
		new GenreDAO();

		for (int i = 0; i < nowMoviesList.size(); i++) {
			Film f = new Film();
			f.setDateSortie(nowMoviesList.get(i).getReleaseDate());
			f.setDurée(nowMoviesList.get(i).getRuntime() + " minutes");
			listegenre = tmdbMovies.getMovie(nowMoviesList.get(i).getId(), "fr").getGenres();
			for (int ii = 0; ii < listegenre.size(); ii++) {
				f.setGenre(listegenre.get(ii).getName());
			}
			f.setSynopsys(nowMoviesList.get(i).getOverview());
			f.setTitre(nowMoviesList.get(i).getTitle());
			f.setUrlAffiche(nowMoviesList.get(i).getPosterPath());
			filmDao.saveOrUpdate(f);

		}

	}
}
