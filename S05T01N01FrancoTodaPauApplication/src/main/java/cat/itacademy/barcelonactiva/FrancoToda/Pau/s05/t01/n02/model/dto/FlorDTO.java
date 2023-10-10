package cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n02.model.dto;

import java.util.Arrays;
import java.util.List;


public class FlorDTO {
//sucursal es otra forma de decir flor y por eso en algunos sitios aun pone sucursal
	private long pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	public String tipusSucursal;//ha de ser public perque si no peta, perque els altres no els hi fa falta no en tinc ni idea pero l'html peta si aquest no es public JODER
	private static final List<String> paisosUE;


	static {
		paisosUE = Arrays.asList ("Espanya", "França", "Belgica", "Holanda", "Luxemburg", "Alemanya", "Irlanda", "Italia", "Republica Xeca", "Slovakia", "Eslovenia", "Croacia", "Grecia", "Polonia",
				"Estonia", "Latvia", "Lituania", "Austria", "Malta", "Portugal", "Bulgaria", "Romania", "Xipre", "Suecia", "Finalndia", "Hungria", "Dinamarca");


	}


	public FlorDTO() {}


	public FlorDTO(String nomSucursal, String paisSucursal) {
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.tipusSucursal = (getUE().contains(getPaisSucursal()))?"UE":"Fora UE";
	}

	public FlorDTO(long id, String nomSucursal, String paisSucursal) {
		this.pk_SucursalID = id;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.tipusSucursal = (getUE().contains(getPaisSucursal()))?"UE":"Fora UE";
	}


	public String getTipus(){
		return this.tipusSucursal;
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


	public String getTipusSurcursal() {
		return tipusSucursal;
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

	public void setTipusSucursal(String tipus) {
		this.tipusSucursal =tipus;
	}

	public static List<String> getUE() {
		return paisosUE;
	}


	public void tipejar() {
		setTipusSucursal(getUE().contains(getPaisSucursal())?"UE":"Fora UE");

	}


	@Override
	public String toString () {
		return "id: " + getPk_SucursalID() + " nom: " + getNomSucursal() + " pais: "+ getPaisSucursal() + " tipus: " + getTipusSurcursal();
	}

}
