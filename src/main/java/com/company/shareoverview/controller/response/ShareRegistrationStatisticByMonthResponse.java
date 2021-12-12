package com.company.shareoverview.controller.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ShareRegistrationStatisticByMonthResponse {

    int year;
    String month;
    String companyName;
    String shareName;
    String isin;
    String country;
    String eoa;
    Long shareVolume;
    BigDecimal averagePrice;
    BigDecimal totalPrice;
    Long employeeId;
}
