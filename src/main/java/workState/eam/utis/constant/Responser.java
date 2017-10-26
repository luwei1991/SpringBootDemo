package workState.eam.utis.constant;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 接口返回对象定义
 * @author lw 10565
 * @param <T>
 * @date 2017年7月5日
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)//自动屏蔽为字段为null的
public class Responser<T> {
	//返回码
	private String respcode;
	
	private String sessionid;
	//当前系统时间
	private String dt;
	
	private T  resultobj;
	
	public static <T> Responser< T>  newInshtance(){
		return new Responser<T>();
	}

	public String getRespcode() {
		return respcode;
	}

	public void setRespcode(String respcode) {
		this.respcode = respcode;
	}



	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public T getResultobj() {
		return resultobj;
	}

	public void setResultobj(T resultobj) {
		this.resultobj = resultobj;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}


	

}
