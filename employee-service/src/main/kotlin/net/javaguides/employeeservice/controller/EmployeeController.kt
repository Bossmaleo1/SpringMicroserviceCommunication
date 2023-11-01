package net.javaguides.employeeservice.controller

import lombok.AllArgsConstructor
import net.javaguides.employeeservice.dto.APIResponseDto
import net.javaguides.employeeservice.dto.EmployeeDto
import net.javaguides.employeeservice.service.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
class EmployeeController(
    val employeeService: EmployeeService
) {

    // Build Save Employee REST API
    @PostMapping
    fun saveDepartment(@RequestBody employeeDto: EmployeeDto): ResponseEntity<EmployeeDto> {
        val savedEmployee = employeeService.saveEmployee(employeeDto)
        return ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED)
    }

    // Build Get Employee REST API
    @GetMapping("{id}")
    fun getEmployee(@PathVariable("id") employeeId: Long): ResponseEntity<APIResponseDto> {
        val apiResponseDto: APIResponseDto? = employeeService.getEmployeeById(employeeId)
        return ResponseEntity<APIResponseDto>(apiResponseDto, HttpStatus.OK)
    }
}