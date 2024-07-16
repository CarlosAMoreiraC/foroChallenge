package com.foro.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DatosActualizarTopico(

    String titulo,

    String mensaje,

    String status,

    Long autorId,

    Long cursoId
) {}
