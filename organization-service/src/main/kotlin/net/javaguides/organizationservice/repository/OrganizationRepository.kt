package net.javaguides.organizationservice.repository

import net.javaguides.organizationservice.entity.Organization
import org.springframework.data.jpa.repository.JpaRepository

interface OrganizationRepository : JpaRepository<Organization, Long> {
}