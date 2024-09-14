package dev.franzon.habittracker.api;

import dev.franzon.habittracker.dto.HabitoDeHojeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("habitos-de-hoje")
public class HabitosDeHojeController {

    @PostMapping("click/{id}")
    public String click(@PathVariable("id") String id, Model model) {
        HabitoDeHojeDTO habito = WebController.habitosDeHoje.stream().filter(h -> Objects.equals(h.getId(), Long.valueOf(id))).findAny().orElseThrow();

        habito.setPronto(!habito.isPronto());
        model.addAttribute("habitoDeHoje", habito);

        return "habitoDeHoje";
    }
}
