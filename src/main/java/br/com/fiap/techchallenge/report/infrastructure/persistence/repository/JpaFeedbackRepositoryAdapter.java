package br.com.fiap.techchallenge.report.infrastructure.persistence.repository;

import br.com.fiap.techchallenge.report.application.ports.FeedbackRepositoryPort;
import br.com.fiap.techchallenge.report.domain.model.Feedback;
import br.com.fiap.techchallenge.report.infrastructure.persistence.mapper.FeedbackPersistenceMapper;
import io.micrometer.core.annotation.Timed;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.OffsetDateTime;
import java.util.List;

@ApplicationScoped
public class JpaFeedbackRepositoryAdapter implements FeedbackRepositoryPort {

    private final PanacheFeedbackRepository panacheRepository;
    private final FeedbackPersistenceMapper mapper;

    public JpaFeedbackRepositoryAdapter(
            PanacheFeedbackRepository panacheRepository,
            FeedbackPersistenceMapper mapper) {
        this.panacheRepository = panacheRepository;
        this.mapper = mapper;
    }


    @Timed(value = "feedback.repository.report", description = "Tempo de execução da busca para gerar o relatorio")
    @Override
    public List<Feedback> findByDataCriacaoBetween(OffsetDateTime inicio, OffsetDateTime fim) {
        return panacheRepository
                .list("dataCriacao >= ?1 and dataCriacao < ?2 order by dataCriacao asc", inicio, fim)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
