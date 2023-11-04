package net.javaguides.employeeservice.dto

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class APIResponseDto(
    val employee: EmployeeDto,
    val department: DepartmentDto,
    val organization: OrganizationDto
)
