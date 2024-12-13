package kfd.yoostudy.backend.topic.assembler

import kfd.yoostudy.backend.topic.controller.TopicController
import kfd.yoostudy.backend.topic.entity.Topic
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelAssembler
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.stereotype.Component

@Component
class TopicModelAssembler : RepresentationModelAssembler<Topic, EntityModel<Topic>> {
    override fun toModel(entity: Topic): EntityModel<Topic> =
        EntityModel.of(entity,
            linkTo(methodOn(TopicController::class.java).getById(entity.getId())).withSelfRel(),
            linkTo(methodOn(TopicController::class.java).getAll()).withRel("topics")
        )
}