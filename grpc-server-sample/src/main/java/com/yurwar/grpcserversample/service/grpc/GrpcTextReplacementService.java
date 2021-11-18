package com.yurwar.grpcserversample.service.grpc;

import com.yurwar.proto.TextReplacementServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

import static com.yurwar.proto.TextReplacementServiceOuterClass.TextReplacementRequest;
import static com.yurwar.proto.TextReplacementServiceOuterClass.TextReplacementResponse;

@Slf4j
@GRpcService
public class GrpcTextReplacementService extends TextReplacementServiceGrpc.TextReplacementServiceImplBase {
    @Override
    public void replaceText(TextReplacementRequest request, StreamObserver<TextReplacementResponse> responseObserver) {
        log.info("Received text replacement request: {}", request.toString());
        String replacedText = request.getText().replace(request.getFromReplace(), request.getToReplace());
        responseObserver.onNext(TextReplacementResponse.newBuilder().setReplacedText(replacedText).build());
        responseObserver.onCompleted();
    }
}
