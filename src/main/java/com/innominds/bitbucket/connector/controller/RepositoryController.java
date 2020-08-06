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
import com.innominds.bitbucket.connector.dto.RepositoryDefinition;
import com.innominds.bitbucket.connector.service.RepositoryService;
import lombok.extern.slf4j.Slf4j;

/**
 * RepositoryController is used to perform all the operation related repository
 * on the bitbucket server.
 * 
 * @author Dilip Kumar Tiwari
 *
 */
@Slf4j
@RestController
@RequestMapping("/repositories")
public class RepositoryController {

	/* Instance of RepositoryConnectorService. */
	@Autowired
	private RepositoryService repositoryConnectorService;

	/**
	 * create api is used to create repository.
	 * 
	 * @param payload
	 *        Request payload
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param repositorySlug
	 *        Id of the repository.
	 * @return
	 */
	@PostMapping("/create/{workspaceId}/{repositorySlug}")
	public ResponseEntity<Object> create(@RequestBody final RepositoryDefinition payload,
			@PathVariable final String workspaceId, @PathVariable final String repositorySlug) {
		log.info("RepositoryController->create(){}" + payload + " " + workspaceId + " " + repositorySlug);
		return ResponseEntity.ok(repositoryConnectorService.create(payload, workspaceId, repositorySlug));
	}

	/**
	 * get api is used to get repository details based on the repository slug.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param repositorySlug
	 *        Id of the repository.
	 * @return
	 */
	@GetMapping("/{workspaceId}/{repositorySlug}")
	public ResponseEntity<Object> get(@PathVariable final String workspaceId,
			@PathVariable final String repositorySlug) {
		log.info("RepositoryController->get(){}" + workspaceId + " " + repositorySlug);
		return ResponseEntity.ok(repositoryConnectorService.fetch(workspaceId, repositorySlug));
	}

	/**
	 *  update api is used to update the existing repository details.
	 *  
	 * @param payload
	 *        Request payload.
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param repositorySlug
	 *        Id of the repository.
	 * @return
	 */
	@PutMapping("/update/{workspaceId}/{repositorySlug}")
	public ResponseEntity<Object> update(@RequestBody final RepositoryDefinition payload,
			@PathVariable final String workspaceId, @PathVariable final String repositorySlug) {
		log.info("RepositoryController->update(){}" + payload + " " + workspaceId + " " + repositorySlug);
		return ResponseEntity.ok(repositoryConnectorService.update(payload, workspaceId, repositorySlug));
	}

	/**
	 * getAll api is used to get all the repository details.
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Object> getAll() {
		log.info("RepositoryController->getAll()");
		return ResponseEntity.ok(repositoryConnectorService.fetchAll());
	}

	/**
	 * destroy is used to destroy the repository from the bitbucket server.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param repositorySlug
	 *        Id of the repository.
	 * @return
	 */
	@DeleteMapping("/destroy/{workspaceId}/{repositorySlug}")
	public ResponseEntity<Object> destroy(@PathVariable final String workspaceId,
			@PathVariable final String repositorySlug) {
		log.info("RepositoryController->destroy(){}" + workspaceId + " " + repositorySlug);
		return ResponseEntity.ok(repositoryConnectorService.destroy(workspaceId, repositorySlug));
	}
}
