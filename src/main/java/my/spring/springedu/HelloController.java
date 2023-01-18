package my.spring.springedu;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
@Controller
public class HelloController {	
	public HelloController() {
		System.out.println("HelloController Create object");
	}
	@RequestMapping("/hello")
	public ModelAndView xxx(HttpServletRequest req){
		InternalResourceView view = new InternalResourceView("/resources/staticview.html");
		ModelAndView viewModel = new ModelAndView(view);
		return viewModel;
	}	
}




