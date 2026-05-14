package br.com.fiap.techchallenge;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;

public class Function {

    @FunctionName("func-feedback-report")
    public void report(
            @TimerTrigger(name = "gerarRelatorio", schedule = "0 0 0 * * 6") String timerInfo,
            ExecutionContext context) {
        context.getLogger().info("Timer is triggered: " + timerInfo);
    }
}
