package vn.iotstar.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBconnect;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoIplm extends DBconnect implements IUserDao {

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM users";
        List<UserModel> list = new ArrayList<>();
        try {
            conn = new DBconnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new UserModel(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("images"),
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getInt("roleid"),
                    rs.getDate("createDate")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return list;
    }

    @Override
    public UserModel findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            conn = new DBconnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new UserModel(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("images"),
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getInt("roleid"),
                    rs.getDate("createDate")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return null;
    }

    @Override
    public void insert(UserModel user) {
        String sql = "INSERT INTO users (username, password, images, fullname, email, phone, roleid, createDate) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBconnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getImages());
            ps.setString(4, user.getFullname());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhone());
            ps.setInt(7, user.getRoleid());
            ps.setDate(8, user.getCreateDate());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
    }

    @Override
    public UserModel findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            conn = new DBconnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new UserModel(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("images"),
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getInt("roleid"),
                    rs.getDate("createDate")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return null;
    }

    @Override
    public boolean checkExistEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            conn = new DBconnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            conn = new DBconnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        String sql = "SELECT * FROM users WHERE phone = ?";
        try {
            conn = new DBconnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return false;
    }

    @Override
    public boolean updatePasswordByUsernameAndEmail(String username, String email, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE username = ? AND email = ?";
        try {
            conn = new DBconnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, username);
            ps.setString(3, email);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
        return false;
    }

    private void closeResources(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void insertregister(UserModel user) {
        String sql = "INSERT INTO users (email, username, fullname, password, phone, roleid, code) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBconnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getPhone());
            ps.setInt(6, user.getRoleid());
            ps.setString(7, user.getCode());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
    }

    @Override
    public void update(UserModel user) {
        String sql = "UPDATE users SET email = ?, username = ?, fullname = ?, password = ?, phone = ?, roleid = ?, code = ? WHERE id = ?";
        try {
            conn = new DBconnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getPhone());
            ps.setInt(6, user.getRoleid());
            ps.setString(7, user.getCode());
            ps.setInt(8, user.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, conn);
        }
    }

    @Override
    public boolean checkExistUserNameAndEmail(String username, String email) {
        String sql = "SELECT * FROM users WHERE username = ? AND email = ?";
        try {
            conn = new DBconnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            return rs.next(); // Trả về true nếu tìm thấy bản ghi khớp
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        return false;
    }


    // Test method
    public static void main(String[] args) {
        UserDaoIplm userDao = new UserDaoIplm();
        try {
            List<UserModel> users = userDao.findAll();
            users.forEach(System.out::println);

            UserModel user = userDao.findByUsername("thang");
            System.out.println(user);

            boolean exists = userDao.checkExistEmail("example@gmail.com");
            System.out.println("Email exists: " + exists);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
