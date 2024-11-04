package org.example.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class EndpointLogger {

    @Bean
    public CommandLineRunner logEndpoints(RequestMappingHandlerMapping handlerMapping) {
        return args -> {
            handlerMapping.getHandlerMethods().forEach((requestMappingInfo, handlerMethod) -> {
                System.out.println(requestMappingInfo + " " + handlerMethod);
            });
        };
    }
}