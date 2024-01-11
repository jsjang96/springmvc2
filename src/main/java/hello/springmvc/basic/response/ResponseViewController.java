package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
	
	@RequestMapping("/response-view-v1")
	public ModelAndView responseViewV1() {
		ModelAndView mav = new ModelAndView("response/hello")//템플릿
				.addObject("data", "hello!");
		
		return mav;
	}
	
	//이걸 쓰면 body가 그대로 나간다.
	//@ResponseBody
	@RequestMapping("/response-view-v2")
	public String responseViewV2(Model model) {
		model.addAttribute("data", "hello!!");
		
		return "response/hello";
	}
	
	@RequestMapping("/response/hello")
	public void responseViewV3(Model model) {
		model.addAttribute("data", "hello!!!!!");
	}
	//반환을 아무것도 안하면 mapping한 곳의 template가 불려짐.
}
