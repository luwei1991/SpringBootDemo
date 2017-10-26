package workState.eam.user.domain;
/**
 * 登录
 * @author lw 10565
 * @date 2017年7月7日
 *
 */
public class Loginer {
	//登录号
	private int userId;
	//登录密码
	private String passwd;
	//登录时间
	private String loginTiem;
	
	private String  plateform;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getLoginTiem() {
		return loginTiem;
	}
	public void setLoginTiem(String loginTiem) {
		this.loginTiem = loginTiem;
	}
	public String getPlateform() {
		return plateform;
	}
	public void setPlateform(String plateform) {
		this.plateform = plateform;
	}
	
	
	

}
