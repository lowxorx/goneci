package metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CINEMA")
public class Cinema {

	@Id
	@Column(name = "CINEMA_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCinema;

	@Column(name = "CINEMA_NOM")
	private String nomcinema;

	@Column(name = "CINEMA_TARIFNORMAL")
	private int tarifNormal;

	@Column(name = "CINEMA_TARIFETUDIANT")
	private int tarifEtudiant;

	@Column(name = "CINEMA_TARIF3D")
	private int tarif3D;

	public Cinema() {
		super();
	}

	public Cinema(int IdCinema) {
		super();
		this.idCinema = IdCinema;
	}

	public Cinema(int idCinema, String nomcinema, int tarifNormal, int tarifEtudiant, int tarif3d) {
		super();
		this.idCinema = idCinema;
		this.nomcinema = nomcinema;
		this.tarifNormal = tarifNormal;
		this.tarifEtudiant = tarifEtudiant;
		tarif3D = tarif3d;
	}

	public int getIdCinema() {
		return idCinema;
	}

	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}

	public String getNomcinema() {
		return nomcinema;
	}

	public void setNomcinema(String nomcinema) {
		this.nomcinema = nomcinema;
	}

	public int getTarifNormal() {
		return tarifNormal;
	}

	public void setTarifNormal(int tarifNormal) {
		this.tarifNormal = tarifNormal;
	}

	public int getTarifEtudiant() {
		return tarifEtudiant;
	}

	public void setTarifEtudiant(int tarifEtudiant) {
		this.tarifEtudiant = tarifEtudiant;
	}

	public int getTarif3D() {
		return tarif3D;
	}

	public void setTarif3D(int tarif3d) {
		tarif3D = tarif3d;
	}

	@Override
	public String toString() {
		return nomcinema;
	}

}
