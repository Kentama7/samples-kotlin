package com.github.kentama7.scopes

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ScopeController(
    private val requestScopeService: RequestScopeService,
    private val sessionScopeService: SessionScopeService
) {

    @GetMapping
    fun index(): ResponseEntity<String> {
        requestScopeService.printNow()
        sessionScopeService.printNow()
        return ResponseEntity.ok("OK")
    }
}