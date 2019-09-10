package lunaticf.nezuko.common;

import com.sun.corba.se.spi.ior.ObjectKey;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 对Ajax请求的Wrapper
 * @author lunaticf
 */
@Data
public class JsonResult {
    private boolean res;

    private String msg;

    private Object data;

    public JsonResult() {
    }

    public JsonResult(boolean res) {
        this.res = res;
    }

    public JsonResult(boolean res, String msg) {
        this.res = res;
        this.msg = msg;
    }

    public JsonResult(boolean res, String msg, Object data) {
        this.res = res;
        this.msg = msg;
        this.data = data;
    }


    public static JsonResult success(String msg, Object data) {
        return new JsonResult(true, msg, data);
    }

    public static JsonResult success(String msg) {
        return new JsonResult(true, msg);
    }

    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static JsonResult fail(String msg, Object data) {
        return new JsonResult(false, msg, data);
    }

    public static JsonResult fail(String msg) {
        return new JsonResult(false, msg);
    }

    public static JsonResult fail() {
        return new JsonResult(false);
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("res", res);
        map.put("data", data);
        map.put("msg", msg);
        return map;
    }
}
