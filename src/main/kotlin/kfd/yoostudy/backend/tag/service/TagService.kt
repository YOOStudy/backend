package kfd.yoostudy.backend.tag.service

import kfd.yoostudy.backend.common.dto.DeletedResponse
import kfd.yoostudy.backend.tag.dto.TagRequest
import kfd.yoostudy.backend.tag.entity.Tag

interface TagService {

    fun getAll() : List<Tag>

    fun getById(id: Long) : Tag

    fun getByTitle(title: String) : Tag

    fun create(request: TagRequest) : Tag

    fun update(id: Long, request: TagRequest) : Tag

    fun delete(id: Long): DeletedResponse
}