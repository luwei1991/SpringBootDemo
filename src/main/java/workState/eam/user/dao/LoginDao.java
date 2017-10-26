package workState.eam.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import workState.eam.user.domain.Loginer;
import workState.eam.user.domain.User;

/**
 * 登录操作类 操作登录表
 * @author lw 10565
 * @date 2017年7月7日
 *
 */
@Mapper
public interface LoginDao {
	/*
	 * 根据用户名id和密码查询
	 */
	@Select("SELECT * FROM LOGIN_INFO WHERE USER_ID = #{user_id} AND USER_PASSWORD = #{user_password}")
	@Results({
		@Result(property = "passwd", column = "user_password"),
		@Result(property = "userId", column = "user_id"),
		@Result(property = "loginTiem", column = "user_logintime"),
		
	})
	Loginer findByIDAndPwd (@Param("user_id") int userId,@Param("user_password") String password);
	
	       
	/*
	 *查询是否有该id用户 
	 */
	@Select("SELECT * FROM LOGIN_INFO WHERE USER_ID = #{user_id}")
	@Results({
		@Result(property = "passwd", column = "user_password"),
		@Result(property = "userId", column = "user_id"),
		@Result(property = "loginTiem", column = "user_logintime"),
		
	})
	Loginer findByID (@Param("user_id") int userId);
	
	
	/*
	 * 更新登录信息
	 */
	@Update("UPDATE LOGIN_INFO SET USER_LOGINDATE = #{loginTiem},USER_PLATEFORM = #{plateform}  WHERE USER_ID = #{userId}")
	int updateLoginInfo(Loginer loginer);//返回的事更新了几个数据
	

	/*
	 *增加用户信息 
	 */
	@Insert("INSERT INTO LOGIN_INFO(user_id,user_password,user_logindate,user_plateform) values (#{userId},#{passwd},#{loginTiem},#{plateform})")
	int insertLogin(Loginer loginer);
	
	/*
	 * 更改登录密码
	 */
	
	@Update("UPDATE LOGIN_INFO SET USER_PASSWORD = #{password}  WHERE USER_ID = #{userId}")
	int updatePassWord(Loginer loginer);//返回的事更新了几个数据
	
	

}
