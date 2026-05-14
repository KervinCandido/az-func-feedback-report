package br.com.fiap.techchallenge.report.application.ports;

import br.com.fiap.techchallenge.report.application.dto.report.StoredReportResult;

public interface ReportStoragePort {
    StoredReportResult save(String blobName, String content, String contentType);
}
