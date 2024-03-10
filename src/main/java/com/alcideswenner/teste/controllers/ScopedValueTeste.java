package com.alcideswenner.teste.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/")
public class ScopedValueTeste {

    private static final ScopedValue<String> ipThread = ScopedValue.newInstance();
    private static final String IP_UNKNOWN = "unknown";

    @GetMapping
    public ResponseEntity<String> getTeste(HttpServletRequest request) throws Exception {

        String clientIp = request.getHeader("X-Forwarded-For");

        if (clientIp == null || clientIp.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }

        if (clientIp == null || clientIp.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }

        ScopedValue.Carrier carrier = ScopedValue.where(ipThread, clientIp);

        return carrier.call(() -> ResponseEntity.ok().body(ipThread.get()));
    }
}
