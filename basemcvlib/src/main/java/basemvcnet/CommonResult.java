package basemvcnet;

/**
 * Created by zhaoj on 2019/5/18.
 */

public class CommonResult<T extends Object> {
    private int code;
    private String message;
    private T Data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
