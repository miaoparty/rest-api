package com.miaoparty.rest.api.service.response;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.miaoparty.rest.api.entity.CloudResource;

@XmlRootElement()
@XmlType(name = "", propOrder = { "type", "resouces" })
public class CloudResouceResponse {
	String resourceId;
	String type;

	Set<CloudResource> resouces = new HashSet<CloudResource>();

}
