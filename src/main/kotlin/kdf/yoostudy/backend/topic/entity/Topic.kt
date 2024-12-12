package kdf.yoostudy.backend.topic.entity

import jakarta.persistence.*
import kdf.yoostudy.backend.user.entity.User
import kdf.yoostudy.backend.common.entity.AbstractEntity
import kdf.yoostudy.backend.tag.entity.Tag

@Entity
@Table(name = "topic")
class Topic(
    @Column(nullable = false)
    var title: String,
) : AbstractEntity() {

    @ManyToMany(targetEntity = User::class)
    @JoinTable(
        name = "topic_to_user",
        joinColumns = [JoinColumn(name = "topic_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")]
    )
    var contributors: MutableList<User> = mutableListOf()

    @ManyToMany(targetEntity = Tag::class)
    @JoinTable(
        name = "topic_to_tag",
        joinColumns = [JoinColumn(name = "topic_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "id")]
    )
    var tags: List<Tag> = mutableListOf()
}