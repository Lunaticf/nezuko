package lunaticf.nezuko.controller;

import lombok.extern.slf4j.Slf4j;
import lunaticf.nezuko.common.JsonResult;
import lunaticf.nezuko.exception.NezukoException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/")
    public String hello() {
        log.info("hello");
        return "hello";
    }

    @GetMapping("/json")
    public JsonResult json() {
        return JsonResult.success("HELLO");
    }

    @GetMapping("/json1")
    public JsonResult json1() {
        throw new NezukoException("fuck");
//        return JsonResult.success("HELLO");
    }

    @GetMapping("/json2")
    public JsonResult json2() {
        throw new RuntimeException("fuck");
//        return JsonResult.success("HELLO");
    }
}
