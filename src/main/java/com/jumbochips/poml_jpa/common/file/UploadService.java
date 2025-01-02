package com.jumbochips.poml_jpa.common.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {

    String uploadFile(MultipartFile file, String uploadDirType);

    List<String> uploadFiles(List<MultipartFile> files, String uploadDirType);
}
