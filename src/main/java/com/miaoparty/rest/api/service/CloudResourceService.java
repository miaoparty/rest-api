package com.miaoparty.rest.api.service;

import org.springframework.web.multipart.MultipartFile;

import com.miaoparty.rest.api.service.dto.CloudResourceResponse;

/**
 * @author Jason
 *
 */
public interface CloudResourceService {

	public CloudResourceResponse upload(MultipartFile file, String cloudResourceType, String toPath, boolean overwrite);
}
