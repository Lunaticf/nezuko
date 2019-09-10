package lunaticf.nezuko.exception;

/**
 * 自定义异常
 * @author lunaticf
 */
public class NezukoException extends RuntimeException {
    public NezukoException() {
        super();
    }

    public NezukoException(String message) {
        super(message);
    }

    public NezukoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NezukoException(Throwable cause) {
        super(cause);
    }

    protected NezukoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
