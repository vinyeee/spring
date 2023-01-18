package my.spring.springedu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.MyModel;
@Controller
public class ResponseBodyController {
	@RequestMapping(value = "/body/text/{id}", produces="text/plain; charset=utf-8")
	@ResponseBody
	public String getByIdInTEXT(@PathVariable String id) {
		return "<h1>컨트롤러에서 바로 문자열을 리턴해요 : "+id+"</h1>";
	}
	@RequestMapping(value = "/body/htmltext/{id}", 	produces="text/html; charset=utf-8")
	@ResponseBody
	public String getByIdInHTMLTEXT(@PathVariable String id) {
		return "<h1>컨트롤러에서 바로 HTML 문자열을 리턴해요 : " + id +"</h1>";
	}
	@RequestMapping(value = "/body/json/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public MyModel getByIdInJSON(@PathVariable String id) {
		MyModel my = new MyModel();
		my.setFlowerName("장미");
		my.setNum(5);
		my.setId(id);
		return my;
	}	
	@RequestMapping(value = "/body/xml/{id}", produces = "text/xml; charset=utf-8")
	@ResponseBody
	public MyModel getByIdInXML(@PathVariable String id) {
		MyModel my = new MyModel();
		my.setFlowerName("장미");
		my.setNum(5);
		my.setId(id);
		return my;
	}
	@RequestMapping(value = "/body/html/{id}")
	public String getByIdInHTML(@PathVariable String id, Model model) {
		MyModel my = new MyModel();
		my.setFlowerName("장미");
		my.setNum(5);
		my.setId(id);
		model.addAttribute("my", my);
		return "myhtml";
	}	
}
