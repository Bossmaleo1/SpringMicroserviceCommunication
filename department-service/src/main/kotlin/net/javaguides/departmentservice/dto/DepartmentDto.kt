package net.javaguides.departmentservice.dto

import io.swagger.v3.oas.annotations.media.Schema
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Schema(
    description = "DepartmentDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class DepartmentDto (
    val id: Long,
    @Schema(
        description = "Department Name"
    )
    val departmentName: String,
    @Schema(
        description = "Department Description"
    )
    val departmentDescription: String,
    @Schema(
        description = "Department Code"
    )
    val departmentCode: String
)