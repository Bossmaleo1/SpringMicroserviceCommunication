package net.javaguides.organizationservice.dto

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class OrganizationDto(
    val id: UUID?,
    val organizationName: String,
    val organizationDescription: String,
    val organizationCode: String,
    val createdDate: LocalDateTime? = null,
    val modifiedDate: LocalDateTime? = null
)
