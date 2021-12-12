package com.company.shareoverview.service;

import com.company.shareoverview.controller.response.ShareRegistrationAcquiredByMonthResponse;
import com.company.shareoverview.controller.response.ShareRegistrationAmountByMonthResponse;
import com.company.shareoverview.controller.response.ShareRegistrationStatisticByMonthResponse;
import com.company.shareoverview.dto.ShareRegistrationDTO;
import com.company.shareoverview.dto.mapper.ShareRegistrationAcquiredByMonthResponseMapper;
import com.company.shareoverview.dto.mapper.ShareRegistrationAmountByMonthResponseMapper;
import com.company.shareoverview.dto.mapper.ShareRegistrationModelMapper;
import com.company.shareoverview.dto.mapper.ShareRegistrationStatisticByMonthResponseMapper;
import com.company.shareoverview.model.ShareRegistration;
import com.company.shareoverview.repository.ShareRegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ShareRegistrationService {

    private final ShareRegistrationRepository shareRegistrationRepository;

    public void createShareRegistrationRecord(List<ShareRegistrationDTO> shareRegistrationDTOS) {
        List<ShareRegistration> shareRegistrations = shareRegistrationDTOS.stream()
                .map(ShareRegistrationModelMapper::mapToModel)
                .collect(Collectors.toList());

        shareRegistrationRepository.saveAll(shareRegistrations);
    }

    public List<ShareRegistrationAmountByMonthResponse> getAmountSpentByMonth() {
        return shareRegistrationRepository.getTotalSpentByMonth().stream()
                .map(ShareRegistrationAmountByMonthResponseMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<ShareRegistrationAmountByMonthResponse> getAmountSpentByMonth(Long employeeId) {
        return shareRegistrationRepository.getTotalSpentByMonth(employeeId).stream()
                .map(ShareRegistrationAmountByMonthResponseMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<ShareRegistrationAcquiredByMonthResponse> getAcquiringRecordsByMont() {
        return shareRegistrationRepository.getAcquiringRecordsByMonth().stream()
        .map(ShareRegistrationAcquiredByMonthResponseMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<ShareRegistrationAcquiredByMonthResponse> getAcquiringRecordsByMont(Long employeeId) {
        return shareRegistrationRepository.getAcquiringRecordsByMonth(employeeId).stream()
                .map(ShareRegistrationAcquiredByMonthResponseMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<ShareRegistrationStatisticByMonthResponse> getStatisticsByMonth(int month) {
        return shareRegistrationRepository.getStatisticsByMonth(month).stream()
                .map(ShareRegistrationStatisticByMonthResponseMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<ShareRegistrationStatisticByMonthResponse> getStatisticsByMonth(int month, long employeeId) {
        return shareRegistrationRepository.getStatisticsByMonth(month, employeeId).stream()
                .map(ShareRegistrationStatisticByMonthResponseMapper::mapToResponse)
                .collect(Collectors.toList());
    }
}
