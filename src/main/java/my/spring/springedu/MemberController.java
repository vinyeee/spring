package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vo.MemberVO;

@Controller
public class MemberController {	
	
	@PostMapping("/member1")
	protected ModelAndView proc1(@RequestParam(value = "name", defaultValue = "없음") String name,
			@RequestParam(value = "phone", defaultValue = "없음") String phone,
			@RequestParam(value = "id", defaultValue = "없음") String id,			
			@RequestParam(value = "password", defaultValue = "없음") String password) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("id", id);
		mav.addObject("phone", phone);
		mav.addObject("password", password);
		mav.setViewName("memberView");
		return mav;
	}
	
	@PostMapping("/member2")
	public ModelAndView proc2(MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		if( vo.getName() == null || vo.getName().equals("")) 			
			vo.setName("없음"); 
		if( vo.getPhone() == null || vo.getPhone().equals("")) 
			vo.setPhone("없음");
		if( vo.getId() == null || vo.getId().equals("")) 
			vo.setId("없음");
		if( vo.getPassword() == null || vo.getPassword().equals("")) 
			vo.setPassword("없음");				
		mav.addObject("member", vo);
		mav.setViewName("memberView");
		return mav;
	}
	
	@PostMapping("/member3")
	public String proc3(MemberVO vo) {
		if( vo.getName() == null || vo.getName().equals("")) 			
			vo.setName("없음"); 
		if( vo.getPhone() == null || vo.getPhone().equals("")) 
			vo.setPhone("없음");
		if( vo.getId() == null || vo.getId().equals("")) 
			vo.setId("없음");
		if( vo.getPassword() == null || vo.getPassword().equals("")) 
			vo.setPassword("없음");				
		
		return "memberView";
	}
}
