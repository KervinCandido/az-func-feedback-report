package br.com.fiap.techchallenge.report.domain.model;

import br.com.fiap.techchallenge.report.domain.enums.Urgencia;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

public record Feedback(
        UUID id,
        String descricao,
        int nota,
        Urgencia urgencia,
        OffsetDateTime dataCriacao) {

    public Feedback {
        Objects.requireNonNull(id, "id é obrigatório");
        validarDescricao(descricao);
        validarNota(nota);
        Objects.requireNonNull(urgencia, "urgencia é obrigatória");
        Objects.requireNonNull(dataCriacao, "dataCriacao é obrigatória");
    }

    private static void validarDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição é obrigatória.");
        }
    }

    private static void validarNota(int nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10.");
        }
    }
}
