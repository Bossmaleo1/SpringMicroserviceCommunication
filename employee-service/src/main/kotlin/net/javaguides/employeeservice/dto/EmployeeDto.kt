package net.javaguides.employeeservice.dto

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class EmployeeDto (
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val departmentCode: String
)