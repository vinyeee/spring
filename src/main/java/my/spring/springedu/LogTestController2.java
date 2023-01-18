package my.spring.springedu;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LogTestController2 {	
	@RequestMapping("/log2")
	public ModelAndView xxx(HttpServletRequest req){
		String loggerName="case2";
		Logger log=LogManager.getLogger(loggerName);
		log.info(req.getRemoteHost() +"로 부터 요청이 왔어요!");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("logView");
		mav.addObject("msg", "톰캣콘솔창과 c:/Temp/logtest/myLogA2.log에서 확인하세요!!");
		return mav;
	}
	
}
