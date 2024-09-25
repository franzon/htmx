package dev.franzon.habittracker.repository;

import dev.franzon.habittracker.dto.Habito;
import dev.franzon.habittracker.dto.Recorrencia;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class HabitoRepositoryTest {

    @Autowired
    private HabitoRepository habitoRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16-alpine"
    )
            .withInitScript("migrations/V1__criar_tabelas.sql");

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void beforeEach() {
        limparHabitos();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    void deveRetornarListaVaziaSeNaoHouverNenhumHabitoCadastrado() {
        List<Habito> habitos = habitoRepository.listarHabitos();

        assertTrue(habitos.isEmpty());
    }

    @Test
    void deveRetornarListaDeHabitos() {
        jdbcTemplate.execute("insert into habito (titulo, recorrencia, ocorrencias) values ('Correr', 'DIARIO', 1)");
        jdbcTemplate.execute("insert into habito (titulo, recorrencia, ocorrencias) values ('Comer', 'SEMANAL', 2)");
        jdbcTemplate.execute("insert into habito (titulo, recorrencia, ocorrencias) values ('Dormir', 'QUINZENAL', 3)");
        jdbcTemplate.execute("insert into habito (titulo, recorrencia, ocorrencias) values ('Arrumar a cama', 'MENSAL', 4)");

        List<Habito> habitos = habitoRepository.listarHabitos();

        assertEquals(4, habitos.size());

        assertEquals("Correr", habitos.getFirst().getTitulo());
        assertEquals(Recorrencia.DIARIO, habitos.getFirst().getRecorrencia());
        assertEquals(1, habitos.getFirst().getOcorrencias());

        assertEquals("Comer", habitos.get(1).getTitulo());
        assertEquals(Recorrencia.SEMANAL, habitos.get(1).getRecorrencia());
        assertEquals(2, habitos.get(1).getOcorrencias());

        assertEquals("Dormir", habitos.get(2).getTitulo());
        assertEquals(Recorrencia.QUINZENAL, habitos.get(2).getRecorrencia());
        assertEquals(3, habitos.get(2).getOcorrencias());

        assertEquals("Arrumar a cama", habitos.get(3).getTitulo());
        assertEquals(Recorrencia.MENSAL, habitos.get(3).getRecorrencia());
        assertEquals(4, habitos.get(3).getOcorrencias());
    }

    @Test
    void deveCriarUmHabitoComRecorrenciaDiario() {
        // Verifica se inicialmente está vazio, para garantir
        List<Habito> habitos = habitoRepository.listarHabitos();
        assertTrue(habitos.isEmpty());

        Habito habito = Habito.builder()
                .titulo("Correr")
                .recorrencia(Recorrencia.DIARIO)
                .ocorrencias(1)
                .build();

        habitoRepository.criarHabito(habito);

        habitos = habitoRepository.listarHabitos();
        assertEquals("Correr", habitos.getFirst().getTitulo());
        assertEquals(Recorrencia.DIARIO, habitos.getFirst().getRecorrencia());
        assertEquals(1, habitos.getFirst().getOcorrencias());
    }

    @Test
    void deveCriarUmHabitoComRecorrenciaSemanal() {
        // Verifica se inicialmente está vazio, para garantir
        List<Habito> habitos = habitoRepository.listarHabitos();
        assertTrue(habitos.isEmpty());

        Habito habito = Habito.builder()
                .titulo("Comer")
                .recorrencia(Recorrencia.SEMANAL)
                .ocorrencias(2)
                .build();

        habitoRepository.criarHabito(habito);

        habitos = habitoRepository.listarHabitos();
        assertEquals("Comer", habitos.getFirst().getTitulo());
        assertEquals(Recorrencia.SEMANAL, habitos.getFirst().getRecorrencia());
        assertEquals(2, habitos.getFirst().getOcorrencias());
    }

    @Test
    void deveCriarUmHabitoComRecorrenciaQuinzenal() {
        // Verifica se inicialmente está vazio, para garantir
        List<Habito> habitos = habitoRepository.listarHabitos();
        assertTrue(habitos.isEmpty());

        Habito habito = Habito.builder()
                .titulo("Dormir")
                .recorrencia(Recorrencia.QUINZENAL)
                .ocorrencias(3)
                .build();

        habitoRepository.criarHabito(habito);

        habitos = habitoRepository.listarHabitos();
        assertEquals("Dormir", habitos.getFirst().getTitulo());
        assertEquals(Recorrencia.QUINZENAL, habitos.getFirst().getRecorrencia());
        assertEquals(3, habitos.getFirst().getOcorrencias());
    }

    @Test
    void deveCriarUmHabitoComRecorrenciaMensal() {
        // Verifica se inicialmente está vazio, para garantir
        List<Habito> habitos = habitoRepository.listarHabitos();
        assertTrue(habitos.isEmpty());

        Habito habito = Habito.builder()
                .titulo("Arrumar a cama")
                .recorrencia(Recorrencia.MENSAL)
                .ocorrencias(4)
                .build();

        habitoRepository.criarHabito(habito);

        habitos = habitoRepository.listarHabitos();
        assertEquals("Arrumar a cama", habitos.getFirst().getTitulo());
        assertEquals(Recorrencia.MENSAL, habitos.getFirst().getRecorrencia());
        assertEquals(4, habitos.getFirst().getOcorrencias());
    }


    // TODO: detalhes
    // TODO: atualização
    // TODO: exclusão

    @Test
    void deveRetornarDetalhesDeUmHabito() {
        jdbcTemplate.execute("insert into habito (id, titulo, recorrencia, ocorrencias) values (1, 'Correr', 'DIARIO', 1)");

        Optional<Habito> habito = habitoRepository.detalhesHabito(1L);

        assertTrue(habito.isPresent());
        assertEquals("Correr", habito.get().getTitulo());
        assertEquals(Recorrencia.DIARIO, habito.get().getRecorrencia());
        assertEquals(1, habito.get().getOcorrencias());
    }

    @Test
    void deveRetornarVazioSeNaoEncontrarHabito() {
        jdbcTemplate.execute("insert into habito (id, titulo, recorrencia, ocorrencias) values (1, 'Correr', 'DIARIO', 1)");

        Optional<Habito> habito = habitoRepository.detalhesHabito(2L);

        assertTrue(habito.isEmpty());
    }

    @Test
    void deveAtualizarOTituloDeUmHabito() {
        jdbcTemplate.execute("insert into habito (id, titulo, recorrencia, ocorrencias) values (1, 'Correr', 'DIARIO', 1)");

        Optional<Habito> habito = habitoRepository.detalhesHabito(1L);

        assertTrue(habito.isPresent());
        assertEquals("Correr", habito.get().getTitulo());
        assertEquals(Recorrencia.DIARIO, habito.get().getRecorrencia());
        assertEquals(1, habito.get().getOcorrencias());

        Habito habitoAtualizadoIn = Habito.builder()
                .id(1L)
                .titulo("Correr atualizado")
                .recorrencia(Recorrencia.DIARIO)
                .ocorrencias(1)
                .build();

        habitoRepository.atualizarHabito(habitoAtualizadoIn);

        Optional<Habito> habitoAtualizadoOut = habitoRepository.detalhesHabito(1L);

        assertTrue(habitoAtualizadoOut.isPresent());
        assertEquals("Correr atualizado", habitoAtualizadoOut.get().getTitulo());
        assertEquals(Recorrencia.DIARIO, habitoAtualizadoOut.get().getRecorrencia());
        assertEquals(1, habitoAtualizadoOut.get().getOcorrencias());
    }

    @Test
    void deveAtualizarARecorrenciaDeUmHabito() {
        jdbcTemplate.execute("insert into habito (id, titulo, recorrencia, ocorrencias) values (1, 'Correr', 'DIARIO', 1)");

        Optional<Habito> habito = habitoRepository.detalhesHabito(1L);

        assertTrue(habito.isPresent());
        assertEquals("Correr", habito.get().getTitulo());
        assertEquals(Recorrencia.DIARIO, habito.get().getRecorrencia());
        assertEquals(1, habito.get().getOcorrencias());

        Habito habitoAtualizadoIn = Habito.builder()
                .id(1L)
                .titulo("Correr")
                .recorrencia(Recorrencia.SEMANAL)
                .ocorrencias(1)
                .build();

        habitoRepository.atualizarHabito(habitoAtualizadoIn);

        Optional<Habito> habitoAtualizadoOut = habitoRepository.detalhesHabito(1L);

        assertTrue(habitoAtualizadoOut.isPresent());
        assertEquals("Correr", habitoAtualizadoOut.get().getTitulo());
        assertEquals(Recorrencia.SEMANAL, habitoAtualizadoOut.get().getRecorrencia());
        assertEquals(1, habitoAtualizadoOut.get().getOcorrencias());
    }

    @Test
    void deveAtualizarAsOcorrenciasDeUmHabito() {
        jdbcTemplate.execute("insert into habito (id, titulo, recorrencia, ocorrencias) values (1, 'Correr', 'DIARIO', 1)");

        Optional<Habito> habito = habitoRepository.detalhesHabito(1L);

        assertTrue(habito.isPresent());
        assertEquals("Correr", habito.get().getTitulo());
        assertEquals(Recorrencia.DIARIO, habito.get().getRecorrencia());
        assertEquals(1, habito.get().getOcorrencias());

        Habito habitoAtualizadoIn = Habito.builder()
                .id(1L)
                .titulo("Correr")
                .recorrencia(Recorrencia.DIARIO)
                .ocorrencias(3)
                .build();

        habitoRepository.atualizarHabito(habitoAtualizadoIn);

        Optional<Habito> habitoAtualizadoOut = habitoRepository.detalhesHabito(1L);

        assertTrue(habitoAtualizadoOut.isPresent());
        assertEquals("Correr", habitoAtualizadoOut.get().getTitulo());
        assertEquals(Recorrencia.DIARIO, habitoAtualizadoOut.get().getRecorrencia());
        assertEquals(3, habitoAtualizadoOut.get().getOcorrencias());
    }

    @Test
    void deveAtualizarApenasUmHabitoEspecifico() {
        jdbcTemplate.execute("insert into habito (id, titulo, recorrencia, ocorrencias) values (1, 'Correr', 'DIARIO', 1)");
        jdbcTemplate.execute("insert into habito (id, titulo, recorrencia, ocorrencias) values (2, 'Comer', 'SEMANAL', 2)");

        Habito habitoAtualizadoIn = Habito.builder()
                .id(1L)
                .titulo("Correr atualizado")
                .recorrencia(Recorrencia.DIARIO)
                .ocorrencias(1)
                .build();

        habitoRepository.atualizarHabito(habitoAtualizadoIn);

        Optional<Habito> habitoAtualizadoOut = habitoRepository.detalhesHabito(2L);

        assertTrue(habitoAtualizadoOut.isPresent());
        assertEquals("Comer", habitoAtualizadoOut.get().getTitulo());
        assertEquals(Recorrencia.SEMANAL, habitoAtualizadoOut.get().getRecorrencia());
        assertEquals(2, habitoAtualizadoOut.get().getOcorrencias());
    }

    @Test
    void deveExcluirUmHabito() {
        jdbcTemplate.execute("insert into habito (id, titulo, recorrencia, ocorrencias) values (1, 'Correr', 'DIARIO', 1)");

        List<Habito> habitos = habitoRepository.listarHabitos();
        assertEquals(1, habitos.size());

        habitoRepository.excluirHabito(1L);

        habitos = habitoRepository.listarHabitos();
        assertEquals(0, habitos.size());
    }

    void limparHabitos() {
        jdbcTemplate.execute("delete from habito");
    }
}