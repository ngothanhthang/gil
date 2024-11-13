package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.userService;

@WebServlet(urlPatterns = { "/forgotpassword" })
public class ForgotPasswordController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    IUserService service = new userService(); // Service xử lý logic người dùng

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Hiển thị trang quên mật khẩu
        req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // Lấy thông tin từ form
        String username = req.getParameter("uname");
        String email = req.getParameter("email");
        String newPassword = req.getParameter("newPassword");
        String alertMsg = "";

        // Kiểm tra xem username và email có tồn tại và khớp hay không
        if (!service.checkExistUserNameAndEmail(username, email)) {
            alertMsg = "Tài khoản hoặc email không đúng!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
        } else {
            // Nếu tồn tại, cập nhật mật khẩu mới
            boolean isSuccess = service.updatePasswordByUsernameAndEmail(username, email, newPassword);

            if (isSuccess) {
                // Nếu cập nhật thành công, chuyển về trang đăng nhập với thông báo thành công
                req.setAttribute("alert", "Mật khẩu đã được cập nhật thành công!");
                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            } else {
                // Nếu có lỗi trong quá trình cập nhật mật khẩu
                alertMsg = "Lỗi hệ thống, vui lòng thử lại!";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
            }
        }
    }
}
