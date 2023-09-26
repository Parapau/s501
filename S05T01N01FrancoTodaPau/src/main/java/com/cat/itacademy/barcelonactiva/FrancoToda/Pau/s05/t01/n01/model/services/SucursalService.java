package com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.domain.Sucursal;
import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.dto.SucursalDTO;
import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalService { //Potser hauras d'afegir un repository pel DTO(ho dubto)

	@Autowired
	SucursalRepository sucursalRepo;
	
	public SucursalDTO save(SucursalDTO dto) {
		sucursalRepo.save(new Sucursal(dto.getNomSucursal(), dto.getPaisSucursal()));
		
		return dto;
	}
	
	
	public void deleteById(Integer id) {
		sucursalRepo.deleteById(id);
	}
	
	
	public List<SucursalDTO> findAll() {
		List<Sucursal> llista = sucursalRepo.findAll();
		List<SucursalDTO> llistaDTO = new ArrayList<SucursalDTO>();
		
		for (Sucursal sucursal : llista) {
			llistaDTO.add(new SucursalDTO(sucursal.getNomSucursal(), sucursal.getPaisSucursal()));
		}
		
		return llistaDTO;
	}
	
	
	public Optional<SucursalDTO> findByid(Integer id) {
		Optional<SucursalDTO> dto = Optional.empty();
		Optional<Sucursal> sucursalMaybe;
		Sucursal sucursal;
		
		sucursalMaybe = sucursalRepo.findById(id);
		
		if (sucursalMaybe.isPresent()) {
			sucursal = sucursalMaybe.get();
			dto = Optional.of(new SucursalDTO(sucursal.getNomSucursal(), sucursal.getPaisSucursal()));
		}
		
		return dto;
		
	}
	
	
	
	
	
	
}








