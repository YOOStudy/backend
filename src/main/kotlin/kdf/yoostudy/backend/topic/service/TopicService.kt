package kdf.yoostudy.backend.topic.service

import kdf.yoostudy.backend.common.dto.DeletedResponse
import kdf.yoostudy.backend.topic.dto.TopicRequest
import kdf.yoostudy.backend.topic.entity.Topic

interface TopicService {

    fun getALl() : List<Topic>

    fun getById(id: Long) : Topic

    fun create(request: TopicRequest) : Topic

    fun update(id: Long, request: TopicRequest) : Topic

    fun delete(id: Long) : DeletedResponse

    fun addContributor(topicId: Long, userId: Long) : Topic

    fun removeContributor(topicId: Long, userId: Long) : Topic
}