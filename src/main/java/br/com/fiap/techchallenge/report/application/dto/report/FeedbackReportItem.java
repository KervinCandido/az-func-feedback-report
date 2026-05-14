package br.com.fiap.techchallenge.report.application.dto.report;

import br.com.fiap.techchallenge.report.domain.enums.Urgencia;

import java.time.OffsetDateTime;
import java.util.UUID;

public record FeedbackReportItem(
        UUID id,
        String descricao,
        int nota,
        Urgencia urgencia,
        OffsetDateTime dataEnvio
) {
}
