package workState;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
/**
 * 
 * @author lw 10565
 * @date 2017年6月28日
 * spring boot 应用启动类
 */
@SpringBootApplication
//mapper 接口类扫描包配置
@MapperScan("workState.eam.user.*.dao")
public class Application extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	
	public static void main(String[] args) {
		//程序启动入口
		//启动嵌入式的Tomcat并初始化Spring环境及其各Spring组件
		SpringApplication.run(Application.class,args);
	
	}
	

}
