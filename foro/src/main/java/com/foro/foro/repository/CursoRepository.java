package com.foro.foro.repository;

import com.foro.foro.domain.CursoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoData, Long> {
}
