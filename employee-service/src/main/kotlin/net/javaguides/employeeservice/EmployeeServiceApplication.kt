package net.javaguides.employeeservice

import io.swagger.v3.oas.annotations.ExternalDocumentation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient


@OpenAPIDefinition(
	info = Info(
		title = "Employee Service REST APIs",
		description = "Employee Service REST APIs Documentation",
		version = "v1.0",
		contact = Contact(
			name = "BOSSMALEO",
			email = "sidneymaleoregis@gmail.com",
			url = "https://bossmaleo.com"
		),
		license = License(
			name = "Apache 2.0",
			url = "https://bossmaleo.com"
		)
	),
	externalDocs = ExternalDocumentation(
		description = "Employee-Service Doc",
		url = "https://bossmaleo.com"
	)
)
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
class EmployeeServiceApplication {
	/*@Bean
	fun restTemplate(): RestTemplate {
		return RestTemplate()
	}*/

	@Bean
	fun webClient(): WebClient {
		return WebClient.builder().build()
	}
}


fun main(args: Array<String>) {
	runApplication<EmployeeServiceApplication>(*args)
}
