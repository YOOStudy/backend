package kdf.yoostudy.backend.tag.service

import kdf.yoostudy.backend.tag.dto.TagRequest
import kdf.yoostudy.backend.tag.entity.Tag

interface TagService {

    fun getAll() : List<Tag>

    fun getById(id: Long) : Tag

    fun getByTitle(title: String) : Tag

    fun create(request: TagRequest) : Tag

    fun update(request: TagRequest) : Tag

    fun delete(id: Long)
}