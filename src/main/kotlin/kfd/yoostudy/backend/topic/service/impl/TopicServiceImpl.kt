package kfd.yoostudy.backend.topic.service.impl

import kfd.yoostudy.backend.common.dto.DeletedResponse
import kfd.yoostudy.backend.tag.service.TagService
import kfd.yoostudy.backend.topic.dto.TopicRequest
import kfd.yoostudy.backend.topic.entity.Topic
import kfd.yoostudy.backend.topic.exception.TopicNotFoundException
import kfd.yoostudy.backend.topic.repository.TopicRepository
import kfd.yoostudy.backend.topic.service.TopicService
import kfd.yoostudy.backend.user.entity.User
import kfd.yoostudy.backend.user.service.UserService
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    val topicRepository: TopicRepository,
    val tagService: TagService,
    val userService: UserService,
) : TopicService {

    override fun getAll(): List<Topic> =
        topicRepository.findAll()

    override fun getById(id: Long) : Topic =
        topicRepository.findById(id).orElseThrow {
            TopicNotFoundException("Could not find topic with id: $id")
        }

    override fun create(request: TopicRequest): Topic {
        val entity = Topic(
            request.title,
        )
            .apply {
                contributors = request.contributorsIds.map {
                    userService.getById(it)
                }.toMutableList()
                tags = request.tags.map {
                    tagService.getByTitle(it)
                }
            }
        return topicRepository.save(entity)
    }

    override fun update(id: Long, request: TopicRequest) : Topic {
        val entity = topicRepository.findById(id).orElseThrow {
            TopicNotFoundException("Could not find topic with id: $id")
        }
            .apply {
                title = request.title
                contributors = request.contributorsIds.map {
                    userService.getById(it)
                }.toMutableList()
            }
        return topicRepository.save(entity)
    }

    override fun delete(id: Long) : DeletedResponse {
        val entity = getById(id)
        topicRepository.delete(entity)
        return DeletedResponse()
    }

    override fun addContributor(topicId: Long, userId: Long) : Topic {
        val userEntity: User = userService.getById(userId)
        val topicEntity: Topic = getById(topicId)

        val currContributors: List<User> = topicEntity.contributors
        for (contributor in currContributors) {
            if (contributor == userEntity) {
                throw RuntimeException("sd")
            }
        }

        topicEntity.contributors.add(userEntity)
        return topicRepository.save(topicEntity)
    }

    override fun removeContributor(topicId: Long, userId: Long) : Topic {
        val userEntity: User = userService.getById(userId)
        val topicEntity: Topic = getById(topicId)

        if (!topicEntity.contributors.remove(userEntity)) {
            throw RuntimeException("sd")
        }
        return topicRepository.save(topicEntity)
    }
}