package com.lucky.healthcheck

import org.springframework.boot.actuate.health.HealthEndpoint
import org.springframework.boot.actuate.health.Status
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomReadinessController(
    private val healthEndpoint: HealthEndpoint, // Access built-in readiness checks
) {

    @GetMapping("/custom-readiness")
    fun customReadiness(): ResponseEntity<Map<String, Any>> {
        // Fetch built-in readiness health
        val readinessHealth= healthEndpoint.healthForPath("readiness")

        // Extract status and details safely
        val readinessStatus: Status = readinessHealth?.status ?: Status.UNKNOWN

        // Add custom checks (e.g., custom database or Kafka checks)
        val customChecks = mapOf(
            "customCheck1" to "UP",
            "customCheck2" to "DOWN"
        )

        // Combine overall status
        val overallStatus = if (readinessStatus == Status.UP && !customChecks.containsValue("DOWN")) {
            "UP"
        } else {
            "DOWN"
        }

        // Build response
        val response = mapOf(
            "status" to overallStatus,
            "builtInReadiness" to readinessStatus,
            "customChecks" to customChecks
        )

        return ResponseEntity.ok(response)
    }
}
