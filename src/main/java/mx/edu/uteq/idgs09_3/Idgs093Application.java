package mx.edu.uteq.idgs09_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableFeignClients
@SpringBootApplication
public class Idgs093Application {

	public static void main(String[] args) {
		SpringApplication.run(Idgs093Application.class, args);
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:5173/")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                        .allowedHeaders("*") // Permite todos los encabezados
                        .allowCredentials(true) // Permite el envío de cookies y credenciales
                        .maxAge(3600); // Tiempo en caché de la configuración CORS
            }
        };
    }

}
