package net.javaguides.organizationservice.service

import net.javaguides.organizationservice.dto.OrganizationDto

interface OrganizationService {
    fun saveOrganization(organizationDto: OrganizationDto): OrganizationDto

    fun getOrganizationByCode(organizationCode: String): OrganizationDto
}