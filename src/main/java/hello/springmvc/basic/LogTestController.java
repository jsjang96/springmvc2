package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

//@Slf4j
//log를 뜨로 선언 안해줘도 쓸 수 있게 해줌.
@RestController
public class LogTestController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/log-test")
	public String logTest() {
		String name = "Spring";
		
		System.out.println("name = "+ name);
		
		log.trace("teace log={}",name);
		log.debug("debug log={}", name);
		log.info("info log={}",name);
		log.warn("warn log={}", name);
		log.error("error log={}",name);
		
		return "ok"; 
	}
}
