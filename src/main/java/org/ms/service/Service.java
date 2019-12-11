package org.ms.service;

import java.util.Optional;

import org.ms.service.dto.ApiService;
import org.ms.service.dto.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.OptBoolean;

@RestController
public class Service {
	@Autowired
	private ApiService ApiService;
	@PostMapping("/documents")
	 public Optional<String> postDocument(@RequestPart MultipartFile[] fichiers) {
			Optional<String> value =ApiService.getPersonnesAssurees(fichiers);
	        return value;
	    }
	
}
