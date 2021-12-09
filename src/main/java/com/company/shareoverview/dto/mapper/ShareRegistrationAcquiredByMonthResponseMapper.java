package com.company.shareoverview.dto.mapper;

import com.company.shareoverview.controller.response.ShareRegistrationAcquiredByMonthResponse;
import com.company.shareoverview.dto.ShareRegistrationAcquiredByMonthDTO;

import java.math.RoundingMode;
import java.time.Month;

public class ShareRegistrationAcquiredByMonthResponseMapper {

    public static ShareRegistrationAcquiredByMonthResponse mapToResponse(ShareRegistrationAcquiredByMonthDTO dto) {
        return ShareRegistrationAcquiredByMonthResponse.builder()
                .year(dto.getYear())
                .month(Month.of(dto.getMonth()).name())
                .companyName(dto.getCompanyName())
                .shareName(dto.getShareName())
                .isin(dto.getIsin())
                .country(dto.getCountry())
                .eoa(dto.getEoa())
                .averagePrice(dto.getAveragePrice().setScale(2, RoundingMode.HALF_EVEN))
                .acquiredAmount(dto.getAcquiredAmount())
                .totalPrice(dto.getTotalPrice().setScale(2, RoundingMode.HALF_EVEN))
                .build();
    }
}
