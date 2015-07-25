package com.miaoparty.rest.api.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.miaoparty.rest.api.entity.CloudResource;
import com.miaoparty.rest.api.entity.CloudResourceType;
import com.miaoparty.rest.api.service.CloudResourceService;
import com.miaoparty.rest.api.service.dto.CloudResourceResponse;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

@Service("cloudResourceService")
public class QiniuCloudResourceServiceImpl implements CloudResourceService {
	// static final Logger logger =
	// LoggerFactory.getLogger(QiniuResourceServiceImpl.class);

	private String domain = "http://7xjvvh.com1.z0.glb.clouddn.com";
	private Auth auth = Auth.create("qRFdNgayztqHDKo8A6wqYMMqLMX3ejrXCT0482-2", "fxfi0Vi9Fz8-GXI7pvTBSaZYDtrmaWtDC1q2RTnN");
	private String bucket = "miaoparty";
	private UploadManager uploadManager = new UploadManager();

	// public static void main(String[] args) {
	// CloudResource resource = new QiniuCloudResourceServiceImpl().upload(new
	// File("/Users/Jason/Desktop/abc.png"), CloudResourceType.STATIC, "123",
	// true);
	// System.out.println(resource.getFileExt());
	// System.out.println(resource.getName());
	// System.out.println(resource.getUrl());
	// }

	@Override
	public Response upload(MultipartFile file, String cloudResourceType, String toPath, boolean overwrite) {
		CloudResourceResponse response = null;
		CloudResourceType type = null;
		cloudResourceType = cloudResourceType == null ? "" : cloudResourceType.toUpperCase();
		for (CloudResourceType value : CloudResourceType.values()) {
			if (value.toString().equals(cloudResourceType)) {
				type = value;
				break;
			} else {

				// throw unknown resource type exception
			}
		}

		File tmpFile = new File(File.listRoots()[0] + "miaoparty/temp/" + RandomStringUtils.randomAlphanumeric(16) + "/" + file.getName());
		try {
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(tmpFile));
			stream.write(bytes);
			stream.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		CloudResource resource = new CloudResource();
		String categoryPath = type.path();
		toPath = toPath == null ? "" : toPath;
		toPath = toPath.startsWith("/") ? toPath.substring(1, toPath.length() - 1) : toPath;
		toPath = toPath.endsWith("/") ? toPath : (toPath + "/");
		String key = categoryPath + "/" + toPath + tmpFile.getName();

		com.qiniu.http.Response resp = null;
		try {
			if (overwrite) {
				resp = uploadManager.put(tmpFile, key, getUpToken(key));
			} else {
				resp = uploadManager.put(tmpFile, key, getUpToken());
			}
			if (resp.isOK()) {
				resource.setFileExt(getFileExtension(tmpFile));
				resource.setName(tmpFile.getName());
				resource.setUrl(domain + "/" + key);

				response = new CloudResourceResponse();
				// response.setId(id);
				response.setName(tmpFile.getName());
				resource.setUrl(domain + "/" + key);
			}
		} catch (QiniuException e) {
			e.printStackTrace();
		}
		return Response.ok(response).build();
	}

	private String getUpToken() {
		return auth.uploadToken(bucket);
	}

	private String getUpToken(String key) {
		return auth.uploadToken(bucket, key);
	}

	private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		} else {
			return "";
		}
	}
}
