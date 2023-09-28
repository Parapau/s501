package com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.domain.Sucursal;

public class SucursalDTO {

	private long pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	private static final List<String> paisosUE;
	
	
	static {
		paisosUE = Arrays.asList ("Espanya", "França", "Belgica", "Holanda", "Luxemburg", "Alemanya", "Irlanda", "Italia", "Republica Xeca", "Slovakia", "Eslovenia", "Croacia", "Grecia", "Polonia",
				"Estonia", "Latvia", "Lituania", "Austria", "Malta", "Portugal", "Bulgaria", "Romania", "Xipre", "Suecia", "Finalndia", "Hungria", "Dinamarca");
	
		
	}
	
	
	public SucursalDTO() {}
	
	
	public SucursalDTO(String nomSucursal, String paisSucursal) {
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.tipusSucursal = (getUE().contains(getPaisSucursal()))?"UE":"Fora UE";
	}
	
	public SucursalDTO(long id, String nomSucursal, String paisSucursal) {
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

	public static List<String> getUE() {
		return paisosUE;
	}

	@Override
	public String toString () {
		return getPk_SucursalID() + getNomSucursal() + getPaisSucursal() + getTipusSurcursal();
	}
	
}
