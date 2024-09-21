package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.Impl.UserDaoIplm;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class userService implements IUserService{

	IUserDao userdao=new UserDaoIplm();
	@Override
	public UserModel login(String username, String password) {
		UserModel user=this.FindbyUserName(username);
		if(user!=null && password.equals(user.getPassword()))
		{
			return user;
		}
		return null;
	}

	@Override
	public UserModel FindbyUserName(String username) {
		return userdao.findByUsername(username);
	}
	
}
