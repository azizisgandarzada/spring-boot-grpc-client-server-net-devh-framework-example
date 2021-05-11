package com.user.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "grpc")
@Data
public class GrpcProperties {

    private String host;
    private int port;

}
