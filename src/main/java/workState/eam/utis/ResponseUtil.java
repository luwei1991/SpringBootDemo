package workState.eam.utis;

import java.text.SimpleDateFormat;
import java.util.Date;

import workState.eam.utis.constant.Constant;
import workState.eam.utis.constant.Responser;



/**
 * 返回结果工具类
 * @author lw 10565
 * @date 2017年7月6日
 *
 */
public class ResponseUtil {
	private static final String TAG = "ResponseUtil";
	/**
	 * @param respcode
	 * @param resultObj
	 * @param tokenid
	 * @return
	 */
	public static <T> Responser<T>  responseMessage(String respcode,T resultObj,String sessionid){
		Responser responser = new Responser();
		//当前系统时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		String nowSysTime = format.format(date);
		
		responser.setDt(nowSysTime);
		responser.setRespcode(respcode);
		responser.setResultobj(resultObj);
		responser.setSessionid(sessionid);
		return responser;
	}
	
	public static <T> Responser<T>  responseMessage(String respcode,T resultObj){
		Responser responser = new Responser();
		//当前系统时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		String nowSysTime = format.format(date);
		
		responser.setDt(nowSysTime);
		responser.setRespcode(respcode);
		responser.setResultobj(resultObj);
		return responser;
	}
	
	/**
	 * 返回成功
	 * @param resultObj
	 * @param tokenid
	 * @return
	 */
	public static <T>Responser<T> responseSuccesMessage(T resultObj,String sessionid){
		return responseMessage(Constant.ResponseCode.RESPONSE_SUCCESS, resultObj, sessionid);
	}
	/**
	 * 空值返回成功
	 * @return
	 */
	public static <T>Responser<T> responseSuccesMessage(){
		return responseMessage(Constant.ResponseCode.RESPONSE_SUCCESS,null);
	}
	
	/**
	 * 返回成功结果
	 * @return
	 */
	public static <T>Responser<T> responseSuccesMessage(T resultObj){
		return responseMessage(Constant.ResponseCode.RESPONSE_SUCCESS,resultObj);
	}
	/**
	 * 返回平台错误
	 * @return
	 */
	public static <T>Responser<T> responseServerErrorMessage(){
		
		return (Responser<T>) responseMessage(Constant.ResponseCode.RESPONSE_ERROR_STATE, "平台处理错误！");
	}
	
	/**
	 * 返回服务器正忙
	 * @return
	 */
	public static <T>Responser<T> responseServerBusyMessage(){
		
		return (Responser<T>) responseMessage(Constant.ResponseCode.RESPONSE_ERROR_SERVER_BUSY, "服务器正忙！");
	}
	/**
	 * 字段异常
	 */
	public static <T>Responser<T> responseFieldMessage(){
		
		return (Responser<T>) responseMessage(Constant.ResponseCode.RESPONSE_ERROR_PARAM, "请求参数错误！");
	}
	/**
	 * session失效
	 */
	public static <T>Responser<T> responseSessionOutMessage(){
		
		return (Responser<T>) responseMessage(Constant.ResponseCode.RESPONSE_ERROR_SESSION_OUT, "session过期或者请求无session！");
	}
	
	/**
	 * 一般错误
	 */
	public static <T>Responser<T> responseErrorMessage(T resultObj){
		
		return (Responser<T>) responseMessage(Constant.ResponseCode.RESPONSE_ERROR_PARAM, resultObj);
	}
	
	
}
