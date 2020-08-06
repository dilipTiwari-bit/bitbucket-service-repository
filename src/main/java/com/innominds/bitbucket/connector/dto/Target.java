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
 * Target is used to contains the parent branch details.
 * 
 * @author Dilip Kumar Tiwari
 *
 */
@Data
@ToString
@NoArgsConstructor
public class Target {
	/* Hash contains the hash value of the specific branch. */
	private String hash;

}
