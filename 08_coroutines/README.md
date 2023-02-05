# Домашнее задание к занятию «9. Coroutines: легковесные потоки, Thread Pools & Dispatchers»

Выполненное задание прикрепите ссылкой на ваши GitHub-проекты в личном кабинете студента на сайте [netology.ru](https://netology.ru).

**Важно**: ознакомьтесь со ссылками на главной странице [репозитория с домашними заданиями](../README.md).

**Важно**: если у вас что-то не получилось, оформите Issue. [Шаблон для оформления](../report-requirements.md).

## Как сдавать задачи

1. Создайте проект на GitHub.
1. Сделайте необходимые коммиты.
1. Сделайте пуш. Удостоверьтесь, что ваш код появился на GitHub.
1. Ссылку на ваш проект прикрепите в личном кабинете на сайте [netology.ru](https://netology.ru).
1. Выполните все задачи, чтобы получить зачёт по теме.

## Задача №1. AuthorId

### Легенда

Разработчики снова переделали API и сделали следующие сущности:
```kotlin
data class Post(
    val id: Long,
    val authorId: Long,
    val content: String,
    val published: Long,
    val likedByMe: Boolean,
    val likes: Int = 0,
    var attachment: Attachment? = null,
)

data class Attachment(
    val url: String,
    val description: String,
    val type: AttachmentType,
)

data class Comment(
    val id: Long,
    val postId: Long,
    val authorId: Long,
    val content: String,
    val published: Long,
    val likedByMe: Boolean,
    val likes: Int = 0,
)

data class Author(
    val id: Long,
    val name: String,
    val avatar: String,
)
```

Теперь в постах и комментариях нет ни имени автора, ни аватарки.

Сервер с реализацией находится в каталоге [server](server).

Чтобы автор отображался, нужно делать запрос на `/api/authors/{id}`, где `{id}` — это идентификатор автора. Никакого `getAll` для авторов нет.

### Задача

Используя примеры с лекций, реализуйте любым способом (последовательным или с помощью `async`/`await`) получение авторов:
* для постов;
* для комментариев (*необязательная часть*).

Нужно сделать обычный (не Android) проект и реализовать такую последовательность вызовов, в результате которой мы получим коллекцию из постов с авторами и комментариями. Комментарии тоже должны быть с авторами — *необязательная часть*.

### Результат

Опубликуйте изменения в вашем проекте на GitHub.

Результат пришлите ссылкой на GitHub-проект в личном кабинете студента на сайте [netology.ru](https://netology.ru).
