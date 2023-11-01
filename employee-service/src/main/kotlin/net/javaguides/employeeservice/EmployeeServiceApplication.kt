package net.javaguides.employeeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
class EmployeeServiceApplication {
	/*@Bean
	fun restTemplate(): RestTemplate {
		return RestTemplate()
	}*/

	/*@Bean
	fun webClient(): WebClient {
		return WebClient.builder().build()
	}*/
}


fun main(args: Array<String>) {
	runApplication<EmployeeServiceApplication>(*args)
}
