package cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n02.model.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n02.model.repository.FlorRepository;


@Service
public class FlorService {


	//	@Autowired
	//	EntityManagerRepository entityManager;

	@Autowired
	FlorRepository sucursalRepo;

	public FlorDTO save(FlorDTO dto) {
		Flor sucursal = sucursalRepo.save(new Flor(dto.getNomSucursal(), dto.getPaisSucursal()));

		dto.setPk_SucursalID(sucursal.getPk_SucursalID());

		return dto;
	}


	public void deleteById(Integer id) {
		sucursalRepo.deleteById(id);
	}


	public FlorDTO update(FlorDTO dto) {
		Flor sucursal = sucursalRepo.save(new Flor(dto.getPk_SucursalID(), dto.getNomSucursal(), dto.getPaisSucursal()));

		dto.setPk_SucursalID(sucursal.getPk_SucursalID());

		return dto;
	}


	public List<FlorDTO> findAll() {
		List<Flor> llista = sucursalRepo.findAll();
		List<FlorDTO> llistaDTO = new ArrayList<FlorDTO>();

		for (Flor sucursal : llista) {
			llistaDTO.add(new FlorDTO(sucursal.getPk_SucursalID(), sucursal.getNomSucursal(), sucursal.getPaisSucursal()));
		}

		return llistaDTO;
	}


	public Optional<FlorDTO> findByid(Integer id) {
		Optional<FlorDTO> dto = Optional.empty();
		Optional<Flor> sucursalMaybe;
		Flor sucursal;

		sucursalMaybe = sucursalRepo.findById(id);

		if (sucursalMaybe.isPresent()) {
			sucursal = sucursalMaybe.get();
			dto = Optional.of(new FlorDTO(sucursal.getPk_SucursalID(), sucursal.getNomSucursal(), sucursal.getPaisSucursal()));
		}

		return dto;

	}




	public void deleteAll() {
		sucursalRepo.deleteAll();
		//
		//		entityManager.truncateTable();
	}






}








