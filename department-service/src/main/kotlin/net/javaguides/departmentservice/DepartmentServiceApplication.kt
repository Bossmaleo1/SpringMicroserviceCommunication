package net.javaguides.departmentservice

import io.swagger.v3.oas.annotations.ExternalDocumentation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient


@OpenAPIDefinition(
	info = Info(
		title = "Department Service REST APIs",
		description = "Department Service REST APIs Documentation",
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
		description = "Department-Service Doc",
		url = "https://bossmaleo.com"
	)
)
@SpringBootApplication
@EnableDiscoveryClient
class DepartmentServiceApplication

fun main(args: Array<String>) {
	runApplication<DepartmentServiceApplication>(*args)
}
