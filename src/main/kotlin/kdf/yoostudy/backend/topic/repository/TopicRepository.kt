package kdf.yoostudy.backend.topic.repository

import kdf.yoostudy.backend.topic.entity.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository : JpaRepository<Topic, Long> {
}