package my.spring.springedu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.VisitorMybatisDAO;
import vo.VisitorVO;

@Controller
public class VisitorController {
	@Autowired
	VisitorMybatisDAO dao;

	@RequestMapping("/vlist")
	public ModelAndView list() {
		List<VisitorVO> list = null;
		list = dao.list();
		ModelAndView mav = new ModelAndView();	
		if (list.size() != 0) {
			mav.addObject("list", list);
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("visitorView");
		return mav;
	}

	@RequestMapping("/vsearch")
	public ModelAndView search(String key) {
		List<VisitorVO> list = null;
		list = dao.search(key);
		ModelAndView mav = new ModelAndView();
		if (list.size() != 0) {
			mav.addObject("list", list);
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("visitorView");
		return mav;
	}

	@RequestMapping(value = "/vdelete")
	public ModelAndView delete(String id) {
		boolean result = dao.delete(id);
		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.addObject("list", dao.list());
		} else {
			mav.addObject("msg", "글 삭제에 실패했습니다.");
		}
		mav.setViewName("visitorView");
		return mav;
	}
	
	@RequestMapping(value = "/one", produces = "application/json; charset=utf-8")
	@ResponseBody
	public VisitorVO one(int id) {
		VisitorVO result = dao.one(id);
		return result;		
	}

	@RequestMapping(value = "/vinsert", 
			                     method = RequestMethod.POST)
	public ModelAndView insert(VisitorVO vo) {
		boolean result = dao.insert(vo);
		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.addObject("list", dao.list());
		} else {
			mav.addObject("msg", "글 등록에 실패했습니다.");
		}
		mav.setViewName("visitorView");
		return mav;
	}
	
	@RequestMapping(value = "/vupdate", 
            method = RequestMethod.POST)
	public ModelAndView update(VisitorVO vo) {
		boolean result = dao.update(vo);
		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.addObject("list", dao.list());
		} else {
			mav.addObject("msg", "글 수정에 실패했습니다.");
		}
		mav.setViewName("visitorView");
		return mav;
	}
}



