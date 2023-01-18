package my.spring.springedu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping(value="/requestmethod")
public class RequestMethodController {
	
	public RequestMethodController() {
		System.out.println("RequestMethodController 객체 생성");
	}
	@RequestMapping(method=RequestMethod.GET)
	//@GetMapping
	public String myGet() {
		System.out.println("GET 방식 요청 처리............");
		return  "getResult";
	}	
	@RequestMapping(method=RequestMethod.POST)
	//@PostMapping
	public String myPost() {
		System.out.println("POST 방식 요청 처리............");
		return  "postResult";
	}
}



