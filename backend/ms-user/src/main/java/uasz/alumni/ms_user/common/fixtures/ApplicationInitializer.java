package uasz.alumni.ms_user.common.fixtures;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitializer {

    private final RoleFixtures roleFixtures;

    @PostConstruct
    public void init() {
        log.info("Initialisation des données de l'application...");
        roleFixtures.init();
        log.info("Initialisation terminée.");
    }
}