package dev.franzon.habittracker.repository;

import dev.franzon.habittracker.dto.Habito;
import dev.franzon.habittracker.dto.Recorrencia;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class HabitoRepository {

    private final JdbcTemplate jdbcTemplate;

    private static Habito mapRow(ResultSet rs, int rowNum) {
        try {
            return new Habito(
                    rs.getLong("id"),
                    rs.getString("titulo"),
                    rs.getTimestamp("criado_em").toLocalDateTime(),
                    Recorrencia.valueOf(rs.getString("recorrencia").toUpperCase()),
                    rs.getInt("ocorrencias")
            );
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao mapear para a classe Habito", e);
        }
    }

    public List<Habito> listarHabitos() {
        return jdbcTemplate.query("select * from habito", HabitoRepository::mapRow);
    }

    public void criarHabito(Habito habito) {
        jdbcTemplate.update("insert into habito (titulo, recorrencia, ocorrencias) values (?, ?::recorrencia_type, ?)", habito.getTitulo(), habito.getRecorrencia().name(), habito.getOcorrencias());
    }

    public Optional<Habito> detalhesHabito(Long id) {
        return jdbcTemplate.query("select * from habito where id = ?", HabitoRepository::mapRow, id).stream().findFirst();
    }

    public void atualizarHabito(Habito habito) {
        jdbcTemplate.update("update habito set titulo = ?, recorrencia = ?::recorrencia_type, ocorrencias = ? where id = ?", habito.getTitulo(), habito.getRecorrencia().name(), habito.getOcorrencias(), habito.getId());
    }

    public void excluirHabito(Long id) {
        jdbcTemplate.update("delete from habito where id = ?", id);
    }
}
