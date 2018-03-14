package com.hcz.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping("/upload")
	public String fileUpload(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest request) throws IOException{
		String path = request.getRealPath("/fileupload");
		InputStream in = file.getInputStream();
		OutputStream out = new FileOutputStream(new File(path, file.getOriginalFilename()));
		int len = 0;
		byte[] buffer = new byte[400];
		while((len=in.read(buffer))!=-1){
			out.write(buffer, 0, len);
		}
		out.close();
		in.close();
		return "index.jsp";
	}
}
