package net.javaguides.organizationservice.controller

import lombok.AllArgsConstructor
import net.javaguides.organizationservice.dto.OrganizationDto
import net.javaguides.organizationservice.service.OrganizationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
class OrganizationController(
    val organizationService: OrganizationService
) {

    @PostMapping
    fun saveDepartment(@RequestBody organizationDto: OrganizationDto): ResponseEntity<OrganizationDto> {
        val savedOrganization = organizationService.saveOrganization(organizationDto)
        return ResponseEntity<OrganizationDto>(savedOrganization, HttpStatus.CREATED)
    }
}