//package org;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//
//@RestController
//@Slf4j
//public class DemoController {
//
//    @Resource
//    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
//
//    @GetMapping(value = "/index")
//    public String helloWorld() {
//        threadPoolTaskExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                log.info("线程池执行但是和请求同一个traceid");
//            }
//        });
//        return "HelloWorld";
//    }
//}
