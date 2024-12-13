package kfd.yoostudy.backend.user.dto

data class RegistrationRequest(
    val username: String,
    val email: String,
    val password: String,
    val confirmedPassword: String,
    val imagePath: String?,
)
