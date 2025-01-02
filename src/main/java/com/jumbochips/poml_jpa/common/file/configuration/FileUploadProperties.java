package com.jumbochips.poml_jpa.common.file.configuration;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@ConfigurationProperties(prefix = "image")
@Setter
public class FileUploadProperties {

    // Setters for ConfigurationProperties
    private String baseUploadDir;
    private String uploadProjectDir;
    private String uploadBlogDir;

    // Getter methods with OS-specific paths
    public String getBaseUploadDir() {
        return convertToOsSpecificPath(baseUploadDir);
    }

    public String getUploadProjectDir() {
        return File.separator + convertToOsSpecificPath(uploadProjectDir);
    }

    public String getUploadBlogDir() {
        return File.separator + convertToOsSpecificPath(uploadBlogDir);
    }

    // Convert method
    private String convertToOsSpecificPath(String path) {
        return path.replace("/", File.separator);
    }

}