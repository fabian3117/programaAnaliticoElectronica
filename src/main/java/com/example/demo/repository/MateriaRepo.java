package com.example.demo.repository;

import com.example.demo.Entidades.Materias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MateriaRepo extends JpaRepository<Materias, Long> {
}
