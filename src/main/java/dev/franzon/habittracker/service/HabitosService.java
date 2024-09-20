package dev.franzon.habittracker.service;

import dev.franzon.habittracker.dto.Habito;
import dev.franzon.habittracker.repository.HabitoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HabitosService {

    private final HabitoRepository repository;

    public List<Habito> listarHabitos() {
        return repository.listarHabitos();
    }

    public void criarHabito(Habito habito) {
        repository.criarHabito(habito);
    }

    public Optional<Habito> detalhesHabito(Long id) {
        return repository.detalhesHabito(id);
    }

    public void atualizarHabito(Habito habito) {
        repository.atualizarHabito(habito);
    }

    public void excluirHabito(Long id) {
        repository.excluirHabito(id);
    }
}
