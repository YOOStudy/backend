package kfd.yoostudy.backend.user.service

import kfd.yoostudy.backend.common.dto.DeletedResponse
import kfd.yoostudy.backend.user.dto.RegistrationRequest
import kfd.yoostudy.backend.user.entity.User

interface UserService {

    fun getAll(): List<User>

    fun getById(id: Long): User

    fun getByUsername(username: String): User

    fun getByEmail(email: String): User

    fun create(request: RegistrationRequest): User

    fun update(id: Long)

    fun delete(id: Long): DeletedResponse

    fun checkRegistrationRequest(request: RegistrationRequest)
}