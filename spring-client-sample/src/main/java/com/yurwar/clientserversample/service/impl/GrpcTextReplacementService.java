package com.yurwar.clientserversample.service.impl;

import com.yurwar.clientserversample.service.TextReplacementService;
import com.yurwar.proto.TextReplacementServiceGrpc;
import io.grpc.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.yurwar.proto.TextReplacementServiceOuterClass.TextReplacementRequest;
import static com.yurwar.proto.TextReplacementServiceOuterClass.TextReplacementResponse;

@Service
@Slf4j
public class GrpcTextReplacementService implements TextReplacementService {
    private final Channel managedChanel;

    public GrpcTextReplacementService(Channel managedChanel) {
        this.managedChanel = managedChanel;
    }

    @Override
    public String replaceText(String text, String fromReplace, String toReplace) {
        TextReplacementServiceGrpc.TextReplacementServiceBlockingStub textReplacementService = TextReplacementServiceGrpc.newBlockingStub(managedChanel);

        TextReplacementRequest textReplacementRequest = buildReplacementRequest(text, fromReplace, toReplace);
        log.info("Sending text replacement request on gRPC server: {}", textReplacementRequest);
        TextReplacementResponse textReplacementResponse = textReplacementService.replaceText(textReplacementRequest);

        return textReplacementResponse.getReplacedText();
    }

    private TextReplacementRequest buildReplacementRequest(String text, String fromReplace, String toReplace) {
        return TextReplacementRequest.newBuilder()
                .setText(text)
                .setFromReplace(fromReplace)
                .setToReplace(toReplace).build();
    }
}
