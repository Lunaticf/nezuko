package lunaticf.nezuko.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class HelloController {
    @GetMapping("/")
    @ResponseBody
    public String hello() {
        log.info("hello");
        return "hello";
    }
}
