package com.miaoparty.rest.api.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import com.miaoparty.rest.api.entity.CloudResource;

/**
 * @author Jason
 *
 */
@Path("/cloudResource")
@Produces("application/json")
public interface CloudResourceService {

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
	@POST
	@Path("/upload/{cloudResourceType}/{toPath}")
	@Consumes("multipart/form-data")
	public CloudResource upload(@Multipart(value = "file") Attachment attachment, @PathParam("cloudResourceType") String cloudResourceType, @PathParam("toPath") String toPath,
			@FormParam("overwrite") boolean overwrite);
}
