package br.com.fiap.techchallenge.report.infrastructure.report;

import br.com.fiap.techchallenge.report.application.dto.report.WeeklyFeedbackReport;
import br.com.fiap.techchallenge.report.application.ports.WeeklyFeedbackReportSerializerPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class JacksonWeeklyFeedbackReportSerializerAdapter implements WeeklyFeedbackReportSerializerPort {

    private final ObjectMapper objectMapper;

    @Inject
    public JacksonWeeklyFeedbackReportSerializerAdapter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String serialize(WeeklyFeedbackReport report) {
        try {
            return objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(report);
        } catch (JsonProcessingException exception) {
            throw new IllegalStateException("Não foi possível serializar o relatório semanal.", exception);
        }
    }
}
