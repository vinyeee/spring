package my.spring.springedu;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vo.MyVO;
@Controller
public class TestModelController1 {
	@ModelAttribute("v1")
	public String createString() {
		System.out.println("객체 생성 자동호출1");
		return "테스트!!";
	}
	@ModelAttribute("v2")
	public int[] createArray() {
		System.out.println("객체 생성 자동호출2");
		return new int[]{10, 20, 30, 40, 50};
	}
	@ModelAttribute("v3")
	public MyVO createVO() {
		System.out.println("객체 생성 자동호출3");
		MyVO vo = new MyVO();
		vo.setMyColor("yellow");
		vo.setMyNumber(23);
		return vo;
	}	
	@ModelAttribute("v4")
	public Date createDate() {
		System.out.println("객체 생성 자동호출4");		
		return new Date();
	}	
	@RequestMapping("/modeltest")
	public String handle() {
		System.out.println("handle() 메서드 호출");		
		return "modelResult";
	}
}



