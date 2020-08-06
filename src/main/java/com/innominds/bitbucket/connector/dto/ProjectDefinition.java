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

/**
 * ProjectDefinition is used to contains the project related data to communicate
 * presentation layer to service layer.
 * 
 * @author Dilip Kumar Tiwari
 *
 */
/*
 * @Data
 * 
 * @ToString
 * 
 * @NoArgsConstructor
 */
public class ProjectDefinition {
	/* name of the project. */
	private String name;

	/* key of the project. */
	private String key;

	/* description of the project. */
	private String description;

	/* is_private of the project. */
	private boolean is_private;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isIs_private() {
		return is_private;
	}

	public void setIs_private(boolean is_private) {
		this.is_private = is_private;
	}

	@Override
	public String toString() {
		return "ProjectDefinition [name=" + name + ", key=" + key + ", description=" + description + ", is_private="
				+ is_private + "]";
	}

}
