package com.duoc.vrk.repository;

import com.duoc.vrk.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Integer> {
}