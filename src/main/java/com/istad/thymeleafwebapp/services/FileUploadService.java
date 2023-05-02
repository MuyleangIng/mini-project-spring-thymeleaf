package com.istad.thymeleafwebapp.services;

import com.istad.thymeleafwebapp.models.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    FileUpload uploadSingle(MultipartFile file);
}
