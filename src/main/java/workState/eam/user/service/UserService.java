package workState.eam.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import workState.eam.user.dao.UserDao;
import workState.eam.user.domain.Loginer;
import workState.eam.user.domain.User;

/**
 * 处理用户业务逻辑
 * @author lw 10565
 * @date 2017年7月3日
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	

	/*
	 * 根据用户id查询用户信息
	 */
	public User findById(int userId){
		return userDao.findById(userId);
	}
	/**
	 * 增加用户信息
	 * @param user
	 * @return
	 */
    public int addUser(User user){
    	return userDao.insertUser(user);
    }
	
}
