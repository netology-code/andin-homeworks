package ru.netology.nmedia.entity

import ru.netology.nmedia.dto.Comment
import javax.persistence.*

@Entity
data class CommentEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    var postId: Long, // no relations for simplicity
    var authorId: Long, // no relations for simplicity
    @Column(columnDefinition = "TEXT")
    var content: String,
    var published: Long,
    var likedByMe: Boolean,
    var likes: Int = 0,
) {
    fun toDto() = Comment(id, postId, authorId, content, published, likedByMe, likes)

    companion object {
        fun fromDto(dto: Comment) = CommentEntity(
            dto.id,
            dto.postId,
            dto.authorId,
            dto.content,
            dto.published,
            dto.likedByMe,
            dto.likes,
        )
    }
}
