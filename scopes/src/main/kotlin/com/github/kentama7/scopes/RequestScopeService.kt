package com.github.kentama7.scopes

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.context.annotation.RequestScope
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy


@RequestScope
@Service
class RequestScopeService {

    companion object {
        private val logger = LoggerFactory.getLogger(RequestScopeService::class.java)
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