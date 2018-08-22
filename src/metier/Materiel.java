package metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIEL")
public class Materiel {

	@Id
	@Column(name = "ID_MATERIEL")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMatos;

	@Column(name = "TYPE_SON")
	private String typeSon;

	@Column(name = "TYPE_ECRAN")
	private String typeEcran;

	public Materiel(String son, String ecran) {
		this.typeSon = son;
		this.typeEcran = ecran;
	}

	public Materiel() {

	}

	public int getIdMatos() {
		return idMatos;
	}

	public void setIdMatos(int idMatos) {
		this.idMatos = idMatos;
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

	@Override
	public String toString() {
		return "Materiel [idMatos=" + idMatos + ", typeSon=" + typeSon + ", typeEcran=" + typeEcran + "]";
	}

}
