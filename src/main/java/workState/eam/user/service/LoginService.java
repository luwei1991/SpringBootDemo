package workState.eam.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import workState.eam.user.dao.LoginDao;
import workState.eam.user.domain.Loginer;
import workState.eam.user.domain.User;

/**
 * 登录服务
 * @author lw 10565
 * @date 2017年7月7日
 *
 */
@Service
public class LoginService {
	@Autowired
	private LoginDao loginDao;
	

	/*
	 * 登录(根据用户id和密码查找是否存在)
	 */
	public Loginer loginByIdAndPwd(int userId,String password){
		return loginDao.findByIDAndPwd(userId, password);
	}
	
	/*
	 * 根据id查询用户是否存在
	 */
	
	public Loginer findById(int userId){
		return loginDao.findByID(userId);
	}
	
	
	
	public int updateLoginInfo(Loginer loginer){
		return loginDao.updateLoginInfo(loginer);
	}
	
	public int addLoginInfo(Loginer loginer){
		return loginDao.insertLogin(loginer);
		
	}
	

}
