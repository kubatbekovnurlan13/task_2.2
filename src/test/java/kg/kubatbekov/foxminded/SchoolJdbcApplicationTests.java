package kg.kubatbekov.foxminded;

import kg.kubatbekov.foxminded.dao.CourseDAOImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class SchoolJdbcApplicationTests {

	@Autowired
	private CourseDAOImplementation courseDAOImplementation;

	@Container
	public static PostgreSQLContainer container =
			new PostgreSQLContainer("postgres:latest")
					.withDatabaseName("school_db")
					.withPassword("password")
					.withUsername("postgres");

	@DynamicPropertySource
	public static void properties(DynamicPropertyRegistry registry){
		registry.add("spring.datasource.url",container::getJdbcUrl);
		registry.add("spring.datasource.password",container::getPassword);
		registry.add("spring.datasource.username",container::getUsername);
	}


	@Test
	void contextLoads() {
		System.out.println("Hello world!");
	}

}
