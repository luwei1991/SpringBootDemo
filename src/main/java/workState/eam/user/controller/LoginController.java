package workState.eam.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
 * 登录控制
 * @author lw 10565
 * @date 2017年7月7日
 *
 */
@RestController
@RequestMapping({"/user"})
public class LoginController extends BaseController{
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;
	/**
	 * 
	 * @param session
	 * @param userId 用户账号
	 * @param password 用户密码
	 * @param pv 协议版本
	 * @param plateform 平台分0：Android 1:IOS 2:其他
	 * @param dt 时间戳
	 * @return
	 */
	@RequestMapping("/login")
	public <T> Responser<T> login(HttpSession session,@RequestParam(value = "userId",required = true) String userId,
			@RequestParam(value = "userpassword",required = true) String password,
			@RequestParam(value = "pv",required = true) String pv,
			@RequestParam(value = "plateform",required = true) String plateform,
			@RequestParam(value = "dt",required = true) String dt
			){
		logger.info("=======longin========");
		//判断接口协议
		if(pv.equals(Constant.ProtocolVersion.PROTOCOL_VERSION_1)){
			//输入的用户id和密码提示（应该提示用户名或者密码输入有误）
			Loginer loginer = loginService.loginByIdAndPwd(Integer.parseInt(userId), password);
			if(null != loginer){//登录成功
				session.setAttribute(userId,password);
				String seesionid = session.getId();
				//更新用户登录信息
				loginer.setLoginTiem(dt);
				loginer.setPlateform(plateform);
				loginService.updateLoginInfo(loginer);
				//将用户的基本信息返回
				User user = userService.findById(Integer.parseInt(userId));
				return (Responser<T>) ResponseUtil.responseSuccesMessage(user,seesionid);
			}else{
				//判读是无此用户还是密码错误！
				Loginer loginer1 = loginService.findById(Integer.parseInt(userId));
				if(null != loginer1){
					return (Responser<T>) ResponseUtil.responseSuccesMessage("用户名或者密码错误！");
				}else{
					return (Responser<T>) ResponseUtil.responseSuccesMessage("无此用户！");
				}
			}
		}else{//如果版本协议不对
			return (Responser<T>) ResponseUtil.responseFieldMessage();
		}
		
	
		
	}
	
	/**
	 * 登出
	 * @param session
	 * @param userId
	 * @return
	 */
	@RequestMapping("/logout")
	public <T> Responser<T> logout(HttpSession session,@RequestParam(value = "userId",required = true) String userId,
			@RequestParam(value = "pv",required = true) String pv,
			@RequestParam(value = "plateform",required = true) String plateform,
			@RequestParam(value = "dt",required = true) String dt
			){
		logger.info("=======logout========");
		//先判断是否存在这个session
		if(null != session.getAttribute(userId)){
			//登出
			Loginer loginer1 = loginService.findById(Integer.parseInt(userId));
			if(null != loginer1){
				session.removeAttribute(userId);
				return (Responser<T>) ResponseUtil.responseSuccesMessage("登出成功！");
			}else{
				return (Responser<T>) ResponseUtil.responseSuccesMessage("登录失败！");
			}
		}else{
			 return (Responser<T>) ResponseUtil.responseSessionOutMessage();
			
		}
		
	
		
	}
	

}
