package com.company.shareoverview.service;

import com.company.shareoverview.dto.ShareDataDTO;
import com.company.shareoverview.dto.mapper.ShareDataModelMapper;
import com.company.shareoverview.model.ShareData;
import com.company.shareoverview.repository.ShareDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ShareDataService {

    private final ShareDataRepository shareDataRepository;

    public void createShareDataRecord(List<ShareDataDTO> shareDataDTOS) {
        List<ShareData> shareData = shareDataDTOS.stream()
                .map(ShareDataModelMapper::mapToModel)
                .collect(Collectors.toList());

        shareDataRepository.saveAll(shareData);
    }

    public List<ShareData> getAllShareDataRecords() {
        return shareDataRepository.findAll();
    }
}
