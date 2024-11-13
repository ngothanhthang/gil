package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();
	UserModel findById(int id);
	void insert(UserModel user);
	UserModel findByUsername(String username);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	boolean updatePasswordByUsernameAndEmail(String username, String email, String newPassword);
	void insertregister(UserModel user);
	void update(UserModel user);
	boolean checkExistUserNameAndEmail(String username, String email);
}
