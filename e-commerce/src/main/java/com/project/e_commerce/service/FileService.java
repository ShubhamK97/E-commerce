package com.project.e_commerce.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadTheImage(String path, MultipartFile file) throws IOException;
}
