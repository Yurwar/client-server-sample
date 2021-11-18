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
    private final TextReplacementService defaultTextReplacementService;
    private final TextReplacementService grpcTextReplacementService;

    @PostMapping("/replace")
    public TextReplacementResponseDto replaceText(@RequestBody TextReplacementRequestDto textReplacementRequest) {
        String replacedText = getReplacedText(textReplacementRequest, defaultTextReplacementService);

        return TextReplacementResponseDto.builder()
                .replacedText(replacedText)
                .build();
    }

    @PostMapping("/grpc-replace")
    public TextReplacementResponseDto grpcReplaceText(@RequestBody TextReplacementRequestDto textReplacementRequest) {
        String replacedText = getReplacedText(textReplacementRequest, grpcTextReplacementService);

        return TextReplacementResponseDto.builder()
                .replacedText(replacedText)
                .build();
    }

    private String getReplacedText(TextReplacementRequestDto textReplacementRequest, TextReplacementService textReplacementService) {
        return textReplacementService.replaceText(textReplacementRequest.getText(),
                textReplacementRequest.getFromReplace(),
                textReplacementRequest.getToReplace());
    }
}
