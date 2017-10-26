package workState.eam.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import workState.eam.BaseController;
import workState.eam.user.domain.Loginer;
import workState.eam.user.domain.User;
import workState.eam.user.service.LoginService;
import workState.eam.user.service.UserService;
import workState.eam.utis.ResponseUtil;
import workState.eam.utis.constant.Constant;
import workState.eam.utis.constant.Responser;

/**
 * usercontroller 用户控制,用户信息的增删改查
 * @author lw 10565
 * @date 2017年7月3日
 *
 */
@RestController
@RequestMapping({"/user"})
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private LoginService loginService;
	
	/**
	 * 注册用户
	 * @param session
	 * @param userId
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public <T> Responser<T> addUserInfo(@RequestParam(value = "userName",required = true) String userName,
			@RequestParam(value = "userAge",required = true) String userAge,
			@RequestParam(value = "userSex",required = true) String userSex,
			@RequestParam(value = "userMail",required = true) String userMail,
			@RequestParam(value = "userMobile",required = true) String userMobile,
//			@RequestParam(value = "userDepartid",required = true) String userDepartid,
			@RequestParam(value = "password",required = true) String password,
			@RequestParam(value = "pv",required = true) String pv,
			@RequestParam(value = "dt",required = true) String dt,
			@RequestParam(value = "plateform",required = true) String plateform
			
			){
		if(pv.equals(Constant.ProtocolVersion.PROTOCOL_VERSION_1)){
			User user = new User();
			user.setUserName(userName);
			user.setUserAddTime(dt);
			user.setUserAge(Integer.parseInt(userAge));
//			user.setUserDeparId(Integer.parseInt(userDepartid));
			user.setUserMail(userMail);
			user.setUserMobile(userMobile);
			user.setUserSex(userSex);
			user.setPlateform(plateform);
			int count = userService.addUser(user);
			logger.info("=======add========"+user.getUserId());
			Loginer loginer = new Loginer();
			loginer.setUserId(Integer.parseInt(user.getUserId()));
		    loginer.setPasswd(password);
		    loginService.addLoginInfo(loginer);
			return (Responser<T>) ResponseUtil.responseSuccesMessage("注册成功！");
		}else{
			return ResponseUtil.responseFieldMessage();
		}
		
		
	}
	
	/**
	 * 更新密码
	 * @param session
	 * @param userId
	 * @return
	 */
	@RequestMapping("/uppassword")
	@Transactional  //事务控制
	public <T> Responser<T> upPassword(HttpSession session,@RequestParam(value = "userId",required = true) String userId,
			@RequestParam(value = "pv",required = true) String pv,
			@RequestParam(value = "dt",required = true) String dt,
			@RequestParam(value = "oldpsw",required = true) String oldpsw,
			@RequestParam(value = "newpsw",required = true) String newpsw
			){
		//先判断是否存在这个session
		logger.info("=======uppassword========");
		if(null != session.getAttribute(userId)){
			if(pv.equals(Constant.ProtocolVersion.PROTOCOL_VERSION_1)){
				//验证原密码的正确性
				Loginer oldLoginer = loginService.loginByIdAndPwd(Integer.parseInt(userId), oldpsw);	
				if(null != oldLoginer){
					oldLoginer.setPasswd(newpsw);
					int i = loginService.updateLoginInfo(oldLoginer);
					if(i != 0){
						//密码修改成功后，清除session
						session.removeAttribute(userId);
						return (Responser<T>) ResponseUtil.responseSuccesMessage("修改成功，请重新登录！");
					}else{
						return (Responser<T>) ResponseUtil.responseErrorMessage("修改失败，数据库更新失败！");
					}
				}else{
					 return (Responser<T>) ResponseUtil.responseErrorMessage("原密码不正确，请重新确认后再提交！");
				}
			}else{
				return (Responser<T>) ResponseUtil.responseFieldMessage();
			}
		}else{
			 return (Responser<T>) ResponseUtil.responseSessionOutMessage();
		}
		
	
	}
}