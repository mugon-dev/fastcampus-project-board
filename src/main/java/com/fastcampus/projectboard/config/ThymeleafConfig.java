package com.fastcampus.projectboard.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

/**
 * thymeleaf decoupling 기능을 쓰기 위한 설정
 */
@Configuration
public class ThymeleafConfig {

    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver(
        SpringResourceTemplateResolver defaultTemplateResolver,
        Thymeleaf3Properties thymeleaf3Properties
    ) {
        defaultTemplateResolver.setUseDecoupledLogic(thymeleaf3Properties.isDecoupledLogic());
        return defaultTemplateResolver;
    }


    @RequiredArgsConstructor
    @Getter
    @ConstructorBinding
    // application.yml에 spring.thymeleaf3.decoupled-logic 옵션 추가
    @ConfigurationProperties("spring.thymeleaf3")
    public static class Thymeleaf3Properties {

        /**
         * Use Thymeleaf 3 Decoupled Logic
         */
        private final boolean decoupledLogic;

    }

}
