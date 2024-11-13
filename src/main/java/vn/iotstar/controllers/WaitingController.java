package vn.iotstar.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy session hiện tại
        HttpSession session = req.getSession();

        // Kiểm tra session và thông tin người dùng
        if (session != null && session.getAttribute("account") != null) {
            UserModel user = (UserModel) session.getAttribute("account");

            // Đặt thuộc tính username cho giao diện (nếu cần)
            req.setAttribute("username", user.getUsername());

            // Phân quyền dựa trên roleId
            if (user.getRoleid() == 1) {
                // Admin
                resp.sendRedirect(req.getContextPath() + "/admin/home");
            } else if (user.getRoleid() == 2) {
                // Manager
                resp.sendRedirect(req.getContextPath() + "/manager/home");
            } else {
                // Người dùng bình thường
                resp.sendRedirect(req.getContextPath() + "/home");
            }
        } else {
            // Nếu session không hợp lệ, chuyển về trang đăng nhập
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
