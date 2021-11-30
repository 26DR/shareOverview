package com.company.shareoverview.controller.request;

import com.company.shareoverview.model.ShareData;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ShareRegistrationRequest {

    private ShareData acquiredShareData;
    private BigDecimal pricePerShare;
    private int amountOfSharesAcquired;
    private Long acquirerEmployeeId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate acquisitionDate = LocalDate.now();
}
