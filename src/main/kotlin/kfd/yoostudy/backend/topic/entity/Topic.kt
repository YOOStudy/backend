package kfd.yoostudy.backend.topic.entity

import jakarta.persistence.*
import kfd.yoostudy.backend.user.entity.User
import kfd.yoostudy.backend.common.entity.AbstractEntity
import kfd.yoostudy.backend.tag.entity.Tag
import lombok.Getter

@Getter
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