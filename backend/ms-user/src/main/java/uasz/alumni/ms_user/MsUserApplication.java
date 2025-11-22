package uasz.alumni.ms_user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uasz.alumni.ms_user.common.fixtures.ApplicationInitializer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing
@RequiredArgsConstructor
@Slf4j
public class MsUserApplication implements CommandLineRunner {
    private final ApplicationInitializer appInit;

    public static void main(String[] args) {
        SpringApplication.run(MsUserApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Démarrage de l'application...");
        appInit.init();
    }

}
