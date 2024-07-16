package com.foro.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DatosRegistroTopico(

  @NotNull
  @NotBlank
  String titulo,

  @NotNull
  @NotBlank
  String mensaje,

  @NotNull
  @Positive
  Long autorId,

  @NotNull
  @Positive
  Long cursoId
) {
  public static record Topico() {
  }
}
