package com.miaoparty.rest.api.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.stereotype.Service;

import com.miaoparty.rest.api.entity.CloudResource;
import com.miaoparty.rest.api.entity.CloudResourceType;
import com.miaoparty.rest.api.service.CloudResourceService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

@Service("cloudResourceService")
public class QiniuCloudResourceServiceImpl implements CloudResourceService {
	// static final Logger logger =
	// LoggerFactory.getLogger(QiniuResourceServiceImpl.class);

	private String domain = "http://7xjvvh.com1.z0.glb.clouddn.com";
	private Auth auth = Auth.create("qRFdNgayztqHDKo8A6wqYMMqLMX3ejrXCT0482-2", "fxfi0Vi9Fz8-GXI7pvTBSaZYDtrmaWtDC1q2RTnN");
	private String bucket = "pethub";
	private UploadManager uploadManager = new UploadManager();

//	public static void main(String[] args) {
//		CloudResource resource = new QiniuCloudResourceServiceImpl().upload(new File("/Users/Jason/Desktop/abc.png"), CloudResourceType.STATIC, "123", true);
//		System.out.println(resource.getFileExt());
//		System.out.println(resource.getName());
//		System.out.println(resource.getUrl());
//	}

	@Override
	public CloudResource upload(Attachment attachment, String cloudResourceType, String toPath, boolean overwrite) {
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

		DataHandler dh = attachment.getDataHandler();
		File file = null;
		try {
			InputStream ins = dh.getInputStream();
			file = writeToFile(ins, File.listRoots()[0] + "pethub/temp/" + RandomStringUtils.randomAlphanumeric(16) + "/" + dh.getName());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		CloudResource resource = new CloudResource();
		String categoryPath = type.path();
		toPath = toPath == null ? "" : toPath;
		toPath = toPath.startsWith("/") ? toPath.substring(1, toPath.length() - 1) : toPath;
		toPath = toPath.endsWith("/") ? toPath : (toPath + "/");
		String key = categoryPath + "/" + toPath + file.getName();

		Response resp = null;
		try {
			if (overwrite) {
				resp = uploadManager.put(file, key, getUpToken(key));
			} else {
				resp = uploadManager.put(file, key, getUpToken());
			}
			if (resp.isOK()) {
				resource.setFileExt(getFileExtension(file));
				resource.setName(file.getName());
				resource.setUrl(domain + "/" + key);
			}
		} catch (QiniuException e) {
			e.printStackTrace();
		}
		return resource;
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

	private File writeToFile(InputStream ins, String path) {
		File file = new File(path);
		try {
			OutputStream out = new FileOutputStream(file);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = ins.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
}
