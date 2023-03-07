package com.example.lavajato.fornecimento.service;

import com.example.lavajato.fornecimento.entity.Pedido;
import com.example.lavajato.fornecimento.payloads.FornecedorRequest;
import com.example.lavajato.fornecimento.payloads.RelatorioFornecedorResponse;
import com.example.lavajato.fornecimento.repositories.FornecedorRepository;
import com.example.lavajato.fornecimento.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PedidosPorFornecedorService {
    private final PedidoRepository pedidoRepository;

    private final FornecedorRepository fornecedorRepository;

    @Cacheable(cacheNames = "rlfornecedor", key ="#idFornecedor" )
    public RelatorioFornecedorResponse execute(UUID idFornecedor){

        FornecedorRequest fornecedor = new FornecedorRequest();
        fornecedor.setId(idFornecedor);
        fornecedor.setCnpj(fornecedorRepository.findById(idFornecedor).get().getCnpj());
        fornecedor.setRazaoSocial(fornecedorRepository.findById(idFornecedor).get().getRazaoSocial());

        log.info("Relatorio do fornecedor invocado");

        List<Pedido> pedidos = pedidoRepository.findByFornecedor(idFornecedor);
        RelatorioFornecedorResponse relatorioFornecedor = new RelatorioFornecedorResponse();
        relatorioFornecedor.setFornecedor(fornecedor);
        relatorioFornecedor.setPedidos(pedidos);
        return relatorioFornecedor;
    }
}