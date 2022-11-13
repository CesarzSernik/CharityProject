package pl.coderslab.charity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
@EntityScan(basePackages = "pl.coderslab.charity.entities")
@EnableJpaRepositories(basePackages = "pl.coderslab.charity.repositories")
public class AppConfig implements WebMvcConfigurer {
}
