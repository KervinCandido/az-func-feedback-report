package br.com.fiap.techchallenge.report.application.dto.report;

public record StoredWeeklyFeedbackReportResult(
        WeeklyFeedbackReport report,
        StoredReportResult storage
) {
}
