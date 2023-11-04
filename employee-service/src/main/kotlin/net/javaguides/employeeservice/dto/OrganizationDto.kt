package net.javaguides.employeeservice.dto

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime
import java.util.*

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class OrganizationDto(
    val id: UUID?,
    val organizationName: String,
    val organizationDescription: String,
    var organizationCode: String,
    val createdDate: LocalDateTime? = null,
    val modifiedDate: LocalDateTime? = null
)