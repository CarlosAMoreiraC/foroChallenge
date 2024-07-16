package com.foro.foro.service;

import com.foro.foro.domain.CursoData;
import com.foro.foro.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

  @Autowired
  private CursoRepository repository;

  public CursoData findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso no " +
        "encontrado"));
  }
}
