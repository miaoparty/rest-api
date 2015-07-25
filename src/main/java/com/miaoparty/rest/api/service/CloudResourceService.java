package com.miaoparty.rest.api.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Jason
 *
 */

public interface CloudResourceService {
	@POST
	@Path("/upload/{cloudResourceType}/{toPath}")
	public Response upload(MultipartFile file, String cloudResourceType, String toPath, boolean overwrite);
}
