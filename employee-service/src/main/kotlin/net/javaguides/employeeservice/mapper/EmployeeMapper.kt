package net.javaguides.employeeservice.mapper

import net.javaguides.employeeservice.dto.EmployeeDto
import net.javaguides.employeeservice.entity.Employee

class EmployeeMapper {

    companion object {
       fun mapToEmployeeDto(employee: Employee): EmployeeDto {
           return EmployeeDto(
               employee.id,
               employee.firstName,
               employee.lastName,
               employee.email,
               employee.departmentCode,
               employee.organizationCode
           )
       }

        fun mapToEmployee(employeeDto: EmployeeDto): Employee {
            return Employee(
                employeeDto.id,
                employeeDto.firstName,
                employeeDto.lastName,
                employeeDto.email,
                employeeDto.departmentCode,
                employeeDto.organizationCode
            )
        }
    }
}