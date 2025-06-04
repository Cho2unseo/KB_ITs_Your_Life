package org.scoula.ex05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request_redirect")
public class RequestRedirectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // request scope에 속성 설정
        req.setAttribute("username", "홍길동");
        req.setAttribute("useraddress","서울");

        // 리다이렉트 -> 속성 전달 안 됨 (새로운 request)
        res.sendRedirect("response_redirect");
    }
}
