package kfd.yoostudy.backend.tag.assembler

import kfd.yoostudy.backend.tag.controller.TagController
import kfd.yoostudy.backend.tag.entity.Tag
import kfd.yoostudy.backend.topic.controller.TopicController
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelAssembler
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.stereotype.Component

@Component
class TagAssembler : RepresentationModelAssembler<Tag, EntityModel<Tag>> {
    override fun toModel(entity: Tag): EntityModel<Tag> =
        EntityModel.of(entity,
            linkTo(methodOn(TagController::class.java).getById(entity.getId())).withSelfRel(),
            linkTo(methodOn(TopicController::class.java).getAll()).withRel("topics")
        )
}