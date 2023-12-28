package com.Hieucompany.bundesliga.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hieucompany.bundesliga.dao.BundesligaDAO;
import com.Hieucompany.bundesliga.model.Fixture;

@WebServlet("/bundesliga")
public class BundesligaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BundesligaDAO bundesligaDAO;

    public void init() {
        bundesligaDAO = new BundesligaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy danh sách đội bóng và trận đấu từ cơ sở dữ liệu
        List<String> teams = bundesligaDAO.getAllTeams();
        List<Fixture> fixtures = bundesligaDAO.getAllFixtures();

        // Đặt dữ liệu vào request để chuyển đến JSP
        request.setAttribute("teams", teams);
        request.setAttribute("fixtures", fixtures);

        // Chuyển hướng đến trang JSP để hiển thị dữ liệu
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý các thao tác POST nếu cần

        // Ví dụ: Thêm mới một trận đấu
        String homeTeam = request.getParameter("homeTeam");
        String awayTeam = request.getParameter("awayTeam");
        String matchDate = request.getParameter("matchDate");

        Fixture newFixture = new Fixture(homeTeam, awayTeam, matchDate);
        boolean success = bundesligaDAO.addFixture(newFixture);

        if (success) {
            // Thêm thành công, có thể chuyển hướng hoặc gửi thông báo về trang JSP
            response.sendRedirect(request.getContextPath() + "/bundesliga");
        } else {
            // Xử lý khi thêm không thành công
            response.getWriter().println("Failed to add fixture.");
        }
    }
}
