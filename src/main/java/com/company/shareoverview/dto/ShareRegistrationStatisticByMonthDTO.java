package com.company.shareoverview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
public class ShareRegistrationStatisticByMonthDTO {

    int year;
    int month;
    String companyName;
    String shareName;
    String isin;
    String country;
    String eoa;
    long shareVolume;
    double averagePrice;
    BigDecimal totalPrice;
    long employeeId;
}
