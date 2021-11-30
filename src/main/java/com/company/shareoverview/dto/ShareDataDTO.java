package com.company.shareoverview.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShareDataDTO {

    private String companyName;
    private String shareName;
    private String isinCode;
    private String country;
    private String economicActivity;
}
