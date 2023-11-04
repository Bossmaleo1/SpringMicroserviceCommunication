package net.javaguides.organizationservice.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import lombok.AllArgsConstructor
import net.javaguides.organizationservice.dto.OrganizationDto
import net.javaguides.organizationservice.service.OrganizationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(
    name = "Organization Service - Organization Controller",
    description = "Organization Controller Exposes REST APIs for Organization-Service"
)
@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
class OrganizationController(
    val organizationService: OrganizationService
) {

    @Operation(
        summary = "Save Organization REST API",
        description = "Save Organization REST API is used to save organization object in database"
    )
    @ApiResponse(
        responseCode = "201",
        description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    fun saveDepartment(@RequestBody organizationDto: OrganizationDto): ResponseEntity<OrganizationDto> {
        val savedOrganization = organizationService.saveOrganization(organizationDto)
        return ResponseEntity<OrganizationDto>(savedOrganization, HttpStatus.CREATED)
    }

    @Operation(
        summary = "Get Organization REST API",
        description = "Get Organization REST API is used to save organization object from the database"
    )
    @ApiResponse(
        responseCode = "200",
        description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{code}")
    fun getEmployee(@PathVariable("code") organizationCode: String): ResponseEntity<OrganizationDto> {
        val organizationDto = organizationService.getOrganizationByCode(organizationCode)
        return ResponseEntity<OrganizationDto>(organizationDto, HttpStatus.OK)
    }
}