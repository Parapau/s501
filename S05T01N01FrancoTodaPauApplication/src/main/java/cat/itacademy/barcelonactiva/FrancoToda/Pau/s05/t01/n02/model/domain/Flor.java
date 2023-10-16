package cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n02.model.domain;

import cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n02.model.dto.FlorDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table
public class Flor {

	
//	@TableGenerator(
//			name = "generadorid",
//			allocationSize = 1,
//			initialValue = 0)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
	private long pk_SucursalID;
	
	@Column(name = "nom")
	private String nomSucursal;

	@Column(name = "pais")
	private String paisSucursal;






	public Flor() {}


	public Flor(String nomSucursal, String paisSucursal) {
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}

	public Flor(long id, String nomSucursal, String paisSucursal) {
		this.pk_SucursalID = id;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}

	public long getPk_SucursalID() {
		return pk_SucursalID;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}



	public void setPk_SucursalID(long pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	public FlorDTO doting() {
		return new FlorDTO(this.getPk_SucursalID(), this.getNomSucursal(), this.getPaisSucursal());
	}

	@Override
	public String toString () {
		return getPk_SucursalID() + getNomSucursal() + getPaisSucursal();
	}



}
