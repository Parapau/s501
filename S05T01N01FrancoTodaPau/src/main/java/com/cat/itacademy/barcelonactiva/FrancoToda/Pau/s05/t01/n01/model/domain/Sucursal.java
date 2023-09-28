package com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.domain;

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
public class Sucursal {

	
//	@TableGenerator(
//			name = "generadorid",
//			allocationSize = 1,
//			initialValue = 0)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
			
	private long pk_SucursalID;//Aixo segurament seria millor amb long pero l'enunciat diu Integer aixi que no ho cambíis

	@Column(name = "nom")
	private String nomSucursal;

	@Column(name = "pais")
	private String paisSucursal;






	public Sucursal() {}


	public Sucursal(String nomSucursal, String paisSucursal) {
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


	@Override
	public String toString () {
		return getPk_SucursalID() + getNomSucursal() + getPaisSucursal();
	}



}
