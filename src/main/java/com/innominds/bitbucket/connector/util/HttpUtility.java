/*
 * Copyright (c) 2020 Innominds Software Pvt Ltd.. All rights reserved.
 *
 * This file is part of AWS message broker.
 *
 * bitbucket-connector-service project and associated code cannot be copied
 * and/or distributed without a written permission of Innominds Software Pvt Ltd.,
 * and/or its subsidiaries.
 */
package com.innominds.bitbucket.connector.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

/**
 * 
 * @author Dilip Kumar Tiwari
 *
 */
public class HttpUtility {

	public static HttpHeaders getHttpHeader() {
		return new HttpHeaders();
	}

	public static HttpEntity<Object> getHttpEntity(HttpHeaders headers) {
		return new HttpEntity<Object>(headers);
	}

	public static HttpEntity<Object> getHttpEntity(Object obj, HttpHeaders headers) {
		return new HttpEntity<Object>(obj, headers);
	}

}
