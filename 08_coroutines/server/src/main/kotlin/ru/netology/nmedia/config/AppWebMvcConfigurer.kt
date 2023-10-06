package ru.netology.nmedia.config

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CommonsRequestLoggingFilter
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class AppWebMvcConfigurer : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(object : HandlerInterceptor {
            override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
                if (
                    request.requestURI.startsWith("/api/slow") ||
                    request.requestURI.startsWith("/avatars") ||
                    request.requestURI.startsWith("/images")
                ) {
                    Thread.sleep(5_000)
                }
                return true
            }
        })
    }
}