# Домашнее задание к занятию «4.2 Регистрация, аутентификация и авторизация»

В качестве результата пришлите ссылки на ваш GitHub-проект в личном кабинете студента на сайте [netology.ru](https://netology.ru).

**Важно**: ознакомьтесь со ссылками, представленными на главной странице [репозитория с домашними заданиями](../README.md).

**Важно**: если у вас что-то не получилось, то оформляйте Issue [по установленным правилам](../report-requirements.md).

## Как сдавать задачи

1. Откройте ваш проект Android приложения с предыдущего ДЗ (можете брать код с лекции).
1. Сделайте необходимые коммиты.
1. Сделайте пуш (удостоверьтесь, что ваш код появился на GitHub).
1. Ссылку на ваш проект отправьте в личном кабинете на сайте [netology.ru](https://netology.ru).
1. Задачи, отмеченные, как необязательные, можно не сдавать, это не повлияет на получение зачета (в этом ДЗ все задачи являются обязательными).

## Задача Аутентификация

### Описание

Реализуйте при нажатии на пункт меню "Sign in" следующую последовательность действий:

1\. Открытие фрагмента с двумя полями (логин и пароль) и кнопкой Войти (создайте для этого фрагмента собственную `ViewModel`)

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

Где `id` - идентификатор пользователя с логином `student` и паролем `secret`, а `token` - это и есть токен.

Как отправлять формы формата `form-encoded` (`application/x-www-form-urlencoded`) смотрите в [документации на Retrofit](https://square.github.io/retrofit/).

<details>
<summary>Если не нашли, как отправлять форму</summary>

```kotlin
@FormUrlEncoded
@POST("users/authentication")
suspend fun updateUser(@Field("login") login: String, @Field("pass") pass: String): Response<ваш_тип>
```

</details>

3\. Сохраните указанную пару в `AppAuth`

4\. Вернитесь на предыдущий фрагмент (с которого вы попали на фрагмент аутентификации)

Убедитесь, что после того, как вы вернулись на предыдущий фрагмент, меню в `ActionBar`'е и карточки постов, авторами которых вы являетесь, обновились.

### Результат

Опубликуйте изменения в виде Pull Request'а в вашем проекте на GitHub.

В качестве результата пришлите: ссылку на PR GitHub-проект в личном кабинете студента на сайте [netology.ru](https://netology.ru)

## Задача `Sign In to ...` и `Are you sure?`*

**Важно**: это необязательная задача. Её (не)выполнение не влияет на получение зачёта по ДЗ.

### Описание

Реализуйте следующую функциональность:
1\. При нахождении на экране ленты постов в `PostViewModel` проверку на то, аутентифицирован ли пользователь при выполнении следующих действий:
   1. Добавление поста (нажатие на `Fab` +)
   1. Лайк поста
      
Если пользователь не аутентифицирован, выводите диалоговое окно с предложением пройти аутентификацию (перенаправляйте пользователя на фрагмент аутентификации, который вы реализовали в предыдущем пункте).

2\. При нахождении на экране создания поста вывод диалогового окна с подтверждением выхода, если пользователь в `ActionBar`'е выбрал пункт меню `Sign Out`.

Если пользователь подтвердил выход, перенаправляйте на предыдущий фрагмент.

### Результат

Опубликуйте изменения в виде Pull Request'а в вашем проекте на GitHub.

В качестве результата пришлите: ссылку на PR GitHub-проект в личном кабинете студента на сайте [netology.ru](https://netology.ru)

## Задача Регистрация*

**Важно**: это необязательная задача. Её (не)выполнение не влияет на получение зачёта по ДЗ.

### Описание

Реализуйте при нажатии на пункт меню "Sign Up" следующую последовательность действий:

1\. Открытие фрагмента с тремя полями (логин, пароль и подтверждение пароля) и кнопкой Зарегистрироваться (создайте для этого фрагмента собственную `ViewModel`)

2\. Отправку запроса вида:

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

Где `id` - идентификатор созданного пользователя, а `token` - это и есть токен.

Как отправлять формы формата `form-encoded` (`application/x-www-form-urlencoded`) смотрите в документации на Retrofit.

<details>
<summary>Если не нашли, как отправлять форму</summary>

```kotlin
@FormUrlEncoded
@POST("users/authentication")
suspend fun updateUser(@Field("login") login: String, @Field("pass") pass: String): Response<ваш_тип>
```

</details>

3\. Сохраните указанную пару в `AppAuth`

4\. Вернитесь на предыдущий фрагмент (с которого вы попали на фрагмент регистрации)

Убедитесь, что после того, как вы вернулись на предыдущий фрагмент, меню в `ActionBar`'е и карточки постов, авторами которых вы являетесь, обновились.

### Pro Level

Регистрироваться можно и с указанием аватарки, для этого надо отправлять запрос вида:
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

**Q**: Как в форму с картинкой добавить текстовые поля?

**A**: Пример:

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

Создание файла - как в предыдущих примерах.

### Результат

Опубликуйте изменения в виде Pull Request'а в вашем проекте на GitHub.

В качестве результата пришлите: ссылку на PR GitHub-проект в личном кабинете студента на сайте [netology.ru](https://netology.ru)
