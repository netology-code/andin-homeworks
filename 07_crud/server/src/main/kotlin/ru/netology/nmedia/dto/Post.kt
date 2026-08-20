package ru.netology.nmedia.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import ru.netology.nmedia.enumeration.AttachmentType
import java.time.Instant

data class Post(
    val id: Long,
    val author: String,
    val authorAvatar: String,
    val content: String,
    val published: Long,
    val likedByMe: Boolean,
    val likes: Int = 0,
    var attachment: Attachment? = null,
) {
    @JsonCreator
    constructor(
        @JsonProperty("id") id: Long?,
        @JsonProperty("author") author: String?,
        @JsonProperty("authorAvatar") authorAvatar: String?,
        @JsonProperty("content") content: String,
        @JsonProperty("published") published: Instant?,
        @JsonProperty("likedByMe") likedByMe: Boolean?,
        @JsonProperty("likes") likes: Int?,
        @JsonProperty("attachment") attachment: Attachment?,
    ) : this(
        id = id ?: 0,
        author = author ?: "",
        authorAvatar = authorAvatar.orEmpty(),
        content = content,
        published = (published ?: Instant.now()).toEpochMilli(),
        likedByMe = likedByMe ?: false,
        likes = likes ?: 0,
        attachment = attachment,
    )
}

data class Attachment(
    val url: String,
    val description: String,
    val type: AttachmentType,
)
