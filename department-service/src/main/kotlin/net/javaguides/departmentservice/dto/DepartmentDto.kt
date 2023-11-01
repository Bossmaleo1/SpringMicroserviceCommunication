package net.javaguides.departmentservice.dto

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class DepartmentDto (
    val id: Long,
    val departmentName: String,
    val departmentDescription: String,
    val departmentCode: String
)