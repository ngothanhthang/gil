package vn.iotstar.services;


import vn.iotstar.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	
	UserModel FindbyUserName(String username);
	
	void insert(UserModel user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);

	boolean register(String email, String password, String username, String fullname, String images);

	void update(UserModel user);

	boolean checkExistUserNameAndEmail(String username, String email);

	boolean updatePasswordByUsernameAndEmail(String username, String email, String newPassword);
}
