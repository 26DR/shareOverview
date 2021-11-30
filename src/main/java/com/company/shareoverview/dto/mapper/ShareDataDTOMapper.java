package com.company.shareoverview.dto.mapper;

import com.company.shareoverview.controller.request.ShareDataRequest;
import com.company.shareoverview.dto.ShareDataDTO;

public class ShareDataDTOMapper {

    public static ShareDataDTO mapToDto(ShareDataRequest request) {
        return ShareDataDTO.builder()
                .companyName(request.getCompanyName())
                .shareName(request.getShareName())
                .isinCode(request.getIsinCode())
                .country(request.getCountry())
                .economicActivity(request.getEconomicActivity())
                .build();
    }
}
