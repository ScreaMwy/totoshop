package org.totoshop.web;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.apache.log4j.Logger;

@Controller("fileUploadController")
@Scope(scopeName = "singleton")
@RequestMapping(path = {"/file"})
@SuppressWarnings({"unused"})
public class FileUploadController {
	private static Logger logger = Logger.getLogger(FileUploadController.class);
	
	@Value("${uploadPath}")
	private String filePath;
	
	@RequestMapping(path = {"/upload"}, method = {RequestMethod.POST, RequestMethod.GET})
	private String fileUpload() {
		return "upload";
	}
	
	@RequestMapping(path = {"/uploaded"}, method = {RequestMethod.POST})
	@ResponseBody
	private String uploaded(MultipartFile uploadedFile, HttpServletRequest request) throws IOException {
		String prefix = UUID.randomUUID().toString() + "_";
		Map<String, String> status = new HashMap<String, String>();
		status.put("error", "303");
		status.put("success", "300");
		if (uploadedFile.getSize() > 0) {
			String fileName = prefix + uploadedFile.getOriginalFilename();
			if (fileName.endsWith("jpg") || fileName.endsWith("png") || fileName.endsWith("gif")) {
				String resourcePath = request.getSession().getServletContext().getRealPath(filePath);
				File newFile = new File(resourcePath, fileName);
				uploadedFile.transferTo(newFile);
			} 
		} else {
			return status.get("error");
		}
		return status.get("success");
	}
	
	@RequestMapping(path = {"/download"}, method = {RequestMethod.POST, RequestMethod.GET})
	@SuppressWarnings({"resource"})
	public ResponseEntity<byte[]> download(@RequestParam(name = "fileName", required = true) String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException { 
		String name = fileName;
		String path = request.getSession().getServletContext().getRealPath(filePath);
		//System.out.printf("%s", path);
		File file = new File(path, name);
		InputStream in = new FileInputStream(file);
		byte[] bytes = new byte[in.read()];
		in.read(bytes);
		name = new String(fileName.getBytes("utf-8"), "utf-8");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.IMAGE_PNG);
		httpHeaders.setContentDispositionFormData("attachment", name);
		httpHeaders.setContentLength(file.length());
		/*httpHeaders.set("Content-Type", "image/png");
		httpHeaders.set("Content-Disposition", "attachment;file=" + name);
		httpHeaders.set("Content-Length", String.valueOf(file.length()));*/
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.OK);
		return responseEntity;
	} 
}
