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
 * RepositoryDefinition contains the details of the repository to communicate
 * the presentation layer to service.
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
public class RepositoryDefinition {
	/* name of the repository. */
	private String name;

	/* is_private for the repository. */
	private boolean is_private;

	/* readme file details. */
	private String readme_type;

	/* scm of the repository. */
	private String scm;

	/* description of the repository. */
	private String description;

	/* forking details of the repository. */
	private String forking;

	/* no_forks of the repository. */
	private boolean no_forks;

	/* no_public_forks of the repository. */
	private boolean no_public_forks;

	/* language of the repository. */
	private String language;

	/*
	 * public String getProject() { return project; }
	 * 
	 * public void setProject(String project) { this.project = project; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIs_private() {
		return is_private;
	}

	public void setIs_private(boolean is_private) {
		this.is_private = is_private;
	}

	public String getReadme_type() {
		return readme_type;
	}

	public void setReadme_type(String readme_type) {
		this.readme_type = readme_type;
	}

	public String getScm() {
		return scm;
	}

	public void setScm(String scm) {
		this.scm = scm;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getForking() {
		return forking;
	}

	public void setForking(String forking) {
		this.forking = forking;
	}

	public boolean isNo_forks() {
		return no_forks;
	}

	public void setNo_forks(boolean no_forks) {
		this.no_forks = no_forks;
	}

	public boolean isNo_public_forks() {
		return no_public_forks;
	}

	public void setNo_public_forks(boolean no_public_forks) {
		this.no_public_forks = no_public_forks;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "RepositoryDefinition [name=" + name + ", is_private=" + is_private + ", readme_type=" + readme_type
				+ ", scm=" + scm + ", description=" + description + ", forking=" + forking + ", no_forks=" + no_forks
				+ ", no_public_forks=" + no_public_forks + ", language=" + language + "]";
	}

}
