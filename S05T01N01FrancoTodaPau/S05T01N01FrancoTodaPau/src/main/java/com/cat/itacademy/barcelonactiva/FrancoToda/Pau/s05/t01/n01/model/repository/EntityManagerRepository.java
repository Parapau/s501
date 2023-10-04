package com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class EntityManagerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    
    public void truncateTable() {
        String sql = "TRUNCATE TABLE sucursal";
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
    }
}
