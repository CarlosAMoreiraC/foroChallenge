package com.foro.foro.controller;

import com.foro.foro.domain.topico.DatosActualizarTopico;
import com.foro.foro.domain.topico.DatosRegistroTopico;
import com.foro.foro.domain.topico.TopicoData;
import com.foro.foro.service.TopicoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  @Operation(summary = "Registra un nuevo topico")
  private ResponseEntity<TopicoData> registratTopico(@RequestBody @Valid DatosRegistroTopico topico,
                                                     UriComponentsBuilder uriComponentsBuilder) {
    Long topicoId = service.registrar(topico);
    TopicoData topicoResponse = service.buscarPorId(topicoId);

    URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topicoId).toUri();
    return ResponseEntity.created(url).body(topicoResponse);
  }

  @GetMapping
  @Operation(summary = "Obtiene la lista de topicos por paginacion")
  private ResponseEntity<Page<TopicoData>> getTopicos(@PageableDefault(size = 10,
      sort = {"fechaCreacion"}) Pageable paginacion) {
    var page = service.obtenerTopicos(paginacion).map(TopicoData::new);
    return ResponseEntity.ok().body(page);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Obtienes los detalles de un topico mediante el id")
  private ResponseEntity<TopicoData> getTopico(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok().body(service.buscarPorId(id));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Actualiza la informacion de un topico mediante el id")
  private ResponseEntity<TopicoData> actualizarTopico(@PathVariable(name = "id") Long id,
                                                      @RequestBody DatosActualizarTopico topico) {
    service.actualizar(id, topico);
    return ResponseEntity.ok().body(service.buscarPorId(id));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Elimina de base de datos un topico")
  private void eliminarTopico(@PathVariable(name = "id") Long id) {
    service.eliminar(id);
  }


}
