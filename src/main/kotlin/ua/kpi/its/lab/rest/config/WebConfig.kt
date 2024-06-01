package ua.kpi.its.lab.rest.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.function.router
import ua.kpi.its.lab.rest.handler.MobilePhoneHandler
import ua.kpi.its.lab.rest.handler.FileHandler

@Configuration
@EnableWebMvc
class WebConfig {

    @Bean
    fun functionalRoutes(
        phoneHandler: MobilePhoneHandler,
        fileHandler: FileHandler
    ) = router {
        "/fn".nest {
            "/phones".nest {
                POST("", phoneHandler::createPhoneHandler)
                GET("/{id}", phoneHandler::getPhoneByIdHandler)
                PUT("/{id}", phoneHandler::updatePhoneHandler)
                DELETE("/{id}", phoneHandler::deletePhoneHandler)
                GET("", phoneHandler::getAllPhonesHandler)
            }
            "/files".nest {
                POST("", fileHandler::createFileHandler)
                GET("/{id}", fileHandler::getFileByIdHandler)
                PUT("/{id}", fileHandler::updateFileHandler)
                DELETE("/{id}", fileHandler::deleteFileHandler)
                GET("", fileHandler::getAllFilesHandler)
            }
        }
    }
}
