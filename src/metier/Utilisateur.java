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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur {

	@Id
	@Column(name = "UTILISATEUR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUtilisateur;

	@Column(name = "UTILISATEUR_NOM")
	private String nom;

	@Column(name = "UTILISATEUR_PRENOM")
	private String prenom;

	@Column(name = "UTILISATEUR_MAIL")
	private String email;

	@Column(name = "UTILISATEUR_NUMFIDELITE")
	private String numFidélité;

	@Column(name = "UTILISATEUR_ADMIN")
	private boolean admin;

	@Column(name = "UTILISATEUR_PASSWORD")
	private String password;

	@Column(name = "UTILISATEUR_PTSFI")
	private int ptsFi;

	@Column(name = "UTILISATEUR_GENRE_PREFERE")
	private String genrePref;

	@Column(name = "UTILISATEUR_CINEMA_PREFERE")
	private String cinePref;

	@Column(name = "UTILISATEUR_PUBLICITE")
	private boolean AutorisationPub;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE, CascadeType.REFRESH })
	private List<Reservation> reservations = new ArrayList<Reservation>();

	public Utilisateur() {
		super();
	}

	public Utilisateur(int IdClient) {
		super();
		this.idUtilisateur = IdClient;
	}

	public Utilisateur(int idUtilisateur, String nom, String prenom, String email, String numFidélité, boolean admin,
			String password, int ptsFi, String genrePref, String cinePref, List<Reservation> reservations) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numFidélité = numFidélité;
		this.admin = admin;
		this.password = password;
		this.ptsFi = ptsFi;
		this.genrePref = genrePref;
		this.cinePref = cinePref;
		this.reservations = reservations;
	}

	public Utilisateur(String nom, String prenom, String email, String numFidélité, boolean admin, String password,
			int ptsFi, String genrePref, String cinePref, List<Reservation> reservations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numFidélité = numFidélité;
		this.admin = admin;
		this.password = password;
		this.ptsFi = ptsFi;
		this.genrePref = genrePref;
		this.cinePref = cinePref;
		this.reservations = reservations;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumFidélité() {
		return numFidélité;
	}

	public void setNumFidélité(String numFidélité) {
		this.numFidélité = numFidélité;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPtsFi() {
		return ptsFi;
	}

	public void setPtsFi(int ptsFi) {
		this.ptsFi = ptsFi;
	}

	public String getGenrePref() {
		return genrePref;
	}

	public void setGenrePref(String genrePref) {
		this.genrePref = genrePref;
	}

	public String getCinePref() {
		return cinePref;
	}

	public void setCinePref(String cinePref) {
		this.cinePref = cinePref;
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
		reservation.setClient(this);
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
		this.reservations.forEach((reservation) -> reservation.setClient(this));
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
				"%s {\n\tidUtilisateur: %s\n\tnom: %s\n\tprenom: %s\n\temail: %s\n\tnumFidélité: %s\n\tadmin: %s\n\treservations: %s\n}",
				getClass().getName(), idUtilisateur, nom, prenom, email, numFidélité, admin, reservations);
	}

	public boolean isAutorisationPub() {
		return AutorisationPub;
	}

	public void setAutorisationPub(boolean autorisationPub) {
		AutorisationPub = autorisationPub;
	}

}
