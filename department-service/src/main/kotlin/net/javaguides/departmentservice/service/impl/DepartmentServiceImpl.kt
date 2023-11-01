package net.javaguides.departmentservice.service.impl

import lombok.AllArgsConstructor
import net.javaguides.departmentservice.dto.DepartmentDto
import net.javaguides.departmentservice.entity.Department
import net.javaguides.departmentservice.repository.DepartmentRepository
import net.javaguides.departmentservice.service.DepartmentService
import org.springframework.stereotype.Service

@Service
@AllArgsConstructor
class DepartmentServiceImpl(
    val departmentRepository: DepartmentRepository
): DepartmentService {
    override fun saveDepartment(departmentDto: DepartmentDto): DepartmentDto {
        // convert department dto to department jpa entity
        val department: Department = Department(
            departmentDto.id,
            departmentDto.departmentName,
            departmentDto.departmentDescription,
            departmentDto.departmentCode
        )

        val savedDepartment = departmentRepository.save(department)

        return DepartmentDto(
            savedDepartment.id,
            savedDepartment.departmentName,
            savedDepartment.departmentDescription,
            savedDepartment.departmentCode
        )
    }

    override fun getDepartmentByCode(departmentCode: String): DepartmentDto {
        val department = departmentRepository.findByDepartmentCode(departmentCode)

        return DepartmentDto(
            department.id,
            department.departmentName,
            department.departmentDescription,
            department.departmentCode
        )
    }
}