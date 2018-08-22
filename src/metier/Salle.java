package metier;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SALLE")
public class Salle {

	@Id
	@Column(name = "SALLE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSalle;

	@Column(name = "SALLE_NUMERO")
	private int numéro;

	@Column(name = "SALLE_NOM")
	private String nomSalle;

	@Column(name = "SALLE_NOMBRERANGEE")
	private int nbRangées;

	@Column(name = "SALLE_NOMBRESIEGERANGEE")
	private int nbSiegeRangées;

	@Column(name = "SALLE_NOMBRESIEGEHANDICAPE")
	private int nbSiegeHandi;

	@Column(name = "SALLE_NBPLACESTOTAL")
	private int nbPlacesTotal;

	@Column(name = "SALLE_TYPESON")
	private String typeSon;

	@Column(name = "SALLE_TYPEECRAN")
	private String typeEcran;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "cinema", referencedColumnName = "CINEMA_ID", nullable = false, insertable = true, updatable = true)
	private Cinema cinema;

	public Salle() {
		super();
	}

	public Salle(int idSalle) {
		super();
		this.idSalle = idSalle;
	}

	public Salle(int numéro, int nbRangées, int nbSiegeRangées, int nbSiegeH, int nbPlaces, String typeSon,
			String typeEcran, String nomSalle, Cinema cinema) {
		super();
		this.numéro = numéro;
		this.nbRangées = nbRangées;
		this.nbSiegeRangées = nbSiegeRangées;
		this.cinema = cinema;
		this.nomSalle = nomSalle;
		this.typeEcran = typeEcran;
		this.typeSon = typeSon;
		this.nbPlacesTotal = nbPlaces;
	}

	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public int getNuméro() {
		return numéro;
	}

	public void setNuméro(int numéro) {
		this.numéro = numéro;
	}

	public int getNbRangées() {
		return nbRangées;
	}

	public void setNbRangées(int nbRangées) {
		this.nbRangées = nbRangées;
	}

	public int getNbSiegeRangées() {
		return nbSiegeRangées;
	}

	public void setNbSiegeRangées(int nbSiegeRangées) {
		this.nbSiegeRangées = nbSiegeRangées;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public int getNbSiegeHandi() {
		return nbSiegeHandi;
	}

	public void setNbSiegeHandi(int nbSiegeHandi) {
		this.nbSiegeHandi = nbSiegeHandi;
	}

	public int getNbPlacesTotal() {
		return nbPlacesTotal;
	}

	public void setNbPlacesTotal(int nbPlacesTotal) {
		this.nbPlacesTotal = nbPlacesTotal;
	}

	public String getTypeSon() {
		return typeSon;
	}

	public void setTypeSon(String typeSon) {
		this.typeSon = typeSon;
	}

	public String getTypeEcran() {
		return typeEcran;
	}

	public void setTypeEcran(String typeEcran) {
		this.typeEcran = typeEcran;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nSalle) {
		this.nomSalle = nSalle;
	}

	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", numéro=" + numéro + ", nbRangées=" + nbRangées + ", nbSiegeRangées="
				+ nbSiegeRangées + ", nbSiegeHandi=" + nbSiegeHandi + ", cinema=" + cinema + "]";
	}

}
