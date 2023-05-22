package dev.dashaun.function.redis.hash;

import com.redis.testcontainers.RedisStackContainer;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static com.redis.testcontainers.RedisStackContainer.DEFAULT_IMAGE_NAME;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.documentationConfiguration;

@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class HgetAllTest {

	@Container
	static final RedisStackContainer REDIS;

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.redis.host", REDIS::getHost);
		registry.add("spring.redis.port", REDIS::getFirstMappedPort);
	}

	static {
		REDIS = new RedisStackContainer(DEFAULT_IMAGE_NAME.withTag("edge"));
		REDIS.start();
	}

	@LocalServerPort
	private int port;

	private RequestSpecification spec;

	@BeforeEach
	void setUp(RestDocumentationContextProvider restDocumentation) {
		this.spec = new RequestSpecBuilder().addFilter(documentationConfiguration(restDocumentation)).build();

		RestAssured.port = port;
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@Test
	void test() {
		given(this.spec).contentType("application/json")
			.body("{\"k\":\"SpringIO2023\",\"f\":\"start\",\"v\":\"dotspringdotio\"}")
			.when()
			.port(this.port)
			.post("/hset")
			.then()
			.assertThat()
			.statusCode(is(200))
			.and()
			.body(equalTo("OK"));
		given(this.spec).contentType("text/plain")
			.body("SpringIO2023")
			.filter(document("hgetall"))
			.when()
			.port(this.port)
			.post("/hgetAll")
			.then()
			.assertThat()
			.statusCode(is(200))
			.and()
			.body(containsString("3.1.0"));
	}

}
