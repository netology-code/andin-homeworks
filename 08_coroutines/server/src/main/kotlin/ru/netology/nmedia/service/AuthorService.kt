package ru.netology.nmedia.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.netology.nmedia.dto.Author
import ru.netology.nmedia.entity.AuthorEntity
import ru.netology.nmedia.exception.NotFoundException
import ru.netology.nmedia.repository.AuthorRepository

@Service
@Transactional
class AuthorService(private val repository: AuthorRepository) {
    fun getById(id: Long): Author = repository
        .findById(id)
        .map { it.toDto() }
        .orElseThrow(::NotFoundException)

    fun save(dto: Author): Author = repository
        .findById(dto.id)
        .orElse(AuthorEntity.fromDto(dto))
        .let {
            if (it.id == 0L) repository.save(it)
            it
        }.toDto()
}