package com.themyntt.dStock;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "dStock API",
				version = "0.1",
				description = "API para gerenciamento de estoque",
				contact = @Contact(
						name = "Gabriel Araújo Lima",
						email = "gabriel.araujo2902@outlook.com"
				)
		),
		servers = {
				@Server(url = "http://localhost:8080", description = "Servidor local")
		}
)
@SpringBootApplication
public class DStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(DStockApplication.class, args);
	}

}
