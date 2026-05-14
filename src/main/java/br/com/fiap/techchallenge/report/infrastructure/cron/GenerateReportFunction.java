package br.com.fiap.techchallenge.report.infrastructure.cron;

import br.com.fiap.techchallenge.report.application.usecase.GenerateAndStoreWeeklyFeedbackReportUseCase;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;
import java.time.ZoneId;

public class GenerateReportFunction {

    private static final Logger LOG = LoggerFactory.getLogger(GenerateReportFunction.class);
    private static final ZoneId ZONE_ID_SP = ZoneId.of("America/Sao_Paulo");

    private final GenerateAndStoreWeeklyFeedbackReportUseCase generateAndStoreWeeklyFeedbackReportUseCase;

    @Inject
    public GenerateReportFunction(
            GenerateAndStoreWeeklyFeedbackReportUseCase generateAndStoreWeeklyFeedbackReportUseCase) {
        this.generateAndStoreWeeklyFeedbackReportUseCase = generateAndStoreWeeklyFeedbackReportUseCase;
    }

    @FunctionName("func-feedback-report")
    public void report(
            @TimerTrigger(name = "gerarRelatorio", schedule = "0 0 0 * * 6") String timerInfo,
            ExecutionContext context) {
        OffsetDateTime fim = OffsetDateTime.now(ZONE_ID_SP);
        OffsetDateTime inicio = fim.minusWeeks(1);

        LOG.info("Gerando relatório semanal de {} até {}", inicio, fim);

        LOG.info("Gerando e armazenando relatório semanal de {} até {}", inicio, fim);

        generateAndStoreWeeklyFeedbackReportUseCase.execute(inicio, fim);
    }
}
