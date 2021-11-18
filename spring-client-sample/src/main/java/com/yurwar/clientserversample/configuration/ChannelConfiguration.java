package com.yurwar.clientserversample.configuration;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChannelConfiguration {
    private static final int TEXT_REPLACEMENT_GRPC_SERVER_PORT = 6565;

    @Bean
    public Channel managedChannel() {
        return ManagedChannelBuilder
                .forAddress("localhost",
                        TEXT_REPLACEMENT_GRPC_SERVER_PORT)
                .usePlaintext()
                .build();
    }
}
