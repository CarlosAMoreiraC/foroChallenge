package com.foro.foro.domain.topico;

import com.foro.foro.domain.CursoData;
import com.foro.foro.domain.UsuarioData;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="topico")
public class TopicoData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String mensaje;
  private LocalDateTime fechaCreacion;
  private String status;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "autor_id")
  private UsuarioData autor;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "curso_id")
  private CursoData curso;

  public TopicoData() {
  }

  public TopicoData(String titulo, String mensaje, String status, UsuarioData autor, CursoData curso) {
    this.titulo = titulo;
    this.mensaje = mensaje;
    this.fechaCreacion = LocalDateTime.now();
    this.status = status;
    this.autor = autor;
    this.curso = curso;
  }

  public TopicoData(TopicoData topicoData) {
    this.titulo = topicoData.getTitulo();
    this.mensaje = topicoData.getMensaje();
    this.fechaCreacion = topicoData.getFechaCreacion();
    this.status = topicoData.getStatus();
    this.autor = topicoData.getAutor();
    this.curso = topicoData.getCurso();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public UsuarioData getAutor() {
    return autor;
  }

  public void setAutor(UsuarioData autor) {
    this.autor = autor;
  }

  public CursoData getCurso() {
    return curso;
  }

  public void setCurso(CursoData curso) {
    this.curso = curso;
  }
}
