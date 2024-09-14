package dev.franzon.habittracker.api;

import dev.franzon.habittracker.dto.HabitoDeHojeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {

    public static List<HabitoDeHojeDTO> habitosDeHoje = List.of(
            new HabitoDeHojeDTO(1L, "Correr", true),
            new HabitoDeHojeDTO(2L, "Arrumar a cama", true),
            new HabitoDeHojeDTO(3L, "Lavar louça", false),
            new HabitoDeHojeDTO(4L, "Ler um livro", true),
            new HabitoDeHojeDTO(5L, "Meditar", true),
            new HabitoDeHojeDTO(6L, "Fazer exercícios de alongamento", true),
            new HabitoDeHojeDTO(7L, "Tomar café da manhã saudável", true),
            new HabitoDeHojeDTO(8L, "Estudar um novo idioma", false),
            new HabitoDeHojeDTO(9L, "Escrever no diário", true),
            new HabitoDeHojeDTO(10L, "Organizar a mesa de trabalho", true),
            new HabitoDeHojeDTO(11L, "Beber 2 litros de água", true),
            new HabitoDeHojeDTO(12L, "Fazer uma caminhada", true),
            new HabitoDeHojeDTO(13L, "Limpar o banheiro", false),
            new HabitoDeHojeDTO(14L, "Ouvir um podcast", true),
            new HabitoDeHojeDTO(15L, "Planejar o dia", true),
            new HabitoDeHojeDTO(16L, "Fazer uma refeição balanceada", true),
            new HabitoDeHojeDTO(17L, "Assistir a um documentário", false),
            new HabitoDeHojeDTO(18L, "Fazer uma pausa para relaxar", true),
            new HabitoDeHojeDTO(19L, "Jogar um jogo de tabuleiro", false),
            new HabitoDeHojeDTO(20L, "Ligar para um amigo", true)
    );


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("habitosDeHoje", habitosDeHoje);

        return "index";
    }
}
