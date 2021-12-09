package com.company.shareoverview.dto.mapper;

import com.company.shareoverview.controller.response.ShareRegistrationAmountByMonthResponse;
import com.company.shareoverview.dto.ShareRegistrationAmountByMonthDTO;
import org.springframework.stereotype.Component;

import java.time.Month;

@Component
public class ShareRegistrationAmountByMonthResponseMapper {

    public static ShareRegistrationAmountByMonthResponse mapToResponse(ShareRegistrationAmountByMonthDTO dto) {
        return ShareRegistrationAmountByMonthResponse.builder()
                .amount(dto.getPrice())
                .month(Month.of(dto.getMonth()).name())
                .year(dto.getYear())
                .build();
    }

}
