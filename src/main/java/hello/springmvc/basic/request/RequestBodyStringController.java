package hello.springmvc.basic.request;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestBodyStringController {

	@PostMapping("/request-body-string-v1")
	public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		
		log.info("messageBody={}",messageBody);
		
		response.getWriter().write("ok");
	}
	
	@PostMapping("/request-body-string-v2")
	public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException{
		
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		log.info("messageBody={}",messageBody);
		responseWriter.write("ok");
	}
	
	@PostMapping("/request-body-string-v3")
	public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException{
		
		//스프링이 알아서 너 문자구나 그럼 http body에 있는 것을 문자로 바꿔서 줄게~ 라는 메시지 컨버터가 실행됨.
		String messageBody = httpEntity.getBody();
		log.info("messageBody={}", messageBody);
		
		return new HttpEntity<>("ok");
		
	}
	
	@PostMapping("/request-body-string-v4")
	public HttpEntity<String> requestBodyStringV4(RequestEntity<String> httpEntity) throws IOException{
		
		//스프링이 알아서 너 문자구나 그럼 http body에 있는 것을 문자로 바꿔서 줄게~ 라는 메시지 컨버터가 실행됨.
		String messageBody = httpEntity.getBody();
		log.info("messageBody={}", messageBody);
		
		return new ResponseEntity<>("ok", HttpStatus.CREATED);
		
	}
	
	//싦무에서 많이 씀.
	@ResponseBody//응답
	@PostMapping("/request-body-string-v5")
	public String requestBodyStringV5(@RequestBody String messageBody) {
		
		log.info("messageBody={}", messageBody);
		
		return "ok";
		
	}
}
