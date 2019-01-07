package org.totoshop.util.multipart;

import java.util.UUID;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.totoshop.util.Status;

@SuppressWarnings({"unused"})
public class FileTransfer {
	private String filePath;
	
	private File file;
	
	private Status status;
	
	public FileTransfer() {
		status = new Status();
	}
	
	public int upload(MultipartFile uploadFile, HttpServletRequest request) throws IOException {
		StringBuilder prefix = new StringBuilder(UUID.randomUUID().toString()).append("-");
		if (uploadFile.getSize() > 0) {
			StringBuilder fileName = new StringBuilder(prefix.toString()).append(uploadFile.getName());
			if (fileName.toString().endsWith("jpg") || fileName.toString().endsWith("png") || fileName.toString().endsWith("gif") || fileName.toString().endsWith("jpeg")) {
				String realPath = request.getSession().getServletContext().getRealPath(filePath);
				File newFile = new File(realPath, fileName.toString());
				uploadFile.transferTo(newFile);
			}
		} else {
			return status.getStatus(Status.STATUS_ERROR);
		}
		return status.getStatus(Status.STATUS_SUCCESS);
	}
	
	@SuppressWarnings({"resource"})
	public ResponseEntity<byte[]> download(String fileName, HttpServletRequest request) throws IOException {
		String name = fileName;
		String realPath = request.getSession().getServletContext().getRealPath(filePath);
		File newFile = new File(realPath, name);
		InputStream in = new FileInputStream(newFile);
		byte[] bytes = new byte[in.read()];
		in.read(bytes);
		
		HttpHeaders httpHeader = new HttpHeaders();
		if (fileName.endsWith("jpg") || fileName.endsWith("jpeg")) {
			httpHeader.setContentType(MediaType.IMAGE_JPEG);
		} else if (fileName.endsWith("png")) {
			httpHeader.setContentType(MediaType.IMAGE_PNG);
		} else if (fileName.endsWith("gif")) {
			httpHeader.setContentType(MediaType.IMAGE_GIF);
		}
		httpHeader.setContentDispositionFormData("attachment", name);
		httpHeader.setContentLength(newFile.length());
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, httpHeader, HttpStatus.OK);
		return responseEntity;
	}
}
