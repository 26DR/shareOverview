package com.company.shareoverview.controller.response;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ShareRegistrationAcquiredByMonthResponse {

    int year;
    String month;
    String companyName;
    String shareName;
    String isin;
    String country;
    String eoa;
    BigDecimal averagePrice;
    int acquiredAmount;
    BigDecimal totalPrice;
}
