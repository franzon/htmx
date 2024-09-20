package dev.franzon.habittracker.api;

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
public class WebController {

    private final HabitosService habitosService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/habitos")
    public String listarHabitos(Model model) {
        var habitos = habitosService.listarHabitos();
        model.addAttribute("habitos", habitos);

        return "habitos";
    }

    @GetMapping("/habitos/{id}")
    public String detalhesHabito(Model model, @PathVariable("id") Long id) {
        var habito = habitosService.detalhesHabito(id);

        if (habito.isEmpty())
            throw new RuntimeException("erro1!!!");

        model.addAttribute("habito", habito.get());

        return "detalhes-habito";
    }


    @GetMapping("/criar-habito")
    public String criarHabito(Model model) {
        return "criar-habito";
    }

    @PostMapping(value = "/criar-habito")
    public String criarHabitoPost(@ModelAttribute CriarHabitoRequest criarHabitoRequest, Model model) {
        Habito habito = Habito.builder()
                .titulo(criarHabitoRequest.getTitulo())
                .recorrencia(Recorrencia.valueOf(criarHabitoRequest.getRecorrencia()))
                .ocorrencias(criarHabitoRequest.getOcorrencias())
                .build();

        habitosService.criarHabito(habito);

        var habitos = habitosService.listarHabitos();
        model.addAttribute("habitos", habitos);

        return "redirect:habitos";
    }

    @PostMapping(value = "/atualizar-habito")
    public String atualizarHabitoPost(@ModelAttribute AtualizarHabitoRequest atualizarHabitoRequest, Model model) {
        Habito habito = Habito.builder()
                .id(atualizarHabitoRequest.getId())
                .titulo(atualizarHabitoRequest.getTitulo())
                .recorrencia(Recorrencia.valueOf(atualizarHabitoRequest.getRecorrencia()))
                .ocorrencias(atualizarHabitoRequest.getOcorrencias())
                .build();

        habitosService.atualizarHabito(habito);

        var habitos = habitosService.listarHabitos();
        model.addAttribute("habitos", habitos);

        return "redirect:habitos";
    }

    @DeleteMapping(value = "/excluir-habito/{id}")
    public void excluirHabito(@PathVariable("id") Long id) {
        habitosService.excluirHabito(id);
    }
}
