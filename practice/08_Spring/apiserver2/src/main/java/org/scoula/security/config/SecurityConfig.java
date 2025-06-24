package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.scoula.security.filter.JwtUsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity // Spring Security 활성화
@Log4j2
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtUsernamePasswordAuthenticationFilter jwtUsernamePasswordAuthenticationFilter;

    //    DB 기반 인증 처리를 위한 서비스 (in-memory 방식과 병행 불가)
    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
//        보안 강화를 위한 BCrypt 해시 알고리즘 사용
        return new BCryptPasswordEncoder();
    }

    // 문자셋 필터 정의
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    // AuthenticationManager 빈 등록
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // Cross-Origin 설정 (CORS 허용)
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 인증 정보 포함 허용
        config.addAllowedOriginPattern("*"); // 모든 Origin 허용
        config.addAllowedHeader("*"); // 모든 헤더 허용
        config.addAllowedMethod("*"); // 모든 HTTP Method 허용
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    // 정적 리소스 및 인증 제외 경로 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/assets/**", // 정적 리소스
                "/*", // 루트 경로
                "/api/member/**"); // 회원 가입 등 비인증 API
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 한글 인코딩 필터를 CsrfFilter 앞에 등록
        http.addFilterBefore(encodingFilter(), CsrfFilter.class)
                .addFilterBefore(jwtUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.httpBasic().disable() // 기본 HTTP 인증 비활성화
                .csrf().disable() // CSRF 보호 비활성화
                .formLogin().disable() // 폼 로그인 기능 비활성화
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션 사용 안함 (JWT 기반 인증 대응)
    }

    // 인증 매니저 구성: 사용자 정보와 패스워드 인코더 설정
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());


    }
}
