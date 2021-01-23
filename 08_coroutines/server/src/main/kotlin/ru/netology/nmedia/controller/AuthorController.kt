package ru.netology.nmedia.controller

import org.springframework.web.bind.annotation.*
import ru.netology.nmedia.dto.Author
import ru.netology.nmedia.service.AuthorService

@RestController
@RequestMapping("/api/authors", "/api/slow/authors")
class AuthorController(private val service: AuthorService) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = service.getById(id)

    @PostMapping
    fun save(@RequestBody dto: Author) = service.save(dto)
}