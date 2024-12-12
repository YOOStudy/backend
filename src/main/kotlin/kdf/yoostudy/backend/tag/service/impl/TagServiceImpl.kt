package kdf.yoostudy.backend.tag.service.impl

import kdf.yoostudy.backend.tag.TagNotFoundException
import kdf.yoostudy.backend.tag.dto.TagRequest
import kdf.yoostudy.backend.tag.entity.Tag
import kdf.yoostudy.backend.tag.repository.TagRepository
import kdf.yoostudy.backend.tag.service.TagService
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

    override fun update(request: TagRequest): Tag {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}