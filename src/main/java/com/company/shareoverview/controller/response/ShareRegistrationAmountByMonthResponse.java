package com.company.shareoverview.controller.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ShareRegistrationAmountByMonthResponse {
    BigDecimal amount;
    String month;
    int year;
}
