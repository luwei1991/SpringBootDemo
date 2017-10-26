package workState;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldTest {
	@RequestMapping
	public String  sayHello(){
		return "hello world";
		
	}
	

}
