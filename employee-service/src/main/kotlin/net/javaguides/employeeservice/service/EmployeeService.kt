package net.javaguides.employeeservice.service

import net.javaguides.employeeservice.dto.APIResponseDto
import net.javaguides.employeeservice.dto.EmployeeDto

interface EmployeeService {

    fun saveEmployee(employeeDto: EmployeeDto): EmployeeDto

    fun getEmployeeById(employeeId: Long): APIResponseDto?

}