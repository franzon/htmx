package dev.franzon.habittracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public final class HabitoDeHojeDTO {
    private final Long id;
    private final String titulo;
    private boolean pronto;
}
