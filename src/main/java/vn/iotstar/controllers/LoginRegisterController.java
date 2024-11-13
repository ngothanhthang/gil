package vn.iotstar.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.userService;
import vn.iotstar.utils.Constant;

@WebServlet(urlPatterns = { "/login", "/register" })
public class LoginRegisterController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    IUserService service = new userService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI(); // Lấy đường dẫn URI đầy đủ
        if (url.contains("/login")) {
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp); // Hiển thị trang login
        } else if (url.contains("/register")) {
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp); // Hiển thị trang register
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI(); // Lấy đường dẫn URI đầy đủ

        if (url.contains("/login")) {
            // Xử lý đăng nhập
            String username = req.getParameter("uname");
            String password = req.getParameter("psw");
            String remember = req.getParameter("remember"); // Lấy giá trị từ checkbox "Remember Me"

            boolean isRememberMe = "on".equals(remember); // Kiểm tra checkbox "Remember Me" có được chọn không
            String alertMsg = "";

            if (username.isEmpty() || password.isEmpty()) {
                alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
                return;
            }

            UserModel user = service.login(username, password);
            if (user != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("account", user);

                if (isRememberMe) {
                    // Gọi hàm lưu cookie
                    saveRememberMe(resp, username);
                }
                resp.sendRedirect(req.getContextPath() + "/waiting");
            } else {
                alertMsg = "Tài khoản hoặc mật khẩu không đúng";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            }
        } else if (url.contains("/register")) {
            // Xử lý đăng ký
            String username = req.getParameter("uname");
            String password = req.getParameter("psw");
            String email = req.getParameter("email");
            String fullname = req.getParameter("fname");
            String alertMsg = "";

            if (service.checkExistEmail(email)) {
                alertMsg = "Email đã tồn tại!";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            } else if (service.checkExistUsername(username)) {
                alertMsg = "Tài khoản đã tồn tại!";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            } else {
                boolean isSuccess = service.register(email, password, username, fullname, "default.jpg");
                if (isSuccess) {
                    resp.sendRedirect(req.getContextPath() + "/login");
                } else {
                    alertMsg = "Lỗi hệ thống, vui lòng thử lại!";
                    req.setAttribute("alert", alertMsg);
                    req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
                }
            }
        }
    }
    private void saveRememberMe(HttpServletResponse resp, String username) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30 * 60); // Cookie tồn tại trong 30 phút
        resp.addCookie(cookie);
    }

}
