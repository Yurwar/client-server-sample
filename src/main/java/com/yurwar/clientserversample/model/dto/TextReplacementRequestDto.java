package com.yurwar.clientserversample.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextReplacementRequestDto {
    private String text;
    private String fromReplace;
    private String toReplace;
}
