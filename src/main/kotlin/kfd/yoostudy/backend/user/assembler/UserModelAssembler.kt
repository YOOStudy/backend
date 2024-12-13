package kfd.yoostudy.backend.user.assembler

import kfd.yoostudy.backend.user.controller.UserController
import kfd.yoostudy.backend.user.entity.User
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelAssembler

class UserModelAssembler : RepresentationModelAssembler<User, EntityModel<User>> {
    override fun toModel(entity: User): EntityModel<User> {
//            return EntityModel.of(entity,
//                linkTo(methodOn(UserController::class.java).findAll(authentication(entity.username, entity.email)))
        return EntityModel.of(entity)
    }
}