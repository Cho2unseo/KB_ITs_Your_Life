package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    // 애플리케이션(Application) 영역 접근용 변수
    ServletContext sc;

    // 서블릿 초기화 시 호출되는 메서드
    @Override
    public void init(ServletConfig config) throws ServletException {
        sc = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Application Scope 객체 얻기
        sc.setAttribute("scopeName", "applicationScope 값");

        // Session Scope에 데이터 저장
        HttpSession session = req.getSession();
        session.setAttribute("scopeName", "sessionScope 값");

        // Request Scope에 데이터 저장
        req.setAttribute("scopeName", "requestScope 값");
        Member member = new Member("홍길동", "hong");
        req.setAttribute("member", member);

        req.getRequestDispatcher("scope.jsp").forward(req, res);
    }
}
