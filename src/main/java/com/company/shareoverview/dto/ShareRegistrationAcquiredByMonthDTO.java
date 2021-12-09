package com.company.shareoverview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
public class ShareRegistrationAcquiredByMonthDTO {

    int year;
    int month;
    String companyName;
    String shareName;
    String isin;
    String country;
    String eoa;
    BigDecimal averagePrice;
    int acquiredAmount;
    BigDecimal totalPrice;

    public ShareRegistrationAcquiredByMonthDTO(int year, int month, String companyName, String shareName, String isin, String country, String eoa, double averagePrice, long acquiredAmount, BigDecimal totalPrice) {
        this.year = year;
        this.month = month;
        this.companyName = companyName;
        this.shareName = shareName;
        this.isin = isin;
        this.country = country;
        this.eoa = eoa;
        this.averagePrice = BigDecimal.valueOf(averagePrice);
        this.acquiredAmount = Math.toIntExact(acquiredAmount);
        this.totalPrice = totalPrice;
    }
}
