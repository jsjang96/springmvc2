package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//그냥 컨트롤러는 view를 반환해주는데 이거는 http 메시지 바디에 바로 입력해줌.
public class MappingController {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
	public String helloBasic() {
		log.info("helloBasic");
		return"ok"; 
		 
	}
	
	@GetMapping(value = "/mapping-get-v2")
	public String mappingGetV2() {
		log.info("mapping-get-v2");
		return "ok";
	}
	
	//Http API는 리소스 경로에 식별자를 넣는 스타일
	@GetMapping(value = "/mapping/{userId}")
	public String mappingPath(@PathVariable("userId") String data) {
		log.info("mappingPath userId={}" ,data);
		return "ok";
	}
	
	@GetMapping(value = "/mapping/users/{userId}/orders/{orderId}")
	public String mappingPath(@PathVariable("userId") String userId, @PathVariable("orderId") Long orderId) {
	 log.info("mappingPath userId={}, orderId={}", userId, orderId);
	 return "ok";
	}
	
	/**
	 * 파라미터로 추가 매핑
	 * params="mode",
	 * params="!mode"
	 * params="mode=debug"
	 * params="mode!=debug" (! = )
	 * params = {"mode=debug","data=good"}
	 */
	@GetMapping(value = "/mapping-param", params = "mode=debug")
	public String mappingParam() {
	 log.info("mappingParam");
	 return "ok";
	}
	
	/**
	 * 특정 헤더로 추가 매핑
	 * headers="mode",
	 * headers="!mode"
	 * headers="mode=debug"
	 * headers="mode!=debug" (! = )
	 */
	@GetMapping(value = "/mapping-header", headers = "mode=debug")
	public String mappingHeader() {
	 log.info("mappingHeader");
	 return "ok";
	}
	
	/**
	 * Content-Type 헤더 기반 추가 매핑 Media Type
	 * consumes="application/json"
	 * consumes="!application/json"
	 * consumes="application/*"
	 * consumes="*\/*"
	 * MediaType.APPLICATION_JSON_VALUE
	 */
	@PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String mappingConsumes() {
	 log.info("mappingConsumes");
	 return "ok";
	}
	
	/**
	 * Accept 헤더 기반 Media Type
	 * produces = "text/html"
	 * produces = "!text/html"
	 * produces = "text/*"
	 * produces = "*\/*"
	 */
	@PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
	public String mappingProduces() {
	 log.info("mappingProduces");
	 return "ok";
	}
}
