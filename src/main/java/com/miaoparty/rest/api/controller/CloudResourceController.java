package com.miaoparty.rest.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.miaoparty.rest.api.service.CloudResourceService;
import com.miaoparty.rest.api.service.dto.CloudResourceResponse;

@RestController
@RequestMapping("/cloudResource")
public class CloudResourceController {
	@Autowired
	CloudResourceService service;

	/**
	 * @param file
	 * @param type
	 * @param toPath
	 *            the path to put file in cloud
	 * @param overwrite
	 *            overwrite resource if turn this flag to true and same resource
	 *            exist in cloud
	 * @return CloudResource
	 */
	@RequestMapping(value = "/upload/{cloudResourceType}/{toPath}", method = RequestMethod.POST)
	public CloudResourceResponse upload(@RequestParam("file") MultipartFile file, @RequestParam("cloudResourceType") String cloudResourceType, @RequestParam("toPath") String toPath,
			@RequestParam("overwrite") boolean overwrite) {
		return service.upload(file, cloudResourceType, toPath, overwrite);
	}
}
