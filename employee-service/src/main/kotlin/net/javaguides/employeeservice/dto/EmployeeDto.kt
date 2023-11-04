package net.javaguides.employeeservice.dto

import io.swagger.v3.oas.annotations.media.Schema
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Schema(
    description = "Employee Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class EmployeeDto (
    val id: Long,
    @Schema(
        description = "Employee First Name"
    )
    val firstName: String,
    @Schema(
        description = "Employee Last Name"
    )
    val lastName: String,
    @Schema(
        description = "Employee Email"
    )
    val email: String,
    @Schema(
        description = "Employee Department Code"
    )
    val departmentCode: String,
    @Schema(
        description = "Employee Organization Code"
    )
    val organizationCode: String
)