package my.spring.springedu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.EmpMybatisDAO;
import vo.EmpVO;
import vo.PageVO;

@Controller
public class EmpController {
	@Autowired
	EmpMybatisDAO dao;
	
	@GetMapping("/count")
	public ModelAndView count() {
		ModelAndView mav = new ModelAndView();
		int num = dao.getAllDataNum();
		mav.addObject("num", num);
		mav.setViewName("empResult");
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> list = dao.listAll();
		mav.addObject("list", list);
		mav.setViewName("empResult");
		return mav;
	}
	
	@GetMapping("/part")
	public ModelAndView part(PageVO vo) {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> list = dao.listPart(vo);
		mav.addObject("list", list);
		mav.setViewName("empResult");
		return mav;
	}

}
