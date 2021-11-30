package com.company.shareoverview.controller.request.utils;

import com.company.shareoverview.controller.request.ShareDataRequest;
import com.company.shareoverview.exception.ApiRequestException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShareDataRequestUtil {

    //TODO refactor 2 methods to be used elsewhere, with other classes
    public static List<ShareDataRequest> getShareDataRequestListFromFiles(List<MultipartFile> files) {
        return files.stream()
                .flatMap(file -> convertMultipartJsonToObject(file).stream())
                .collect(Collectors.toList());
    }

    private static List<ShareDataRequest> convertMultipartJsonToObject(MultipartFile file) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(file.getBytes(), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new ApiRequestException("There was a problem parsing JSON file: " + e.getLocalizedMessage());
        }
    }
}
