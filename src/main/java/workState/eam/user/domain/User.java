package workState.eam.user.domain;

import java.io.Serializable;

/**
 * User用户实体类
 * @author lw 10565
 * @date 2017年7月3日
 *
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 4295008175160615532L;
	
	//用户名
	private  String userName;
	//年龄
	private int userAge;
	// 用户id
	private String userId;
	//性别
	private String userSex;
	//注册时间
	private String userAddTime;
	//用户邮箱
	private String userMail;
	//用户手机号码
	private String userMobile;
	//用户部门编号
	private int  userDeparId;
	//注册平台
	private String plateform;
	
	
	
	public String getPlateform() {
		return plateform;
	}
	public void setPlateform(String plateform) {
		this.plateform = plateform;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public String getUserAddTime() {
		return userAddTime;
	}
	public void setUserAddTime(String userAddTime) {
		this.userAddTime = userAddTime;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public int getUserDeparId() {
		return userDeparId;
	}
	public void setUserDeparId(int userDeparId) {
		this.userDeparId = userDeparId;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	
	
	

}
