package br.com.confidence.dojo.properties;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

@SpringBootTest
class PropertiesApplicationTests {

	@Test
	void contextLoads() {
		List<String> collection = Lists.newArrayList("ab", "cd", "ef");
		assertThat(collection, contains("ab", "cd", "ef"));
	}


}
