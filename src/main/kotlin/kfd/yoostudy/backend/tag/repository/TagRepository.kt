package kfd.yoostudy.backend.tag.repository

import kfd.yoostudy.backend.tag.entity.Tag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TagRepository : JpaRepository<Tag, Long> {

    fun findByTitle(title: String): Optional<Tag>
}