package dev.franzon.habittracker.api.web;

import dev.franzon.habittracker.dto.Habito;
import dev.franzon.habittracker.dto.Recorrencia;
import dev.franzon.habittracker.dto.request.AtualizarHabitoRequest;
import dev.franzon.habittracker.dto.request.CriarHabitoRequest;
import dev.franzon.habittracker.service.HabitosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/habitos")
public class HabitosController {

    private final HabitosService habitosService;

    @GetMapping
    public String paginaListarHabitos(Model model) {
        var habitos = habitosService.listarHabitos();
        model.addAttribute("habitos", habitos);

        return "lista-habitos";
    }

    @GetMapping("/{id}")
    public String paginaDetalhesHabito(Model model, @PathVariable("id") Long id) {
        var habito = habitosService.detalhesHabito(id);

        if (habito.isEmpty())
            throw new RuntimeException("erro1!!!");

        model.addAttribute("habito", habito.get());

        return "detalhes-habito";
    }

    @GetMapping("/criacao")
    public String paginaCriacaoHabito() {
        return "criacao-habito";
    }

    @PostMapping
    public String criarHabito(@ModelAttribute CriarHabitoRequest criarHabitoRequest, Model model) {
        Habito habito = Habito.builder()
                .titulo(criarHabitoRequest.getTitulo())
                .recorrencia(Recorrencia.valueOf(criarHabitoRequest.getRecorrencia()))
                .ocorrencias(criarHabitoRequest.getOcorrencias())
                .build();

        habitosService.criarHabito(habito);

        return "redirect:/habitos";
    }

    @PostMapping("/atualizar")
    public String atualizarHabito(@ModelAttribute AtualizarHabitoRequest atualizarHabitoRequest, Model model) {
        Habito habito = Habito.builder()
                .id(atualizarHabitoRequest.getId())
                .titulo(atualizarHabitoRequest.getTitulo())
                .recorrencia(Recorrencia.valueOf(atualizarHabitoRequest.getRecorrencia()))
                .ocorrencias(atualizarHabitoRequest.getOcorrencias())
                .build();

        habitosService.atualizarHabito(habito);

        return "redirect:/habitos";
    }

    @DeleteMapping("/{id}")
    public void excluirHabito(@PathVariable("id") Long id) {
        habitosService.excluirHabito(id);
    }
}
