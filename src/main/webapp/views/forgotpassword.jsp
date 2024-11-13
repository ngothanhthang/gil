<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên Mật Khẩu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .forgot-container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .form-actions {
            margin-top: 20px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .alert {
            color: red;
            font-size: 14px;
            margin-bottom: 10px;
        }
        a {
            margin-top: 15px;
            display: inline-block;
            font-size: 14px;
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="forgot-container">
        <h1>Quên Mật Khẩu</h1>
        <!-- Hiển thị thông báo lỗi hoặc thành công -->
        <c:if test="${not empty alert}">
            <div class="alert">${alert}</div>
        </c:if>
        <form action="${pageContext.request.contextPath}/forgotpassword" method="post">
            <div class="form-group">
                <label for="uname">Tài khoản:</label>
                <input type="text" id="uname" name="uname" placeholder="Nhập tài khoản" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" placeholder="Nhập email" required>
            </div>
            <div class="form-group">
                <label for="newPassword">Mật khẩu mới:</label>
                <input type="password" id="newPassword" name="newPassword" placeholder="Nhập mật khẩu mới" required>
            </div>
            <div class="form-actions">
                <button type="submit">Đặt lại mật khẩu</button>
            </div>
        </form>
        <a href="${pageContext.request.contextPath}/login">Quay lại đăng nhập</a>
    </div>
</body>
</html>
