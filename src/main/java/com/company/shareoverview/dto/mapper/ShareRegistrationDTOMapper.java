package com.company.shareoverview.dto.mapper;

import com.company.shareoverview.controller.request.ShareRegistrationRequest;
import com.company.shareoverview.dto.ShareRegistrationDTO;

public class ShareRegistrationDTOMapper {

    public static ShareRegistrationDTO mapToDto(ShareRegistrationRequest request) {
        return ShareRegistrationDTO.builder()
                .acquiredShareData(request.getAcquiredShareData())
                .pricePerShare(request.getPricePerShare())
                .amountOfSharesAcquired(request.getAmountOfSharesAcquired())
                .acquirerEmployeeId(request.getAcquirerEmployeeId())
                .build();
    }
}
