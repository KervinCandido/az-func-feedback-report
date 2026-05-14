package br.com.fiap.techchallenge.report.application.ports;

import br.com.fiap.techchallenge.report.domain.model.Feedback;

import java.time.OffsetDateTime;
import java.util.List;

public interface FeedbackRepositoryPort {
    List<Feedback> findByDataCriacaoBetween(OffsetDateTime inicio, OffsetDateTime fim);
}
