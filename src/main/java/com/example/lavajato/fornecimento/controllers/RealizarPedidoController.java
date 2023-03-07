package com.example.lavajato.fornecimento.controllers;

import com.example.lavajato.fornecimento.payloads.PedidoRequest;
import com.example.lavajato.fornecimento.payloads.PedidoResponse;
import com.example.lavajato.fornecimento.payloads.RelatorioFornecedorResponse;
import com.example.lavajato.fornecimento.service.PedidosPorFornecedorService;
import com.example.lavajato.fornecimento.service.RealizarPedidoService;
import com.example.lavajato.fornecimento.service.VisualizarPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/realizarpedido")
@RequiredArgsConstructor
public class RealizarPedidoController {

    private final RealizarPedidoService realizarPedidoService;

    private final VisualizarPedidoService visualizarPedidoService;

    private final PedidosPorFornecedorService pedidosPorFornecedorService;

    @PostMapping(path= "")
    public void realizarPedido(@RequestBody PedidoRequest pedidoRequest){
        realizarPedidoService.execute(pedidoRequest);
    }

    @GetMapping(path = "/pedido/{idPedido}")
    public PedidoResponse getPedido(@PathVariable UUID idPedido){
        return visualizarPedidoService.execute(idPedido);
    }

    @GetMapping(path = "/relatorio/{idFornecedor}")
    public RelatorioFornecedorResponse getRelatorioPedidos(@PathVariable UUID idFornecedor){
        return pedidosPorFornecedorService.execute(idFornecedor);
    }
}
