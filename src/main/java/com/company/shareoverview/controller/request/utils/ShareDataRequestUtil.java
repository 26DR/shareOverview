package com.company.shareoverview.controller.request.utils;

import com.company.shareoverview.exception.ApiRequestException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShareDataRequestUtil {

    //TODO fix depricated method
    public static List<Object> getShareDataRequestListFromFiles(List<MultipartFile> files, Class<?> clazz) {
        return files.stream()
                .flatMap(file -> convertMultipartJsonToObject(file, clazz).stream())
                .collect(Collectors.toList());
    }

    private static <T> List<T> convertMultipartJsonToObject(MultipartFile file, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(file.getBytes(), TypeFactory.defaultInstance().constructParametrizedType(ArrayList.class, List.class, clazz));
        } catch (IOException e) {
            throw new ApiRequestException("There was a problem parsing JSON file: " + e.getLocalizedMessage());
        }
    }
}
