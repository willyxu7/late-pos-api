package com.lateras.latepos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig{

    @Bean
    public AuditorAware<String> auditorProvider() {
        //nanti harus di ganti dengan user yg login kalau punya authentikasi
        return () -> Optional.ofNullable("Test User");
    }

}
