# Домашнее задание к занятию «14. Регистрация, аутентификация и авторизация»

Выполненное задание прикрепите ссылкой на ваши GitHub-проекты в личном кабинете студента на сайте [netology.ru](https://netology.ru).

**Важно**: ознакомьтесь со ссылками на главной странице [репозитория с домашними заданиями](../README.md).

**Важно**: если у вас что-то не получилось, оформите Issue. [Шаблон для оформления](../report-requirements.md).

## Как сдавать задачи

1. Откройте ваш проект Android-приложения с предыдущего ДЗ (можете брать код из лекции).
1. Сделайте необходимые коммиты.
1. Сделайте пуш. Удостоверьтесь, что ваш код появился на GitHub.
1. Ссылку на ваш проект прикрепите в личном кабинете на сайте [netology.ru](https://netology.ru).
1. Необязательные задачи можно не выполнять. На зачёт это не повлияет. 

## Задача №1. Аутентификация

### Описание

При нажатии на пункт меню «Sign in» реализуйте следующую последовательность действий:

1\. Открытие фрагмента с двумя полями (логин и пароль) и кнопкой «Войти». Создайте для этого фрагмента собственную `ViewModel`.

2\. Отправку запроса вида:

```http request
POST http://localhost:9999/api/users/authentication
Content-Type: application/x-www-form-urlencoded

login=student&pass=secret
```

В ответ вам придёт JSON вида:
```json
{
  "id": 6,
  "token": "j/cAPk6GZEm7Vmq..."
}
```

Где `id` — идентификатор пользователя с логином `student` и паролем `secret`, а `token` — это и есть токен.

Как отправлять формы формата `form-encoded` (`application/x-www-form-urlencoded`), смотрите в [документации на Retrofit](https://square.github.io/retrofit/).

<details>
<summary>Если не нашли, как отправлять форму:</summary>

```kotlin
@FormUrlEncoded
@POST("users/authentication")
suspend fun updateUser(@Field("login") login: String, @Field("pass") pass: String): Response<ваш_тип>
```

</details>

3\. Сохраните указанную пару в `AppAuth`.

4\. Вернитесь на предыдущий фрагмент, с которого вы попали на фрагмент аутентификации.

Убедитесь, что меню в `ActionBar` и карточки постов, автором которых вы являетесь, обновились.

### Результат

Опубликуйте изменения в виде Pull Request в вашем проекте на GitHub.

Результат пришлите ссылкой на PR GitHub-проект в личном кабинете студента на сайте [netology.ru](https://netology.ru).

## Задача №2. `Sign In to ...` и `Are you sure?`*

**Важно**: это необязательная задача. Её можно не выполнять. На зачёт это не повлияет.

### Описание

Реализуйте следующую функциональность:

1\. Когда на экране находится лента постов в `PostViewModel`, проходит проверка, аутентифицирован ли пользователь. Проверка проходит при:
   * добавлении поста (нажатие на `Fab` +);
   * лайке поста.
      
Если пользователь не аутентифицирован, появляется диалоговое окно с предложением пройти аутентификацию. Перенаправляйте пользователя на фрагмент аутентификации, который вы реализовали в предыдущем пункте.

2\. При создании поста возникает диалоговое окно с подтверждением выхода, если пользователь в `ActionBar` выбрал пункт меню `Sign Out`.

Если пользователь подтвердил выход, перенаправляйте на предыдущий фрагмент.

### Результат

Опубликуйте изменения в виде Pull Request в вашем проекте на GitHub.

Результат пришлите ссылкой на PR GitHub-проект в личном кабинете студента на сайте [netology.ru](https://netology.ru).

## Задача №3. Регистрация*

**Важно**: это необязательная задача. Её можно не выполнять. На зачёт это не повлияет.

### Описание

Реализуйте при нажатии на пункт меню «Sign Up» следующую последовательность действий:

1\. Открывается фрагмент с 4 полями (имя, логин, пароль и подтверждение пароля) и кнопкой «Зарегистрироваться». Создайте для этого фрагмента собственную `ViewModel`.

2\. Отправляется запроса вида:

```http request
POST /api/users/registration
Content-Type: application/x-www-form-urlencoded

login=noname&pass=secret&name=NoName
```

В ответ вам придёт JSON вида:
```json
{
  "id": 7,
  "token": "j/cAPk6GZEm7Vmq..."
}
```

где `id` — идентификатор созданного пользователя, а `token` — это и есть токен.

Как отправлять формы формата `form-encoded` (`application/x-www-form-urlencoded`), смотрите в документации на Retrofit.

<details>
<summary>Если не нашли, как отправлять форму:</summary>

```kotlin
@FormUrlEncoded
@POST("users/registration")
suspend fun registerUser(@Field("login") login: String, @Field("pass") pass: String, @Field("name") name: String): Response<ваш_тип>
```

</details>

3\. Сохраните указанную пару в `AppAuth`.

4\. Вернитесь на предыдущий фрагмент, с которого вы попали на фрагмент регистрации.

Убедитесь, что меню в `ActionBar` и карточки постов, автором которых вы являетесь, обновились.

### Pro Level

Регистрироваться можно и с указанием аватарки. Для этого надо отправлять запрос вида:
```http request
POST /api/users/registration
Content-Type: multipart/form-data; boundary=WebAppBoundary

--WebAppBoundary
Content-Disposition: form-data; name="login"
Content-Type: text/plain

newbie
--WebAppBoundary
Content-Disposition: form-data; name="pass"
Content-Type: text/plain

password
--WebAppBoundary
Content-Disposition: form-data; name="name"
Content-Type: text/plain

Newbie
--WebAppBoundary
Content-Disposition: form-data; name="file"; filename="image.png"

< ./avatar.jpg
--WebAppBoundary--
```

Вот как в форму с картинкой добавить текстовые поля:

```kotlin
@Multipart
@POST("users/registration")
suspend fun registerWithPhoto(
    @Part("login") login: RequestBody,
    @Part("pass") pass: RequestBody,
    @Part("name") name: RequestBody,
    @Part media: MultipartBody.Part,
): Response<ваш_тип>
```

Создание `RequestBody`:
```kotlin
login.toRequestBody("text/plain".toMediaType())
```

Создание файла — как в предыдущих примерах.

### Результат

Опубликуйте изменения в виде Pull Request в вашем проекте на GitHub.

Результат пришлите ссылкой на PR GitHub-проект в личном кабинете студента на сайте [netology.ru](https://netology.ru).
