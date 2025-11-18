package uasz.alumni.ms_user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;

@SpringBootTest(properties = {"spring.config.import=", "spring.cloud.config.enabled=false"},
	excludeAutoConfiguration = {DataSourceAutoConfiguration.class, FlywayAutoConfiguration.class})
class MsUserApplicationTests {

	@Test
	void contextLoads() {
	}

}
