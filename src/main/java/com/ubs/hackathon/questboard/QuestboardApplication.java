package com.ubs.hackathon.questboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableWebSecurity
public class QuestboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestboardApplication.class, args);
	}

}
