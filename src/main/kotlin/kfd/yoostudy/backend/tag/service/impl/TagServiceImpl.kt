package kfd.yoostudy.backend.tag.service.impl

import kfd.yoostudy.backend.common.dto.DeletedResponse
import kfd.yoostudy.backend.tag.exception.TagNotFoundException
import kfd.yoostudy.backend.tag.dto.TagRequest
import kfd.yoostudy.backend.tag.entity.Tag
import kfd.yoostudy.backend.tag.repository.TagRepository
import kfd.yoostudy.backend.tag.service.TagService
import org.springframework.stereotype.Service

@Service
class TagServiceImpl(
    val tagRepository: TagRepository,
) : TagService {
    override fun getAll(): List<Tag> =
        tagRepository.findAll()

    override fun getById(id: Long): Tag =
        tagRepository.findById(id).orElseThrow {
            TagNotFoundException("Could not find tag with id: $id")
        }

    override fun getByTitle(title: String): Tag =
        tagRepository.findByTitle(title).orElseThrow {
            TagNotFoundException("Could not find tag with title: $title")
        }

    override fun create(request: TagRequest): Tag {
        val entity = Tag(
            title = request.title,
        )
        tagRepository.save(entity)
        return entity
    }

    override fun update(id: Long, request: TagRequest): Tag {
        val entity = getById(id)
        entity.apply {
                title = request.title
            }
        return tagRepository.save(entity)
    }


    override fun delete(id: Long): DeletedResponse {
        val entity = getById(id)
        tagRepository.delete(entity)
        return DeletedResponse()
    }
}