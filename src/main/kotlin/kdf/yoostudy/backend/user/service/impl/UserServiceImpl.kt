package kdf.yoostudy.backend.user.service.impl

import kdf.yoostudy.backend.common.dto.DeletedResponse
import kdf.yoostudy.backend.user.repository.UserRepository
import kdf.yoostudy.backend.user.dto.RegistrationRequest
import kdf.yoostudy.backend.user.entity.User
import kdf.yoostudy.backend.user.exception.RegistrationErrorException
import kdf.yoostudy.backend.user.exception.UserNotFoundException
import kdf.yoostudy.backend.user.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository,
) : UserService {
    override fun getAll(): List<User> =
        userRepository.findAll()

    override fun getById(id: Long): User =
        userRepository.findById(id).orElseThrow {
            UserNotFoundException("Could not find user with id $id")
        }

    override fun getByUsername(username: String): User =
        userRepository.findByUsername(username).orElseThrow {
            UserNotFoundException("Could not find user with username: $username")
        }

    override fun getByEmail(email: String): User =
        userRepository.findByEmail(email).orElseThrow {
            UserNotFoundException("Could not find user with email $email")
        }

    override fun create(request: RegistrationRequest): User {

        checkRegistrationRequest(request)

        val entity = User(
            username = request.username,
            email = request.email,
            password = request.password,
            imagePath = request.imagePath,
        )

        return userRepository.save(entity)
    }

    override fun update(id: Long) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long): DeletedResponse {
        val entity: User = getById(id)
        userRepository.delete(entity)
        return DeletedResponse()
    }

    override fun checkRegistrationRequest(request: RegistrationRequest) {
        if (request.email.isBlank() && request.username.isBlank()) {
            throw RegistrationErrorException("Email and/or Username must be provided")
        }

        if (request.password.isBlank()) {
            throw RegistrationErrorException("Password must be provided")
        }

        if (request.password != request.confirmedPassword) {
            throw RegistrationErrorException("Passwords do not match")
        }
    }
}