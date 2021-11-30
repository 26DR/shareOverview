package com.company.shareoverview.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class ApiException {

    private final List<String> message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
}
