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
import com.innominds.bitbucket.connector.dto.RepositoryDefinition;
import com.innominds.bitbucket.connector.util.HttpUtility;

import lombok.extern.slf4j.Slf4j;

/**
 * RepositoryService contains business logic to perform the operation related to
 * repository on bitbucket server.
 * 
 * @author Dilip Kumar Tiwari
 *
 */
@Slf4j
@Service
public class RepositoryService {

	/* Instance of BitbucketConnectorCredential. */
	@Autowired
	private BitbucketConnectorCredential bitbucketConnectorCredential;

	/* Instance of RestTemplate. */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * create is used to create the repository under the workspace and project also.
	 * 
	 * @param payload        
	 *        Payload contains the details of the repository creation.
	 * @param workspaceId    Id of the workspace.
	 * @param repositorySlug Id of the repository.
	 * @return
	 */
	public Object create(final RepositoryDefinition payload, final String workspaceId, final String repositorySlug) {
		log.info("RepositoryService->create(){}" + payload + " " + workspaceId + " " + repositorySlug);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + repositorySlug;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.POST,
				HttpUtility.getHttpEntity(payload, headers), Object.class);
		return response;
	}

	/**
	 * fetch is used to fetch the details of the repository based on the workspaceId
	 * and repositorySlug.
	 * 
	 * @param workspaceId    Id of the workspace.
	 * @param repositorySlug Id of the repository.
	 * @return
	 */
	public Object fetch(final String workspaceId, final String repositorySlug) {
		log.info("RepositoryService->fetch(){}" + workspaceId + " " + repositorySlug);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + repositorySlug;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.GET,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}

	/**
	 * update is used to update the repository details of the existing repository.
	 * 
	 * @param payload
	 *        Payload contains the details of the repository which will update the existing repository details.
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param repositorySlug
	 *        Id of the repository.
	 * @return
	 */
	public Object update(final RepositoryDefinition payload, final String workspaceId, final String repositorySlug) {
		log.info("RepositoryService->update(){}" + payload + " " + workspaceId + " " + repositorySlug);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + repositorySlug;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.PUT,
				HttpUtility.getHttpEntity(payload, headers), Object.class);
		return response;
	}

	/**
	 * fetchAll is used to fetch all the repositories details.
	 * 
	 * @return
	 */
	public Object fetchAll() {
		log.info("RepositoryService->fetchAll()");
		String restUrl = "https://api.bitbucket.org/2.0/repositories";
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.GET,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}

	/**
	 * destroy is used to delete the repository based on repositorySlug.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param repositorySlug
	 *        Id of the repository.
	 * @return
	 */
	public Object destroy(final String workspaceId, final String repositorySlug) {
		log.info("RepositoryService->destroy(){}" + workspaceId + " " + repositorySlug);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + repositorySlug;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.DELETE,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}
}
