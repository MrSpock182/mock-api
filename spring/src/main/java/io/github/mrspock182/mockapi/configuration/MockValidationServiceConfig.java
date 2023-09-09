package io.github.mrspock182.mockapi.configuration;

import io.github.mrspock182.mockapi.repository.RegisterMockRepository;
import io.github.mrspock182.mockapi.service.MockValidationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockValidationServiceConfig {

    @Bean
    public MockValidationService mockValidationService(final RegisterMockRepository repository) {
        return new MockValidationService(repository);
    }

}
