package com.yurwar.clientserversample.service.impl;

import com.yurwar.clientserversample.service.TextReplacementService;
import org.springframework.stereotype.Service;

@Service
public class DefaultTextReplacementService implements TextReplacementService {
    @Override
    public String replaceText(String text, String fromReplace, String toReplace) {
        return text.replace(fromReplace, toReplace);
    }
}
