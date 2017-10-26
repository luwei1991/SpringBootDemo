package workState.eam.utis;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import workState.eam.utis.constant.Responser;

/**
 * 自定义异常处理类
 * @author lw 10565
 * @date 2017年7月6日
 *
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class MyException {
	Logger logger =  org.slf4j.LoggerFactory.getLogger(this.getClass());
	/**
	 * 返回运行时异常信息服务器错误
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value= RuntimeException.class)
	private<T>Responser<T> RuntimeExceptionHandler(Exception e){
		logger.info(e.getMessage());
		return ResponseUtil.responseServerErrorMessage();
	}

}
