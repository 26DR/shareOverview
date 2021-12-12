package com.company.shareoverview.dto.mapper;

import com.company.shareoverview.controller.response.ShareRegistrationStatisticByMonthResponse;
import com.company.shareoverview.dto.ShareRegistrationStatisticByMonthDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;

@Component
public class ShareRegistrationStatisticByMonthResponseMapper {

    public static ShareRegistrationStatisticByMonthResponse mapToResponse (ShareRegistrationStatisticByMonthDTO dto) {
        return ShareRegistrationStatisticByMonthResponse.builder()
                .year(dto.getYear())
                .month(Month.of(dto.getMonth()).name())
                .companyName(dto.getCompanyName())
                .shareName(dto.getShareName())
                .isin(dto.getIsin())
                .country(dto.getCountry())
                .eoa(dto.getEoa())
                .shareVolume(dto.getShareVolume())
                .averagePrice(BigDecimal.valueOf(dto.getAveragePrice()).setScale(2, RoundingMode.HALF_EVEN))
                .totalPrice(dto.getTotalPrice())
                .employeeId(dto.getEmployeeId())
                .build();
    }
}
