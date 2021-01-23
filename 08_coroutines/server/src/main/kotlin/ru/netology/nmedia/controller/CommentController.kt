package ru.netology.nmedia.controller

import org.springframework.web.bind.annotation.*
import ru.netology.nmedia.dto.Comment
import ru.netology.nmedia.service.CommentService

@RestController
@RequestMapping("/api/posts/{postId}/comments", "/api/slow/posts/{postId}/comments")
class CommentController(private val service: CommentService) {
    @GetMapping
    fun getAllByPostId(@PathVariable postId: Long) = service.getAllByPostId(postId)

    @PostMapping
    fun save(@RequestBody dto: Comment) = service.save(dto)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = service.removeById(id)

    @PostMapping("/{id}/likes")
    fun likeById(@PathVariable id: Long) = service.likeById(id)

    @DeleteMapping("/{id}/likes")
    fun unlikeById(@PathVariable id: Long) = service.unlikeById(id)
}