<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<style>
    /* Tổng quan về giao diện */
    body {
        font-family: 'Arial', sans-serif; /* Font chữ đơn giản */
        margin: 0;
        padding: 0;
        background-color: #f5f5f5; /* Màu nền xám nhạt */
        color: #333; /* Màu chữ */
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh; /* Chiều cao toàn màn hình */
    }

    /* Khung chính */
    .main-container {
        background-color: white; /* Nền trắng */
        width: 400px;
        padding: 30px;
        border-radius: 15px; /* Bo góc mềm mại */
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Hiệu ứng đổ bóng */
        text-align: center;
    }

    /* Tiêu đề */
    .main-container h1 {
        margin: 0 0 20px 0;
        font-size: 24px;
        color: #007bff; /* Màu xanh nổi bật */
    }

    .main-container p {
        margin: 10px 0 20px;
        font-size: 16px;
        color: #555; /* Màu chữ xám */
    }

    /* Nút đăng xuất */
    .logout-btn {
        display: inline-block;
        padding: 12px 20px;
        background-color: #ff4d4d; /* Màu đỏ tươi */
        color: white;
        font-size: 16px;
        font-weight: bold;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: all 0.3s ease-in-out;
    }

    .logout-btn:hover {
        background-color: #e60000; /* Màu đỏ đậm khi hover */
    }
</style>
</head>
<body>

    <!-- Nội dung chính -->
    <div class="main-container">
        <h1>Chào mừng, User!</h1>
        <p>Đăng xuất để thoát khỏi phiên làm việc hiện tại.</p>
        
        <!-- Nút đăng xuất -->
        <form action="${pageContext.request.contextPath}/login" method="get">

            <button type="submit" class="logout-btn">Đăng xuất</button>
        </form>
    </div>

</body>
</html>
