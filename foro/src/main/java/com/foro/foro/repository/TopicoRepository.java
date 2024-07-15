package com.foro.foro.repository;

import com.foro.foro.domain.topico.TopicoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<TopicoData, Long> {
}
