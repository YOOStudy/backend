package kdf.yoostudy.backend.common.entity

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@MappedSuperclass
abstract class AbstractEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0
) {
    @Column(name = "created_at")
    @CreationTimestamp
    private val createdAt: LocalDateTime = LocalDateTime.now()
}