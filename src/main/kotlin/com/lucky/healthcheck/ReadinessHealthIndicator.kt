package com.lucky.healthcheck

import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.stereotype.Component

@Component("readinessHealth")
class ReadinessHealthIndicator: HealthIndicator {
    override fun health(): Health {
        return Health.down().withDetails(mapOf("status" to "customized")).build()
    }
}