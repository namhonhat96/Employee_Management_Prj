package com.example.demo.controller;
import com.example.demo.pojo.StorageFileNotFoundException;
import com.example.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class FileUploadController {
	private final StorageService storageService;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@RequestMapping(value = "/files/list", method = RequestMethod.GET)
	public List<String> listUploadedFiles() throws IOException {
		return storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList());
	}

	@RequestMapping(value = "/files/{filename:.+}", method = RequestMethod.POST)
	public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@RequestMapping(value = "/files/upload/", method = RequestMethod.POST)
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file,
											  RedirectAttributes redirectAttributes) {
		System.out.println("Here");
		storageService.store(file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return ResponseEntity.ok(new JwtResponse("okay"));
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}