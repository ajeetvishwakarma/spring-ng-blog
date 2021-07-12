package com.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import com.blog.controller.PostController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringNgBlogApplicationTests {

	@Autowired
	private PostController controller;
	
	

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
}

