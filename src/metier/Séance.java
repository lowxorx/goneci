package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SEANCE")
public class Séance {

	@Id
	@Column(name = "SEANCE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSéance;

	@Column(name = "SEANCE_DUREE")
	private String durée;

	@Column(name = "SEANCE_PLACEDISPONIBLE")
	private String placeDisponible;

	@Column(name = "SEANCE_IS3D")
	private boolean is3D;

	@Column(name = "SEANCE_VERSION")
	private String version;

	@Column(name = "SEANCE_HEUREDEBUT")
	private String heureDebut;

	@Column(name = "SEANCE_HEUREFIN")
	private String heureFin;

	@Column(name = "SEANCE_DATESEANCE")
	private Date dateSeance;

	@OneToOne
	@JoinColumn(name = "idSalle", nullable = false)
	private Salle salle;

	@ManyToOne
	@JoinColumn(name = "FILM_ID", nullable = false)
	private Film film;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "séance")
	private List<Reservation> reservations = new ArrayList<Reservation>();

	public Séance() {
		super();
	}

	public Séance(int idSéance) {
		super();
		this.idSéance = idSéance;
	}

	public Séance(int idSéance, String durée, String placeDisponible, boolean is3d, String version, String heureDebut,
			String heureFin) {
		super();
		this.idSéance = idSéance;
		this.durée = durée;
		this.placeDisponible = placeDisponible;
		is3D = is3d;
		this.version = version;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	public Séance(String durée, String placeDisponible, boolean is3d, String version, String heureDebut,
			String heureFin) {
		super();
		this.durée = durée;
		this.placeDisponible = placeDisponible;
		is3D = is3d;
		this.version = version;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	public Séance(String durée, String placeDisponible, boolean is3d, String version, String heureDebut,
			String heureFin, Salle salle, Film film) {
		super();
		this.durée = durée;
		this.placeDisponible = placeDisponible;
		is3D = is3d;
		this.version = version;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.salle = salle;
		this.film = film;
	}

	public int getIdSéance() {
		return idSéance;
	}

	public void setIdSéance(int idSéance) {
		this.idSéance = idSéance;
	}

	public String getDurée() {
		return durée;
	}

	public void setDurée(String durée) {
		this.durée = durée;
	}

	public String getPlaceDisponible() {
		return placeDisponible;
	}

	public void setPlaceDisponible(String placeDisponible) {
		this.placeDisponible = placeDisponible;
	}

	public boolean isIs3D() {
		return is3D;
	}

	public void setIs3D(boolean is3d) {
		is3D = is3d;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Date getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(Date dateSeance) {
		this.dateSeance = dateSeance;
	}

	public List<Reservation> getReservations() {
		return (reservations == null) ? new ArrayList<Reservation>() : reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations.clear();
		this.reservations.addAll(reservations);
	}

	public List<Reservation> addReservation(Reservation reservation) {
		if (this.reservations.contains(reservation) || reservation == null)
			return reservations;
		reservations.add(reservation);
		reservation.setSéance(this);
		return reservations;
	}

	public List<Reservation> removeReservation(Reservation reservation) {
		if (!this.reservations.contains(reservation) || reservation == null)
			return reservations;
		reservations.remove(reservation);
		return reservations;
	}

	public List<Reservation> addAllReservations(List<Reservation> reservations) {
		if (this.reservations.equals(reservations) || reservations == null)
			return this.reservations;
		this.reservations.addAll(reservations);
		this.reservations.forEach((reservation) -> reservation.setSéance(this));
		return this.reservations;
	}

	public List<Reservation> removeAllReservation(List<Reservation> reservations) {
		if (reservations == null)
			return this.reservations;
		this.reservations.removeAll(reservations);
		return reservations;
	}

	public boolean containsReservation(Reservation reservation) {
		if (reservation == null)
			return false;
		return reservations.contains(reservation) ? true : false;
	}

	@Override
	public String toString() {
		return String.format(
				"%s {\n\tidSéance: %s\n\tdurée: %s\n\tplaceDisponible: %s\n\tis3D: %s\n\tversion: %s\n\theureDebut: %s\n\theureFin: %s\n\tsalle: %s\n\tfilm: %s\n\treservations: %s\n}",
				getClass().getName(), idSéance, durée, placeDisponible, is3D, version, heureDebut, heureFin, salle,
				film.getIdFilm(), reservations);
	}

}