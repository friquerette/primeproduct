package com.friquerette.primems.core.client;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.friquerette.primems.controller.rest.poc.entity.User;

import junit.framework.TestCase;

public class ClientRestLocalTest extends TestCase {

	public static final String REST_SERVICE_URI = "http://localhost:8080/primems/rest/";

	@Test
	public void testGetUser() {
		System.out.println("Testing getUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(REST_SERVICE_URI + "/user/1", User.class);
		System.out.println(user);
	}

	@Test
	public void testCreateUser() {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(0, "Sarah", 51, 134);
		User user2 = restTemplate.postForObject(REST_SERVICE_URI + "/user/", user, User.class);
		System.out.println(user2.getAge());
	}

}