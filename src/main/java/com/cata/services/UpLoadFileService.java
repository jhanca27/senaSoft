package com.cata.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UpLoadFileService {

	private String folder = "cargas//";
	private final Logger logg = LoggerFactory.getLogger(UpLoadFileService.class);

	public String SaveJson(MultipartFile file) {
		if (file.isEmpty()) {
			byte[] json;
			try {
				json = file.getBytes();
				Path path = Paths.get(folder + file.getName());
				Files.write(path, json);
				logg.info("Archivo Guardado");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "El archivo se Guardo correctamente";
	}

}
