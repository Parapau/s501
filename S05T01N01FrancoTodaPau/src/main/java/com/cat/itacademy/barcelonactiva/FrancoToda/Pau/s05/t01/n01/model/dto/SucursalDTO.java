package com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.domain.Sucursal;

public class SucursalDTO extends Sucursal{

	
	private String tipusSurcursal;
	private static final List<String> paisosUE;
	
	
	static {
		paisosUE = Arrays.asList ("Espanya", "França", "Belgica", "Holanda", "Luxemburg", "Alemanya", "Irlanda", "Italia", "Republica Xeca", "Slovakia", "Eslovenia", "Croacia", "Grecia", "Polonia",
				"Estonia", "Latvia", "Lituania", "Austria", "Malta", "Portugal", "Bulgaria", "Romania", "Xipre", "Suecia", "Finalndia", "Hungria", "Dinamarca");
	
		
	}
	
	
	public SucursalDTO() {}
	
	
	public SucursalDTO(String nomSucursal, String paisSucursal) {
		this.tipusSurcursal = (paisosUE.contains(getPaisSucursal()))?"UE":"fora UE";
	}


	public String getTipus(){
		return this.tipusSurcursal;
	}
	
	
	/*Crec que aixo es mala idea 
	 * 
	 * public SucursalDTO tornaDTO (Sucursal sucursal) {
		SucursalDTO dto;
		
		
		
		
		return null;
	}*/
	
}
