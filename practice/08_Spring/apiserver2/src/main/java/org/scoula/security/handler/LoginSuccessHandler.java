package org.scoula.security.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.dto.AuthResultDTO;
import org.scoula.security.account.dto.UserInfoDTO;
import org.scoula.security.util.JsonResponse;
import org.scoula.security.util.JwtProcessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtProcessor jwtProcessor;

    // 사용자 객체 기반으로 토큰 + 사ㅏ용자 정보를 조합하여 AuthResultDTO 생성
    private AuthResultDTO makeAuthResult(CustomUser user) {
        String username = user.getUsername();
        String token = jwtProcessor.generateToken(username);
        return new AuthResultDTO(token, UserInfoDTO.of(user.getMember()));
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Principal 객체에서 사용자 정보 추출
        CustomUser user = (CustomUser) authentication.getPrincipal();
        // 사용자 기반 토큰 및 정보 생성
        AuthResultDTO result = makeAuthResult(user);
        // JSON 응답 전송
        JsonResponse.send(response, result);
    }
}
