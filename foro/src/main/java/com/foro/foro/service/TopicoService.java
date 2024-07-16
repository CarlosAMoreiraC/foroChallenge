package com.foro.foro.service;

import com.foro.foro.domain.CursoData;
import com.foro.foro.domain.UsuarioData;
import com.foro.foro.domain.topico.DatosActualizarTopico;
import com.foro.foro.domain.topico.TopicoData;
import com.foro.foro.repository.CursoRepository;
import com.foro.foro.repository.TopicoRepository;
import com.foro.foro.domain.topico.DatosRegistroTopico;
import com.foro.foro.repository.UsuarioRepository;
import com.sun.jdi.request.DuplicateRequestException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TopicoService {

  @Autowired
  private TopicoRepository repository;

  @Autowired
  private CursoService cursoService;

  @Autowired
  private UsuarioService usuarioService;

  public Long registrar(DatosRegistroTopico topico) {

    if (Objects.nonNull(repository.findByTituloAndMensaje(topico.titulo(), topico.mensaje())))
      throw new DuplicateRequestException("El topico con titulo: " + topico.titulo() + " y " +
          "mensaje:" +
          " " + topico.mensaje() + " ya se encuentra registrado");

    CursoData curso = cursoService.findById(topico.cursoId());
    UsuarioData autor = usuarioService.findById(topico.autorId());

    TopicoData data = new TopicoData(topico.titulo(), topico.mensaje(), "CREADO", autor, curso);

    var response = repository.save(data);
    return response.getId();
  }

  public TopicoData buscarPorId(Long topicoId) {
    return repository.findById(topicoId)
        .orElseThrow(() -> new EntityNotFoundException("El topico con " + "id " + topicoId + " no se encuentra registrado"));
  }

  public Page<TopicoData> obtenerTopicos(Pageable paginacion) {
    return repository.findAll(paginacion);
  }

  public void actualizar(Long id, DatosActualizarTopico topico) {

    TopicoData data = buscarPorId(id);

    if (Objects.nonNull(topico.titulo()) && Objects.nonNull(topico.mensaje())) {
      if (Objects.nonNull(repository.findByTituloAndMensaje(topico.titulo(), topico.mensaje())))
        throw new DuplicateRequestException("El topico con titulo: " + topico.titulo() + " y " +
            "mensaje:" + topico.mensaje() + " ya se encuentra registrado");
    }

    if (Objects.nonNull(topico.titulo()))
      data.setMensaje(topico.mensaje());

    if (Objects.nonNull(topico.mensaje()))
      data.setTitulo(topico.titulo());

    if (Objects.nonNull(topico.status()))
      data.setStatus(topico.status());


    if (Objects.nonNull(topico.cursoId())) {
      CursoData curso = cursoService.findById(topico.cursoId());
      data.setCurso(curso);
    }

    if (Objects.nonNull(topico.autorId())) {
      UsuarioData autor = usuarioService.findById(topico.autorId());
      data.setAutor(autor);
    }

    repository.save(data);

  }

  public void eliminar(Long id) {
    buscarPorId(id);
    repository.deleteById(id);
  }
}
