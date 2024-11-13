package vn.iotstar.services.impl;

import java.sql.Date;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.Impl.UserDaoIplm;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class userService implements IUserService {

    // Khởi tạo đối tượng DAO
    IUserDao userDao = new UserDaoIplm();

    @Override
    public UserModel login(String username, String password) {
        // Gọi hàm FindbyUserName để lấy thông tin người dùng
        UserModel user = this.FindbyUserName(username);
        if (user != null && password.equals(user.getPassword())) {
            return user; // Trả về người dùng nếu thông tin đăng nhập hợp lệ
        }
        return null; // Trả về null nếu không hợp lệ
    }

    @Override
    public UserModel FindbyUserName(String username) {
        // Gọi hàm DAO để tìm người dùng theo tên đăng nhập
        return userDao.findByUsername(username);
    }

    @Override
    public void insert(UserModel user) {
        // Gọi hàm DAO để thêm người dùng mới
        userDao.insert(user);
    }

    @Override
    public boolean register(String email, String password, String username, String fullname, String images) {
        // Kiểm tra sự tồn tại của username và email
        if (userDao.checkExistUsername(username) || userDao.checkExistEmail(email)) {
            return false; // Không đăng ký nếu username hoặc email đã tồn tại
        }
        // Lấy ngày hiện tại
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        // Tạo và thêm người dùng mới
        userDao.insert(new UserModel(0, username, password, images, fullname, email, null, 5, date));
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        // Kiểm tra email có tồn tại không
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        // Kiểm tra username có tồn tại không
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        // Kiểm tra số điện thoại có tồn tại không
        return userDao.checkExistPhone(phone);
    }

    @Override
    public void update(UserModel user) {
        // Gọi hàm DAO để cập nhật thông tin người dùng
        userDao.update(user);
    }

    @Override
    public boolean checkExistUserNameAndEmail(String username, String email) {
        // Kiểm tra sự tồn tại của username và email đồng thời
        return userDao.checkExistUserNameAndEmail(username, email);
    }

    @Override
    public boolean updatePasswordByUsernameAndEmail(String username, String email, String newPassword) {
        // Cập nhật mật khẩu dựa trên username và email
        return userDao.updatePasswordByUsernameAndEmail(username, email, newPassword);
    }
}
