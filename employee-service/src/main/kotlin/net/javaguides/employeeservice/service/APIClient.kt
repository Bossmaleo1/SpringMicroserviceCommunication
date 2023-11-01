package net.javaguides.employeeservice.service

import net.javaguides.employeeservice.dto.DepartmentDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
fun interface APIClient {

    //Build get department rest api
    @GetMapping("api/departments/{department-code}")
    fun getDepartment(@PathVariable("department-code") departmentCode: String): DepartmentDto
}