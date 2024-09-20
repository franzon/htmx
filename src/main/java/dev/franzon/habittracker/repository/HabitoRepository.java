package dev.franzon.habittracker.repository;

import dev.franzon.habittracker.dto.Habito;
import dev.franzon.habittracker.dto.Recorrencia;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
            throw new RuntimeException(e);
        }
    }

    public List<Habito> listarHabitos() {
        return jdbcTemplate.query("select * from habito", HabitoRepository::mapRow);
    }

    public void criarHabito(Habito habito) {
        try {
            PreparedStatement statement = jdbcTemplate.getDataSource().getConnection().prepareStatement("insert into habito (titulo, recorrencia, ocorrencias) values (?, ?, ?)");
            statement.setString(1, habito.getTitulo());
            statement.setObject(2, habito.getRecorrencia(), Types.OTHER);
            statement.setInt(3, habito.getOcorrencias());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Habito> detalhesHabito(Long id) {
        return jdbcTemplate.query("select * from habito where id = ?", HabitoRepository::mapRow, id).stream().findFirst();
    }

    public void atualizarHabito(Habito habito) {
        try {
            PreparedStatement statement = jdbcTemplate.getDataSource().getConnection().prepareStatement("update habito set titulo = ?, recorrencia = ?, ocorrencias = ? where id = ?");
            statement.setString(1, habito.getTitulo());
            statement.setObject(2, habito.getRecorrencia(), Types.OTHER);
            statement.setInt(3, habito.getOcorrencias());
            statement.setLong(4, habito.getId());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirHabito(Long id) {
        try {
            PreparedStatement statement = jdbcTemplate.getDataSource().getConnection().prepareStatement("delete from habito where id = ?");
            statement.setLong(1, id);

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
