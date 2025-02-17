package com.lucky.healthcheck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class HealthcheckApplication

fun main(args: Array<String>) {
	runApplication<HealthcheckApplication>(*args)
}