package dev.franzon.habittracker.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class AtualizarHabitoRequest {

    private Long id;
    private String titulo;
    private String recorrencia;
    private int ocorrencias;
}
