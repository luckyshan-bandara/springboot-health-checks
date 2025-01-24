package com.lucky.healthcheck

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean


@SpringBootApplication
class HealthcheckApplication

fun main(args: Array<String>) {
	runApplication<HealthcheckApplication>(*args)
}