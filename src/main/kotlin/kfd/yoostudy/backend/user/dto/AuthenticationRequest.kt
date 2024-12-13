package kfd.yoostudy.backend.user.dto

data class AuthenticationRequest(
    val username: String?,
    val email: String?,
    val password: String,
)
