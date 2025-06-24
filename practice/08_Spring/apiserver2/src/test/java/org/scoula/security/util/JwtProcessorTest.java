package org.scoula.security.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j2
class JwtProcessorTest {
    @Autowired
    JwtProcessor jwtProcessor;

    // 토큰 생성 테스트
    @Test
    void generateToken() {
        String username = "user0";
        String token = jwtProcessor.generateToken(username);
        log.info(token);
        assertNotNull(token);
    }

    @Test
    void getUsername() {
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTc1MDcyOTAzNywiZXhwIjoxNzUwNzI5MzM3fQ.eWprN8M0BmH-kfToLj6X-CNNsNo-s3rdDQuCNx5tV1XJADhPToLTH_Y8w6532zCY";

        String username = jwtProcessor.getUsername(token);
        log.info(username);
        assertNotNull(username);
    }

    @Test
    void validateToken() {
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTc1MDcyOTAzNywiZXhwIjoxNzUwNzI5MzM3fQ.eWprN8M0BmH-kfToLj6X-CNNsNo-s3rdDQuCNx5tV1XJADhPToLTH_Y8w6532zCY";

        // 발급 5분 이내에만 true, 그 이후엔 예외 발생
        boolean isValid = jwtProcessor.validateToken(token);
        log.info(isValid);
        assertTrue(isValid);
    }
}