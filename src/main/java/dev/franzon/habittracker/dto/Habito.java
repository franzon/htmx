package dev.franzon.habittracker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Builder
@RequiredArgsConstructor
@Getter
public class Habito {
    private final Long id;
    private final String titulo;
    private final LocalDateTime criadoEm;
    private final Recorrencia recorrencia;
    private final int ocorrencias;
}
