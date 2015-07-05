package com.miaoparty.rest.api.entity;

import org.apache.commons.lang3.RandomStringUtils;


public enum CloudResourceType {
	STATIC("static"), ENCRYPTED("encrypted");

	private final String path;

	CloudResourceType(String path) {
		if ("encrypted".equals(path)) {
			this.path = path + "/" + RandomStringUtils.randomAlphanumeric(16);
		} else {
			this.path = path;
		}
	}

	public String path() {
		return path;
	}
}
