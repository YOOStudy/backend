package kfd.yoostudy.backend.tag.controller

import kfd.yoostudy.backend.tag.assembler.TagAssembler
import kfd.yoostudy.backend.tag.dto.TagRequest
import kfd.yoostudy.backend.tag.entity.Tag
import kfd.yoostudy.backend.tag.service.TagService
import org.springframework.hateoas.EntityModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tags")
class TagController(
    val tagAssembler: TagAssembler,
    val tagService: TagService,
) {

    @GetMapping
    fun getAll(): List<EntityModel<Tag>> =
        tagService.getAll().map {
            tagAssembler.toModel(it)
        }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): EntityModel<Tag> =
        tagAssembler.toModel(tagService.getById(id))

    @PostMapping
    fun create(@RequestBody request: TagRequest): EntityModel<Tag> =
        tagAssembler.toModel(tagService.create(request))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: TagRequest): EntityModel<Tag> =
        tagAssembler.toModel(tagService.update(id, request))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<DeleteMapping> {
        tagService.delete(id)
        return ResponseEntity<DeleteMapping>(HttpStatus.NO_CONTENT) // 204
    }
}