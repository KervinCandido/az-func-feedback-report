package br.com.fiap.techchallenge.report.domain.model;

import br.com.fiap.techchallenge.report.domain.enums.Urgencia;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackTest {

    @Test
    void deveCriarNovoFeedbackComDadosValidos() {
        Feedback feedback = new Feedback(
                UUID.randomUUID(),
                "A aula foi muito boa",
                9,
                Urgencia.BAIXA,
                OffsetDateTime.now());

        assertNotNull(feedback.id());
        assertEquals("A aula foi muito boa", feedback.descricao());
        assertEquals(9, feedback.nota());
        assertEquals(Urgencia.BAIXA, feedback.urgencia());
        assertNotNull(feedback.dataCriacao());
    }

    @Test
    void deveFalharQuandoDescricaoForNula() {
        assertThrows(IllegalArgumentException.class, () -> new Feedback(
                UUID.randomUUID(),
                null,
                8,
                Urgencia.BAIXA,
                OffsetDateTime.now()));
    }

    @Test
    void deveFalharQuandoDescricaoForVazia() {
        assertThrows(IllegalArgumentException.class, () -> new Feedback(
                UUID.randomUUID(),
                "   ",
                8,
                Urgencia.BAIXA,
                OffsetDateTime.now()));
    }

    @Test
    void deveFalharQuandoNotaForMenorQueZero() {
        assertThrows(IllegalArgumentException.class, () -> new Feedback(
                UUID.randomUUID(),
                "Comentário válido",
                -1,
                Urgencia.BAIXA,
                OffsetDateTime.now()));
    }

    @Test
    void deveFalharQuandoNotaForMaiorQueDez() {
        assertThrows(IllegalArgumentException.class, () -> new Feedback(
                UUID.randomUUID(),
                "Comentário válido",
                11,
                Urgencia.BAIXA,
                OffsetDateTime.now()));
    }
}
