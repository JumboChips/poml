package com.jumbochips.poml_jpa.common.file.controller;

import com.jumbochips.poml_jpa.common.file.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/upload/file")
@RequiredArgsConstructor
public class FileUploadController {

    @Value("${image.upload-project-dir}")
    private String uploadProjectDir;

    @Value("${image.upload-blog-dir}")
    private String uploadBlogDir;


    private final FileUploadService fileUploadService;

    @PostMapping("/project")
    public ResponseEntity<?> uploadProjectImage(@RequestParam("file") List<MultipartFile> files) {
        if(files.isEmpty()) {
            return ResponseEntity.badRequest().body("Empty file");
        }
        try {
            List<String> fileUrl = fileUploadService.uploadFiles(files, uploadProjectDir);
            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/blog")
    public ResponseEntity<?> uploadBlogImage(@RequestParam("file") List<MultipartFile> files) {
        if(files.isEmpty()) {
            return ResponseEntity.badRequest().body("Empty file");
        }
        try {
            List<String> fileUrl = fileUploadService.uploadFiles(files, uploadBlogDir);
            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
