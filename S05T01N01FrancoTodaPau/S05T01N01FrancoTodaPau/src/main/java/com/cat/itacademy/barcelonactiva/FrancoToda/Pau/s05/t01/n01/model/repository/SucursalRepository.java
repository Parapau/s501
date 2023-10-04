package com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.domain.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {}
