/*
 * Copyright (c) 2020 Innominds Software Pvt Ltd.. All rights reserved.
 *
 * This file is part of AWS message broker.
 *
 * bitbucket-connector-service project and associated code cannot be copied
 * and/or distributed without a written permission of Innominds Software Pvt Ltd.,
 * and/or its subsidiaries.
 */
package com.innominds.bitbucket.connector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.innominds.bitbucket.connector.credential.BitbucketConnectorCredential;
import com.innominds.bitbucket.connector.dto.ProjectDefinition;
import com.innominds.bitbucket.connector.util.HttpUtility;

import lombok.extern.slf4j.Slf4j;

/**
 * ProjectService contains the business logic to perform the operation on
 * bitbucket server.
 * 
 * @author Dilip Kumar Tiwari
 *
 */
@Slf4j
@Service
public class ProjectService {

	/* Instance of BitbucketConnectorCredential. */
	@Autowired
	private BitbucketConnectorCredential bitbucketConnectorCredential;

	/* Instance of RestTemplate. */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * create is used to create the project under workspace
	 * 
	 * @param payload
	 *        Payload of the request which contains the project details.
	 * @param workspaceId
	 *        Id of the workspace.
	 * @return
	 */
	public Object create(final ProjectDefinition payload, final String workspaceId) {
		log.info("ProjectService->create(){}" + payload + " " + workspaceId);
		String restUrl = "https://api.bitbucket.org/2.0/workspaces/" + workspaceId + "/projects";
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.POST,
				HttpUtility.getHttpEntity(payload, headers), Object.class);
		return response;
	}

	/**
	 * fetchAll is used to fetch all the project details from the workspace.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @return
	 */
	public Object fetchAll(final String workspaceId) {
		log.info("ProjectService->fetchAll" + workspaceId);
		String restUrl = "https://api.bitbucket.org/2.0/workspaces/" + workspaceId + "/projects";
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.GET,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}

	/**
	 * update is used to update the project details in the workspace.
	 * 
	 * @param payload
	 *        Payload contains the details of the project which will update on the existing project.       
	 * @param workspaceId
	 *        Id of the project.
	 * @param projectKey
	 *        Key of the project.
	 * @return
	 */
	public Object update(final ProjectDefinition payload, final String workspaceId, final String projectKey) {
		log.info("ProjectService->update(){}" + payload + " " + workspaceId);
		String restUrl = "https://api.bitbucket.org/2.0/workspaces/" + workspaceId + "/projects/" + projectKey;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.PUT,
				HttpUtility.getHttpEntity(payload, headers), Object.class);
		return response;
	}

	/**
	 * fetch is used to fetch the specific project details based on the projectKey and workspaceId.
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param projectKey
	 *        Key of the project.
	 * @return
	 */
	public Object fetch(final String workspaceId, final String projectKey) {
		log.info("ProjectService->fetch(){}" + workspaceId + " " + projectKey);
		String restUrl = "https://api.bitbucket.org/2.0/workspaces/" + workspaceId + "/projects/" + projectKey;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.GET,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}

	/**
	 * destroy is used to delete the project from the workspace based on the workspaceId and projectKey.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param projectKey
	 *        Key of the project.
	 * @return
	 */
	public Object destroy(final String workspaceId, final String projectKey) {
		log.info("ProjectService->destroy(){}" + workspaceId + " " + projectKey);
		String restUrl = "https://api.bitbucket.org/2.0/workspaces/" + workspaceId + "/projects/" + projectKey;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.DELETE,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}
}
