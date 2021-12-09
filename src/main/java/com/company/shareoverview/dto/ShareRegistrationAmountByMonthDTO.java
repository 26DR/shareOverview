package com.company.shareoverview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
public class ShareRegistrationAmountByMonthDTO {
    BigDecimal price;
    private int month;
    private int year;

    public ShareRegistrationAmountByMonthDTO(int month, int year) {
        this.month = month;
        this.year = year;
    }
}
