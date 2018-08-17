package com.mudra.mboss.master.bean.supplier;

import org.springframework.web.multipart.MultipartFile;

public class SupplierDetailFileBean {
	public MultipartFile uploadziprarfile;
	
	public MultipartFile uploadpanfile;
	
	public MultipartFile newuploadpan;
	
	public String servercontextpath;
	
	public SupplierDetailFileBean(MultipartFile uploadziprarfile, MultipartFile uploadpanfile, String servercontextpath) {
		super();
		this.uploadziprarfile = uploadziprarfile;
		this.uploadpanfile = uploadpanfile;
		this.servercontextpath = servercontextpath;
	}

}
