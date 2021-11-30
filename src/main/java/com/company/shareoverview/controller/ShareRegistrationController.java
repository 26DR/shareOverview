package com.company.shareoverview.controller;

import com.company.shareoverview.controller.request.ShareRegistrationRequest;
import com.company.shareoverview.dto.ShareRegistrationDTO;
import com.company.shareoverview.dto.mapper.ShareRegistrationDTOMapper;
import com.company.shareoverview.service.ShareRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/share-registration")
@AllArgsConstructor
public class ShareRegistrationController {

    private final ShareRegistrationService shareRegistrationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createShareRegistrationRecordJSON(@Valid @RequestBody List<ShareRegistrationRequest> request) {

        List<ShareRegistrationDTO> shareRegistrationDTOS = requestToDTO(request);
        shareRegistrationService.createShareRegistrationRecord(shareRegistrationDTOS);

        return new ResponseEntity<>("Share registration records successfully created", HttpStatus.OK);
    }

    private static List<ShareRegistrationDTO> requestToDTO(@RequestBody List<ShareRegistrationRequest> request) {
        return request.stream()
                .map(ShareRegistrationDTOMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
