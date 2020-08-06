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
import com.innominds.bitbucket.connector.dto.BranchDefinition;
import com.innominds.bitbucket.connector.util.HttpUtility;
import lombok.extern.slf4j.Slf4j;

/**
 * BranchService is used to contains the business to perform the operation
 * bitbucket server.
 * 
 * @author Dilip Kumar Tiwari
 *
 */
@Slf4j
@Service
public class BranchService {

	/* Instance of BitbucketConnectorCredential. */
	@Autowired
	private BitbucketConnectorCredential bitbucketConnectorCredential;

	/* Instance of restTemplate. */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * create method is used to create branch on the specific repository.
	 * 
	 * @param payload
	 *        payload contains branch details.       
	 * @param workspaceId
	 *        workspaceId is the id of particular workspace..
	 * @param repositorySlug
	 *        repositorySlug is the id of the particual repository.
	 * @return Object
	 *    
	 */
	public Object create(final BranchDefinition payload, final String workspaceId, final String repositorySlug) {
		log.info("BranchService->create(){}" + payload + " " + workspaceId + " " + repositorySlug);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + repositorySlug
				+ "/refs/branches";
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.POST,
				HttpUtility.getHttpEntity(payload, headers), Object.class);
		return response;
	}

	/**
	 * fetchAll method is used to get all the branch details.
	 * 
	 * @param workspaceId
	 *        Id of the workspace
	 * @param repositorySlug
	 *        Id of the particular repository.
	 * @return Object
	 */
	public Object fetchAll(final String workspaceId, final String repositorySlug) {
		log.info("BranchService->fetchAll(){}" + workspaceId + " " + repositorySlug);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + repositorySlug
				+ "/refs/branches";
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.GET,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}

	/**
	 * fetch method is used to fetch the details of the branch based on the branchName.
	 * 
	 * @param workaspaceId
	 *        Id of the workspace.
	 * @param reposSlug
	 *        Id of the particular repository.
	 * @param branchName
	 *        Name of the branch.
	 * @return Object
	 */
	public Object fetch(final String workspaceId, final String reposSlug, final String branchName) {
		log.info("BranchService->fetchAll(){}" + workspaceId + " " + reposSlug + " " + branchName);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + reposSlug
				+ "/refs/branches/" + branchName;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.GET,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}

	/**
	 * destroy method is used to destroy the specific branch based on the branch name.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param reposslug
	 *        Id of the repository.
	 * @param branchName
	 *        Name of the branch.
	 * @return
	 */
	public Object destroy(final String workspaceId, final String reposslug, final String branchName) {
		log.info("BranchService->destroy(){}" + workspaceId + " " + reposslug + " " + branchName);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + reposslug
				+ "/refs/branches/" + branchName;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.DELETE,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}

	/**
	 * createBranchModel is used to create the model for the branch in repository.
	 * @param branchModelDetails
	 *        Branch model details.
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param reposSlug
	 *        Id of the repository.
	 * @return
	 */
	public Object createBranchModel(final String branchModelDetails, final String workspaceId, final String reposSlug) {
		log.info("BranchService->createBranchModel(){}" + branchModelDetails + " " + workspaceId + " " + reposSlug);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + reposSlug
				+ "/branching-model/settings";
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		log.info(restUrl);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.PUT,
				HttpUtility.getHttpEntity(branchModelDetails, headers), Object.class);
		return response;
	}

	/**
	 * fetchBranchModel is used to fetch the details of the branch model.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param reposSlug
	 *        Id of the repository.
	 * @return
	 */
	public Object fetchBranchModel(final String workspaceId, final String reposSlug) {
		log.info("BranchService->fetchBranchModel(){}" + workspaceId + " " + reposSlug);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + reposSlug
				+ "/branching-model/settings";
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.GET,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}

	/**
	 * createBranchRestriction is used to create the restriction on the branch.
	 * 
	 * @param restrictionDetails
	 *        Details of the branch restriction.
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param reposSlug
	 *        Id of the repository.
	 * @return
	 */
	public Object createBranchRestriction(final String restrictionDetails, final String workspaceId,
			final String reposSlug) {
		log.info("BranchService->createBranchRestriction(){}" + restrictionDetails + " " + workspaceId + " "
				+ reposSlug);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + reposSlug
				+ "/branch-restrictions";
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.POST,
				HttpUtility.getHttpEntity(restrictionDetails, headers), Object.class);
		return response;
	}

	/**
	 * fetchRestrictions is used to fetch the restrictions of the branch.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param reposSlug
	 *        Id of the repository.
	 * @param kind
	 *        kind is the allowed restriction like push,delete.
	 * @param pattern
	 *        Pattern is use for the branch.
	 * @return
	 */
	public Object fetchRestrictions(final String workspaceId, final String reposSlug, final String kind,
			final String pattern) {
		log.info("BranchService->fetchRestrictions(){}" + workspaceId + " " + reposSlug + " " + kind + " " + pattern);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + reposSlug
				+ "/branch-restrictions?kind=" + kind + "&&pattern=" + pattern;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.GET,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}

	/**
	 * 
	 * @param workspace
	 * @param reposSlug
	 * @param id
	 * @return
	 */
	public Object fetchRestriction(final String workspaceId, final String reposSlug, final String id) {
		log.info("BranchService->fetchRestriction(){}" + workspaceId + " " + reposSlug + " " + id);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + reposSlug
				+ "/branch-restrictions/" + id;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.GET,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}

	/**
	 * 
	 * @param workspaceId
	 * @param reposSlug
	 * @param id
	 * @return
	 */
	public Object destroyRestriction(final String workspaceId, final String reposSlug, final String id) {
		log.info("BranchService->destroyRestriction(){}" + workspaceId + " " + reposSlug + " " + id);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + reposSlug
				+ "/branch-restrictions/" + id;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.DELETE,
				HttpUtility.getHttpEntity(headers), Object.class);
		return response;
	}

	/**
	 * 
	 * @param workspaceId
	 * @param reposSlug
	 * @param id
	 * @return
	 */
	public Object updateRestriction(final String restrictionDetails, final String workspaceId, final String reposSlug,
			final String id) {
		log.info("BranchService->updateRestriction(){}" + workspaceId + " " + reposSlug + " " + id);
		String restUrl = "https://api.bitbucket.org/2.0/repositories/" + workspaceId + "/" + reposSlug
				+ "/branch-restrictions/" + id;
		HttpHeaders headers = HttpUtility.getHttpHeader();
		headers.add("Authorization", "Bearer " + bitbucketConnectorCredential.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Object> response = restTemplate.exchange(restUrl, HttpMethod.PUT,
				HttpUtility.getHttpEntity(restrictionDetails, headers), Object.class);
		return response;
	}
}
