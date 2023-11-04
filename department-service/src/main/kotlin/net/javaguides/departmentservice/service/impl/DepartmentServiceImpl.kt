package net.javaguides.departmentservice.service.impl

import lombok.AllArgsConstructor
import net.javaguides.departmentservice.dto.DepartmentDto
import net.javaguides.departmentservice.entity.Department
import net.javaguides.departmentservice.mapper.DepartmentMapper
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
        val department: Department = DepartmentMapper.mapToDepartment(departmentDto)

        val savedDepartment = departmentRepository.save(department)

        return DepartmentMapper.mapToDepartmentDto(savedDepartment)
    }

    override fun getDepartmentByCode(departmentCode: String): DepartmentDto {
        val department = departmentRepository.findByDepartmentCode(departmentCode)

        return DepartmentMapper.mapToDepartmentDto(department)
    }
}