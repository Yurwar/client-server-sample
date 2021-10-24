package com.yurwar.clientserversample.controller.api;

import com.yurwar.clientserversample.model.dto.TextReplacementRequestDto;
import com.yurwar.clientserversample.model.dto.TextReplacementResponseDto;
import com.yurwar.clientserversample.service.TextReplacementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/text")
@RequiredArgsConstructor
@CrossOrigin
public class TextController {
    private final TextReplacementService textReplacementService;

    @PostMapping("/replace")
    public TextReplacementResponseDto replaceText(@RequestBody TextReplacementRequestDto textReplacementRequest) {
        String replacedText = textReplacementService.replaceText(textReplacementRequest.getText(),
                textReplacementRequest.getFromReplace(),
                textReplacementRequest.getToReplace());

        return TextReplacementResponseDto.builder()
                .replacedText(replacedText)
                .build();
    }
}
