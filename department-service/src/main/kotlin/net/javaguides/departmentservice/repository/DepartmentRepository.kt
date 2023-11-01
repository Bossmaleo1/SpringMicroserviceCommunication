package net.javaguides.departmentservice.repository

import net.javaguides.departmentservice.entity.Department
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository : JpaRepository<Department,Long> {

    fun findByDepartmentCode(departmentCode: String): Department

}