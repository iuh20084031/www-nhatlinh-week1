package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ControlServlet")
public class ControlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("action1")) {
                // Thực hiện hành động 1
                response.getWriter().write("Action 1 được thực hiện.");
            } else if (action.equals("action2")) {
                // Thực hiện hành động 2
                response.getWriter().write("Action 2 được thực hiện.");
            } else {
                // Xử lý khi action không được xác định
                response.getWriter().write("Action không hợp lệ.");
            }
        } else {
            // Xử lý khi không có tham số "action"
            response.getWriter().write("Vui lòng cung cấp tham số 'action'.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
