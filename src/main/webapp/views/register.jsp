<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký</title>
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
        .register-container {
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
        input[type="text"], input[type="password"], input[type="email"] {
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
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #218838;
        }
        .alert {
            color: red;
            font-size: 14px;
            margin-bottom: 10px;
        }
        .login-link {
            margin-top: 15px;
            font-size: 14px;
            color: #007bff;
            text-decoration: none;
        }
        .login-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h1>Đăng Ký</h1>
        <!-- Hiển thị thông báo lỗi -->
        <c:if test="${not empty alert}">
            <div class="alert">${alert}</div>
        </c:if>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <label for="uname">Tài khoản:</label>
                <input type="text" id="uname" name="uname" placeholder="Nhập tài khoản">
            </div>
            <div class="form-group">
                <label for="psw">Mật khẩu:</label>
                <input type="password" id="psw" name="psw" placeholder="Nhập mật khẩu">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Nhập email">
            </div>
            <div class="form-group">
                <label for="fname">Họ tên:</label>
                <input type="text" id="fname" name="fname" placeholder="Nhập họ tên">
            </div>
            <div class="form-actions">
                <button type="submit">Đăng Ký</button>
            </div>
        </form>
        <a href="${pageContext.request.contextPath}/login" class="login-link">Đã có tài khoản? Đăng nhập ngay</a>
    </div>
</body>
</html>
