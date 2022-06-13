package com.informix.test.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TemplateResponseUtil {

    private String message;
    private HttpStatus httpStatus;
    private String extraInfo;
}
