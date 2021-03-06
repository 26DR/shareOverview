package com.company.shareoverview.controller;

import com.company.shareoverview.controller.request.ShareRegistrationRequest;
import com.company.shareoverview.controller.request.utils.MultiPartFileUtils;
import com.company.shareoverview.controller.request.utils.ShareDataRequestUtil;
import com.company.shareoverview.controller.response.ShareRegistrationAcquiredByMonthResponse;
import com.company.shareoverview.controller.response.ShareRegistrationAmountByMonthResponse;
import com.company.shareoverview.controller.response.ShareRegistrationStatisticByMonthResponse;
import com.company.shareoverview.dto.ShareRegistrationDTO;
import com.company.shareoverview.dto.mapper.ShareRegistrationDTOMapper;
import com.company.shareoverview.exception.ApiRequestException;
import com.company.shareoverview.service.ShareRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
@RestController
@RequestMapping(value = "/api/v1/share-registration")
@AllArgsConstructor
public class ShareRegistrationController {

    private final ShareRegistrationService shareRegistrationService;

    //TODO fix 415 when no file attached
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createShareRegistrationRecordMultiPartFile(@RequestPart List<MultipartFile> files) {

        if (!MultiPartFileUtils.areMultipartFilesPresent(files)) {
            throw new ApiRequestException("JSON file is required for this endpoint.");
        }

        List<ShareRegistrationRequest> shareRegistrationRequests = (List<ShareRegistrationRequest>) (Object) ShareDataRequestUtil.getShareDataRequestListFromFiles(files, ShareRegistrationRequest.class);
        List<ShareRegistrationDTO> shareRegistrationDTOS = requestToDTO(shareRegistrationRequests);

        shareRegistrationService.createShareRegistrationRecord(shareRegistrationDTOS);

        return new ResponseEntity<>("Share registration records successfully created", HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createShareRegistrationRecordJSON(@Valid @RequestBody List<ShareRegistrationRequest> request) {

        List<ShareRegistrationDTO> shareRegistrationDTOS = requestToDTO(request);
        shareRegistrationService.createShareRegistrationRecord(shareRegistrationDTOS);

        return new ResponseEntity<>("Share registration records successfully created", HttpStatus.OK);
    }

    @GetMapping("/amount-by-month")
    public ResponseEntity getShareRegistrationTotalAmountSpentByMonth() {
        List<ShareRegistrationAmountByMonthResponse> shareRegistrationAmountsByMonth =
                shareRegistrationService.getAmountSpentByMonth();

        return new ResponseEntity<>(shareRegistrationAmountsByMonth, HttpStatus.OK);
    }

    @GetMapping("/amount-by-month/{employeeId}")
    public ResponseEntity getShareRegistrationTotalAmountSpentByMonth(@PathVariable Long employeeId) {
        List<ShareRegistrationAmountByMonthResponse> shareRegistrationAmountsByMonth =
                shareRegistrationService.getAmountSpentByMonth(employeeId);

        return new ResponseEntity<>(shareRegistrationAmountsByMonth, HttpStatus.OK);
    }

    @GetMapping("/acquired-by-month")
    public ResponseEntity getShareRegistrationAcquiredRecordsByMonth() {
        List<ShareRegistrationAcquiredByMonthResponse> shareRegistrationAcquiredByMonth =
                shareRegistrationService.getAcquiringRecordsByMont();

        return new ResponseEntity<>(shareRegistrationAcquiredByMonth, HttpStatus.OK);
    }

    @GetMapping("/acquired-by-month/{employeeId}")
    public ResponseEntity getShareRegistrationAcquiredRecordsByMonth(@PathVariable Long employeeId) {
        List<ShareRegistrationAcquiredByMonthResponse> shareRegistrationAcquiredByMonth =
                shareRegistrationService.getAcquiringRecordsByMont(employeeId);

        return new ResponseEntity<>(shareRegistrationAcquiredByMonth, HttpStatus.OK);
    }

    @GetMapping("/statistics-by-month/{month}")
    public ResponseEntity getShareRegistrationStatisticsByMonth(@PathVariable int month) {
        List<ShareRegistrationStatisticByMonthResponse> shareRegistrationStatisticByMonth =
                shareRegistrationService.getStatisticsByMonth(month);

        return new ResponseEntity<>(shareRegistrationStatisticByMonth, HttpStatus.OK);
    }

    @GetMapping("/statistics-by-month/{month}/{employeeId}")
    public ResponseEntity getShareRegistrationStatisticsByMonth(@PathVariable int month, @PathVariable long employeeId) {
        List<ShareRegistrationStatisticByMonthResponse> shareRegistrationStatisticByMonth =
                shareRegistrationService.getStatisticsByMonth(month, employeeId);

        return new ResponseEntity<>(shareRegistrationStatisticByMonth, HttpStatus.OK);
    }

    private static List<ShareRegistrationDTO> requestToDTO(@RequestBody List<ShareRegistrationRequest> request) {
        return request.stream()
                .map(ShareRegistrationDTOMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
