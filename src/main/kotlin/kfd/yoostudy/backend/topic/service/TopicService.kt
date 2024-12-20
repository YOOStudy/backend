package kfd.yoostudy.backend.topic.service

import kfd.yoostudy.backend.common.dto.DeletedResponse
import kfd.yoostudy.backend.topic.dto.TopicRequest
import kfd.yoostudy.backend.topic.entity.Topic

interface TopicService {

    fun getAll() : List<Topic>

    fun getById(id: Long) : Topic

    fun create(request: TopicRequest) : Topic

    fun update(id: Long, request: TopicRequest) : Topic

    fun delete(id: Long) : DeletedResponse

    fun addContributor(topicId: Long, userId: Long) : Topic

    fun removeContributor(topicId: Long, userId: Long) : Topic
}