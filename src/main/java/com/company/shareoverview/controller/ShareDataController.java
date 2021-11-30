package com.company.shareoverview.controller;

import com.company.shareoverview.controller.request.ShareDataRequest;
import com.company.shareoverview.controller.request.utils.MultiPartFileUtils;
import com.company.shareoverview.controller.request.utils.ShareDataRequestUtil;
import com.company.shareoverview.dto.ShareDataDTO;
import com.company.shareoverview.dto.mapper.ShareDataDTOMapper;
import com.company.shareoverview.exception.ApiRequestException;
import com.company.shareoverview.model.ShareData;
import com.company.shareoverview.service.ShareDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/share-data")
@AllArgsConstructor
public class ShareDataController {

    private final ShareDataService shareDataService;

    //TODO fix 415 when no file attached
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createShareDataRecordMultiPartFile(@RequestPart List<MultipartFile> files) {

        if (!MultiPartFileUtils.areMultipartFilesPresent(files)) {
            throw new ApiRequestException("JSON file is required for this endpoint.");
        }

        List<ShareDataRequest> shareDataRequests = ShareDataRequestUtil.getShareDataRequestListFromFiles(files);
        List<ShareDataDTO> shareDataDTOs = requestToDTO(shareDataRequests);

        shareDataService.createShareDataRecord(shareDataDTOs);

        return new ResponseEntity<>("Share data records successfully created", HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createShareDataRecordJSON(@Valid @RequestBody List<ShareDataRequest> request) {

        List<ShareDataDTO> shareDataDTOS = requestToDTO(request);
        shareDataService.createShareDataRecord(shareDataDTOS);

        return new ResponseEntity<>("Share data records successfully created", HttpStatus.OK);
    }

    @GetMapping
    public List<ShareData> getAllShareDataRecords() {
        return shareDataService.getAllShareDataRecords();
    }

    private static List<ShareDataDTO> requestToDTO(@RequestBody List<ShareDataRequest> request) {
        return request.stream()
                .map(ShareDataDTOMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
