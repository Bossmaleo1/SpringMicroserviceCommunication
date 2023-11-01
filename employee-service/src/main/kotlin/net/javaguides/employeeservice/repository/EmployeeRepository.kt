package net.javaguides.employeeservice.repository

import net.javaguides.employeeservice.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository: JpaRepository<Employee,Long> {
}