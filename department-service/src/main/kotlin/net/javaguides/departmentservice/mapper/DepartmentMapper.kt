package net.javaguides.departmentservice.mapper

import net.javaguides.departmentservice.dto.DepartmentDto
import net.javaguides.departmentservice.entity.Department

class DepartmentMapper {
    companion object {
        fun mapToDepartmentDto(department: Department): DepartmentDto {
            return DepartmentDto(
                department.id,
                department.departmentName,
                department.departmentDescription,
                department.departmentCode
            )
        }

        fun mapToDepartment(departmentDto: DepartmentDto): Department {
            return Department(
                departmentDto.id,
                departmentDto.departmentName,
                departmentDto.departmentDescription,
                departmentDto.departmentCode
            )
        }
    }
}