package net.javaguides.departmentservice.service

import net.javaguides.departmentservice.dto.DepartmentDto

interface DepartmentService {

   fun saveDepartment(departmentDto: DepartmentDto): DepartmentDto

   fun getDepartmentByCode(code: String): DepartmentDto

}