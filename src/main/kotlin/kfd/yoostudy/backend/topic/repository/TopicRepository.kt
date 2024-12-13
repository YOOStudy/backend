package kfd.yoostudy.backend.topic.repository

import kfd.yoostudy.backend.topic.entity.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository : JpaRepository<Topic, Long> {
}