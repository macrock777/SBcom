package com.mudra.mboss.master.bean.client;

import org.springframework.web.multipart.MultipartFile;

public class ClientMasterFileBean {

	public MultipartFile panfile,bankfile,clientcontractfile;
	
	public String servercontextpath;

	public ClientMasterFileBean(MultipartFile panfile, MultipartFile bankfile, MultipartFile clientcontractfile,
			String servercontextpath) {
		super();
		this.panfile = panfile;
		this.bankfile = bankfile;
		this.clientcontractfile = clientcontractfile;
		this.servercontextpath = servercontextpath;
	}
	
}
