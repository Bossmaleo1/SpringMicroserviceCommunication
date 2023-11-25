package net.javaguides.employeeservice.currency

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "currency-service")
@Component
class CurrencyServiceConfiguration(
    url: String,
    userName: String,
    key: String
) {

}