package com.foro.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(

  @NotNull
  @NotBlank
  String titulo,

  @NotNull
  @NotBlank
  String mensaje,

  @NotNull
  @NotBlank
  Long autorId,

  @NotNull
  @NotBlank
  Long cursoId
) {}
