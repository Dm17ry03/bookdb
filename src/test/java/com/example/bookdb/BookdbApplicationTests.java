package com.example.bookdb;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookdbApplicationTests {

	@Container
	public static PostgreSQLContainer<?> postgresContainer =
			new PostgreSQLContainer<>("postgres:17");

	@DynamicPropertySource
	static void registerPgProperties(DynamicPropertyRegistry registry) {
		// Configure Spring Boot's datasource properties dynamically based on container's details
		registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
		registry.add("spring.datasource.username", postgresContainer::getUsername);
		registry.add("spring.datasource.password", postgresContainer::getPassword);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void testPostgresContainerIsRunning() {
		// Ensure the container is running
		assert(postgresContainer.isRunning());
	}

	@Test
	void selectTest() {
		jdbcTemplate.execute("select 1");
	}

	@Test
	void contextLoads() {
	}



}
