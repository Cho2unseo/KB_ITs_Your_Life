package org.snack.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vote-submit")
public class VoteSubmitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String snack = req.getParameter("snack");
        req.setAttribute("snack", snack);
        Cookie[] cookies = req.getCookies();
        Cookie c = null;
        if (cookies == null || cookies.length == 0) {
            c = new Cookie("snack", snack);
        } else {
            c = new Cookie("lastSnack", snack);
        }
        c.setMaxAge(60 * 60);
        res.addCookie(c);
        req.getRequestDispatcher("vote_result.jsp").forward(req, res);
    }
}
