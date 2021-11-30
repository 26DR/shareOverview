package com.company.shareoverview.controller.request;

import lombok.Data;

@Data
public class ShareDataRequest {

    private String companyName;
    private String shareName;
    private String isinCode;
    private String country;
    private String economicActivity;
}
