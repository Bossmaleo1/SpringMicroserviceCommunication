package net.javaguides.organizationservice.mapper

import net.javaguides.organizationservice.dto.OrganizationDto
import net.javaguides.organizationservice.entity.Organization

class OrganizationMapper {

    companion object {

        fun mapToOrganizationDto(organization: Organization): OrganizationDto {
            return OrganizationDto(
                organization.id,
                organization.organizationName,
                organization.organizationDescription,
                organization.organizationCode,
                organization.createdDate,
                organization.modifiedDate
            )
        }

        fun mapToOrganization(organization: OrganizationDto): Organization {
            return Organization(
                organization.id,
                organization.organizationName,
                organization.organizationDescription,
                organization.organizationCode,
                organization.createdDate,
                organization.modifiedDate
            )
        }

    }

}