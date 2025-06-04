package org.scoula.ex05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // [1] 클라이언트로부터 전달된 파라미터(아이디, 비밀번호)를 가져옴
        String userid = req.getParameter("userid");
        String passwd = req.getParameter("passwd");

        // [2] JSP에서 사용할 수 있도록 request 영역에 데이터 저장
        req.setAttribute("userid", userid);
        req.setAttribute("passwd", passwd);

        // [3] login.jsp로 포워딩 (forward 방식으로 JSP에 request 그대로 전달)
        req.getRequestDispatcher("login.jsp").forward(req, res);
    }


}
