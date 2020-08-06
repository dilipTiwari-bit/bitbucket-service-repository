/*
 * Copyright (c) 2020 Innominds Software Pvt Ltd.. All rights reserved.
 *
 * This file is part of AWS message broker.
 *
 * bitbucket-connector-service project and associated code cannot be copied
 * and/or distributed without a written permission of Innominds Software Pvt Ltd.,
 * and/or its subsidiaries.
 */
package com.innominds.bitbucket.connector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innominds.bitbucket.connector.dto.ProjectDefinition;
import com.innominds.bitbucket.connector.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

/**
 * ProjectController is used to perform all the operation related to project on
 * bitbucket server.
 * 
 * @author Dilip Kumar Tiwari
 *
 */
@Slf4j
@RestController
@RequestMapping("/projects")
public class ProjectController {
	/* Instance of BitbucketConnectorService */
	@Autowired
	private ProjectService bitbucketConnectorService;

	/**
	 * Api is used to create the project under the workspace.
	 * 
	 * @param payload
	 *        Request payload.
	 * @param workspaceId
	 *        Id of the workspace.
	 * @return
	 */
	@PostMapping("/create/{workspaceId}")
	public ResponseEntity<Object> create(@RequestBody final ProjectDefinition payload,
			@PathVariable final String workspaceId) {
		log.info("ProjectController->create(){}" + payload + " " + workspaceId);
		return ResponseEntity.ok(bitbucketConnectorService.create(payload, workspaceId));
	}

	/**
	 * getAll api is used to get all the project details.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @return
	 */
	@GetMapping("/{workspaceId}")
	public ResponseEntity<Object> getAll(@PathVariable final String workspaceId) {
		log.info("ProjectController->get(){}" + workspaceId);
		return ResponseEntity.ok(bitbucketConnectorService.fetchAll(workspaceId));
	}

	/**
	 * update api is used to update the existing project details.
	 * 
	 * @param payload
	 *        Request payload.
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param projectKey
	 *        Key of the project.
	 * @return
	 */
	@PutMapping("/update/{workspaceId}/{projectKey}")
	public ResponseEntity<Object> update(@RequestBody final ProjectDefinition payload,
			@PathVariable final String workspaceId, @PathVariable final String projectKey) {
		log.info("ProjectController->update(){}" + payload + " " + workspaceId + " " + projectKey);
		return ResponseEntity.ok(bitbucketConnectorService.update(payload, workspaceId, projectKey));
	}

	/**
	 * get api is used to get the specific project based on the project key.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param projectKey
	 *        Key of the project.
	 * @return
	 */
	@GetMapping("/project/{workspaceId}/{projectKey}")
	public ResponseEntity<Object> get(@PathVariable final String workspaceId, @PathVariable final String projectKey) {
		log.info("ProjectController->get(){}" + workspaceId + " " + projectKey);
		return ResponseEntity.ok(bitbucketConnectorService.fetch(workspaceId, projectKey));
	}

	/**
	 * destroy is used to delete the specific project based the project key.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param projectKey
	 *        Key of the project.
	 * @return
	 */
	@DeleteMapping("/destroy/{workspaceId}/{projectKey}")
	public ResponseEntity<Object> destroy(@PathVariable final String workspaceId,
			@PathVariable final String projectKey) {
		log.info("ProjectController->destroy(){}" + workspaceId + " " + projectKey);
		return ResponseEntity.ok(bitbucketConnectorService.destroy(workspaceId, projectKey));
	}
}
