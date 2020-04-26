package com.github.kentama7.scopes

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.context.annotation.SessionScope
import java.time.LocalDateTime
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

@SessionScope
@Service
class SessionScopeService {

    companion object {
        private val logger = LoggerFactory.getLogger(SessionScopeService::class.java)
    }

    private var now: LocalDateTime? = null

    @PostConstruct
    fun init() {
        now = LocalDateTime.now()
    }

    @PreDestroy
    fun destroy() {
        logger.info("DESTROY!!!")
    }

    @Throws(InterruptedException::class)
    fun printNow() {
        logger.info(now.toString())
    }
}