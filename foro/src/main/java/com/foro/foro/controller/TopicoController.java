package com.foro.foro.controller;

import com.foro.foro.domain.topico.Topico;
import com.foro.foro.domain.topico.DatosRegistroTopico;
import com.foro.foro.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

  @Autowired
  private TopicoService service;
  @PostMapping
  private ResponseEntity<Topico> registratTopico(@RequestBody @Valid DatosRegistroTopico topico, UriComponentsBuilder uriComponentsBuilder) {
    Long topicoId = service.registrar(topico);
    Topico topicoResponse = service.buscarPorId(topicoId);

    URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topicoId).toUri();
    return ResponseEntity.created(url).body(topicoResponse);
  }
}
