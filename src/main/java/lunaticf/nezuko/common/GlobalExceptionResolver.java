package lunaticf.nezuko.common;

import lombok.extern.slf4j.Slf4j;
import lunaticf.nezuko.exception.NezukoException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局处理异常类
 * @author lunaticf
 */
@Component
@Slf4j
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String defaultMsg = "System error!";
        String ajaxFlag = "x-requested-with";
        ModelAndView mv;
        JsonResult result;

        // 如果异常是我们自己定义的异常
        if (e instanceof NezukoException) {
            // 使用错误的msg
            result = JsonResult.fail(e.getMessage());
        } else {
            log.error("未知的异常， url = " + httpServletRequest.getRequestURL(), e);
            // 使用默认的错误信息
            result = JsonResult.fail(defaultMsg);
        }

        // 如果是JSON请求
        if (httpServletRequest.getHeader(ajaxFlag) != null) {
            mv = new ModelAndView(new MappingJackson2JsonView());
            mv.addAllObjects(result.toMap());
            return mv;
        } else {
            // 如果是页面请求 返回500.html
            mv = new ModelAndView("500", result.toMap());
            return mv;
        }
    }
}
