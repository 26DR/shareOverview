package com.company.shareoverview.dto;

import com.company.shareoverview.model.ShareData;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ShareRegistrationDTO {

    private ShareData acquiredShareData;
    private BigDecimal pricePerShare;
    private int amountOfSharesAcquired;
    private Long acquirerEmployeeId;
}
