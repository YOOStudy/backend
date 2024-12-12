package kdf.yoostudy.backend.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import kdf.yoostudy.backend.topic.entity.Topic
import kdf.yoostudy.backend.common.entity.AbstractEntity
import lombok.EqualsAndHashCode
import lombok.ToString

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "`user`")
class User (
    @Column(nullable = false, unique = true)
    var username: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(nullable = false)
    var password: String,

    @Column(nullable = true)
    var imagePath: String?,

) : AbstractEntity() {

    @ManyToMany(mappedBy = "contributors")
    var topics: MutableList<Topic> = mutableListOf()
}