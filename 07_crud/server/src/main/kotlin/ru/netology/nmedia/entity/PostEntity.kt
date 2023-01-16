package ru.netology.nmedia.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import ru.netology.nmedia.dto.Attachment
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.enumeration.AttachmentType

@Entity
data class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    var author: String,
    val authorAvatar: String,
    @Column(columnDefinition = "TEXT")
    var content: String,
    var published: Long,
    var likedByMe: Boolean,
    var likes: Int = 0,
    @Embedded
    var attachment: AttachmentEmbeddable?,
) {
    fun toDto() = Post(id, author, authorAvatar, content, published, likedByMe, likes, attachment?.toDto())

    companion object {
        fun fromDto(dto: Post) = PostEntity(
            dto.id,
            dto.author,
            dto.authorAvatar,
            dto.content,
            dto.published,
            dto.likedByMe,
            dto.likes,
            AttachmentEmbeddable.fromDto(dto.attachment),
        )
    }
}

@Embeddable
data class AttachmentEmbeddable(
    var url: String,
    @Column(columnDefinition = "TEXT")
    var description: String,
    @Enumerated(EnumType.STRING)
    var type: AttachmentType,
) {
    fun toDto() = Attachment(url, description, type)

    companion object {
        fun fromDto(dto: Attachment?) = dto?.let {
            AttachmentEmbeddable(it.url, it.description, it.type)
        }
    }
}
