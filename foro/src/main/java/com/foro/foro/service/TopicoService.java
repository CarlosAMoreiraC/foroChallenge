package com.foro.foro.service;

import com.foro.foro.repository.TopicoRepository;
import com.foro.foro.domain.topico.Topico;
import com.foro.foro.domain.topico.DatosRegistroTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

  @Autowired
  private TopicoRepository repository;

  public Long registrar(DatosRegistroTopico topico) {




  }

  public Topico buscarPorId(Long topicoId) {

  }
}
