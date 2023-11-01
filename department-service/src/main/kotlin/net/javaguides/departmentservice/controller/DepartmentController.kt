package net.javaguides.departmentservice.controller

import lombok.AllArgsConstructor
import net.javaguides.departmentservice.dto.DepartmentDto
import net.javaguides.departmentservice.service.DepartmentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
class DepartmentController(
    val departmentService: DepartmentService
) {

    @PostMapping
    fun saveDepartment(@RequestBody departmentDto: DepartmentDto): ResponseEntity<DepartmentDto> {
        val savedDepartment = departmentService.saveDepartment(departmentDto)
        return ResponseEntity<DepartmentDto>(savedDepartment, HttpStatus.CREATED)
    }

    @GetMapping("{department-code}")
    fun getDepartment(@PathVariable("department-code") departmentCode: String) : ResponseEntity<DepartmentDto> {
        val departmentDto = departmentService.getDepartmentByCode(departmentCode)
        return ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK)
    }
}