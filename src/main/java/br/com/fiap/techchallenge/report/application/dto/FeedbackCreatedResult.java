package br.com.fiap.techchallenge.report.application.dto;

import br.com.fiap.techchallenge.report.domain.enums.Urgencia;
import br.com.fiap.techchallenge.report.domain.model.Feedback;

import java.time.OffsetDateTime;
import java.util.UUID;

public record FeedbackCreatedResult(
        UUID id,
        String descricao,
        int nota,
        Urgencia urgencia,
        OffsetDateTime dataCriacao
) {

    public static FeedbackCreatedResult from(Feedback feedback) {
        return new FeedbackCreatedResult(
                feedback.id(),
                feedback.descricao(),
                feedback.nota(),
                feedback.urgencia(),
                feedback.dataCriacao()
        );
    }
}
