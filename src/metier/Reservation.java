package metier;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

	@Id
	@Column(name = "RESERVATION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReservation;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "UTILISATEUR_ID", nullable = false)
	private Utilisateur client;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "SEANCE_ID", nullable = false, unique = true)
	private Séance séance;

	@Column(name = "RESERVATION_PRIX")
	private int prix;

	@Column(name = "RESERVATION_NBPLACE")
	private int nbPlace;

	@Column(name = "RESERVATION_CHOIXPLACE")
	private boolean choixPlace;

	@Column(name = "NUM_RESERVATION")
	private String numReservation;

	public Reservation() {
		super();
	}

	public Reservation(int idReservation, Utilisateur client, Séance séance, int prix, int nbPlace,
			boolean choixPlace) {
		super();
		this.idReservation = idReservation;
		this.client = client;
		this.séance = séance;
		this.prix = prix;
		this.nbPlace = nbPlace;
		this.choixPlace = choixPlace;
	}

	public Reservation(Utilisateur client, Séance séance, int prix, int nbPlace, boolean choixPlace) {
		super();
		this.client = client;
		this.séance = séance;
		this.prix = prix;
		this.nbPlace = nbPlace;
		this.choixPlace = choixPlace;
	}

	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public Utilisateur getClient() {
		return client;
	}

	public void setClient(Utilisateur client) {
		this.client = client;
	}

	public Séance getSéance() {
		return séance;
	}

	public void setSéance(Séance séance) {
		this.séance = séance;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public boolean isChoixPlace() {
		return choixPlace;
	}

	public void setChoixPlace(boolean choixPlace) {
		this.choixPlace = choixPlace;
	}

	public String getNumReservation() {
		return numReservation;
	}

	public void setNumReservation(String numReservation) {
		this.numReservation = numReservation;
	}

	@Override
	public String toString() {
		return "séance =" + séance.getHeureDebut() + ", prix=" + prix + " €" + ", Nombre de places :" + nbPlace
				+ ", numéro de réservation :" + numReservation;
	}

	// @Override
	// public String toString() {
	// return String
	// .format("%s {\n\tidReservation: %s\n\tclient: %s\n\tséance: %s\n\tprix:
	// %s\n\tnbPlace: %s\n\tchoixPlace: %s\n}",
	// getClass().getName(), idReservation, client.getIdUtilisateur(),
	// séance.getIdSéance(),
	// prix, nbPlace, choixPlace);
	// }

}