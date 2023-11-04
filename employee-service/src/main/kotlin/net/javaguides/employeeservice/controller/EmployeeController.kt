package net.javaguides.employeeservice.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
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

    @Operation(
        summary = "Save Employee REST API",
        description = "Save Employee REST API is used to save department object in database"
    )
    @ApiResponse(
        responseCode = "201",
        description = "HTTP Status 201 CREATED"
    )
    // Build Save Employee REST API
    @PostMapping
    fun saveDepartment(@RequestBody employeeDto: EmployeeDto): ResponseEntity<EmployeeDto> {
        val savedEmployee = employeeService.saveEmployee(employeeDto)
        return ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED)
    }

    @Operation(
        summary = "Get Employee REST API",
        description = "Get Employee REST API is used to save employee object from the database"
    )
    @ApiResponse(
        responseCode = "200",
        description = "HTTP Status 200 OK"
    )
    // Build Get Employee REST API
    @GetMapping("{id}")
    fun getEmployee(@PathVariable("id") employeeId: Long): ResponseEntity<APIResponseDto> {
        val apiResponseDto: APIResponseDto? = employeeService.getEmployeeById(employeeId)
        return ResponseEntity<APIResponseDto>(apiResponseDto, HttpStatus.OK)
    }
}