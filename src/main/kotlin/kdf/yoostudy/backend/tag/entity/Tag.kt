package kdf.yoostudy.backend.tag.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import kdf.yoostudy.backend.common.entity.AbstractEntity

@Entity
@Table(name = "tags")
class Tag(
    @Column(nullable = false, unique = true)
    val title: String
) : AbstractEntity() {
}