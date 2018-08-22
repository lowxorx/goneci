package metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FILM")
public class Film {

	@Id
	@Column(name = "FILM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFilm;

	@Column(name = "FILM_TITRE")
	private String titre;

	@Column(name = "FILM_DUREE")
	private String durée;

	@Column(name = "FILM_GENRE")
	private String genre;

	@Column(name = "FILM_DATESORTIE")
	private String dateSortie;

	@Column(name = "FILM_REALISATEUR")
	private String Réalisateur;

	@Lob
	@Column(name = "FILM_SYNOPSIS", length = 1000000)
	private String synopsys;

	@Column(name = "FILM_URLAFFICHE")
	private String urlAffiche;

	@Column(name = "FILM_A_LAFFICHE")
	private boolean aLaffiche;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "film", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<Séance> séances = new ArrayList<Séance>();

	public Film() {
		super();
	}

	public Film(int idFilm) {
		super();
		this.idFilm = idFilm;

	}

	public Film(int idFilm, String titre, String durée, String genre, String dateSortie, String réalisateur,
			String synopsys, String urlAffiche, boolean aLaffiche) {
		super();
		this.idFilm = idFilm;
		this.titre = titre;
		this.durée = durée;
		this.genre = genre;
		this.dateSortie = dateSortie;
		Réalisateur = réalisateur;
		this.synopsys = synopsys;
		this.urlAffiche = urlAffiche;
		this.aLaffiche = aLaffiche;
	}

	public Film(String titre, String durée, String genre, String dateSortie, String réalisateur, String synopsys,
			String urlAffiche, boolean aLaffiche) {
		super();
		this.titre = titre;
		this.durée = durée;
		this.genre = genre;
		this.dateSortie = dateSortie;
		Réalisateur = réalisateur;
		this.synopsys = synopsys;
		this.urlAffiche = urlAffiche;
		this.aLaffiche = aLaffiche;
	}

	public int getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDurée() {
		return durée;
	}

	public void setDurée(String durée) {
		this.durée = durée;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getRéalisateur() {
		return Réalisateur;
	}

	public void setRéalisateur(String réalisateur) {
		Réalisateur = réalisateur;
	}

	public String getSynopsys() {
		return synopsys;
	}

	public void setSynopsys(String synopsys) {
		this.synopsys = synopsys;
	}

	public String getUrlAffiche() {
		return urlAffiche;
	}

	public void setUrlAffiche(String urlAffiche) {
		this.urlAffiche = urlAffiche;
	}

	public boolean isaLaffiche() {
		return aLaffiche;
	}

	public void setaLaffiche(boolean aLaffiche) {
		this.aLaffiche = aLaffiche;
	}

	public List<Séance> getSéances() {
		return (séances == null) ? new ArrayList<Séance>() : séances;
	}

	public void setSéances(List<Séance> séances) {
		this.séances.clear();
		this.séances.addAll(séances);
	}

	public List<Séance> addSéance(Séance séance) {
		if (this.séances.contains(séance) || séance == null)
			return séances;
		séances.add(séance);
		séance.setFilm(this);
		return séances;
	}

	public List<Séance> removeSéance(Séance séance) {
		if (!this.séances.contains(séance) || séance == null)
			return séances;
		séances.remove(séance);
		return séances;
	}

	public List<Séance> addAllSéances(List<Séance> séances) {
		if (this.séances.equals(séances) || séances == null)
			return this.séances;
		this.séances.addAll(séances);
		this.séances.forEach((séance) -> séance.setFilm(this));
		return this.séances;
	}

	public List<Séance> removeAllSéances(List<Séance> séances) {
		if (séances == null)
			return this.séances;
		this.séances.removeAll(séances);
		return séances;
	}

	public boolean containsSéance(Séance séance) {
		if (séance == null)
			return false;
		return séances.contains(séance) ? true : false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Réalisateur == null) ? 0 : Réalisateur.hashCode());
		result = prime * result + ((dateSortie == null) ? 0 : dateSortie.hashCode());
		result = prime * result + ((durée == null) ? 0 : durée.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + idFilm;
		result = prime * result + ((synopsys == null) ? 0 : synopsys.hashCode());
		result = prime * result + ((séances == null) ? 0 : séances.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		result = prime * result + ((urlAffiche == null) ? 0 : urlAffiche.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (Réalisateur == null) {
			if (other.Réalisateur != null)
				return false;
		} else if (!Réalisateur.equals(other.Réalisateur))
			return false;
		if (dateSortie == null) {
			if (other.dateSortie != null)
				return false;
		} else if (!dateSortie.equals(other.dateSortie))
			return false;
		if (durée == null) {
			if (other.durée != null)
				return false;
		} else if (!durée.equals(other.durée))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (idFilm != other.idFilm)
			return false;
		if (synopsys == null) {
			if (other.synopsys != null)
				return false;
		} else if (!synopsys.equals(other.synopsys))
			return false;
		if (séances == null) {
			if (other.séances != null)
				return false;
		} else if (!séances.equals(other.séances))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		if (urlAffiche == null) {
			if (other.urlAffiche != null)
				return false;
		} else if (!urlAffiche.equals(other.urlAffiche))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"%s {\n\tidFilm: %s\n\ttitre: %s\n\tdurée: %s\n\tgenre: %s\n\tdateSortie: %s\n\tRéalisateur: %s\n\tsynopsys: %s\n\turlAffiche: %s\n\tséances: %s\n}",
				getClass().getName(), idFilm, titre, durée, genre, dateSortie, Réalisateur, synopsys, urlAffiche,
				séances);
	}

}