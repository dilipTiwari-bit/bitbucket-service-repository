/*
 * Copyright (c) 2020 Innominds Software Pvt Ltd.. All rights reserved.
 *
 * This file is part of AWS message broker.
 *
 * bitbucket-connector-service project and associated code cannot be copied
 * and/or distributed without a written permission of Innominds Software Pvt Ltd.,
 * and/or its subsidiaries.
 */
package com.innominds.bitbucket.connector.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * BranchDefinition contains the branch related data to communicate the
 * presentation layer to service layer.
 * 
 * @author Dilip Kumar Tiwari
 *
 */
@Data
@ToString
@NoArgsConstructor
public class BranchDefinition {
	/* Name of the branch. */
	private String name;

	/* Target is the parent branch for newly created branch. */
	private Target target;
}
