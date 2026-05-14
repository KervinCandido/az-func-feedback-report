package br.com.fiap.techchallenge.report.infrastructure.config;

import br.com.fiap.techchallenge.report.application.ports.FeedbackRepositoryPort;
import br.com.fiap.techchallenge.report.application.ports.ReportStoragePort;
import br.com.fiap.techchallenge.report.application.ports.WeeklyFeedbackReportSerializerPort;
import br.com.fiap.techchallenge.report.application.usecase.GenerateAndStoreWeeklyFeedbackReportUseCase;
import br.com.fiap.techchallenge.report.application.usecase.GenerateWeeklyFeedbackReportUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class Producers {

    @Produces
    @ApplicationScoped
    public GenerateWeeklyFeedbackReportUseCase generateWeeklyFeedbackReportUseCaseProducer(
            FeedbackRepositoryPort feedbackRepository) {
        return new GenerateWeeklyFeedbackReportUseCase(feedbackRepository);
    }

    @Produces
    @ApplicationScoped
    public GenerateAndStoreWeeklyFeedbackReportUseCase generateAndStoreWeeklyFeedbackReportUseCaseProducer(
            GenerateWeeklyFeedbackReportUseCase generateWeeklyFeedbackReportUseCase,
            WeeklyFeedbackReportSerializerPort serializer,
            ReportStoragePort storage) {
        return new GenerateAndStoreWeeklyFeedbackReportUseCase(
                generateWeeklyFeedbackReportUseCase,
                serializer,
                storage);
    }
}
