package com.example.lavajato.fornecimento.jms.out;

import com.example.lavajato.fornecimento.client.payload.request.RealizarPagamentoFinanceiro;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagamentoFornecedorFinanceiroProducer {
    @Value("${business.financeiro.kafka.out}")
    private String topicName;
    private final KafkaTemplate<String, RealizarPagamentoFinanceiro> kafkaTemplate;

    public void send(RealizarPagamentoFinanceiro realizarPagamentoFinanceiro){
        log.info("Mensagem enviada pelo kafka {}", realizarPagamentoFinanceiro);
        kafkaTemplate.send(topicName,realizarPagamentoFinanceiro);
    }
}