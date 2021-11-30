package com.company.shareoverview.controller.request.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class MultiPartFileUtils {

    public static boolean areMultipartFilesPresent(@RequestPart(value = "file", required = false) List<MultipartFile> files) {
        if (files == null) {
            return false;
        }
        return files.stream()
                .anyMatch(file -> file.getSize() > 0);
    }
}
