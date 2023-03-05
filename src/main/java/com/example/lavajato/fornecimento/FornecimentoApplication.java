package com.example.lavajato.fornecimento;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title= "Fornecimento api", version = "1.0", description = "Fornecimento API"))
@EnableKafka
@EnableRabbit
public class FornecimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FornecimentoApplication.class, args);
	}

}
