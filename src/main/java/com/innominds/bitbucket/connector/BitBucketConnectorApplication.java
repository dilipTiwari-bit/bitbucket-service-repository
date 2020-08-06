/*
 * Copyright (c) 2020 Innominds Software Pvt Ltd.. All rights reserved.
 *
 * This file is part of AWS message broker.
 *
 * bitbucket-connector-service project and associated code cannot be copied
 * and/or distributed without a written permission of Innominds Software Pvt Ltd.,
 * and/or its subsidiaries.
 */
package com.innominds.bitbucket.connector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * BitBucketConnectorApplication main application class.
 * 
 * @author Dilip Kumar Tiwari
 *
 */
@SpringBootApplication
public class BitBucketConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitBucketConnectorApplication.class, args);
	}

	/* RestTemplate bean definition. */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
