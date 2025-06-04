package org.snack.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vote-form")
public class VoteFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String snack = req.getParameter("snack");
        req.setAttribute("snack", snack);

        req.getRequestDispatcher("vote_form.jsp").forward(req, res);
    }
}
