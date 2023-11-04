package net.javaguides.organizationservice.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organizations")
data  class Organization(
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,*/
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID?,
    @field:Column(nullable = false)
    val organizationName: String,
    val organizationDescription: String,
    @field:Column(nullable = false, unique = true)
    val organizationCode: String,
    @field:CreationTimestamp
    @field:Column(updatable = false)
    var createdDate: LocalDateTime? = null,
    @field:UpdateTimestamp
    var modifiedDate: LocalDateTime? = null,
)