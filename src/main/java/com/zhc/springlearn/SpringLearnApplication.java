package com.zhc.springlearn;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *     @RestController是@ResponseBod4y和@Controller的组合注解。
 */
	@SpringBootApplication
	@RestController
	public class SpringLearnApplication {

		public static void main(String[] args) {
			SpringApplication.run(com.zhc.springlearn.SpringLearnApplication.class, args);
		}


		/**
		 * http://localhost:8080/hello/world
		 *
		 *	GetMapping的参数
		 *     String name() default "";
		 *     String[] value() default {};
		 *     String[] path() default {};
		 *     String[] params() default {};
		 *     String[] headers() default {};
		 *     String[] consumes() default {};
		 *     String[] produces() default {};
		 * @return
		 */
		@SentinelResource(value = "hello world")
		@GetMapping(value = "/hello/world")
		public String helloWorld(){
			return "HelloWorld";
		}
}
