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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.innominds.bitbucket.connector.dto.BranchDefinition;
import com.innominds.bitbucket.connector.service.BranchService;

import lombok.extern.slf4j.Slf4j;

/**
 * BranchController is used to perform the branch operation in bitbucket server.
 * 
 * @author Dilip Kumar Tiwari
 *
 */
@Slf4j
@RestController
@RequestMapping("/branches")
public class BranchController {

	@Autowired
	private BranchService branchConnectorService;

	/**
	 * create api is used to create the branch under the specific repository.
	 * 
	 * @param payload
	 *        Payload is request payload.
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param reposSlug
	 *        Id of the repository. 
	 * @return
	 */
	@PostMapping("/create/{workspaceId}/{reposSlug}")
	public ResponseEntity<Object> create(@RequestBody final BranchDefinition payload,
			@PathVariable final String workspaceId, @PathVariable final String reposSlug) {
		log.info("BranchController->create(){}" + payload + " " + workspaceId + " " + reposSlug);
		return ResponseEntity.ok(branchConnectorService.create(payload, workspaceId, reposSlug));
	}

	/**
	 * getAll api is used to get all the branches details.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param repositorySlug
	 *        Id of the repository.
	 * @return
	 */
	@GetMapping("/{workspaceId}/{repositorySlug}")
	public ResponseEntity<Object> getAll(@PathVariable final String workspaceId,
			@PathVariable final String repositorySlug) {
		log.info("BranchController->getAll(){}" + workspaceId + " " + repositorySlug);
		return ResponseEntity.ok(branchConnectorService.fetchAll(workspaceId, repositorySlug));
	}

	/**
	 * get api is used to get branch details based on the branch name. 
	 * 
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param repositorySlug
	 *        Id of the repository.
	 * @param branchName
	 *        Name of the branch.
	 * @return
	 */
	@GetMapping("/retrive/{workspaceId}/{reposslug}/{branchName}")
	public ResponseEntity<Object> get(@PathVariable final String workspaceId, @PathVariable final String reposslug,
			@PathVariable final String branchName) {
		log.info("BranchController->get(){}" + workspaceId + " " + reposslug + " " + branchName);
		return ResponseEntity.ok(branchConnectorService.fetch(workspaceId, reposslug, branchName));
	}

	/**
	 * destroy api is used to destroy the branch from the bitbucket sever.
	 * 
	 * @param workspaceId
	 *        Id of the workspace
	 * @param reposslug
	 *        Id of the repository.
	 * @param branchName
	 *        Name of the branch.
	 * @return
	 */
	@DeleteMapping("/destroy/{workspaceId}/{reposslug}/{branchName}")
	public ResponseEntity<Object> destroy(@PathVariable final String workspaceId, @PathVariable final String reposslug,
			@PathVariable final String branchName) {
		log.info("BranchController->destroy(){}" + workspaceId + " " + reposslug + " " + branchName);
		return ResponseEntity.ok(branchConnectorService.destroy(workspaceId, reposslug, branchName));
	}

	/**
	 * updateBranchModel api is used to update the model of the branch like specify branch in development and production. Define the branch type also.
	 * 
	 * @param branchModelDetails
	 *        It contains the branch model details.
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param reposslug
	 *        Id of the repository.
	 * @return
	 */
	@PutMapping("/branch-model/{workspaceId}/{reposslug}")
	public ResponseEntity<Object> updateBranchModel(@RequestBody final String branchModelDetails,
			@PathVariable final String workspaceId, @PathVariable final String reposslug) {
		log.info("BranchController->updateBranchModel(){}" + branchModelDetails + " " + workspaceId + " " + reposslug);
		return ResponseEntity.ok(branchConnectorService.createBranchModel(branchModelDetails, workspaceId, reposslug));
	}

	/**
	 * getBranchModel api is used to retrieve the branch modeling details.
	 * 
	 * @param workspaceId
	 *        Id of the workspace.       
	 * @param reposslug
	 *        Id of the repository.
	 * @return
	 */
	@GetMapping("/retriev-branch-model/{workspaceId}/{reposslug}")
	public ResponseEntity<Object> getBranchModel(@PathVariable final String workspaceId,
			@PathVariable final String reposslug) {
		log.info("BranchController->getBranchModel(){}" + workspaceId + " " + reposslug);
		return ResponseEntity.ok(branchConnectorService.fetchBranchModel(workspaceId, reposslug));
	}

	/**
	 * Api is used to create the restrict on branch.
	 * 
	 * @param restrictionDetails
	 *        It contains detail of the branch restriction.
	 * @param workspaceId
	 *        Id of the workspace.
	 * @param reposSlug
	 *        Id of the repository.
	 * @return
	 */
	@PostMapping("/create-branch-restriction/{workspaceId}/{reposSlug}")
	public ResponseEntity<Object> createBranchRestriction(@RequestBody final String restrictionDetails,
			@PathVariable final String workspaceId, @PathVariable final String reposSlug) {
		log.info("BranchController->createBranchRestriction(){}" + restrictionDetails + " " + workspaceId + " "
				+ reposSlug);
		return ResponseEntity
				.ok(branchConnectorService.createBranchRestriction(restrictionDetails, workspaceId, reposSlug));
	}

	/**
	 * 
	 * @param workspaceId
	 * @param reposSlug
	 * @param kind
	 * @param pattern
	 * @return
	 */
	@GetMapping("/branch-restrictions/{workspaceId}/{reposSlug}")
	public ResponseEntity<Object> getRestrictions(@PathVariable final String workspaceId,
			@PathVariable final String reposSlug, @RequestParam(value = "kind", required = false) final String kind,
			@RequestParam(value = "pattern", required = false) final String pattern) {
		log.info("BranchController->getRestrictions(){}" + workspaceId + " " + reposSlug + " " + kind + " " + pattern);
		return ResponseEntity.ok(branchConnectorService.fetchRestrictions(workspaceId, reposSlug, kind, pattern));
	}

	/**
	 * 
	 * @param workspaceId
	 * @param reposSlug
	 * @param id
	 * @return
	 */
	@GetMapping("/branch-restriction/{workspaceId}/{reposSlug}/{id}")
	public ResponseEntity<Object> getRestriction(@PathVariable final String workspaceId,
			@PathVariable final String reposSlug, @PathVariable final String id) {
		log.info("BranchController->getRestriction(){}" + workspaceId + " " + reposSlug + " " + id);
		return ResponseEntity.ok(branchConnectorService.fetchRestriction(workspaceId, reposSlug, id));
	}

	/**
	 * 
	 * @param workspaceId
	 * @param reposSlug
	 * @param id
	 * @return
	 */
	@DeleteMapping("/destroy-restriction/{workspaceId}/{reposSlug}/{id}")
	public ResponseEntity<Object> dstroyRestriction(@PathVariable final String workspaceId,
			@PathVariable final String reposSlug, @PathVariable final String id) {
		log.info("BranchController->destroyRestriction(){}" + workspaceId + " " + reposSlug + " " + id);
		return ResponseEntity.ok(branchConnectorService.destroyRestriction(workspaceId, reposSlug, id));
	}

	/**
	 * 
	 * @param workspaceId
	 * @param reposSlug
	 * @param id
	 * @return
	 */
	@PutMapping("/update-restriction/{workspaceId}/{reposSlug}/{id}")
	public ResponseEntity<Object> updateRestriction(@RequestBody final String restrictionConfig,
			@PathVariable final String workspaceId, @PathVariable final String reposSlug,
			@PathVariable final String id) {
		log.info("BranchController->updateRestriction(){}" + restrictionConfig + " " + workspaceId + " " + reposSlug
				+ " " + id);
		return ResponseEntity
				.ok(branchConnectorService.updateRestriction(restrictionConfig, workspaceId, reposSlug, id));
	}
}
