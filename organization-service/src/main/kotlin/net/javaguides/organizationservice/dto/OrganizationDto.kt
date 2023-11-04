package net.javaguides.organizationservice.dto

import io.swagger.v3.oas.annotations.media.Schema
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Schema(
    description = "Organization Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class OrganizationDto(
    val id: UUID?,
    val organizationName: String,
    @Schema(
        description = "Organization Description"
    )
    val organizationDescription: String,
    @Schema(
        description = "Organization code"
    )
    val organizationCode: String,
    @Schema(
        description = "Department Created Date"
    )
    val createdDate: LocalDateTime? = null,
    @Schema(
        description = "Department Modified Date"
    )
    val modifiedDate: LocalDateTime? = null
)
