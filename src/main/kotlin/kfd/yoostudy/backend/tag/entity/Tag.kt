package kfd.yoostudy.backend.tag.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import kfd.yoostudy.backend.common.entity.AbstractEntity

@Entity
@Table(name = "tags")
class Tag(
    @Column(nullable = false, unique = true)
    var title: String
) : AbstractEntity() {
}