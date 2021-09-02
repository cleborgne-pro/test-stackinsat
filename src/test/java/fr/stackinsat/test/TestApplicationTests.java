package fr.stackinsat.test;

import fr.stackinsat.test.controller.PersonneController;
import fr.stackinsat.test.service.PersonneService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	private PersonneController personneController;

	@Autowired
	private PersonneService personneService;

	@Test
	void contextLoads() {
		Assertions.assertThat(personneController).isNotNull();
		Assertions.assertThat(personneService).isNotNull();
	}

}
