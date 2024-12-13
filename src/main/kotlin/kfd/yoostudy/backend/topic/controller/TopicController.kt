package kfd.yoostudy.backend.topic.controller

import kfd.yoostudy.backend.common.dto.DeletedResponse
import kfd.yoostudy.backend.topic.assembler.TopicModelAssembler
import kfd.yoostudy.backend.topic.dto.TopicRequest
import kfd.yoostudy.backend.topic.entity.Topic
import kfd.yoostudy.backend.topic.service.TopicService
import org.springframework.hateoas.EntityModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(
    val topicAssembler: TopicModelAssembler,
    val topicService: TopicService
) {

    @GetMapping
    fun getAll(): List<EntityModel<Topic>> =
        topicService.getAll().map {
            topicAssembler.toModel(it)
        }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): EntityModel<Topic> =
        topicAssembler.toModel(topicService.getById(id))

    @PostMapping
    fun create(@RequestBody request: TopicRequest): EntityModel<Topic> =
        topicAssembler.toModel(topicService.create(request))
    
    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody request: TopicRequest): EntityModel<Topic> =
        topicAssembler.toModel(topicService.update(id, request))
    
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<DeletedResponse> {
        topicService.delete(id)
        return ResponseEntity<DeletedResponse>(HttpStatus.NO_CONTENT) // 204
    }
}