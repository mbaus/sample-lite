package de.dacomb.sample.technical.infrastructure.primary.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.dacomb.sample.common.domain.Generated;

@Configuration
@AutoConfigureBefore(SpringdocConfiguration.class)
@Generated(reason = "Not called by integration tests")
class SpringdocJWTConfiguration {

  @Bean
  GlobalOpenApiCustomizer jwtOpenApi() {
    return openApi -> openApi.components(jwtComponents(openApi.getComponents()));
  }

  private Components jwtComponents(Components existingComponents) {
    return existingComponents.addSecuritySchemes(
      "bearer-jwt",
      new SecurityScheme()
        .type(SecurityScheme.Type.HTTP)
        .scheme("Bearer")
        .bearerFormat("JWT")
        .in(SecurityScheme.In.HEADER)
        .name("bearerAuth")
    );
  }
}
