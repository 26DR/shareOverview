package com.company.shareoverview.dto.mapper;

import com.company.shareoverview.dto.ShareDataDTO;
import com.company.shareoverview.model.ShareData;

public class ShareDataModelMapper {

    public static ShareData mapToModel (ShareDataDTO request) {
        return ShareData.builder()
                .companyName(request.getCompanyName())
                .shareName(request.getShareName())
                .isinCode(request.getIsinCode())
                .country(request.getCountry())
                .economicActivity(request.getEconomicActivity())
                .build();
    }
}
