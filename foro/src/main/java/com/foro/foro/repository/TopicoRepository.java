package com.foro.foro.repository;

import com.foro.foro.domain.topico.TopicoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<TopicoData, Long> {

  TopicoData findByTituloAndMensaje(String titulo, String mensaje);

}
