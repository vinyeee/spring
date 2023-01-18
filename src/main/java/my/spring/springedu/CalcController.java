package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

	@RequestMapping("/calc.do")
	public ModelAndView pro(int firstNum, int secondNum, String operator) {
		ModelAndView mav = new ModelAndView();
		String view;
		if (operator.equals("divide") && secondNum == 0) {
			view = "errorResult";
			mav.addObject("data", "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!");
		}
		else {
			int result;
			if (operator.equals("plus")) result = firstNum + secondNum;
			else if (operator.equals("minus")) result = firstNum - secondNum;
			else if (operator.equals("multiply")) result = firstNum * secondNum;
			else result = firstNum / secondNum;
			view = "calcResult";
			mav.addObject("data", result);
		}
		mav.setViewName(view);
		return mav;
	}

}
