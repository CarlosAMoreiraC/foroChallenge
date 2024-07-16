package com.foro.foro.service;

import com.foro.foro.domain.UsuarioData;
import com.foro.foro.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository repository;


  public UsuarioData findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Autor no " +
        "encontrado"));
  }
}
