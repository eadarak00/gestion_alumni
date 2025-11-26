package uasz.alumni.ms_cv;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication(
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
    basePackages = {"org.openapitools", "uasz.alumni.ms_cv.controllers" , "org.openapitools.configuration", "uasz.alumni.ms_cv"},
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@EnableDiscoveryClient
public class MsCvApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCvApplication.class, args);
    }

    @Bean(name = "uasz.alumni.ms_cv.MsCvApplication.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }
}