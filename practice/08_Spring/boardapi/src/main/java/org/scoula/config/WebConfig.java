package org.scoula.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

@Slf4j
@Configuration
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 루트 어플리케이션 설정 (서비스, DAO, DB 등)

    final String LOCATION = "/Users/eunseo/Desktop/gd";
    final long MAX_FILE_SIZE = 1024 * 1024 * 10L;
    final long MAX_REQUEST_SIZE = 1024 * 1024 * 20L;
    final int FILE_SIZE_THRESHOLD = 1024 * 1024 * 5;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    // 서블릿 어플리케이션 설정 (Controller, ViewResolver 등)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ServletConfig.class, SwaggerConfig.class};
    }

    // DispatcherServlet의 URL 매핑
    @Override
    protected String[] getServletMappings() {
        // 모든 요청을 DispatcherServlet이 처리
        return new String[] {"/", // 모든 요청 처리
                "/swagger-ui.html", // Swagger UI 진입점
                "/swagger-resources/**", // Swagger 리소스 경로
                "/v2/api-docs", // Swagger API 문서 JSON
                "/webjars/**"}; // Swagger UI 관련 정적 지원(js/css)
    }

    // 한글 POST 요청 인코딩 필터 설정
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                LOCATION,
                MAX_FILE_SIZE,
                MAX_REQUEST_SIZE,
                FILE_SIZE_THRESHOLD
        );
        registration.setMultipartConfig(multipartConfig);
    }
}
