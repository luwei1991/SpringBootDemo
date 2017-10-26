package workState.eam.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import workState.eam.user.domain.Loginer;
import workState.eam.user.domain.User;

/**
 * UsuserDAO操作数据库数据，增、删、改、查，用户信息。
 * @author lw 10565
 * @date 2017年7月3日
 *
 */
@Mapper  //注解为myties
public interface UserDao {
	
	/*
	 * 根据用户名id查询用户信息
	 */
	@Select("SELECT * FROM USER_INFO WHERE USER_ID = #{user_id}")
	@Results({
		@Result(property = "userId", column = "user_id"),
		@Result(property = "userName", column = "user_name"),
		@Result(property = "userAge", column = "user_age"),
		@Result(property = "userSex", column = "user_sex"),
		@Result(property = "userAddTime", column = "user_addtime"),
		@Result(property = "userMail", column = "user_mail"),
		@Result(property = "userMobile", column = "user_mobile"),
		@Result(property = "userDeparId", column = "user_departid"),
	})
	User findById (@Param("user_id") int userId);
	
	/*
	 *增加用户信息 
	 */
	@Insert("INSERT INTO USER_INFO(user_name,user_age,user_sex,user_addtime,user_mail,user_mobile,user_departid,plateform) values(#{userName},#{userAge},#{userSex},#{userAddTime},#{userMail},#{userMobile},#{userDeparId},#{plateform})")
	@Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id") 
	public int insertUser(User user);
      
	
}
