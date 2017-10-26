package workState.eam.utis.constant;
/**
 * 常量定义类
 * @author lw 10565
 * @date 2017年7月5日
 *
 */
public final class Constant {
	
	
	/**
	 * 返回码定义
	 * @author lw 10565
	 * @date 2017年7月5日
	 *
	 */
	public final class ResponseCode{
		/**成功*/
		public static final String RESPONSE_SUCCESS = "S000";
		/**平台处理错误。*/
		public static final String RESPONSE_ERROR_STATE = "E901";
		/**平台处理繁忙*/
		public static final String RESPONSE_ERROR_SERVER_BUSY = "E902";
		/**session过期或者请求无session*/
		public static final String RESPONSE_ERROR_SESSION_OUT = "E904";
		/**请求参数不对*/
		public static final String RESPONSE_ERROR_PARAM = "E905";
		
		
	}
	
	/**
	 * 接口协议版本
	 * @author lw 10565
	 * @date 2017年7月12日
	 *
	 */
	public final class ProtocolVersion{
		/**1.0协议*/
		public static final String PROTOCOL_VERSION_1 = "1.0";
		
	}
	
	

}
