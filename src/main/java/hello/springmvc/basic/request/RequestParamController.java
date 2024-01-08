package hello.springmvc.basic.request;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestParamController {

	@RequestMapping("/request-param-v1")
	public void reqeustParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		log.info("username={}, age ={}", username, age);
		
		response.getWriter().write("ok");
		}
	
	@ResponseBody
	//ok를 meesagebody에 넣어버림 => RestController와 같은 역할
	@RequestMapping("/request-param-v2")
	public String requestParamV2(
			@RequestParam("username") String memberName,
			@RequestParam("age") int memberAge) {
		
		log.info("username={}, age={}", memberName, memberAge);
		return "ok";
	}
	
	@ResponseBody
	//ok를 meesagebody에 넣어버림 => RestController와 같은 역할
	@RequestMapping("/request-param-v3")
	public String requestParamV3(
			@RequestParam("username") String username,
			@RequestParam("age") int age) {
		
		log.info("username={}, age={}", username, age);
		return "ok";
	}
	
	@ResponseBody
	//ok를 meesagebody에 넣어버림 => RestController와 같은 역할
	@RequestMapping("/request-param-v4")
	public String requestParamV4(
			@RequestParam("username") String username,
			@RequestParam("age") int age) {
		
		log.info("username={}, age={}", username, age);
		return "ok";
	}
	
	@ResponseBody
	//ok를 meesagebody에 넣어버림 => RestController와 같은 역할
	@RequestMapping("/request-param-required")
	public String requiredParamRequired(
			@RequestParam(required = true) String username,
			@RequestParam(required = false) int age) {
		
		log.info("username={}, age={}", username, age);
		return "ok";
	}
	
//	@ResponseBody
//	//ok를 meesagebody에 넣어버림 => RestController와 같은 역할
//	@RequestMapping("/request-param-default")
//	public String requiredParamDefault(
//			@RequestParam(required = true, defaultView = "guest") String username,
//			@RequestParam(required = false, defaultView = "guest") int age) {
//		
//		log.info("username={}, age={}", username, age);
//		return "ok";
//	}
	
	@ResponseBody
	//ok를 meesagebody에 넣어버림 => RestController와 같은 역할
	@RequestMapping("/request-param-map")
	public String requiredParamMap(
			//key가 하나에 value가 여러개일 경우!! => 이걸 쓰는걸 권장 , Map은 파라미터의 값이 한개일 때
			@RequestParam MultiValueMap<String, Object> paramMap)
			{
		
		log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
		return "ok";
	}
	
	@ResponseBody
	//ok를 meesagebody에 넣어버림 => RestController와 같은 역할
	@RequestMapping("/model-attribute-v1")
	public String modelAttributeV1(
			//key가 하나에 value가 여러개일 경우!! => 이걸 쓰는걸 권장 , Map은 파라미터의 값이 한개일 때
			@RequestParam MultiValueMap<String, Object> paramMap)
			{
		
		log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
		return "ok";
	}
	}
