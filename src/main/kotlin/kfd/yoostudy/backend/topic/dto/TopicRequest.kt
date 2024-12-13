package kfd.yoostudy.backend.topic.dto

data class TopicRequest(
    val title: String,
    val contributorsIds: List<Long>,
    val tags: List<String>,
)