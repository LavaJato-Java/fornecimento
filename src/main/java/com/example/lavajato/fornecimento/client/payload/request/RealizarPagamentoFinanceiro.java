package com.example.lavajato.fornecimento.client.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RealizarPagamentoFinanceiro {
    @NotNull
    private FornecedorFinanceiroRequest fornecedor;

    @NotNull
    private List<ItemRequest> items;
}