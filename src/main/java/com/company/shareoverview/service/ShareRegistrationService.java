package com.company.shareoverview.service;

import com.company.shareoverview.dto.ShareRegistrationDTO;
import com.company.shareoverview.dto.mapper.ShareRegistrationModelMapper;
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
}
