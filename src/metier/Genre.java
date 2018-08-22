package metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GENRE")
public class Genre {

	@Id
	@Column(name = "ID_GENRE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idGenre;

	@Column(name = "GENRE_FILM")
	private String genre;

	public Genre(String genre) {
		this.genre = genre;
	}

	public Genre() {

	}

	public int getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
