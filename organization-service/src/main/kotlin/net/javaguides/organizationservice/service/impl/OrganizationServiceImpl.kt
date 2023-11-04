package net.javaguides.organizationservice.service.impl

import net.javaguides.organizationservice.dto.OrganizationDto
import net.javaguides.organizationservice.mapper.OrganizationMapper
import net.javaguides.organizationservice.repository.OrganizationRepository
import net.javaguides.organizationservice.service.OrganizationService
import org.springframework.stereotype.Service

@Service
class OrganizationServiceImpl(
  val organizationRepository: OrganizationRepository
) : OrganizationService {
    override fun saveOrganization(organizationDto: OrganizationDto): OrganizationDto{
        val organization = OrganizationMapper.mapToOrganization(organizationDto)

        val savedOrganization = organizationRepository.save(organization)

        return OrganizationMapper.mapToOrganizationDto(savedOrganization)
    }

    override fun getOrganizationByCode(organizationCode: String): OrganizationDto {
        val organization = organizationRepository.findByOrganizationCode(organizationCode)
        return OrganizationMapper.mapToOrganizationDto(organization)
    }
}