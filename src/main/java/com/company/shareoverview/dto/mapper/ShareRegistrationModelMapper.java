package com.company.shareoverview.dto.mapper;

import com.company.shareoverview.dto.ShareRegistrationDTO;
import com.company.shareoverview.model.ShareRegistration;
import org.springframework.stereotype.Component;

@Component
public class ShareRegistrationModelMapper {

    public static ShareRegistration mapToModel(ShareRegistrationDTO request) {
        return ShareRegistration.builder()
                .acquiredShareData(request.getAcquiredShareData())
                .pricePerShare(request.getPricePerShare())
                .amountOfSharesAcquired(request.getAmountOfSharesAcquired())
                .acquirerEmployeeId(request.getAcquirerEmployeeId())
                .build();
    }
}
